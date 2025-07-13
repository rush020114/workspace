# DISTINCT는 중복요소를 제거한다.
SELECT * 
FROM emp;

# 부서번호와 직급이 전부 같은 중복되는 행을 제거하여 조회
SELECT DISTINCT DEPTNO, JOB
FROM emp;

# 함수
# 수치 함수로 다양한 기능을 조회할 수 있다.

# CEIL : 올림 함수
SELECT CEIL(50.1)
FROM emp;

# 문법 학습을 위해 SELECT 쿼리문은 FROM 절을 작성하지 않아도 됨.
# FLOOR : 내림함수
SELECT CEIL(70.9), FLOOR(70.1);

# ROUND : 소수점을 결정할 수 있는 내림 함수
# 두번째 매개변수의 숫자까지 반올림
SELECT ROUND(123.456), ROUND(123.456, 1), ROUND(123.456, 2);

# MOD : 나머지 연산자
SELECT *
FROM emp
WHERE EMPNO % 2 = 0; # 사원 번호가 짝수인 모든 칼럼 조회

SELECT *
FROM emp
WHERE MOD(EMPNO, 2) = 0; # 위의 쿼리문과 같은 쿼리문

# 문자 관련 함수
# SUBSTR : 문자 추출 (두번째 매개변수 : N번째 문자열부터 끝까지, 세번째 매개변수 : N번째 문자열부터 나열하고 싶은 문자열의 수)
# DB는 문자열 첫번째를 1번으로 간주한다.
# SUBSTRING도 같은 기능의 함수이다.
SELECT SUBSTR('ABCDEF', 3), SUBSTR('ABCDEF', 3, 2);
SELECT SUBSTRING('ABCDEF', 3), SUBSTRING('ABCDEF', 3, 2);

# UPPER 함수 : 대문자 변환 함수
# LOWER 함수 : 소문자 변환 함수
SELECT UPPER('MariaDB'), LOWER('MariaDB');

# LTRIM, RTRIM, TRIM : 공백제거
SELECT RTRIM('   DB   '), LTRIM('   DB   '), TRIM('   DB   ');

# CHAR_LENGTH() : 문자열의 길이, 공백 포함 '  DB  ' => 4
# LENGB() : 문자열 바이트수, 영문 ㅂ글자 : 1BYTE, 한글 1글자 : 3BYTE
SELECT CHAR_LENGTH('디비'), LENGTHB('디비'), CHAR_LENGTH('DB'), LENGTHB('DB');

# CONCAT() : 문자열 나열
SELECT CONCAT ('A', 'B', 'C');
# CONCAT 함수는 밑의 쿼리문처럼 활용할 수 있다.
SELECT ENAME, JOB, CONCAT(ENAME, ' 사원의 직급은 ', JOB)
FROM emp;

# LPAD, RPAD : 문자열 길이를 맞추는 함수
SELECT LPAD('DB', 5, '#'), RPAD('DB', 5, '#');

# REPLACE : 문자열 교체
SELECT REPLACE('나는 HOME에 가고 싶다', 'HOME', '집');