#---------------------------------
#MySQL Workbench
#---------------------------------


#--------------------------
#INT 자료형 : 정수 저장용 자료형

CREATE TABLE items (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    item_text VARCHAR(255)
);

INSERT INTO items(item_text)
VALUES('laptop'), ('mouse'),('headphone');

SELECT 
    *
FROM
    items;
    
INSERT INTO items(item_id,item_text)
VALUES(10,'Server');

SELECT 
    *
FROM
    items;


#------------------------------------
#DECIMAL 자료형 : 실수 저장용 자료형
#DECIMAL(P, D) 

CREATE TABLE materials (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    cost DECIMAL(19, 4) NOT NULL
);


INSERT INTO materials(description,cost)
VALUES('Bicycle', 500.34),('Seat',10.23),('Break',5.21);

SELECT 
    *
FROM
    materials;
    
    
#-----------------------------------
#VARCHAR 자료형 : 문자 저장용 자료형
#유사 자료형을 TEXT 자료형 등이 있다.
    
CREATE TABLE test03 (
	tid INT auto_increment PRIMARY KEY
    ,col VARCHAR(10)
);

INSERT INTO test03(col)
VALUES('Server');  
INSERT INTO test03(col)
VALUES('한글자료저장시길이');

SELECT *
FROM test03;


#-----------------------------------
#TEXT 자료형 : 문자 저장용 자료형
#유사 자료형을 VARCHAR 자료형 등이 있다.
    
CREATE TABLE test04 (
	tid INT auto_increment PRIMARY KEY
    ,col TEXT
);

INSERT INTO test04(col)
VALUES('Server');  
INSERT INTO test04(col)
VALUES('한글자료저장시길이');

SELECT *
FROM test04;


#---------------------------------
#DATE : 날짜 저장용 자료형
#유사한 자료형으로 DATETIME 형이 있다.

CREATE TABLE people (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL
);

INSERT INTO people(first_name,last_name,birth_date)
VALUES('John','Doe','1990-09-01');

INSERT INTO people(first_name,last_name,birth_date)
VALUES('John2','Doe2','19900901');

INSERT INTO people(first_name,last_name,birth_date)
VALUES('John3','Doe3','1990/09/01');

SELECT 
    first_name, 
    last_name, 
    birth_date
FROM
    people;
    
CREATE TABLE test05 (
	tid INT auto_increment PRIMARY KEY
    ,col1 DATE
    ,col2 DATETIME
);

INSERT INTO test05(col1, col2)
VALUES (NOW(), NOW());

SELECT 
    *
FROM
    test05;
    


#---------------------------------------
#ALTER TABLE : 테이블 구조 수정 명령

#테이블 생성
CREATE TABLE test06 (
	tid INT auto_increment PRIMARY KEY
    ,col1 VARCHAR(10)
);

#컬럼 추가
ALTER TABLE test06
ADD COLUMN col2 VARCHAR(10);

#컬럼 삭제
ALTER TABLE test06
DROP COLUMN col2;

#컬럼 수정
ALTER TABLE test06
CHANGE COLUMN col2 col2 VARCHAR(30);



#------------------------------------
#DROP TABLE : 테이블 삭제 명령

DROP TABLE test06;




#--------------------------------------
#Primary Key : 제약 조건 중에서 유일한 값을 가져야 하는 제약 조건.

CREATE TABLE test08 (
	tid INT #PK
    ,col VARCHAR(10)
);

INSERT INTO test08 (tid, col)
VALUES (1, 'TEST');

INSERT INTO test08 (tid, col)
VALUES (1, 'SAMPLE');

SELECT *
FROM test08;

TRUNCATE TABLE test08;

ALTER TABLE test08
ADD PRIMARY KEY (tid);

INSERT INTO test08 (tid, col)
VALUES (1, 'TEST');

INSERT INTO test08 (tid, col)
VALUES (1, 'SAMPLE');

SELECT *
FROM test08;



#--------------------------------------
#Foreign Key : 제약 조건 중에서 참조 값을 가져야 하는 제약 조건.

#PRIMARY KEY 제약 지정
CREATE TABLE test09 (
	tid VARCHAR(4) #A001, A002, ...
    ,col VARCHAR(10)
);

ALTER TABLE test09
ADD CONSTRAINT test09_tid_pk PRIMARY KEY(tid);

INSERT INTO test09 (tid, col)
VALUES ('A001', 'TEST'), ('A002', 'SAMPLE');

SELECT * FROM test09;

#FOREIGN KEY 제약 지정
CREATE TABLE test10 (
	ttid INT AUTO_INCREMENT PRIMARY KEY
    ,col VARCHAR(10)
    ,tid VARCHAR(4) #FK
);

ALTER TABLE test10
ADD CONSTRAINT test10_tid_fk FOREIGN KEY(tid)
		REFERENCES test09(tid);

INSERT INTO test10 (col, tid)
VALUES ('TEST', 'A001'), ('SAMPLE', 'A002');

INSERT INTO test10 (col, tid)
VALUES ('TEST', 'A003');

SELECT * FROM test10;


#---------------------------------
#VIEW : 쿼리의 난이도를 낮추거나, 보안 설정할 때 사용하는 객체.

/*
CREATE 
   [ALGORITHM = {MERGE  | TEMPTABLE | UNDEFINED}]
VIEW [database_name].[view_name] 
AS
[SELECT  statement]
*/

#1차 뷰 생성
CREATE VIEW SalePerOrder AS
    SELECT 
        orderNumber, SUM(quantityOrdered * priceEach) total
    FROM
        classicmodels.orderDetails
    GROUP by orderNumber
    ORDER BY total DESC;

#2차 뷰 생성
CREATE VIEW BigSalesOrder AS
    SELECT 
        orderNumber, ROUND(total,2) as total
    FROM
        saleperorder
    WHERE
        total > 60000;

#2차 뷰를 이용한 쿼리 실행        
SELECT 
    orderNumber, total
FROM
    BigSalesOrder;
    
    
#---------------------------------
    