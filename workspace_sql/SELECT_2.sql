# 복습
SELECT * 
FROM emp;

# EMP 테이블에 저장된 사원 중 부서번호가 30인 사원의 사번, 이름, 부서번호 조회
SELECT EMPNO, ENAME, DEPTNO
FROM emp
WHERE DEPTNO = 30;

# EMP 테이블에서 직급이 대리가 아니거나, 급여가 600 이하인 사원들의 사번, 사원명, 직급, 급여를 조회
SELECT EMPNO, ENAME, JOB, SAL
FROM emp 
WHERE JOB != '대리' OR SAL <= 600;

# 직급이 대리 또는 사원이면서 급여는 400을 초과하는 직원들의 모든 컬럼 정보 조회
SELECT *
FROM emp
WHERE (JOB = '대리' OR JOB = '사원') AND SAL > 400;

# 급여가 800이하인 직원 중에서 커미션이 NULL이 아닌 직원의 모든 컬럼 조회
SELECT *
FROM emp 
WHERE SAL <= 800 AND COMM IS NOT NULL;

#----------------------------------------------------------------------------------------------------

# 별칭을 사용한 조회
# 조회 시 컬럼명 뒤에 AS 키워드를 붙이고, 별칭을 작성하면 조회 시 별칭이 적용된다.
# 별칭을 부여할 때는 AS 키워드는 생략 가능하다.
SELECT EMPNO AS NO, ENAME AS 이름, SAL 급여
FROM emp;

# EMP 테이블에서 급여가 300 이상이고 600 이하인 사원들의 사번, 사원명, 급여 조회
SELECT EMPNO, ENAME, SAL
FROM emp 
WHERE SAL >= 300 AND SAL <= 600;

# 위 조건은 BETWEEN A AND B 연산자를 이용하기도 함 (속도는 많이 느림)
SELECT EMPNO, ENAME, SAL
FROM emp 
WHERE SAL BETWEEN 300 AND 600;

# EMP 테이블에서 급여가 400이거나 500 이거나 600인 사원들의 모든 컬럼 정보 조회
SELECT *
FROM emp 
WHERE SAL = 400 OR SAL = 500 OR SAL = 600;

# 위 조건과 같은 조건식(속도가 약간 더 빠름)
SELECT *
FROM emp
WHERE SAL IN (400, 500, 600);

# 데이터 정렬
# ORDER BY 정렬할 컬럼명 정렬방식(맨마지막에 사용);
# 정렬방식 : 오름차순(ASC, 생략가능), 내림차순(DESC)

# 모든 사원의 모든 칼럼 정보를 조회하되, 급여기준 내림차순 정렬
SELECT *
FROM emp 
ORDER BY SAL DESC;

SELECT *
FROM emp 
ORDER BY DEPTNO ASC;

SELECT *
FROM emp 
ORDER BY DEPTNO;

# 직급이 사장인 사원을 제외하고, 모든 사원의 모든 컬럼을 조회
# 단, 직급 기준 내림차순으로 정렬
SELECT *
FROM emp
WHERE JOB != '사장'
ORDER BY JOB DESC;

# 모든 컬럼을 조회하되, 직급 기준 오름차순 정렬 후 만약 직급이 동일하면 
# 급여기준 내림차순으로 정렬
SELECT *
FROM emp
ORDER BY JOB ASC, SAL DESC;

# LIKE 연산자와 와일드카드
# 와일드 카드 : %, _
# % : 글자 수 제한 없는 어떤 글자
# _ : 한 글자로 이루어진 어떤 글자
# EX) 
# '_이_' : 가운데 글자가 '이'인 세 글자
# '__김' : 마지막 글자가 '김'인 세 글자
# '%김' : 김으로 끝나는 모든 글자'
# '-김%' : 두번째 글자가 '김'인 모든 글자
# 이름에 '이'라는 글자가 포함된 사원들의 모든 칼럼 정보 조회
SELECT * 
FROM emp 
WHERE ENAME LIKE '%이%';



SELECT EMPNO, ENAME, SAL, COMM
FROM emp;

SELECT EMPNO, ENAME AS NAME, JOB
FROM emp
WHERE EMPNO >= 1005;

SELECT ENAME, JOB, SAL
FROM emp
# WHERE JOB = '대리' OR JOB = '과장';
WHERE JOB IN ('대리', '과장');

SELECT *
FROM emp
WHERE SAL >= 300 AND COMM >= 300;

SELECT ENAME, JOB, SAL, COMM
FROM emp
WHERE SAL <= 900
# AND (JOB = '대리' OR JOB = '과장'); 
AND COMM IS NOT NULL AND JOB IN ('대리', '과장');

SELECT ENAME, SAL, COMM
FROM emp
# AND SAL >= 350 AND SAL <= 650;
WHERE SAL BETWEEN 350 AND 650;

SELECT EMPNO, ENAME, JOB
FROM emp
WHERE JOB IN ('과장', '차장', '부장')
ORDER BY JOB ASC;

SELECT EMPNO, ENAME, DEPTNO, SAL
FROM emp
WHERE DEPTNO IN (10, 20) AND ENAME LIKE '%이%'
ORDER BY DEPTNO DESC, SAL ASC;

SELECT *
FROM emp
WHERE ENAME LIKE '%기' AND COMM IS NULL AND SAL >= 400 AND SAL <= 800;
