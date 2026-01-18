import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

from transformers import pipeline

print("Hugging Face 시작!")

# 이미지 분류 파이프라인
classifier = pipeline("image-classification", model="google/vit-base-patch16-224")

print("모델 로딩 완료!")