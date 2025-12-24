import sys
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

# beautifulSoup : 가져온 html을 검색할 수 있게 해준다. div 등 
from bs4 import BeautifulSoup
import requests

response = requests.get("https://remoteok.com/remote-golang-jobs")

soup = BeautifulSoup(
  response.content,
  "html.parser"
)

jobs = soup.find("table").find_all("tr", class_="job")

print(jobs)
