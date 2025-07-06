# 별칭을 사용한 조회(AS 생략 가능, 한글 별칭도 가능)
SELECT EMPNO AS NO, ENAME AS 이름, SAL 급여
FROM emp;

# 이런 식으로 별칭을 잘못 주는 상황이 없도록 한다.
SELECT EMPNO ENAME
FROM emp;

SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL >= 300 AND SAL <= 600;

# 위 조건은 BETWEEN A AND B 연산자를 이용하기도 함(QUERY는 속도가 중요한데 이 문법은 느려서 사용 안 함
# 근데 시험엔 나옴
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL BETWEEN 300 AND 600; 

SELECT *
FROM emp
WHERE SAL = 400 OR SAL = 500 OR SAL = 600;

# 위 조건은 IN을 이용함(위 조건보다 약간 더 빠름, 시험에 나옴)
SELECT *
FROM emp
WHERE SAL IN(400, 500, 600);
 
# 데이터 정렬
# 문법 : ORDER BY 정렬할 컬럼명 (QUERY문에서 ORDER BY절이 항상 제일 마지막에 온다.)
# 정렬방식 : 오름차순(ASC, 생략가능), 내림차순(DESC)
# 문자열 정렬은 사전등록방식으로 한다.

# 내림차순 정렬
SELECT *
FROM emp
ORDER BY SAL DESC;

# 오름차순 정렬
SELECT *
FROM emp
ORDER BY SAL ASC; # 생략 가능

# 정렬은 한 번 이상 줄 수 있다.
# 첫 쉼표를 기준으로 정렬(밑의 사례 : 직원명 정렬 후 그 직원명이 동일하면 급여 정렬
SELECT *
FROM emp
ORDER BY JOB ASC, SAL DESC;

# LIKE 연산자와 와일드카드
# 와일드 카드 : %, _
# % : 글자수 제한 없는 어떤 글자
# _ : 한 글자로 이루어진 어떤 글자

SELECT *
FROM emp
WHERE ENAME LIKE '%이%'; # 한글자가 될 수 있고 무수한 글자가 될 수도 있다.

