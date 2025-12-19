import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

# beautifulSoup : 가져온 html을 검색할 수 있게 해준다. div 등 
from bs4 import BeautifulSoup
import requests

url = "https://weworkremotely.com/categories/remote-full-stack-programming-jobs"

response = requests.get(url)

# 첫번째 매개변수는 html코드, 두번째 매개변수는 BeautifulSoup에게 넘긴 데이터가 어떤 형태인지
soup = BeautifulSoup(
  response.content, 
  "html.parser",
)

# find는 첫번째 태그만 반환, find_all은 모든 태그 반환
# section태그의 jobs라는 클래스명을 가진 태그 안의 모든 li를 검색
# class_를 적어준 이유는 jobs라는 클래스명을 가진 section태그가 첫번째라는 보장이 없기 때문
jobs = soup.find("section", class_="jobs").find_all("li")[:-1]

# 리스트 컴프리헨션
# get으로 인해 리스트로 반환된 값에 feature--ad가 없으면 리스트에 추가하지 않음.
# class 속성이 존재하지 않으면 빈리스트로 조건 검사
# 그러니까 feature--ad가 없으면 리스트에 포함
jobs = jobs = [job for job in jobs if "feature--ad" not in job.get("class", [])]

for job in jobs:
  title = job.find("h3", class_="new-listing__header__title").text
  position, salary, region = job.find_all("p", class_="new-listing__categories__category")[-1].text
  link = job.find("a", class_="listing-link--unlocked")
  print(title, "-------", region)