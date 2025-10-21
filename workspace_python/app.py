# 최초로 프로젝트 생성 시 flask 설치 -> pip install flask
# CORS 해결을 위한 라이브러리 설치 -> pip install flask-cors

from flask import Flask, request 

app = Flask(__name__)

@app.route('/', methods=['GET'])
def hello():
  return 'Hello, World!'

# 버튼 1 클릭 시 호출
@app.route('/t1', methods=['GET'])
def test1():
  return {'name': 'python'}

# 버튼 2 클릭 시 호출 api, URLParameter 데이터 가져오기
# 숫자로 넘어오는 데이터를 num으로 받겠다.
# 문자열이 넘어오면 <str:변수명>
# 리턴할 데이터가 없어도 빈문자열('')이나 빈 객체를 리턴!
@app.route('/t2/<int:num>', methods=['GET'])
def test2(num):
  print(f'전달된 데이터 = {num}')
  return {}

# post 방식으로 넘어오는 데이터 받기
@app.route('/t3', methods=['POST'])
def test3():
  # post로 넘어온 데이터를 받는 문법
  data = request.get_json()
  print(data.get('stuName'))
  print(data.get('stuAge'))
  return {}

# query string 방식의 데이터 받기
@app.route('/t4', methods=['GET'])
def test4():
  stuName = request.args.get('stuName')
  stuAge = request.args.get('stuAge')
  print(stuName, stuAge)
  return {}

if __name__ == '__main__':
  # host='0.0.0.0' -> 모든 ip에서 접근 허용
  app.run(debug=True, host='0.0.0.0', port=5000)