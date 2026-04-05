import time
import threading

def collect_data(device_id):
  time.sleep(1)
  print(f"Device {device_id} collect")

start = time.time()

t1 = threading.Thread(target=collect_data, args=(1,))
t2 = threading.Thread(target=collect_data, args=(2,))
t3 = threading.Thread(target=collect_data, args=(3,))

# 1번 쓰레드 시작
t1.start()
t2.start()
t3.start()

# 1번 일 끝날 때까지 대기 다음 코드를 대기
t1.join()
t2.join()
t3.join()

print(f"Total time: {time.time() - start:.1f}s")