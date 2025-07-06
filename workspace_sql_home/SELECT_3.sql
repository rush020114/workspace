#1. EMP 테이블에서 커미션이 NULL이 아닌 사원 중, 
#급여가 350에서 650 사이인 사원들의 사원명, 급여, 커미션을 조회하되, 쿼리문 작성 시
# BETWEEN 연산자를 사용하여 작성하시오.
#2. 직급이 과장, 차장, 부장인 직원의 사번, 사원명, 직급을 조회하되, 
#직급 기준 오름차순으로 정렬하고, 쿼리 작성 시 IN 연산자를 사용하시오.
#3. 부서번호가 10, 20인 부서에 소속된 직원 중, 
#이름에 ‘이’가 포함된 직원의 사번, 사원명, 부서번호, 급여를 조회하되, 
#부서번호 기준 내림차순으로 정렬 후,
#부서번호가 같다면 급여가 낮은 순부터 조회하는 쿼리문을 작성하시오.
#4. 이름이 ‘기＇로 끝나는 직원 중, 커미션은 NULL이고 
#급여는 400에서 800 사이인 직원의 모든 컬럼 정보를 조회하시오.
SELECT *
FROM emp;

SELECT ENAME, SAL, COMM
FROM emp
WHERE SAL
BETWEEN 350 AND 650;

SELECT EMPNO, ENAME, JOB
FROM emp
WHERE JOB 
IN ('과장', '차장', '부장')
ORDER BY JOB ASC;

SELECT EMPNO, ENAME, DEPTNO, SAL
FROM emp
WHERE DEPTNO IN (10, 20)
AND ENAME LIKE '%이%'
ORDER BY DEPTNO DESC, SAL ASC;

SELECT *
FROM emp
WHERE ENAME LIKE '%기'
AND COMM IS NULL
AND SAL >= 400
AND SAL <= 800;