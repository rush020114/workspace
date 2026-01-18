import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

from transformers import AutoImageProcessor, AutoModelForImageClassification
from PIL import Image
import torch

print("🚀 모델과 프로세서 로딩 중...")

# 1. 모델 불러오기 (직접!)
model_name = "google/vit-base-patch16-224"
processor = AutoImageProcessor.from_pretrained(model_name)
model = AutoModelForImageClassification.from_pretrained(model_name)

print("✅ 로딩 완료!\n")

# 2. 이미지 준비
img_path = "hugging_face/my_fashion.png"
image = Image.open(img_path)

# 3. 전처리 (PyTorch의 transform과 비슷!)
inputs = processor(images=image, return_tensors="pt")
print(f"📊 입력 텐서 크기: {inputs['pixel_values'].shape}\n")

# 4. 예측 (PyTorch와 똑같음!)
print("🔍 예측 중...")
with torch.no_grad():
  outputs = model(**inputs)
  logits = outputs.logits

# 5. 확률 계산 (softmax - PyTorch에서 했던 것!)
probs = torch.nn.functional.softmax(logits, dim=1)
top5 = torch.topk(probs, 5)

print("\n예측 결과:")
for i in range(5):
  idx = top5.indices[0][i].item()
  prob = top5.values[0][i].item()
  label = model.config.id2label[idx]
  print(f"  {label}: {prob*100:.1f}%")