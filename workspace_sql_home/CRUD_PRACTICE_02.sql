# DROP TABLE student;

# 고유번호를 갖는 소유주, 호실(중복 안 되고, NULL 안 됨), 집인원수(기본값1), 재산, 소유주 이름(NULL 안 됨), 차 소유수(기본값0)
CREATE TABLE apt(
	OWN_IDEN INT PRIMARY KEY,
	UNIT INT UNIQUE NOT NULL,
	RESI_CNT INT DEFAULT 1,
	PROPERTY INT,
	RESI_OWN VARCHAR(10) NOT NULL,
	CAR INT DEFAULT 0
);

SELECT *
FROM apt;

# 어떤 제한 조건이 있더라도 데이터 삽입 컬럼에 포함되면 비울 수 없고 입력을 해주어야 함.
INSERT INTO apt (OWN_IDEN, UNIT, RESI_CNT, PROPERTY, RESI_OWN, CAR) 
VALUES (6666, 303, 4, 30000, '이', 1);

INSERT INTO apt (OWN_IDEN, UNIT, RESI_CNT, RESI_OWN, CAR) 
VALUES (7777, 304, 4, '권', 1);

INSERT INTO apt (OWN_IDEN, UNIT, RESI_CNT, RESI_OWN) 
VALUES (9999, 306, 1, '성');

INSERT INTO apt (OWN_IDEN, UNIT, RESI_CNT, PROPERTY, RESI_OWN) 
VALUES (8888, 305, 1, 8000,'박');

# 2층 이상에 사는 가족수 재산 소유주 조회(층수를 내림차순으로 정렬하며 오름차순 이름이 같다면 가족수를 내림차순으로)
SELECT UNIT, RESI_CNT, PROPERTY, RESI_OWN
FROM apt
WHERE UNIT >= 2
ORDER BY UNIT DESC, RESI_OWN ASC, RESI_CNT DESC;

# 모든 칼럼을 재산을 내림차순으로 정렬하되 재산이 같다면 자동차수를 내림차순으로 정렬하며 자동차수가 같다면 가족수를 내림차순으로 정렬
SELECT *
FROM apt
ORDER BY PROPERTY DESC, CAR DESC, RESI_CNT DESC;

# 이씨와 김씨의 재산과 차를 호실을 조회할 때 재산을 내림차순으로 하고 재산이 같다면 차를 내림차순으로
SELECT UNIT ,RESI_OWN, PROPERTY, CAR
FROM apt
WHERE RESI_OWN LIKE '이%'
OR RESI_OWN LIKE '김%'
ORDER BY PROPERTY DESC, CAR DESC;

COMMIT;

SELECT *
FROM apt;

# 105호에 주씨인 사람이 가족 3명과 40000원의 재산과 차 한 대를 갖고 입주
UPDATE apt
SET
RESI_CNT = 3,
PROPERTY = 40000,
RESI_OWN = '주',
CAR = 1
WHERE UNIT = 105;

# 205호의 재산이 20000원이 되고 차가 한 대 생김
UPDATE apt
SET
PROPERTY = 20000,
CAR  = 1
WHERE UNIT = 205;

# 205호에 가족이 한 명 더 생김
UPDATE apt
SET
RESI_CNT = RESI_CNT + 1
WHERE UNIT = 205;

# 201호와 103호에 가족이 한 명 더 생김
UPDATE apt
SET
RESI_CNT = RESI_CNT + 1
WHERE UNIT = 103
OR UNIT = 201;

# 306호 이사
DELETE FROM apt
WHERE UNIT = 306;

ROLLBACK;