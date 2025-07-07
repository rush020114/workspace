# 테이블 : 데이터의 집합 (집)
# 데이터 : 테이블 안에 포함 (가구)

# 테이블 생성 문법
# create table 테이블명(
#	 컬럼명 데이터타입 [제약조건],
#	 컬럼명 데이터타입 [제약조건],
#	 컬럼명 데이터타입 [제약조건],
#	 ...
#   ); 

# 학생 정보 저장하는 테이블 생성문
CREATE TABLE student(
# 기본 키(PRIMARY KEY)는 중복되지 않는 것에 준다.(데이터를 선별하기 위해)
# 테이블에 기본키는 반드시 있어야 한다.
# 기본키는 중복되는 데이터와 NULL을 허락하지 않는다.
	STU_NUM INT PRIMARY KEY, # PRIMARY KEY는 제약 조건중 하나로 데이터의 결함을 없애준다.
	STU_NAME VARCHAR(10),
	KOR_SCORE INT,
	MATH_SCORE INT
);

SELECT * 
FROM student;

# 테이블을 생성 후엔 데이터를 넣어주어야 한다.
# 데이터 삽입 문법
# INSERT INTO 테이블명 (컬럼들) VALUES (값들);
INSERT INTO student (STU_NUM, STU_NAME, KOR_SCORE, MATH_SCORE) 
VALUES (2, '김자바', 80, 90); # STU_NUM에 같은 값을 넣어주면 기본키 제약 조건 때문에 오류가 뜬다.

# 칼럼명은 반드시 테이블에 정의된 컬럼의 개수와 순서를 맞출 필요가 없다.
# 대신 VALUES를 똑같이 입력해주어야 한다.
INSERT INTO student (STU_NUM, MATH_SCORE, STU_NAME)
VALUES (3, 100, '이자바');

INSERT INTO student (KOR_SCORE, MATH_SCORE, STU_NUM)
VALUES (70, 60, 4);

# 데이터 다루는 쿼리문 : CRUD
# 데이터는 신뢰도가 중요한데 C, U , D는 신뢰도를 깨뜨릴 수 있다.
# 이를 위해 ROLLBACK, COMMIT을 반드시 실행
# ROLLBACK : 삽입한 데이터 취소
# COMMIT : 삽입한 데이터를 저장

ROLLBACK;

# 테이블 삭제 문법
DROP TABLE student;

# 회원 정보 테이블
# 아이디, 비밀번호, 회원이름, 회원 나이, 이메일 정보를 가지고 있다.
CREATE TABLE MEMBER(
	MEM_ID VARCHAR(10) PRIMARY KEY,
	MEM_PW VARCHAR(10) NOT NULL, # NULL이 들어올 수 없다는 제약조건
	MEM_NAME VARCHAR(10) NOT NULL,
	MEM_AGE INT,
	MEM_EMAIL VARCHAR(20) UNIQUE # 중복데이터가 들어갈 수 없는 제약조건 (단, NULL은 가능하고 중복 체크가 되지 않는다.)
);

SELECT *
FROM MEMBER;
# 아이디 : JAVA
# 비번 : 1111
# 이름 : 김자바
# 나이 : 36
# 이메일 : java@gmail.com

INSERT INTO MEMBER (MEM_ID, MEM_PW, MEM_NAME, MEM_AGE, MEM_EMAIL) 
VALUES ('JAVA', '1111', '김자바', 36, 'java@gamil.com');

# 테이블 생성문에서 작성한 컬럼명 순서대로 데이터를 삽입하면 컬럼명 생략 가능
INSERT INTO MEMBER
VALUES ('JAVA3', '2222', '최자바', 40, 'JAVA@gmail.com'); 
COMMIT;

# 게시판 테이블
# 글번호, 제목, 작성자, 내용, 작성일, 조회수
CREATE TABLE BOARD(
	BOARD_NUM INT PRIMARY KEY AUTO_INCREMENT, # AUTO_INCREMENT는 자동 증가이다.(데이터 식별을 위한 컬럼이고 어떤 정보를 표현하진 않기에 어떤 데이터를 주어도 상관없으므로 주는 것이다.)
	TITLE VARCHAR(20) NOT NULL,
	WRITER VARCHAR(10) NOT NULL,
	CONTENT VARCHAR(100),
	CREATE_DATE DATETIME DEFAULT SYSDATE(), # DATATIME은 날짜 + 시간, DATE는 날짜만 들어간다, SYSDATE()는 자동으로 컴퓨터 시간을 넣어준다.
	READ_CNT INT DEFAULT 0 # 데이터 등록 시 기본값으로 0을 주겠다.
);

INSERT INTO BOARD (TITLE, WRITER) # AUTO_INCREMENT덕분에 계속 등록이 가능하다.
VALUES ('제목1', '작성자1');

INSERT INTO BOARD (TITLE, WRITER, READ_CNT, CREATE_DATE, BOARD_NUM)
VALUES ('제목2', '작성자2', 5, '2020-10-10 17:50:00', 10); # DEFAULT 값은 기본값이기 때문에 강제로 등록 가능하다.
# 날짜 데이터는 문자열처럼 위의 형식대로 넣어주면 된다.
# BOARD_NUM에도 값을 강제로 넣을 수 있다. 위의 설정들은 값을 지정해주지 않았을 때 자동으로 실행되는 것이기에 강제로 등록하면 등록되는 것이다.

SELECT *
FROM BOARD;

ROLLBACK;