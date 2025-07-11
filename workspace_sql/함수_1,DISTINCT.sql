# DISTINCT 키워드 - 중복제거
SELECT DISTINCT DEPTNO
FROM emp;

SELECT DISTINCT CATEGORY
FROM book;

# DISTINCT 키워드는 한 번만 작성하면 모든 컬럼의 중복값을 제거한다.
# 또한 나열된 모든 컬럼의 값이 같은 것을 중복으로 간주하여 중복을 제거한다.
SELECT DISTINCT JOB,  DEPTNO
FROM emp;

# 함수
# 수치 함수
# 함수 안에 컬럼도 들어갈 수 있다.
SELECT CEIL(SAL)
FROM emp;

SELECT CEIL(48.9)
FROM emp
WHERE EMPNO = 1001; # PRIMARY KEY이기 때문에 무조건 한 개의 데이터를 보여줌.

SELECT CEIL(48.9); # 문법 학습을 위한 SELECT 쿼리문에선 FROM 절 작성하지 않아도 됨.

# CEIL : 올림, FLOOR : 내림
SELECT CEIL(70.1), FLOOR(70.9);

# ROUND : 반올림
SELECT ROUND(112.456), ROUND(112.456, 1), ROUND(112.456, 2);

# TRUNCATE : 내림 (내림한 결과의 표현하고 싶은 소수점을 나타냄)
SELECT TRUNCATE(123.456, 1), TRUNCATE(123.456, 2);

# MOD : 나머지연산
SELECT MOD(7,3), MOD(10,4);

# EMP 테이블에서 사번이 짝수인 사원의 모든 컬럼 정보 조회
SELECT *
FROM emp
WHERE MOD(EMPNO, 2) = 0; # EMP 테이블로부터 사번을 2로 나누었을 때 결과가 0인 칼럼이 들어있는 행을 조회

SELECT *, MOD(EMPNO, 2)
FROM emp;

# 문자 관련 함수

# 데이터베이스는 첫시작을 1으로 한다.
# SUBSTR, SUBSTRING : 문자열 일부 추출, 두 함수의 결과는 동일
SELECT SUBSTR('ABCDEF', 3), SUBSTR('ABCDEF', 3, 2);
SELECT SUBSTRING('ABCDEF', 3), SUBSTRING('ABCDEF', 3, 2);

# UPPER : 대문자로 변환, LOWER : 소문자로 변환
SELECT UPPER('MariaDB'), LOWER('MariaDB');

# LTRIM, RTRIM, TRIM : 공백 제거
SELECT RTRIM('  DB  '), LTRIM('  DB  '), TRIM('  DB  ');

# CHAR_LENGTH() : 문자열의 길이(공백포함)
# LENGTHB() : 문자열의 바이트수, 영문 1글자는 : 1BYTE, 한글 1글자 : 3BYTE
SELECT CHAR_LENGTH('디비'), LENGTH('디비'), CHAR_LENGTH('DB'), LENGTHB('DB');

# CONCAT() : 문자열 나열
SELECT CONCAT('A', 'B', 'C');
SELECT ENAME, JOB, CONCAT(ENAME, '사원의 직급은 ', JOB) AS 사원의_직급
FROM emp;

# LPAD, RPAD : 문자열 길이를 맞추는 함수
SELECT LPAD('DB', 5, '#'), RPAD('DB', 5, '#'), LPAD('123', 5, '0');

# REPLACE : 문자열 교체
SELECT REPLACE('나는 HOME에 가고 싶다.', 'HOME', '집');