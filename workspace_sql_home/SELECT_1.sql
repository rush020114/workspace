# database : 데이터 모음집
# DBMS : 데이터베이스 관리 시스템(우리가 배우는 것)
# 데이터는 신뢰도가 중요하다. DBMS는 데이터의 신뢰도를 지킬 수 있다.
# DBMS를 쓰는 이유는 우리가 작성한 프로그램의 데이터를 영원히 저장하기 위해서이다.
# 데이터는 표 형태로 저장된다.
# 데이터베이스는 순서가 정해져있지 않다.
# DBMS는 데이터 저장, 삭제, 조회를 코드(명령어)로 한다. 이것을 SQL이라 하는데 실무에선 Query라 부른다.	

# 조회문법 -> SELECT 조회할 칼럼 FROM 테이블명 [WHERE 조건] (대괄호의 뜻은 쓸 때도 있고 아닐 때도 있다는 뜻)

SELECT * FROM emp; # emp 테이블(사원정보가 있는 데이터) 안에 있는 모든 정보를 조회한다.

SELECT 3 FROM emp; # 조회는 컬럼만 할 수 있는 것이 아니다.(출력은 EMP테이블의 데이터 수만큼 나온다.)

SELECT '홍길동' FROM emp; # DBMS의 문자열은 홀따옴표를 붙인다.

# 조회 조건
# 같다(=), 다르다(!=, <>) 
# 그리고(AND), 이거나(OR)
# NULL체크는 IS(NULL이다.), IS NOT(NULL이 아니다.)으로 구분한다.

SELECT EMPNO, ENAME, JOB 
FROM emp 
WHERE EMPNO >= 1005; # EMP 테이블에서 사번이 1005이상인 사번, 사원명, 직급을 조회

 SELECT EMPNO, ENAME, JOB
 FROM emp
 WHERE JOB = '사원'; # EMP 테이블에서 직급이 사원인 사번, 사원명 직급을 조회
 
 SELECT *
 FROM emp 
 WHERE JOB != '사원' AND SAL >= 300 AND COMM IS NULL; # EMP 테이블에서 직급이 사원이 아니면서 급여가 300 이상이고 보너스가 NULL이 아닌 모든 정보를 조회