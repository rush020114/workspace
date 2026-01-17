import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

import torch
from torch import nn
from PIL import Image
import torchvision.transforms as transforms

device = "cpu"  # 예측은 CPU도 충분

# 모델 정의 (똑같이)
class CNN(nn.Module):
  def __init__(self):
    super().__init__()
    self.conv_layers = nn.Sequential(
      nn.Conv2d(1, 32, 3),
      nn.ReLU(),
      nn.MaxPool2d(2),
      nn.Conv2d(32, 64, 3),
      nn.ReLU(),
      nn.MaxPool2d(2),
      nn.Flatten(),
      nn.Linear(1600, 10)
    )
  def forward(self, x):
    return self.conv_layers(x)

# 모델 불러오기
model = CNN()
model.load_state_dict(torch.load('fashion_mnist_model.pth'))
model.eval()

# 이미지 예측
img = Image.open("my_fashion.png").convert('L')
img = transforms.functional.invert(img)

transform = transforms.Compose([
  transforms.Resize((28, 28)),
  transforms.ToTensor(),
])

img_tensor = transform(img).unsqueeze(0)

with torch.no_grad():
  pred = model(img_tensor)
  result = pred.argmax(1).item()
  probs = torch.softmax(pred, dim=1)[0]
  
print(f"예측: {result}")
for i in range(10):
  print(f"{i}: {probs[i]*100:.1f}%")

classes = [
    "T-shirt/top",    # 0
    "Trouser",        # 1
    "Pullover",       # 2
    "Dress",          # 3
    "Coat",           # 4
    "Sandal",         # 5
    "Shirt",          # 6
    "Sneaker",        # 7
    "Bag",            # 8
    "Ankle boot"      # 9
]

print(f"예측: {classes[result]}")