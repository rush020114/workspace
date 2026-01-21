import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

import torch
from torch.utils.data import Dataset, DataLoader
from transformers import AutoImageProcessor, AutoModelForImageClassification
from PIL import Image
import os

# 1. 커스텀 데이터셋
# Pytorch로 데이터셋을 구성하기 위해서는 많은 사전작업이 필요했지만
# huggingface기반 데이터셋 커스터마이징은 processor가 복잡한 과정(csv변환 등)을 줄여준다.
class SimpleDataset(Dataset): # Dataset으로 구현된 것을 명시적으로 보여주기 위한 상속
  def __init__(self, image_paths, labels, processor):
    self.image_paths = image_paths # 이미지 경로 배열
    self.labels = labels # 각 이미지의 정답 인덱스
    self.processor = processor # processor?

  def __len__(self):
    return len(self.image_paths)
  
  def __getitem__(self, idx):
    image = Image.open(self.image_paths[idx]).convert("RGB")
    inputs = self.processor(images=image, return_tensors="pt")

    # 텐서 차원 조절(크기가 1인 차원 자동 제거 - 매개변수가 0이므로 0번째 차원만)
    pixel_values = inputs['pixel_values'].squeeze(0)

    return {
      'pixel_values': pixel_values, # 텐서 픽셀 반환
      'labels': torch.tensor(self.labels[idx]) 
    }

# 2. 모델과 프로세서 준비
print("🚀 모델 준비 중...")
model_name = "google/vit-base-patch16-224"
processor = AutoImageProcessor.from_pretrained(model_name)

# 2개 클래스로 수정 (예: 티셔츠 vs 신발)
model = AutoModelForImageClassification.from_pretrained(
  model_name,
  # 클래스를 2개로 마음대로 바꿔버림으로써 내 기준대로 정답을 커스터마이징할 수 있음.
  num_labels=2,  # 클래스 개수!
  ignore_mismatched_sizes=True  # 기존 헤드 무시
)

# 3. 데이터 준비 (예시: 이미지 2개로 테스트)
# 실제론 100장 이상 필요!
image_paths = [
  "hugging_face/my_fashion.png",  # 티셔츠
  "hugging_face/my_fashion.png", # 임시로 같은 이미지
]
  # 
labels = [0, 0] # 0: 티셔츠, 1: 신발

dataset = SimpleDataset(image_paths, labels, processor)
dataloader = DataLoader(dataset, batch_size=2, shuffle=True)

print(f"📊 데이터 준비: {len(dataset)}개\n")

# 4. Fine-tuning (PyTorch 그대로!)
print("🔥 Fine-tuning 시작!\n")

device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
model = model.to(device)

optimizer = torch.optim.Adam(model.parameters(), lr=1e-5)

epochs = 3

for epoch in range(epochs):
  model.train()
  total_loss = 0

  for batch in dataloader:
    # GPU로 이동
    pixel_values = batch['pixel_values'].to(device)
    labels = batch['labels'].to(device)

    # Forward
    outputs = model(pixel_values=pixel_values, labels=labels)
    loss = outputs.loss

    # Backward
    loss.backward()
    optimizer.step()
    optimizer.zero_grad()

    total_loss += loss.item()
  
  avg_loss = total_loss / len(dataloader)
  print(f"Epoch {epoch+1}/{epochs} - Loss: {avg_loss:.4f}")

print("\n✅ Fine-tuning 완료!")

# 5. 저장
model.save_pretrained("my_model")
processor.save_pretrained("my_model")
print("💾 모델 저장 완료: my_model/")

# ========== 6. 예측 (새로 추가!) ==========
print("\n🔮 예측 테스트!\n")

# 테스트할 이미지
test_image_path = "hugging_face/my_fashion.png"  # ← 실제로는 새 이미지
test_image = Image.open(test_image_path).convert("RGB")

# 전처리
inputs = processor(images=test_image, return_tensors="pt")
pixel_values = inputs['pixel_values'].to(device)

# 예측
model.eval()
with torch.no_grad():
    outputs = model(pixel_values=pixel_values)
    logits = outputs.logits
    predicted_class = torch.argmax(logits, dim=1).item()
    confidence = torch.softmax(logits, dim=1)[0][predicted_class].item()

# 결과
class_names = {0: "티셔츠", 1: "신발"}
print(f"📸 이미지: {test_image_path}")
print(f"🎯 예측 결과: {class_names[predicted_class]}")
print(f"📊 신뢰도: {confidence:.2%}")