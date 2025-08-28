-- 1. 고객 테이블 생성
CREATE TABLE CUSTOMER (
    CUSTOMER_ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(50),
    EMAIL VARCHAR(100),
    CITY VARCHAR(50),
    CREATED_AT DATETIME DEFAULT SYSDATE()
);

-- 2. 주문 테이블 생성 (외래키 사용)
CREATE TABLE ORDERS (
    ORDER_ID INT PRIMARY KEY AUTO_INCREMENT,
    CUSTOMER_ID INT REFERENCES CUSTOMER (CUSTOMER_ID),
    PRODUCT_NAME VARCHAR(100),
    ORDER_CNT INT,
    ORDER_DATE DATETIME DEFAULT SYSDATE() 
);

INSERT INTO CUSTOMER (NAME, EMAIL, CITY) VALUES 
('김철수', 'chulsoo@example.com', '서울'),
('이영희', 'younghee@example.com', '부산'),
('박민준', 'minjun@example.com', '대구'),
('정하나', 'hana@example.com', '광주'),
('최수진', 'soojin@example.com', '인천');

-- 4. 주문 데이터 삽입
INSERT INTO Orders (CUSTOMER_ID, PRODUCT_NAME, ORDER_CNT, ORDER_DATE) VALUES
(1, '노트북', 1, '2024-02-01'),
(1, '스마트폰', 2, '2024-02-05'),
(2, '태블릿', 1, '2024-02-10'),
(3, '스마트폰', 1, '2024-02-15'),
(4, '모니터', 2, '2024-02-20');

COMMIT;

SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;

#1. 고객 이름과 주문한 상품명, 수량을 조회
SELECT NAME
	, PRODUCT_NAME
	, ORDER_CNT
FROM orders O
INNER JOIN customer C
ON O.CUSTOMER_ID = C.CUSTOMER_ID;

SELECT (SELECT NAME 
		FROM customer 
		WHERE CUSTOMER_ID = O.CUSTOMER_ID) NAME
	, PRODUCT_NAME
	, ORDER_CNT
FROM orders O;

#2. 고객 "김철수"가 주문한 상품명 조회
SELECT PRODUCT_NAME
FROM orders
WHERE CUSTOMER_ID = (SELECT CUSTOMER_ID 
							FROM customer 
							WHERE NAME = '김철수');

SELECT PRODUCT_NAME
FROM customer C
INNER JOIN orders O
ON C.CUSTOMER_ID = O.CUSTOMER_ID
WHERE NAME = '김철수';


#3. 고객별 총 주문 수량 조회
SELECT SUM(ORDER_CNT), CUSTOMER_ID
FROM orders
GROUP BY CUSTOMER_ID;

#4. 최소 한 번이라도 주문한 고객의 이름 조회
# -> 고객번호가 1,2,3,4번인 사람의 이름을 조회

SELECT NAME
FROM customer
WHERE CUSTOMER_ID IN (SELECT DISTINCT CUSTOMER_ID FROM orders);
