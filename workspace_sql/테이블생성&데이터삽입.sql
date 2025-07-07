# 테이블 생성

# 학생 정보를 저장하는 테이블 생성문

# 항상 기본키를 무엇으로 할지 고민해야 한다.
CREATE TABLE student(
	 # 겹치지 않는 것에 기본 키(PRIMARY KEY)를 준다. (겹치면 한 명만 못 집어내기 때문에)
	STU_NUM INT PRIMARY KEY, # 중복 데이터 저장 불가, NULL 불가
	STU_NAME VARCHAR(10),
	KOR_SCORE INT,
	MATH_SCORE INT
);

SELECT *
FROM student;
COMMIT;
ROLLBACK;

# 데이터 삽입 문법
# INSERT INTO 테이블명 (컬럼들) VALUES (값들);
INSERT INTO student (STU_NUM, STU_NAME, KOR_SCORE, MATH_SCORE)
VALUES (2, '김자바', 80, 90);

# 컬럼명은 반드시 테이블에 정의된 컬럼의 개수를 맞출 필요 없다.
# 순서도 맞출 필요 없다.
INSERT INTO student (STU_NUM, MATH_SCORE, STU_NAME)
VALUE (3, 100, '이자바'); # 대신 작성한 칼럼의 순서를 잘 지켜야 한다.

INSERT INTO student (KOR_SCORE, MATH_SCORE, STU_NUM)
VALUE (60, 70, 4);

# 데이터 변화 쿼리
# C : CREATE 데이터 생성(INSERT)
# R : READ 조회(SELECT)
# U : UPDATE 변경(UPDATE)
# D : DELETE 삭제(DELETE)
# 이 중 SELECT를 제외하고는 다 데이터의 신뢰도가 깨질 염려가 있다.
# 데이터의 변화가 발생하는 쿼리문(삽입, 삭제, 수정) 실행 시 반드시 COMMIT을 ROLLBACK을 진행해야 한다.
# ROLLBAKC : 데이터 지우기, COMMIT : 데이터 확정(COMMIT 실행 시 ROLLBACK 안 됨)

# 테이블 삭제 쿼리 : DROP TABLE 테이블명;
DROP TABLE student;

# 회원정보 테이블
# 아이디, 비밀번호, 회원이름, 회원 나이, 이메일 정보를 갖고 있다.

CREATE TABLE MEMBER(
	MEM_ID VARCHAR(10) PRIMARY KEY,
	MEM_PW VARCHAR(10) NOT NULL, # NOT NULL 제약 조건 : NULL이 들어갈 수 없다.
	MEM_NAME VARCHAR(10) NOT NULL,
	MEM_AGE INT,
	MEM_EMAIL VARCHAR(20) UNIQUE # UNIQUE 제약 조건 : 중복이 되지 않는다.(NULL은 가능! NULL은 중복 체크 X)
	# MEM_EMAIL VARCHAR(20) UNIQUE NOT NULL
	# 위의 쿼리는 제약 조건을 두 개 쓴 것이고 사용 방법은 적용할 제약 조건을 나열한다.(PRIMARY KEY는 한 번밖에 쓰지 못함)
);

SELECT *
FROM member;

# 아이디 : java
# 비번 : 1111
# 이름 : 김자바
# 나이 : 30
# 이메일 : java@gmail.com

INSERT INTO member (MEM_ID, MEM_PW, MEM_NAME, MEM_AGE, MEM_EMAIL)
VALUE ('java', '1111', '김자바', 30, 'java@gmail.com');

INSERT INTO member (MEM_ID, MEM_PW, MEM_AGE, MEM_EMAIL, MEM_NAME)
VALUE ('java2', '1234', 30, 'java1@gmail.com', 'AAA'); 

# 테이블 생성문에서 작성한 순서대로 데이터를 삽입하면 컬럼명 생략 가능
INSERT INTO member VALUES ('JAVA3', '2222', '최자바', 40, 'aaa@gmail.com');

COMMIT;

# 게시판 테이블
# 글번호, 제목, 작성자, 내용, 작성일, 조회수

CREATE TABLE BOARD( 
	BOARD_NUM INT PRIMARY KEY AUTO_INCREMENT, # AUTO_INCREMENT : 자동으로 증가
	TITLE VARCHAR(20) NOT NULL,
	WRITER VARCHAR(10) NOT NULL,
	CONTENT VARCHAR(100),
	CREATE_DATE DATETIME DEFAULT SYSDATE(), # 날짜 및 시간 타입
	READ_CNT INT DEFAULT 0 # DEFAULT : 데이터를 넣지 않으면 기본값으로 적용하겠다.
);

SELECT *
FROM BOARD;

INSERT INTO BOARD (TITLE, WRITER) 
VALUES ('제목1', '작성자1');

INSERT INTO BOARD (TITLE, WRITER, READ_CNT, CREATE_DATE, BOARD_NUM) 
VALUES ('제목1', '작성자1', 5, '2020-10-10 17:50:00', 15);
ROLLBACK;