from flask import Flask, request # flask를 import하면 request도 쓸 수 있음

app = Flask(__name__)

@app.route('/', methods=['GET'])
def hello():
  return 'Hello, World!'

@app.route('/t1', methods=['GET'])
def test1():
  return {'name': 'python'}

# urlParameter
# <자료형:변수명> - 정수는 int, 문자열은 str
# 리턴할 데이터가 없어도 빈문자열 또는 빈 객체를 리턴!
@app.route('/t2/<int:num>', methods=['GET'])
def test2(num):
  print(f'전달된 데이터 = {num}')
  return {}

# post 방식
@app.route('/t3', methods=['POST'])
def test3():
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
  app.run(debug=True, host='0.0.0.0')