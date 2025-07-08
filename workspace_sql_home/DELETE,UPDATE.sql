# MARIADB는 자동 COMMIT을 해주기 때문에 자동COMMIT을 막아주는 실행문을 시작으로 지정하고 데이터를 다루는 중이다.

# 구매이력 테이블 생성
# 이 테이블은 구매번호(고유값, 자동 1증가), 상품명(중복데이터와 데이터 없음을 허용하지 않음)
# 구매 수량(기본값로 정수 1), 가격, 구매자(무조건 데이터 삽입), 구매일시(자동으로 구매일시 입력)을 가진다.
CREATE TABLE sale_info(
	SALE_NUM INT PRIMARY KEY AUTO_INCREMENT,
	ITEM_NAME VARCHAR(10) NOT NULL UNIQUE,
	BUY_CNT INT DEFAULT 1,
	ITEM_PRICE INT,
	BUY_USER VARCHAR(10) NOT NULL,
	BUY_DATE DATETIME DEFAULT SYSDATE()
);

# 구매번호와 구매일시는 자동으로 값을 가지므로 컬럼에 추가할 필요 없다.
INSERT INTO sale_info (ITEM_NAME, BUY_CNT, ITEM_PRICE, BUY_USER)
VALUES ('블라우스', 2, 30000,'윤인사');

SELECT *
FROM sale_info;

COMMIT; # 데이터를 삽입하고 데이터가 확실하면 COMMIT을 해준다.

# 상품가격이 10000원 이상인 구매자, 가격, 상품명 조회
SELECT BUY_USER, ITEM_PRICE, ITEM_NAME
FROM sale_info
WHERE ITEM_PRICE >= 10000;

# 구매번호가 2이상인 컬럼 중 
#이름에 '바'가 들어가거나 성씨가 '이'인 모든 컬럼을 가격이 내림차순이 되도록 조회
SELECT *
FROM sale_info
WHERE SALE_NUM >= 2
AND (BUY_USER LIKE '%바%' OR BUY_USER LIKE '이%')
ORDER BY ITEM_PRICE DESC;

# 구매자명이 김자바, 윤인사, 정자바인 사람 중에서
# 5000원 이상 20000원 이하인 구매자명, 상품명, 가격 조회
SELECT BUY_USER, ITEM_NAME, ITEM_PRICE
FROM sale_info
WHERE BUY_USER IN ('김자바', '윤인사', '정자바')
AND ITEM_PRICE >= 5000
AND ITEM_PRICE <= 20000;

SELECT * FROM sale_info;

# 데이터 삭제 
# DELETE FROM 테이블명 [WHERE 조건];
# 행 전체가 삭제됨

ROLLBACK;
DELETE FROM sale_info; # 조건이 없기 때문에 모든 데이터 삭제

# 상품가격이 10000원을 초과한 상품구매정보 삭제
DELETE FROM sale_info
WHERE ITEM_PRICE > 10000;

# 데이터 수정
# UPDATE 테이블명
# SET
# 컬럼명 = 변경한 값,
# 컬럼명 = 변경한 값
# [WHERE 조건]

# 상품의 가격과 구매자명 변경 쿼리
UPDATE sale_info
SET
ITEM_PRICE = 1500,
BUY_USER = '관리자'; # 조건이 없으므로 모든 데이터가 바뀜


# 데이터 삭제, 수정 쿼리도 데이터의 변화를 주므로 ROLLBACK, COMMIT이 존재

UPDATE sale_info
SET
ITEM_PRICE = 1500,
BUY_USER = '관리자'
WHERE SALE_NUM = 1;

# 모든 가격을 1500올리는 쿼리
UPDATE sale_info
SET
ITEM_PRICE = ITEM_PRICE + 1500;

# 상품명, 상품 가격, 구매수량, 총 구매 가격을 조회
# 데이터 조회를 할 때 컬럼명만 조회할 수 있는 것이 아니니
# 컬럼과 값(문자, 수)들을 활용(연산)하고 별칭을 적용하여 다양한 데이터를 조회할 수 있다.
SELECT ITEM_NAME, ITEM_PRICE, BUY_CNT, ITEM_PRICE * BUY_CNT AS TOTAL_PRICE
FROM sale_info;
