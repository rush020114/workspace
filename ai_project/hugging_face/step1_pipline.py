import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

from transformers import pipeline
import os

print("🚀 모델 로딩 중...")
classifier = pipeline(
  "image-classification",
  model="google/vit-base-patch16-224"
)
print("✅ 모델 로딩 완료!\n")

# hugging_face 폴더 기준
img_path = "hugging_face/my_fashion.png"  # 추가!

print(f"📁 이미지 경로: {os.path.abspath(img_path)}")
print(f"📄 파일 존재: {os.path.exists(img_path)}\n")

if os.path.exists(img_path):
  print(f"🔍 이미지 분석 중...")
  result = classifier(img_path)
  
  print("\n예측 결과:")
  for r in result[:5]:
    print(f"  {r['label']}: {r['score']*100:.1f}%")
else:
  print("❌ 이미지 파일이 없습니다!")