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