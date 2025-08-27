# 단일행 함수
# 함수 사용으로 인해 조회되는 행의 개수가 한 개만 존재하는 함수

# 단일행 함수가 아닌 함수의 예시
SELECT SUBSTR(ENAME, 2, 1), ENAME FROM emp;

# 단일행 함수의 예시
SELECT MAX(SAL) FROM emp;

# 단일행 함수의 종류
SELECT MAX(SAL), MIN(SAL), SUM(SAL), COUNT(SAL), AVG(SAL) FROM emp; 

# COUNT 단일행 함수 사용 시 주의사항
# COUNT 조회되는 데이터의 수를 파악
# 단, NULL데이터는 개수에 포함하지 않음
#ex) emp 테이블에 저장된 데이터 개수를 조회

# 첫번째 방식 (* 활용)
SELECT COUNT(*) FROM emp;

# 두번째 방식 (PK 활용) - 추천(속도가 더 빠름)
SELECT COUNT(EMPNO) FROM emp;

SELECT COUNT(SAL), COUNT(EMPNO), COUNT(ENAME), COUNT(COMM) FROM emp;

# 테이블 묘사
DESC emp;

# 단일행 함수 사용 시 주의사항
# 조회하려는 모든 컬럼의 조회 개수가 동일해야 쿼리가 정상 동작 
SELECT EMPNO, ENAME, SUM(SAL) FROM emp;

# GROUP BY 절 : 특정 컬럼 기준으로 통계 데이터를 볼 수 있음
# 모든 직원의 급여의 합
SELECT SUM(SAL) FROM emp;

# 직급별 직원 급여의 합
# 본래는 단일행과 일반 컬럼은 같이 쓰는 것이 아니지만 GROUP BY와 함께 쓰면 같이 쓸 수 있다.
# 나뉜 그룹의 행이 단일행 조회 결과의 행 수와 같으므로 가능하다.
SELECT SUM(SAL), JOB
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

# 부서별 사원 수를 조회. 단, 부서번호가 10번인 부서는 제외
SELECT DEPTNO, COUNT(EMPNO) 
FROM emp
WHERE DEPTNO != 10
GROUP BY DEPTNO;

# 부서별 사원수를 조회. 단, 부서별 인원수가 5명 이하인 부서는 제외
# GOUPING이 완료된 후 추가되는 조건은 HAVING절에 작성해야 한다.
SELECT DEPTNO, COUNT(EMPNO)
FROM emp
GROUP BY DEPTNO
HAVING COUNT(EMPNO) >= 5;

# 직급별로 직급, 직급별 급여의 합을 조회
# 직급이 사원과 사장인 직급 제외하고, 직급별 급여의 합이 500 이상인 데이터 조회.
# 조회되는 데이터는 직급별 급여의 합 기준 내림차순 정렬
# SUM(SAL) : 직급별 급여라고 해석(GROUP BY JOB과 함께 쓰였으므로)
SELECT JOB, SUM(SAL)
FROM emp
WHERE JOB NOT IN ('사원', '사장')
GROUP BY JOB
HAVING SUM(SAL) >= 500
ORDER BY SUM(SAL) DESC;