# 서브 쿼리 (sub query) : 쿼리 안에 작성된 또 다른 쿼리
# 서브 쿼리는 다양한 곳에서 활용되지만 두 개 이상의 테이블의 컬럼을 조회할 때 사용

# 김사랑 사원과 같은 부서(먼저 해석)에 속한 사원들의 사번, 부서번호, 사원명을 조회
SELECT EMPNO, DEPTNO, ENAME
FROM emp 
WHERE DEPTNO = (SELECT DEPTNO 
					FROM emp 
					WHERE ENAME = '김사랑');

# 전체 사원의 평균 급여(먼저 해석)보다 높은 급여를 받는 사원들의 사원번호, 사원명, 급여를 조회
SELECT EMPNO, ENAME, SAL
FROM emp
WHERE SAL > (SELECT AVG(SAL) FROM emp);

# 김사랑 사원의 사번, 사원명, 부서번호, 부서명을 조회. 단, 조인 사용 금지, 서브쿼리 활용
# 해석순서 : 조회가 될 시 EMP테이블의 DEPTNO가 20이 나오므로 서브 쿼리의 emp.DEPTNO에 20이 들어간다.
SELECT EMPNO
	, ENAME
	, DEPTNO
	, (SELECT DNAME 
		FROM dept 
		WHERE DEPTNO = emp.DEPTNO) DNAME
FROM emp
WHERE ENAME = '김사랑'

