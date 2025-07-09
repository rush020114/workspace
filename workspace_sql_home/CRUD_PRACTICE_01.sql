CREATE TABLE student(
	STU_NUM INT PRIMARY KEY AUTO_INCREMENT,
	STU_NAME VARCHAR(10) NOT NULL,
	STU_AGE INT DEFAULT 19,
	STU_ADDR VARCHAR(20) DEFAULT '울산',
	HOBBY VARCHAR(10),
	STU_TEL VARCHAR(20) NOT NULL UNIQUE
);

SELECT *
FROM student;

INSERT INTO student (STU_NAME, HOBBY, STU_TEL) 
VALUES ('김', '노래','021');

INSERT INTO student (STU_NAME, HOBBY, STU_TEL, STU_AGE, STU_ADDR) 
VALUES ('최', '달리기','018', 18, '경주');

INSERT INTO student (STU_NAME, HOBBY, STU_TEL, STU_AGE) 
VALUES ('정', NULL,'020', 18);

INSERT INTO student (STU_NAME, HOBBY, STU_TEL, STU_ADDR) 
VALUES ('이', '골프','016', '서울');

ROLLBACK;

COMMIT;
# DROP TABLE student;

# 취미가 있는 사람 조회
SELECT *
FROM student
WHERE HOBBY IS NOT NULL;

# 지역이름이 산으로 끝나는 학생이름, 주소, 취미를 이름 오름차순으로 정렬하고 이름이 같다면 취미를 내림차순으로 정렬(NULL이 맨위로 정렬)
SELECT STU_NAME, STU_ADDR, HOBBY
FROM student
WHERE STU_ADDR
LIKE '%산'
ORDER BY STU_NAME ASC ,
HOBBY DESC;

# 나이가 19이면서 취미가 있는 모든 컬럼을 조회하는데 이름을 오름차순으로 정렬하는데 이름이 같다면 주소를 오름차순으로 정렬
SELECT *
FROM student
WHERE STU_AGE = 19
AND HOBBY IS NOT NULL
ORDER BY STU_NAME ASC, STU_ADDR ASC;

SELECT *
FROM student;

ROLLBACK;

COMMIT;

DELETE FROM student; # 데이터 전체 삭제

DELETE FROM student # 나이가 19미만인 학생의 행 삭제
WHERE STU_AGE < 19;

DELETE FROM student
WHERE STU_ADDR != '울산'; #  울산이 아닌 학생 행 삭제

UPDATE student
SET
STU_NAME = '하하'; # 모든 학생이름을 하하로 바꾸겠다.

UPDATE student
SET
STU_NAME = 'LEE'
WHERE STU_NAME = '이'; # 학생이름이 '이'인 학생의 이름을 LEE로 바꾸겠다.

UPDATE student
SET 
STU_AGE = STU_AGE + 1; # 모든 학생의 나이를 1 올리겠다.

SELECT STU_NUM * STU_AGE AS '의미없는 컬럼'
FROM student; # 학생번호와 학생나이를 곱한 컬럼을 별칭 '의미없는 컬럼'으로 조회하겠다.(학생 수의 데이터 만큼 나옴)