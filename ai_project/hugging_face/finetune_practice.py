import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

import torch
from torch.utils.data import Dataset, DataLoader
from transformers import AutoImageProcessor, AutoModelForImageClassification
from PIL import Image

# 커스텀 데이터셋
class SimpleDataset(Dataset):
  def __init__(self, image_paths, labels, processor):
    self.image_paths = image_paths
    self.labels = labels
    self.processor = processor

  def __len__(self):
    return len(self.image_paths)
  
  def __getitem__(self, idx):
    image = Image.open(self.image_paths[idx]).convert("RGB")
    inputs = self.processor(image=image, return_tensor="pt")

    pixel_values = inputs['pixel_values'].squeeze(0)

    return {
      'pixel_values': pixel_values,
      'labels': torch.tensor(self.labels[idx])
    }
  
# 모델과 프로세서 준비

model_name = "google/vit-base-patch16-224"

processor = AutoImageProcessor.from_pretrained(model_name)

model = AutoModelForImageClassification.from_pretrained(
  model_name,
  num_labels=2,
  ignore_mismatched_size=True
)