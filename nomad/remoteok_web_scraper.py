import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

# beautifulSoup : 가져온 html을 검색할 수 있게 해준다. div 등 
from bs4 import BeautifulSoup
import requests

response = requests.get(
  "https://www.saramin.co.kr/zf_user/jobs/list/job-category",
  headers={
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/143.0.0.0 Safari/537.36 Edg/143.0.0.0"
  }
)

print(response.content)
print(response.status_code)
soup = BeautifulSoup(
  response.content,
  "html.parser"
)

jobs = soup.find("ul", class_="list_product")

print(jobs)