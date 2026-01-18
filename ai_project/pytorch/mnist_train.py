import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

import torch
from torch import nn
from torch.utils.data import DataLoader
from torchvision import datasets
from torchvision.transforms import ToTensor

device = (
  "cuda"
  if torch.cuda.is_available()
  else "mps"
  if torch.backends.mps.is_available()
  else "cpu"
)

# 데이터 준비
training_data = datasets.MNIST(
  root="data",
  train=True,
  download=True,
  transform=ToTensor()
)

test_data = datasets.MNIST(
  root="data",
  train=False,
  download=True,
  transform=ToTensor()
)

# batch로 메모리 지키기
train_dataloader = DataLoader(training_data, batch_size=64)
test_dataloader = DataLoader(test_data, batch_size=64)

# 예측 모델 정의
class CNN(nn.Module):
  def __init__(self):
    super().__init__()
    self.conv_layers = nn.Sequential(
      nn.Conv2d(1, 32, 3),  # 합성곱
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
  
model = CNN().to(device)

loss_fn = nn.CrossEntropyLoss()
batch_size = 64
learning_rate = 1e-2

optimizer = torch.optim.SGD(model.parameters(), lr=learning_rate)

def train_loop(dataloader, model, loss_fn, optimizer):
  model.train() # train으로 변경 (모범 사례)
  size = len(dataloader.dataset)

  for batch, (X, y) in enumerate(dataloader):
    X, y = X.to(device), y.to(device)
    pred = model(X) # 모델 학습으로 예측 반환
    loss = loss_fn(pred, y) # 반환된 예측의 오차를 계산

    loss.backward() # 손실에 기반한 변화도 계산
    optimizer.step() # 변화도 기반 손실 바로 잡기
    optimizer.zero_grad() # 변화도 초기화로 제대로 된 학습

    if batch % 100 == 0:
      loss, current = loss.item(), batch * batch_size + len(X)
      print(f"loss: {loss:>7f}  [{current:>5d}/{size:>5d}]")


def test_loop(dataloader, model, loss_fn):
  model.eval() # eval로 변경 (모범 사례)
  size = len(dataloader.dataset)
  num_batches = len(dataloader)
  test_loss, correct = 0, 0

  with torch.no_grad():
    for X, y in dataloader:
      X, y = X.to(device), y.to(device)
      pred = model(X)
      test_loss += loss_fn(pred, y).item()
      correct += (pred.argmax(1) == y).type(torch.float).sum().item()

  test_loss /= num_batches
  correct /= size
  print(f"Test Error: \n Accuracy: {(100*correct):>0.1f}%, Avg loss: {test_loss:>8f} \n")

epochs = 10
for t in range(epochs):
  print(f"Epoch {t+1}\n-------------------------------")
  train_loop(train_dataloader, model, loss_fn, optimizer)
  test_loop(test_dataloader, model, loss_fn)
print("Done!")
# 저장    
torch.save(model.state_dict(), 'mnist_model.pth')
print("모델 저장 완료!")

