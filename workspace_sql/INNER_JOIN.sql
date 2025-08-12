# join : 둘 이상의 테이블에서 데이터를 조회하는 것
# -- 사전 지식 --
# 사원번호, 사원명, 급여, 부서번호를 조회
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM emp;

# 위 쿼리문에 생략된 부분을 살리면
SELECT emp.EMPNO, emp.ENAME, emp.SAL, emp.DEPTNO
FROM emp;

# 별칭을 테이블명에 적용시키면...
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM emp 부서정보;

# 위 두 내용을 함께 사용하면 다음과 같다.
SELECT E.EMPNO, E.ENAME, E.SAL, E.DEPTNO
FROM emp E;

# --- 조인의 기본문법(Cross Join) ---
# 사번, 사원명, 급여, 부서명, 부서번호를 조회
SELECT * FROM emp; # 14
SELECT * FROM dept; # 4

SELECT EMPNO, ENAME, SAL, DNAME, EMP.DEPTNO, dept.DEPTNO
FROM emp JOIN dept;

# INNER 조인
SELECT EMPNO, ENAME, SAL, DNAME, EMP.DEPTNO, dept.DEPTNO
FROM emp INNER JOIN dept # JOIN 대신 INNER JOIN을 넣으면 더 정확함.
ON emp.DEPTNO = dept.DEPTNO; # JOIN 조건은 WHERE절이 아니라 ON 절에 넣는다.

# 급여가 300이상인 사원들의 사번, 사원명, 급여, 부서번호, 부서명, 부서지역을
# 조회화되, 급여 기준 내림차순으로 정렬
SELECT EMPNO, ENAME, SAL, E.DEPTNO, DNAME, LOC
FROM emp E INNER JOIN dept D
ON emp.DEPTNO = dept.DEPTNO
WHERE SAL >= 300
ORDER BY SAL DESC;

SELECT EMPNO, ENAME, LOC
FROM emp INNER JOIN dept
ON emp.DEPTNO = dept.DEPTNO;