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
# huggingface기반 데이터셋 커스터마이징은 processor가 복잡한 과정을 줄여준다.
class SimpleDataset(Dataset):
  def __init__(self, image_paths, labels, processor):
    self.image_paths = image_paths
    self.labels = labels
    self.processor = processor

  def __len__(self):
    return len(self.image_paths)
  
  def __getitem__(self, idx):
    image = Image.open(self.image_paths[idx]).convert("RGB")
    inputs = self.processor(images=image, return_tensors="pt")

    # 텐서 차원 조절(크기가 1인 차원 자동 제거 - 매개변수가 0이므로 0번째 차원만)
    pixel_values = inputs['pixel_values'].squeeze(0)

    return {
      'pixel_values': pixel_values,
      'labels': torch.tensor(self.labels[idx])
    }

  