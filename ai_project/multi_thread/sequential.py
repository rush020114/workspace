# 시간 관련 도구 상자
# time.time() -> 지금 몇 시?
# time.sleep(1) -> 잠깐 멈춰
import time

def collect_data(device_id):
  # 1초 기다려
  time.sleep(1)
  print(f"Device {device_id} collected")

start = time.time()

collect_data(1)
collect_data(2)
collect_data(3)

print(f"Total time: {time.time() - start:.1f}s")