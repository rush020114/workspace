# 단일행 함수 : 함수 사용으로 조회되는 행의 개수가 하나인 함수

# 단일행 함수
SELECT MAX(SAL) , MIN(SAL), SUM(SAL), COUNT(SAL), AVG(SAL)
FROM emp;

# COUNT 단일행 함수 사용 시 주의사항
# NULL 데이터 조회 시 NULL은 누락시키고 개수 COUNT

# 전체 데이터의 수를 조회하기 위한 COUNT 사용 첫번째 방식
SELECT COUNT(*) 
FROM emp;

# 두번째 방식
# PK를 카운터 함수에 넣는다.(속도가 빠르므로 실무에서 쓴다)
# 다른 컬럼은 NULL이 포함될 수도 있기 때문에 PK를 쓴다.
# 데이터베이스를 다룰 때는 현재의 상황이 아닌 나중 상황까지 고려해야 되기 때문이다.
SELECT COUNT(EMPNO) 
FROM emp;

# 테이블 묘사
DESC emp;

# 같은 테이블이지만 NULL 포함 여부에 따라 COUNT가 달리 된다.
SELECT COUNT(SAL), COUNT(EMPNO), COUNT(COMM)
FROM emp;

# 단일행 사용 시 주의사항
# 조회하려는 모든 컬럼의 모든 행의 개수가 동일해야 쿼리가 정상 작동
SELECT EMPNO, ENAME, SUM(SAL) 
FROM emp;

# GROUP BY 절 : 특정 컬럼 기준으로 조회(통계 데이터를 볼 수 있음)
# 일반적으로 단일행은 일반컬럼과 쓰면 데이터가 정확하지 않지만
# 그런데 단일행과 조회하는 컬럼의 개수가 같으면 제대로 된 데이터가 조회된다.
# GROUP BY 절이 실행될 때 단일행 조회 시 GROUP BY로 나눠진 그룹 만큼
# 각각 단일 데이터를 조회시킨다.
# 그러면 단일행으로 인해 조회된 행과 GROUP BY절에 쓰인 컬럼의 
# 행 개수가 동일하므로 단일행 함수와 쓸 수 있게 된다.
# 결론, GROUP BY절의 컬럼과 단일행은 알맞은 조합이다.

# 직급별 직원 급여의 합
SELECT SUM(SAL)
	, JOB
FROM emp
GROUP BY JOB;

# 부서별 급여의 평균값, 최댓값, 최솟값
SELECT AVG(SAL)
	, MAX(SAL)
	, MIN(SAL)
	, DEPTNO
	, (SELECT DNAME 
		FROM dept 
		WHERE DEPTNO = emp.DEPTNO) DNAME
FROM emp
GROUP BY DEPTNO;

# 부서별 사원수를 조회. 단, 부서번호가 10번인 부서는 제외
# 전체 데이터의 수를 알기 위한 카운터 조회는 PK로 한다.
# 그룹절과 관계없이 DEPTNO를 제외시킬 수 있으므로 WHERE절에 조건을 적는다.
SELECT COUNT(EMPNO)
FROM emp
WHERE DEPTNO != 10
GROUP BY DEPTNO;

# 부서별 사원수를 조회. 단, 부서별 인원수가 5명 이하인 부서는 제외
# GROUPING이 완료된 후 추가되는 조건은 HAVING절에 작성
# GROUP 절 실행 후 COUNT(EMPNO)로 인원수를 알았으니 
# HAVING절에 그 인원수 조건을 작성할 수 있다. 
SELECT COUNT(EMPNO)
FROM emp
GROUP BY DEPTNO
HAVING COUNT(EMPNO) > 5;

# 직급별로 직급, 직급별 급여의 합을 조회.
# 직급이 사원과 사장인 직급은 제외하고, 직급별 급여의 합이 500 이상인 데이터만 조회.
# 또한, 조회되는 데이터는 직급별 급여의 합 기준 내림차순으로 정렬

# 무슨무슨 별 조회는 HAVING절이다.
SELECT JOB, SUM(SAL)
FROM emp
WHERE JOB NOT IN ('사원', '사장')
GROUP BY JOB
HAVING SUM(SAL) >=500
ORDER BY SUM(SAL) DESC;