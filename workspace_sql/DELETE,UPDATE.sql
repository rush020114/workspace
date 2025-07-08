# 다음과 같은 요구사항을 충족하는 구매이력 테이블(SALE_INFO)을 만들어보자
# 구매 정보 테이블의 컬럼은 구매번호, 구매 상품명, 구매 수량, 상품 가격
# 구매자명, 구매일시(년월일시분초)를 가진다.
# PK는 구매번호로 지정하며, 1부터 1씩 자동 증가되게 한다.
# 구매 상품명, 구매자명은 NULL이 들아갈 수 없다.
# 구매 수량 데이터를 입력하지 않으면 기본적으로 1이 들어가도록 설정한다.
# 구매 일시는 기본값으로 현재 날짜 및 시간이 들어가도록 한다.
# 구매 상품명은 중복 데이터를 가질 수 없다.
CREATE TABLE SALE_INFO(
	SALE_NUM INT PRIMARY KEY AUTO_INCREMENT,
	ITEM_NAME VARCHAR(10) NOT NULL UNIQUE,
	BUY_CNT INT DEFAULT 1,
	ITEM_PRICE INT, 
	BUY_USER VARCHAR(10) NOT NULL,
	BUY_DATE DATETIME DEFAULT SYSDATE()
);

INSERT INTO SALE_INFO (ITEM_NAME, BUY_CNT, ITEM_PRICE, BUY_USER) 
VALUES ('블라우스', 2, 30000, '윤인사');

SELECT *
FROM sale_info;

COMMIT;

# 1. 상품 가격이 10000원 이상인 상품을 구매한 구매자명, 상품가격, 상품명을 조회
SELECT BUY_USER, ITEM_PRICE, ITEM_NAME
FROM sale_info
WHERE ITEM_PRICE >= 10000;

# 2. 상품명이 2번 이상인 구매 정보 중에서 구메자명에 '바'가 포함되거나, '이'씨가 구매한 구매정보의 모든 칼럼정보를 조회
SELECT *
FROM sale_info
WHERE SALE_NUM >= 2
AND (BUY_USER LIKE '%바%' OR BUY_USER LIKE '이%')
ORDER BY ITEM_PRICE DESC;

# 3. 구매자가 '김자바', '윤인사', '정자바'인 구매자 정보 중,
# 구매 가격이 5000~20000인 구매 정보의 구매자명, 구매상품명, 구매 가격을 조회
SELECT BUY_USER, ITEM_NAME, ITEM_PRICE
FROM sale_info
WHERE BUY_USER IN ('김자바', '윤인사', '정자바')

# ITEM_PRICE BETWEEN 5000 AND 20000
AND ITEM_PRICE >= 5000
AND ITEM_PRICE <= 20000;

SELECT *
FROM sale_info;

ROLLBACK;

# 데이터 삭제
# DELETE FROM 테이블명 [WHERE 조건];
DELETE FROM sale_info; # 조건이 없는 DELETE는 모든 데이터를 삭제

# DROP TABLE sale_info;

# 상품 가격이 10000원을 초과한 상품구매정보는 삭제
DELETE FROM sale_info
WHERE ITEM_PRICE > 10000;

# 데이터 수정
# UPDATE 테이블명
# SET
#   컬럼명 = 변경한 값,
#   컬럼명 = 변경한 값
# [WHERE 조건];

# 상품의 가격과 구매자명을 변경하는 쿼리
UPDATE sale_info
SET 
   ITEM_PRICE = 15000,
   BUY_USER = '관리자'
WHERE SALE_NUM = 1;

# 모든 상품의 상품 가격을 10000원 인상하는 쿼리 작성
UPDATE sale_info
SET 
ITEM_PRICE = ITEM_PRICE + 1000;

COMMIT;
SELECT * FROM sale_info;
# 상품명, 상품가격, 구매 수량, 총 구매 수량  

SELECT ITEM_NAME, ITEM_PRICE, BUY_CNT, ITEM_PRICE * BUY_CNT AS TOTAL_PRICE # 조회할 때 꼭 컬럼 안의 내용만 실행할 수 있는 것이 아니기 때문에 새로운 컬럼을 작성하여 별칭을 주어 조회할 수 있다.
FROM sale_info;