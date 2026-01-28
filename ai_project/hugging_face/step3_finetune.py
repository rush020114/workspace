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
    # 전처리 = 이미지를 AI가 이해할 수 있는 형태로 바꾸는 과정
    # processor = 이 전처리를 자동으로 해주는 도구
    # pytorch로 하면 텐서로 변환하고 크기를 조정하고 
    self.processor = processor # processor : 이미지를 모델이 읽을 수 있는 형태로 변환하는 설정이 들어있는 도구

  def __len__(self):
    return len(self.image_paths)
  
  def __getitem__(self, idx):
    image = Image.open(self.image_paths[idx]).convert("RGB")
    # 전처리기로 픽셀을 텐서화한 키를 포함한 딕셔너리 형태로 반환
    inputs = self.processor(images=image, return_tensors="pt")

    # 텐서 차원 조절(크기가 1인 차원 자동 제거 - 매개변수가 0이므로 0번째 차원만)
    # 모델 학습을 위해 픽셀을 꺼냄
    # squeeze로 불필요한 차원이 제거된다.
    # 신경망 모델은 4차원의 텐서를 기대하기 때문
    # [1,3,224,224] → [3,224,224] 차원 축소
    # (배치 차원 제거, DataLoader가 나중에 다시 묶어줌)
    pixel_values = inputs['pixel_values'].squeeze(0)

    return {
      'pixel_values': pixel_values, # 학습 이미지의 픽셀 데이터 (텐서)
      'labels': torch.tensor(self.labels[idx]) # 그 이미지의 정답 클래스 (0 또는 1)
    }

# 2. 모델과 프로세서 준비
print("🚀 모델 준비 중...")
model_name = "google/vit-base-patch16-224" # 구글이 만들어놓은 최신 이미지 AI 모델 이름
# 해당 모델로 전처리기 설정 다운로드
# 정규화를 어떻게 할지 이미지 크기를 어떻게 바꿀지 등
# 이미지 크기는 줄어도 크게 상관은 없다.
processor = AutoImageProcessor.from_pretrained(model_name) 

# 2개 클래스로 수정 (예: 티셔츠 vs 신발)
model = AutoModelForImageClassification.from_pretrained(
  # 해당 모델로 AI 신경망 모델 다운로드 
  model_name,
  # 클래스를 2개로 마음대로 바꿔버림으로써 내 기준대로 정답을 커스터마이징할 수 있음.
  num_labels=2,  # 클래스 개수!
  ignore_mismatched_sizes=True  # 기존 헤드 무시
)

# 3. 데이터 준비 (예시: 이미지 2개로 테스트)
# 실제론 100장 이상 필요!
image_paths = [
  "hugging_face/my_fashion.png", # 티셔츠
  "hugging_face/my_fashion.png", # 임시로 같은 이미지
]
  
labels = [0, 0] # 0: 티셔츠, 1: 신발

# dataset 세팅
# 2개의 이미지와 정답을 전달
# 모델이 학습할 수 있는 형태로 이미지를 텐서화하는 전처리기도 매개변수로 전달
dataset = SimpleDataset(image_paths, labels, processor)
# dataset을 한 번에 2개씩 묶어서 처리하기 위한 반복자로 만들기 위한 batch_size 전달
# shuffle로 매 epoch마다 순서를 섞어서 과적합 방지
dataloader = DataLoader(dataset, batch_size=2, shuffle=True)

print(f"📊 데이터 준비: {len(dataset)}개\n")

# 4. Fine-tuning (PyTorch 그대로!)
print("🔥 Fine-tuning 시작!\n")

device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
# 신경망 모델 계산을 정해진 계산장치로 옮김.
model = model.to(device)

# optimizer는 가중치의 주소값을 알고 있기 때문에 학습 시에 가중치가 업데이트되어도 현재값을 바라볼 수 있다.
# 그래서 parameter를 매번 전달하지 않고 한 번만 전달해도 정확한 학습이 가능하다.
# Adam: 학습률을 자동 조정하는 최적화 알고리즘
# lr=1e-5: Fine-tuning이므로 작은 학습률 사용 (기존 가중치 보존)
optimizer = torch.optim.Adam(model.parameters(), lr=1e-5)

epochs = 3

for epoch in range(epochs):
  model.train()
  total_loss = 0

  for batch in dataloader:
    # Python은 클래스를 반복 가능하게 커스터마이징할 수 있다.
    # dataset은 dataloader에 감싸지면서 반복이 가능해진다.
    # batch['pixel_values'] 형태가 가능한 이유는
    # dataloader가 dataset을 batch로 감싸서 
    # 모델이 읽을 수 있는 형태로 알아서 바꿔주기 때문이다.
    # dataloader의 내부동작을 간단하게 설명하자면
    # dataset을 batch만큼 반복하여 dataset의 getitem에서 pixel을 얻는다.
    # 그 다음은 batch의 개수에 맞게 알아서 모델이 읽을 수 있는 형태로 잘 묶어준다.
    # 그리고 dataset의 getitem의 형태처럼 이미지 픽셀과 정답을 반환하는 형태로 변형시킨다.
    # 예를 들면 pixel_values 딕셔너리에 들어가는 batch의 반환 형태는
    # [3,224,224] + [3,224,224] → [2,3,224,224] 이런 식이다.
    # 추가로 클래스를 반복 돌릴 때 반복 돌려지는 것의 getitem이 없으면 반복할 때 
    # 무엇을 꺼내야 할지 정의가 되어 있지 않기 때문에 반드시 필요하다.(dataset[0]이 뭐지?가 되어 버림)
    # dataloader에서 dataset의 pixel값을 받을 수 있는 이유도 getitem이 있었기 때문이다.
    pixel_values = batch['pixel_values'].to(device)
    # 모델이 계산을 진행하고 데이터가 모델에 의해서 계산되니까 같은 계산 장치에 있어야 함.
    labels = batch['labels'].to(device)

    # Forward
    # 모델의 신경망에 의해 이미지와 정답을 입력하여 예측 수행
    outputs = model(pixel_values=pixel_values, labels=labels)
    # 예측값과 정답의 손실(차이)을 계산
    # hugginface는 loss도 지원
    loss = outputs.loss

    # Backward
    # 손실을 줄이기 위해 모델 매개변수인 가중치를 얼마나 조정해야 할지 기울기 계산
    loss.backward()
    # 최적화로 기울기에 기반한 가중치 업데이트
    optimizer.step()
    # 기울기 초기화로 기울기 누적 방지
    # 학습 잘 됨 = 기울기 자연스럽게 감소 
    # 초기화 안 함 = 이상하게 누적됨 
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