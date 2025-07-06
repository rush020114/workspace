#1. emp 테이블에서 모든 사원의 사번, 사원명, 급여, 커미션을 조회하시오.
# 2. EMP 테이블에서 사번이 1005번 이상인 사원들의 사번, 사원명, 직급을 조회하되, 
#사원명은 ‘NAME’이라는 별칭으로 조회하시오.
# 3. EMP 테이블에서 직급이 대리이거나과장인 사원들의 사원명, 직급, 급여를 조회하시오.
# 4. EMP 테이블에서 급여가 300 이상이면서 커미션이 300 이상인 사원들의 모든 컬럼을 조회하시오.
# 5. EMP 테이블에서 급여가 900 이하이고 커미션은 NULL이 아니며 
#직급은 대리이거나 과장인 사원들의 사원명, 직급, 급여, 커미션을 조회하시오.

SELECT * 
FROM emp;

SELECT EMPNO, ENAME AS NAME, JOB
FROM emp
WHERE EMPNO >= 1005;

SELECT ENAME, JOB, SAL
FROM emp
#WHERE JOB = '대리' OR JOB = '과장'
WHERE JOB IN ('대리', '과장');

SELECT *
FROM emp
WHERE SAL >= 300
AND COMM >= 300;

SELECT ENAME, JOB, SAL, COMM
FROM emp
WHERE SAL <= 900
AND COMM IS NOT NULL;