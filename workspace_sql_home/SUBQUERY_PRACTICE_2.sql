-- 1. 도서 테이블 생성
CREATE TABLE TEST_BOOK (
    BOOK_ID INT PRIMARY KEY AUTO_INCREMENT,
    TITLE VARCHAR(100),
    AUTHOR VARCHAR(50),
    PUBLISHED_YEAR INT,
    CREATED_AT DATETIME DEFAULT SYSDATE()
);

-- 2. 대출 테이블 생성 (외래키 사용)
CREATE TABLE RENTAL (
    RENTAL_ID INT PRIMARY KEY AUTO_INCREMENT,
    BOOK_ID INT REFERENCES TEST_BOOK (BOOK_ID),
    BORROWER_NAME VARCHAR(50),
    RENTAL_DATE DATETIME DEFAULT SYSDATE(),
    RETURN_DATE DATETIME NULL
);
SELECT * FROM test_book;
SELECT * FROM rental;

#도서 제목, 저자, 대출자 이름, 대출 날짜를 조회하시오.'
SELECT (SELECT TITLE 
		FROM test_book T
		WHERE T.BOOK_ID = R.BOOK_ID) TITLE
		, (SELECT AUTHOR
		FROM test_book T
		WHERE T.BOOK_ID = R.BOOK_ID) AUTHOR
		, BORROWER_NAME
		, RENTAL_DATE
FROM rental R;

#출판 연도가 2020년 이후인 도서 중 대출된 적이 있는 도서의 모든 정보를 조회하시오.
SELECT *
FROM test_book T
WHERE PUBLISHED_YEAR >= 2020
AND EXISTS (SELECT 1 
				FROM rental R
				WHERE R.BOOK_ID = T.BOOK_ID);

SELECT DISTINCT T.BOOK_ID
	, TITLE
	, AUTHOR
	, CREATED_AT
FROM test_book T
INNER JOIN rental R
ON T.BOOK_ID = R.BOOK_ID;

#한 번도 대출되지 않은 도서의 제목과 저자를 조회하시오.
SELECT TITLE
	, AUTHOR 
FROM test_book
WHERE BOOK_ID NOT IN (SELECT BOOK_ID
					FROM rental);

#모든 도서의 제목, 대출횟수, 대출 여부를 출력하세요. 대출 여부는 한번이라도 대출된 적이 있는
#책은 '대출기록있음', 대출된 적이 없는 도서에는 '대출이이력없음'으로 조회하시오.
SELECT TITLE
		, (SELECT COUNT(BOOK_ID)
			FROM rental R
			WHERE R.BOOK_ID = T.BOOK_ID) 대출횟수
		, CASE (SELECT COUNT(BOOK_ID)
					FROM rental R
					WHERE R.BOOK_ID = T.BOOK_ID)
			WHEN 0 THEN '대출이력없음'
			ELSE '대출기록있음' END 대출여부
FROM test_book T;
