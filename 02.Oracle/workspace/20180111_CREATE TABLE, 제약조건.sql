-----------------------------------------------------------
--데이터베이스 객체

/*
1. 데이터베이스에 저장되는 것들은 테이블 외에 기타 여러 가지 것들이 저장되는데 이것을 데이터베이스 객체(Database Objects)라고 부른다.

2. TABLE
하나 또는 여러 컬럼(Column)들이 모여 하나의 레코드를 이루며, 이러한 레코드들이 모여 테이블이된다. 예를 들어 "사원" 테이블은 사번, 이름, 부서 등 여러 컬럼을 갖게 되고 사원수만큼의 레코드를 갖게 된다.

3.
CREATE 문
데이터베이스 내의 모든 객체를 생성할 때 사용하는 문장
ALTER 문
이미 생성된 객체의 구조를 변경
DROP 문
생성된 객체를 삭제

=>주의) 관리자에 의해 RESOURCE 권한을 부여 받은 사용자만 작업 가능

*/


----------------------------------------------
--테이블 작성

/*
1. 테이블은 관계 데이터베이스에 데이터 저장을 위해 이용되는 객체이며, 행과 열 을 통해 spread sheet와 비슷한 방식으로 데이터를 표시한다.

예를 들어, 성적 정보 저장용 테이블이 있다면
column  column  column column column
번호(PK) 이름     국어   영어   수학
1        홍길동   100    100    100    -> row
2        박길동    90     80     90    -> row
3        최길동   100     70     80    -> row

2.
CREATE [GLOBAL TEMPORARY] TABLE [스키마.]테이블_이름 (
	열_이름 데이터타입 [DEFAULT 표현식] [제약조건]
	[, 열_이름 데이터타입 [DEFAULT 표현식] [제약조건] ]
	[ ,...]
);

테이블 생성시 PK 제약을 지정할 수 있는 컬럼을 반드시 추가할 것.

예를 들어, 성적 정보 저장용 테이블을 만든다면
--테이블 생성
CREATE TABLE sungjuk (
  sid NUMBER --고유번호 저장용 컬럼(PK). 필수 항목.
  ,name VARCHAR2(20) --이름 저장용 컬럼. 영숫자 20자 이내. 한글 저장시 NVARCHAR2(20) 한글 20자 이내.
  ,kor NUMBER(3) --과목 점수 저장용 컬럼. 0~100
  ,eng NUMBER(3) --과목 점수 저장용 컬럼. 0~100
  ,mat NUMBER(3) --과목 점수 저장용 컬럼. 0~100
);

--테이블 존재 확인
SELECT * FROM user_tables;

*/




-------------------------------------------
--데이터 타입(자료형)

/*
1. 오라클이 제공하는 데이터 타입은 단일 값을 저장하는 스칼라 데이터 타입, 여러 개의 데이터를 저장할 수 있는 컬렉션 데이터 타입 그리고, 컬럼이 다른 테이블 객체를 참조하는 관계 데이터 타입이있다.

2. VARCHAR2
형식 : VARCHAR2(n)
가변 길이 문자 데이터를 저장하며 최대 길이는 4000자이고, 반드시 길이를 명시해야 한다.
NLS(국가별 언어 집합)는 한글과 영문만 가능
VARCHAR 는 최대 2000개 문자를 저장하며 VARCHAR2와는 다르게 VARCHAR(10)로 선언하면 null을 채워 실제로는 10개의 공간을 사용한다. 하지만 VARCHAR2(10)는 필요한 문자까지만 저장하는 variable length이며 최대 4000개 문자까지 저장할 수 있다.

한글 저장용 NVARCHAR2(n) 자료형


3. NUMBER
형식 : NUMBER(P, S)
P(1~38)는 정밀도로 전체 자리수를 나타내며 기본 값이 38이고 S(-84~127)는 소수점 이하의 자릿수이다.
정수나 실수 저장하기 위한 가변길이의 표준 내부 형식이다.

4.DATE
『년/월/일 시:분:초』까지 저장하며, 기본적으로 년/월/일 정보를 출력한다.
*/



-------------------------------------------------
--INSERT

/*
1. INSERT 문은 테이블에 새 행(row)을 추가하는데 이용하며, single table insert이나 multi table insert를 수행할 수 있다.

Single table insert : 오직 하나의 테이블이나 뷰에 오직 하나의 행(row)의 값들을 삽입할 수 있다.

Multi table insert : 하나 이상의 테이블로부터 서브 쿼리로 얻은 여러 행(row)을 삽입하는 경우이다.

2.
INSERT INTO 테이블_명 [(컬럼_명1, 컬럼_명2, ...)] VALUES (값1, 값2, ...);

주의) 컬럼명과 값은 서로 일치(갯수, 순서, 자료형)해야 한다.
주의) INSERT 명령 실행시 메모리에서만 입력된 상태이므로, 물리적 저장이 필요하면 COMMIT; 명령 실행 필요.
*/


----------------------------------
--제약 조건

/*
Primary key - 고유한 값을 유지하는 제약. 중복된 자료가 입력되지 않도록 차단하는 역할.

제약 추가 방법은 테이블 생성시, 테이블 생성후 제약 추가 가능.

ALTER TABLE 테이블명
    ADD [CONSTRAINT 제약명] PRIMARY KEY(컬럼명);

제약명은 사용자가 작성하는 것을 권장한다.

*/




--------------------------------------
--샘플 테이블 생성 쿼리
--이름, 전화번호 저장용 테이블 생성
--PK(고유한 값을 저장하는 역할) 컬럼 추가 필요
/*
CREATE TABLE 테이블명 (
    컬럼 자료형
    , 컬럼 자료형
    , ...
);
*/

CREATE TABLE new_table (    
    no_ NUMBER(3)
    , name_ VARCHAR2(10)
    , birth DATE
);




CREATE TABLE members (
    mid NUMBER   --PK 역할. 숫자 전용.
    , name_ NVARCHAR2(10)  --한글, 영숫자 가능. 10자 이내.
    , phone VARCHAR2(10) --영숫자 가능. 10자 이내.
);

--PK 제약 추가
--제약명 작성시 '테이블명_컬럼명_제약종류' 표기 권장
ALTER TABLE members
    ADD CONSTRAINT members_mid_pk PRIMARY KEY(mid);
    

--생성된 테이블 확인
SELECT * 
    FROM user_tables;
    
--생성된 테이블 구조(컬럼명, 자료형, null 여부) 확인
DESC members;

DESC new_table;

--생성된 테이블에 샘플 데이터 입력
INSERT INTO members (mid, name_, phone) VALUES (1, '홍길동', '1234');
INSERT INTO members (mid, name_, phone) VALUES (2, '박길동', '5678');
INSERT INTO members (mid, name_, phone) VALUES (3, '최길동', '1111');
INSERT INTO members (mid, name_, phone) VALUES (4, '김길동', '2345');
INSERT INTO members (mid, name_, phone) VALUES (5, '황길동', '5432');

COMMIT;

--생성된 테이블에 입력된 자료 확인
SELECT mid, name_, phone
    FROM members;

--특정인(이름이 '홍길동'인 경우)의 정보 출력

--특정인(번호가 2인 경우)의 정보 출력

--전화번호에 '3'이 포함된 경우 출력


CREATE TABLE insa(
        num NUMBER(5) NOT NULL CONSTRAINT insa_pk PRIMARY KEY
       ,name NVARCHAR2(20) NOT NULL
       ,ssn  VARCHAR2(14) NOT NULL
       ,ibsaDate DATE     NOT NULL
       ,tel   VARCHAR2(15)
       ,city  NVARCHAR2(10)
       ,buseo NVARCHAR2(15) NOT NULL
       ,jikwi NVARCHAR2(15) NOT NULL
       ,basicPay NUMBER(10) NOT NULL
       ,sudang NUMBER(10) NOT NULL
);



INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1001, '홍길동', '771212-1022432', '1998-10-11', '서울', '011-2356-4528', '기획부', 
   '부장', 2610000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1002, '이순신', '801007-1544236', '2000-11-29', '경기', '010-4758-6532', '총무부', 
   '사원', 1320000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1003, '이순애', '770922-2312547', '1999-02-25', '인천', '010-4231-1236', '개발부', 
   '부장', 2550000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1004, '김정훈', '790304-1788896', '2000-10-01', '전북', '019-5236-4221', '영업부', 
   '대리', 1954200, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1005, '한석봉', '811112-1566789', '2004-08-13', '서울', '018-5211-3542', '총무부', 
   '사원', 1420000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1006, '이기자', '780505-2978541', '2002-02-11', '인천', '010-3214-5357', '개발부', 
   '과장', 2265000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1007, '장인철', '780506-1625148', '1998-03-16', '제주', '011-2345-2525', '개발부', 
   '대리', 1250000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1008, '김영년', '821011-2362514', '2002-04-30', '서울', '016-2222-4444', '홍보부',    
'사원', 950000 , 145000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1009, '나윤균', '810810-1552147', '2003-10-10', '경기', '019-1111-2222', '인사부', 
   '사원', 840000 , 220400);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1010, '김종서', '751010-1122233', '1997-08-08', '부산', '011-3214-5555', '영업부', 
   '부장', 2540000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1011, '유관순', '801010-2987897', '2000-07-07', '서울', '010-8888-4422', '영업부', 
   '사원', 1020000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1012, '정한국', '760909-1333333', '1999-10-16', '강원', '018-2222-4242', '홍보부', 
   '사원', 880000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1013, '조미숙', '790102-2777777', '1998-06-07', '경기', '019-6666-4444', '홍보부', 
   '대리', 1601000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1014, '황진이', '810707-2574812', '2002-02-15', '인천', '010-3214-5467', '개발부', 
   '사원', 1100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1015, '이현숙', '800606-2954687', '1999-07-26', '경기', '016-2548-3365', '총무부', 
   '사원', 1050000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1016, '이상헌', '781010-1666678', '2001-11-29', '경기', '010-4526-1234', '개발부', 
   '과장', 2350000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1017, '엄용수', '820507-1452365', '2000-08-28', '인천', '010-3254-2542', '개발부', 
   '사원', 950000 , 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1018, '이성길', '801028-1849534', '2004-08-08', '전북', '018-1333-3333', '개발부', 
   '사원', 880000 , 123000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1019, '박문수', '780710-1985632', '1999-12-10', '서울', '017-4747-4848', '인사부', 
   '과장', 2300000, 165000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1020, '유영희', '800304-2741258', '2003-10-10', '전남', '011-9595-8585', '자재부', 
   '사원', 880000 , 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1021, '홍길남', '801010-1111111', '2001-09-07', '경기', '011-9999-7575', '개발부', 
   '사원', 875000 , 120000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1022, '이영숙', '800501-2312456', '2003-02-25', '전남', '017-5214-5282', '기획부', 
   '대리', 1960000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1023, '김인수', '731211-1214576', '1995-02-23', '서울', NULL           , '영업부', 
   '부장', 2500000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1024, '김말자', '830225-2633334', '1999-08-28', '서울', '011-5248-7789', '기획부', 
   '대리', 1900000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1025, '우재옥', '801103-1654442', '2000-10-01', '서울', '010-4563-2587', '영업부', 
   '사원', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1026, '김숙남', '810907-2015457', '2002-08-28', '경기', '010-2112-5225', '영업부', 
   '사원', 1050000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1027, '김영길', '801216-1898752', '2000-10-18', '서울', '019-8523-1478', '총무부', 
   '과장', 2340000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1028, '이남신', '810101-1010101', '2001-09-07', '제주', '016-1818-4848', '인사부', 
   '사원', 892000 , 110000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1029, '김말숙', '800301-2020202', '2000-09-08', '서울', '016-3535-3636', '총무부', 
   '사원', 920000 , 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1030, '정정해', '790210-2101010', '1999-10-17', '부산', '019-6564-6752', '총무부', 
   '과장', 2304000, 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1031, '지재환', '771115-1687988', '2001-01-21', '서울', '019-5552-7511', '기획부', 
   '부장', 2450000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1032, '심심해', '810206-2222222', '2000-05-05', '전북', '016-8888-7474', '자재부', 
   '사원', 880000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1033, '김미나', '780505-2999999', '1998-06-07', '서울', '011-2444-4444', '영업부', 
   '사원', 1020000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1034, '이정석', '820505-1325468', '2005-09-26', '경기', '011-3697-7412', '기획부', 
   '사원', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1035, '정영희', '831010-2153252', '2002-05-16', '인천', NULL           , '개발부', 
   '사원', 1050000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1036, '이재영', '701126-2852147', '2003-08-10', '서울', '011-9999-9999', '자재부', 
   '사원', 960400 , 190000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1037, '최석규', '770129-1456987', '1998-10-15', '인천', '011-7777-7777', '홍보부', 
   '과장', 2350000, 187000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1038, '손인수', '791009-2321456', '1999-11-15', '부산', '010-6542-7412', '영업부', 
   '대리', 2000000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1039, '고순정', '800504-2000032', '2003-12-28', '경기', '010-2587-7895', '영업부', 
   '대리', 2010000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1040, '박세열', '790509-1635214', '2000-09-10', '경북', '016-4444-7777', '인사부', 
   '대리', 2100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1041, '문길수', '721217-1951357', '2001-12-10', '충남', '016-4444-5555', '자재부', 
   '과장', 2300000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1042, '채정희', '810709-2000054', '2003-10-17', '경기', '011-5125-5511', '개발부', 
   '사원', 1020000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1043, '양미옥', '830504-2471523', '2003-09-24', '서울', '016-8548-6547', '영업부', 
   '사원', 1100000, 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1044, '지수환', '820305-1475286', '2004-01-21', '서울', '011-5555-7548', '영업부', 
   '사원', 1060000, 220000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1045, '홍원신', '690906-1985214', '2003-03-16', '전북', '011-7777-7777', '영업부', 
   '사원', 960000 , 152000);			
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1046, '허경운', '760105-1458752', '1999-05-04', '경남', '017-3333-3333', '총무부', 
   '부장', 2650000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1047, '산마루', '780505-1234567', '2001-07-15', '서울', '018-0505-0505', '영업부', 
   '대리', 2100000, 112000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1048, '이기상', '790604-1415141', '2001-06-07', '전남', NULL           , '개발부', 
   '대리', 2050000, 106000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1049, '이미성', '830908-2456548', '2000-04-07', '인천', '010-6654-8854', '개발부', 
   '사원', 1300000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1050, '이미인', '810403-2828287', '2003-06-07', '경기', '011-8585-5252', '홍보부', 
   '대리', 1950000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1051, '권영미', '790303-2155554', '2000-06-04', '서울', '011-5555-7548', '영업부', 
   '과장', 2260000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1052, '권옥경', '820406-2000456', '2000-10-10', '경기', '010-3644-5577', '기획부', 
   '사원', 1020000, 105000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1053, '김싱식', '800715-1313131', '1999-12-12', '전북', '011-7585-7474', '자재부', 
   '사원', 960000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1054, '정상호', '810705-1212141', '1999-10-16', '강원', '016-1919-4242', '홍보부', 
   '사원', 980000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1055, '정한나', '820506-2425153', '2004-06-07', '서울', '016-2424-4242', '영업부', 
   '사원', 1000000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1056, '전용재', '800605-1456987', '2004-08-13', '인천', '010-7549-8654', '영업부', 
   '대리', 1950000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1057, '이미경', '780406-2003214', '1998-02-11', '경기', '016-6542-7546', '자재부', 
   '부장', 2520000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1058, '김신제', '800709-1321456', '2003-08-08', '인천', '010-2415-5444', '기획부', 
   '대리', 1950000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1059, '임수봉', '810809-2121244', '2001-10-10', '서울', '011-4151-4154', '개발부', 
   '사원', 890000 , 102000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1060, '김신애', '810809-2111111', '2001-10-10', '서울', '011-4151-4444', '개발부', 
   '사원', 900000 , 102000);
COMMIT;   
   
SELECT * FROM insa;   



----------------------------------------
--NUMBER 자료형 테스트
CREATE TABLE test1 (
	col1 NUMBER       --38자리
	,col2 NUMBER(3)   --3자리
	,col3 NUMBER(5,2) --5자리, 소수 이하 2자리
);

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 123, 123);  --123, 123, 123
SELECT * FROM test1;

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 123.45, 123.45); --123, 123, 123.45
SELECT * FROM test1;

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 123.456, 123.456); --123, 123, 123.46
SELECT * FROM test1;

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 1234, 1234); --ORA-01438: value larger than specified precision allowed for this column
SELECT * FROM test1;

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 123, 123456); --ORA-01438: value larger than specified precision allowed for this column
SELECT * FROM test1;

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 123, 123.456); --123, 123, 123.46
SELECT * FROM test1;

--ROLLBACK;
COMMIT;

DROP TABLE test1;





----------------------------------
--VARCHAR2 자료형 테스트
CREATE TABLE test2 (
	col0 VARCHAR2     --ORA-00906: missing left parenthesis
);
--> 테이블 생성 실패

CREATE TABLE test2 (
	col0 VARCHAR2(5000)     --ORA-00910: specified length too long for its datatype
);
--> 테이블 생성 실패

CREATE TABLE test2 (
	col1 VARCHAR2(1)     --1글자(영문, 숫자 기준)
	,col2 VARCHAR2(10)   --10글자(10byte)
	,col3 VARCHAR2(4000) --MAX
);
-->테이블 생성 성공


INSERT INTO test2 (col1, col2, col3)
	VALUES ('T', 'TEST', 'TEST');
SELECT * FROM test2;

INSERT INTO test2 (col1, col2, col3)
	VALUES ('TEST', 'TEST', 'TEST');  --ORA-12899: value too large for column "MINJONG"."TEST2"."COL1" (actual: 4, maximum: 1)
SELECT * FROM test2;

INSERT INTO test2 (col1, col2, col3)
	VALUES ('T', '홍길동', '홍길동');
SELECT * FROM test2;

INSERT INTO test2 (col1, col2, col3)
	VALUES ('T', '대한민국', '대한민국');  --ORA-12899: value too large for column "MINJONG"."TEST2"."COL2" (actual: 12, maximum: 10)
SELECT * FROM test2;

COMMIT;

DROP TABLE test2;





-----------------------------------
--NVARCHAR2 자료형 테스트
CREATE TABLE test3 (
	col1 NVARCHAR2(1)     --1글자(한글, 영문, 숫자 기준)
	,col2 NVARCHAR2(10)   --10글자
	,col3 NVARCHAR2(2000) --MAX
);
-->테이블 생성 성공

INSERT INTO test3 (col1, col2, col3)
	VALUES ('T', '대한민국', '대한민국');
SELECT * FROM test3;

COMMIT;

DROP TABLE test3;





---------------------------------------
--DATE 자료형 테스트
CREATE TABLE test4 (
	col1 DATE     --년/월/일 시:분:초 저장
	,col2 DATE
);

--날짜와 시간 정보 모두 저장되므로 
--SYSDATE인 경우는 현재 시간까지 저장된다.
INSERT INTO test4 (col1, col2) 
	VALUES (SYSDATE, TO_DATE('20120118')); --문자를 날짜형으로 변환
INSERT INTO test4 (col1, col2) 
	VALUES (SYSDATE, '20120118'); --문자를 자동 형변환
INSERT INTO test4 (col1, col2) 
	VALUES (SYSDATE, SYSDATE);
COMMIT;

SELECT * FROM test4; --년/월/일만 출력됨.
SELECT TO_CHAR(col1, 'YYYY-MM-DD HH24:MI:SS') AS col1
	,TO_CHAR(col2, 'YYYY-MM-DD HH24:MI:SS') AS col2
	FROM test4; --년-월-일 시:분:초로 출력됨

DROP TABLE test4;



--문제) 회원 정보(회원번호, 이름, 전화번호, 이메일, 등록일, 부서번호)와 부서 정보(부서번호, 부서명)를 저장하는 테이블 생성.
--회원번호(PK)는 'M001', 'M002' 형태로 저장
--부서번호(PK)는 'B01', 'B02', 형태로 저장


--부서정보 테이블 생성

--회원정보 테이블 생성


--부서 테이블 샘플 자료 입력

--COMMIT;

--회원 테이블 샘플 자료 입력

--COMMIT;

--SELECT 쿼리







-----------------------------------------------
--테이블 관리

/*
***1. 새 테이블 생성
CREATE TABLE 테이블이름 (
	컬럼 자료형 [기타제약]
	,...
);
*/


------------------------------------
/*
2. 기존 테이블 구조(컬럼명, 자료형) 확인
SELECT * 
  FROM user_tab_columns
  WHERE table_name='테이블명'; --테이블 이름 대문자로 표기할 것.

DESC 테이블이름;
*/
SELECT * 
  FROM user_tab_columns
  WHERE table_name='INSA';

SELECT * 
  FROM user_tab_columns
  WHERE table_name='MEMBERS';

DESC members;



------------------------------------
/*
3. 기존 테이블 구조 복사해서 새 테이블 생성 (제약조건은 복사되지 않는다)
CREATE TABLE 새테이블명
AS
SELECT 컬럼리스트 FROM 기존테이블명 WHERE 1=0;
*/

CREATE TABLE members2
AS
SELECT * FROM members WHERE 1=0;  --조건 결과가 거짓이 나오도록 설정

DESC members;  --원본은 구조 외에 제약조건도 있다.
DESC members2; --사본은 구조만 복사되어 있다.

SELECT * FROM members2; -- 0 rows




------------------------------------
/*
**4. 기존 테이블 구조 및 기존 자료 복사해서 새 테이블 생성 및 자료 입력 (제약조건은 복사되지 않는다)
CREATE TABLE 새테이블명
AS
SELECT 컬럼리스트 FROM 기존테이블명 [WHERE 조건식];
*/

CREATE TABLE members3
AS
SELECT * FROM members;

SELECT * FROM members3; --2 rows


CREATE TABLE members4
AS
SELECT * FROM members WHERE mid = 1;

SELECT * FROM members4; --1 rows


CREATE TABLE members5
AS
SELECT mid, name_ FROM members WHERE mid = 1;

SELECT * FROM members5; --1 rows




------------------------------
/*
5. 기존 테이블에 새 열 추가

ALTER TABLE 기존테이블명
	ADD (열이름 자료형, ...);
--> 기존 테이블에 데이터가 있는 경우는 새로 만들어진 컬럼의 데이터는 NULL만 채워진다.
--> NULL이 채워진 컬럼에 자료를 채우려면 UPDATE 명령을 이용한다.
--> 컬럼 생성시 자동으로 기본값을 채우려면 DEFAULT 키워드를 이용한다.
*/

DESC members;
/*
MID   NOT NULL NUMBER        
NAME_          NVARCHAR2(10) 
PHONE          VARCHAR2(10) 
*/
--> 등록일(regDate) 컬럼 추가

SELECT * FROM members;

ALTER TABLE members
	ADD (regDate DATE);
--> 컬럼은 추가되지만 자료는 NULL로 채워진다.


SELECT * FROM members;
--> regDate 컬럼은 NULL로 채워진 상태이다.
--> 자료를 입력하려면 UPDATE 쿼리 사용




--------------------------
/*
6. 기존 테이블에서 기존 열 자료형 변경
ALTER TABLE 기존테이블명
	MODIFY (기존열이름 새로운자료형);
--> 기존 테이블에 데이터가 있는 경우는 새로운 자료형이 기존 자료에 적합해야 한다.
*/

DESC members;
/*
MID     NOT NULL NUMBER        
NAME_            NVARCHAR2(10) 
PHONE            VARCHAR2(20)  
REGDATE          DATE 
*/
--> PHONE 컬럼의 크기 확장. 10->20

ALTER TABLE members
	MODIFY (phone VARCHAR2(20));
    
DESC members;
--> phone 컬럼의 크기 확인

SELECT * FROM members;
--> 기존 자료 그대로 남아 있다.




---------------------------------------
/*
7. 기존 테이블에서 기존 열 이름 변경
ALTER TABLE 기존테이블명
	RENAME COLUMN 기존열이름 TO 새열이름;
--> 기존 테이블에 데이터가 있어도 가능하다.
*/

DESC members;
/*
MID     NOT NULL NUMBER        
NAME_            NVARCHAR2(10) 
PHONE            VARCHAR2(20)  
REGDATE          DATE   
*/
--> phone 컬럼명은 tel 컬럼명으로 변경

ALTER TABLE members
	RENAME COLUMN phone TO tel;
    
DESC members;
--> 컬럼명이 변경되어 있다.




----------------------------------
/*
8. 기존 테이블에서 기존 열 삭제
ALTER TABLE 기존테이블명
	DROP (열이름, ...);
--> 기존 테이블에 기존 데이터가 같이 삭제된다. 복구 불가.
*/

DESC members;
/*
MID     NOT NULL NUMBER        
NAME_            NVARCHAR2(10) 
PHONE            VARCHAR2(20)  
REGDATE          DATE   
*/
--> regDate 컬럼을 삭제

ALTER TABLE members
	DROP (regDate);
    

DESC members;
--> 컬럼이 삭제되어 있다.

SELECT * FROM members;



----------------------------------
/*
9. 기존 테이블 이름 변경
RENAME 기존테이블명 TO 새로운테이블명;
*/

SELECT * FROM user_tables;
--> INSA 테이블명을 EMP 테이블명으로 변경

SELECT * FROM insa;

RENAME insa TO emp;

SELECT * FROM emp;




----------------------------
/*
10. 기존 테이블 삭제 (휴지통 기능 있음)
DROP TABLE 테이블이름;
--> 테이블 삭제시 관련 객체(제약조건, 인덱스, 트리거 등)들이 같이 삭제된다.
--> 참조 관계가 있는 테이블은 제약조건에 따라서 삭제 안되는 경우가 있다.
--> 단독 테이블은 항상 삭제 가능.
*/

CREATE TABLE test1 (
    col NUMBER
);

INSERT INTO test1 (col) VALUES (1);
COMMIT;

SELECT * FROM test1;

SELECT * FROM user_tables;
--> test1 테이블 존재 확인

DROP TABLE test1;  --휴지통 사용. 복구 가능.

SELECT * FROM user_tables;
--> test1 테이블 삭제 확인



------------------------------------------------
/*
--휴지통에 있는 객체 확인
SELECT *
	FROM recyclebin;

--휴지통에 있는 객체 복원 (테이블명은 휴지통 내에서 부여된 임시 객체명)
FLASHBACK TABLE 테이블명 TO BEFORE DROP;

--휴지통 비우기
PURGE recyclebin;

DROP TABLE 테이블이름 PURGE;
*/

SELECT *
	FROM recyclebin;
--> 삭제한 테이블 객체 확인 가능

FLASHBACK TABLE "BIN$GN3ZdqRIRwa9C4GaGAWpYg==$0" TO BEFORE DROP;

SELECT * FROM user_tables;
--> test1 테이블 존재 확인

SELECT * FROM test1;
--> 기존 자료 확인


--휴지통 비우기
PURGE recyclebin;
--> 복원 불가

--휴지통 기능을 거치지 않고 직접 삭제
DROP TABLE test1 PURGE;
--> 복원 불가





-----------------------------------
/*
참조 관계가 있는 테이블은 삭제가 안되는 경우가 있다.
참조 하는 쪽에서 먼저 관련 ROW를 삭제해야 참조 당하는 테이블을 삭제할 수 있다.
또는 CASCADE 옵션을 추가하면 된다.
*/

CREATE TABLE test1 (
    col2 NUMBER --PK 제약
);
--> 참조 관계가 설정된 후에는 테이블 삭제 불가
--> FK 제약을 제거한 후 테이블 삭제 시도하면 삭제 가능
--> FK 제약이 있는 테이블을 먼저 삭제해야 자기 자신 삭제 가능
--> CASCADE 옵션 지정한 상태로 삭제 시도하면 삭제 가능


CREATE TABLE test2 (
    col2 NUMBER --FK 제약 (참조 관계)
);
--> 참조 관계가 설정된 후에도 테이블 삭제 가능


--참조 관계 설정
ALTER TABLE test1
    ADD CONSTRAINT test1_col2_pk PRIMARY KEY(col2);
ALTER TABLE test2
    ADD CONSTRAINT test2_col2_fk FOREIGN KEY(col2)
            REFERENCES test1(col2);

    
DROP TABLE test1;
--ORA-02449: unique/primary keys in table referenced by foreign keys
--> test1 테이블은 참조 당하는 입장이므로 삭제 불가

DROP TABLE test1 CASCADE CONSTRAINTS;
--> test1 테이블은 삭제된다. 내부적으로 FK 제약을 삭제한 후, 테이블 삭제한다.

SELECT * FROM user_tables;
--> test2 테이블은 그대로 남아 있다. 단, FK 제약은 삭제된 상태이다.


---------------------------------------------
--무결성

/*
1. 무결성에는 개체 무결성(Entity Integrity), 참조 무결성(Relational Integrity), 도메인 무결성(Domain Integrity)가 있다.

2. 개체 무결성
개체 무결성은 릴레이션에 저장되는 튜플(tuple)의 유일성을 보장하기 위한 제약조건이다.

3.참조 무결성
참조 무결성은 릴레이션 간의 데이터의 일관성을 보장하기 위한 제약조건이다.

4. 도메인 무결성
도메인 무결성은 속성에서 허용 가능한 값의 범위를 지정하기 위한 제약조건이다.

예를 들어, 학생 정보 저장용 테이블을 만든다면
--테이블 생성
CREATE TABLE member (     --테이블 이름 member
	sid NUMBER        --고유번호 저장용 컬럼
	,name VARCHAR2(10) --이름, 10글자만 허용
	,kor NUMBER(3)     --국어, 숫자 3자리만 허용(0~999). 0~100 제한.
	,eng NUMBER(3)     --영어, 숫자 3자리만 허용
	,mat NUMBER(3)     --수학, 숫자 3자리만 허용
);

5. 제약조건 종류
- PRIMARY KEY(PK) : 해당 컬럼 값은 반드시 존재해야 하며, 유일해야 함(NOT NULL과 UNIQUE 제약조건을 결합한 형태)
- FOREIGN KEY(FK) : 해당 컬럼 값은 참조되는 테이블의 컬럼 값 중의 하나와 일치하거나 NULL을 가짐
- UNIQUE (UK) : 테이블내에서 해당 컬럼 값은 항상 유일해야 함
- NOT NULL : 컬럼은 NULL 값을 포함할 수 없다.
- CHECK (CK) : 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건 지정
*/



------------------------------------------------
--***PRIMARY KEY (PK)

/*
1. 테이블에 대한 기본 키를 생성한다.

2. 테이블에서 각 행을 유일하게 식별하는 컬럼 또는 컬럼의 집합이다. 기본 키는 테이블 당 하나만 존재한다. 그러나, 반드시 하나의 컬럼으로 만 구성되는 것은 아니다. NULL 값이 입력될 수 없고, 이미 테이블에 존재하고 있는 데이터를 다시 입력할 수 없다. UNIQUE INDEX가 자동으로 만들어 진다.


3.
컬럼 레벨의 형식
컬럼명 데이터타입 [CONSTRAINT constraint명] PRIMARY KEY

테이블 레벨의 형식
컬럼명 데이터타입,
컬럼명 데이터타입,
...
[CONSTRAINT constraint명] PRIMARY KEY(컬럼1명, 컬럼2명,...)

4. constraint를 추가 시에 constraint 명을 생략하면 오라클 서버가 자동적으로 constraint 명을 부여한다. 일반적으로 constraint명은 테이블명_컬럼명_constraint약자'처럼 기술한다.
*/


--제약 없는 경우
CREATE TABLE test0 (
	col1 NUMBER(3)
	,col2 VARCHAR2(10)
);

INSERT INTO test0 (col1, col2) 
	VALUES (NULL, NULL);
COMMIT;

SELECT col1, col2
  FROM test0;



-------------------------------------------
--PK 지정 테스트 - (테이블 생성시 제약 추가) 컬럼 레벨의 형식
CREATE TABLE test1 (
	col1 NUMBER(3)     PRIMARY KEY
	,col2 VARCHAR2(10)
);

INSERT INTO test1 (col1, col2) 
	VALUES (1, 'TEST');
INSERT INTO test1 (col1, col2) 
	VALUES (2, 'ABCD');
INSERT INTO test1 (col1, col2) 
	VALUES (3, NULL);
INSERT INTO test1 (col1, col2) 
	VALUES (2, 'ABCD');  --ORA-00001 (중복된 번호 입력 불가)
INSERT INTO test1 (col1, col2) 
	VALUES (NULL, NULL); --ORA-01400 (NULL 입력 불가)
COMMIT;

SELECT * FROM test1;


DESC test1;
/*
이름   널        유형           
---- -------- ------------ 
COL1 NOT NULL NUMBER(3)      -->PK 제약 확인 불가
COL2          VARCHAR2(10) 
*/


SELECT * FROM all_users;


--제약 조건 확인
SELECT * FROM user_constraints;

SELECT * FROM user_constraints 
	WHERE table_name='TEST1'; --테이블 이름 대문자

--제약이 지정된 컬럼 확인
SELECT * FROM user_cons_columns
  WHERE table_name='TEST1'; --테이블 이름 대문자

--제약이 걸린 소유주, 제약명, 테이블, 제약종류, 컬럼 정보 확인
SELECT uc.owner, uc.constraint_name, uc.table_name, uc.constraint_type, ucc.column_name
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.constraint_name = ucc.constraint_name
    AND uc.table_name='TEST1';  --테이블 이름 대문자




-------------------------------
--PK 지정 테스트 -  (테이블 생성시 제약 추가) 테이블 레벨의 형식
--> 제약명을 사용자가 결정한다
--> 제약명은 '테이블명_컬럼명_PK' 형식으로 작성한다.

CREATE TABLE test2 (
	col1 NUMBER(3)
	,col2 VARCHAR2(10)
	,CONSTRAINT TEST2_COL1_PK PRIMARY KEY(col1)
);

INSERT INTO test2 (col1, col2) 
	VALUES (1, 'TEST');
INSERT INTO test2 (col1, col2) 
	VALUES (2, 'ABCD');
INSERT INTO test2 (col1, col2) 
	VALUES (3, NULL);
INSERT INTO test2 (col1, col2) 
	VALUES (2, 'ABCD');  --ORA-00001
INSERT INTO test2 (col1, col2) 
	VALUES (NULL, NULL); --ORA-01400
COMMIT;

SELECT * FROM test2;

--제약이 걸린 소유주, 제약명, 테이블, 제약종류, 컬럼 정보 확인

SELECT *
FROM user_constraints
WHERE table_name='TEST2';

SELECT uc.owner, uc.constraint_name, uc.table_name, uc.constraint_type, ucc.column_name
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.constraint_name = ucc.constraint_name
    AND uc.table_name='TEST2';  --테이블 이름 대문자


--------------------------------------
--PK 지정 테스트 - 다중 컬럼 PK 지정 (복합키)
CREATE TABLE test3 (
	col1 NUMBER(3)
	,col2 VARCHAR2(10)
	,CONSTRAINT TEST3_COL1_COL2_PK PRIMARY KEY(col1, col2)
);

INSERT INTO test3 (col1, col2) 
	VALUES (1, 'TEST');
INSERT INTO test3 (col1, col2) 
	VALUES (2, 'ABCD');
INSERT INTO test3 (col1, col2) 
	VALUES (3, NULL); --ORA-01400
INSERT INTO test3 (col1, col2) 
	VALUES (3, 'ABCD'); --col1은 다른 데이터, col2는 같은 데이터
INSERT INTO test3 (col1, col2) 
	VALUES (2, 'KOREA'); --col1은 같은 데이터, col2는 다른 데이터
INSERT INTO test3 (col1, col2) 
	VALUES (NULL, NULL); --ORA-01400
INSERT INTO test3 (col1, col2) 
	VALUES (2, 'ABCD'); --col1, col2 모두 같은 데이터. ORA-00001

COMMIT;

SELECT * FROM test3;

----------------------------------
--***PK 지정 테스트 - 테이블 생성 후 제약 추가
CREATE TABLE test4 (
	col1 NUMBER(3)
	,col2 VARCHAR2(10) 
);

--ALTER TABLE 테이블명
--	ADD CONSTRAINT 제약명 PRIMARY KEY(컬럼명);

ALTER TABLE test4
	ADD CONSTRAINT TEST4_COL1_PK PRIMARY KEY(col1);

INSERT INTO test4 (col1, col2) 
	VALUES (1, 'TEST');
INSERT INTO test4 (col1, col2) 
	VALUES (2, 'ABCD');
INSERT INTO test4 (col1, col2) 
	VALUES (3, NULL);
INSERT INTO test4 (col1, col2) 
	VALUES (2, 'ABCD');  --ORA-00001
INSERT INTO test4 (col1, col2) 
	VALUES (NULL, NULL); --ORA-01400
COMMIT;

SELECT * FROM test4;


DROP TABLE test4;



--문제) 회원 정보(회원번호, 이름, 전화번호, 이메일, 등록일, 부서번호)와 부서 정보(부서번호, 부서명)를 저장하는 테이블 생성.
--회원번호(PK)는 'M001', 'M002' 형태로 저장
--부서번호(PK)는 'B01', 'B02', 형태로 저장


--부서정보 테이블 생성

--회원정보 테이블 생성

--부서정보,회원정보 테이블에 Primary Key 제약 조건 추가

--부서 테이블 샘플 자료 입력

--COMMIT;

--회원 테이블 샘플 자료 입력

--COMMIT;

--SELECT 쿼리




----------------------------------------------------
--***FOREIGN KEY (FK)

/*
1. 참조 키 또는 외래 키(FK)는 두 테이블의 데이터 간 연결을 설정하고 강제 적용하는 데 사용되는 열이
다. 한 테이블의 기본 키 값이 있는 열을 다른 테이블에 추가하면 테이블 간 연결을 설정할 수 있다. 이 
때 두 번째 테이블에 추가되는 열이 외래 키가 된다.

외래 키가 적용된 컬럼에는 데이터 입력시 기본 키 값 범위 내에서만 입력 가능.


2. 부모 테이블이 먼저 생성된 후 자식 테이블(foreign key를 포함하는 테이블)이 생성되어야 한다.

3.

컬럼 레벨의 형식
컬럼명 데이터타입 CONSTRAINT constraint명
	REFERENCES 참조_테이블명 (참조_컬럼명)
	[ON DELETE CASCADE | ON DELETE SET NULL]


테이블레벨의 형식
컬럼명 데이터타입,
컬럼명 데이터타입,
...
CONSTRAINT constraint명 FOREIGN KEY(컬럼)
	REFERENCES 참조_테이블명 (참조_컬럼명)
	[ON DELETE CASCADE | ON DELETE SET NULL]
    
    
테이블 생성후 제약 추가
ALTER TABLE 테이블명
	ADD CONSTRAINT 제약명 FOREIGN KEY(컬럼명)
			REFERENCES 참조_테이블명 (참조_컬럼명);


4. FOREIGN KEY 생성 시 주의사항
- 참조하고자 하는 부모 테이블을 먼저 생성해야 한다.
- 참조하고자 하는 컬럼이 PRIMARY KEY 또는 UNIQUE 제약조건이 있어야 한다.
- 테이블 사이에 PRIMARY KEY와 FOREIGN KEY가 정의 되어 있으면, primary key 삭제 시 foreign key 컬럼에 그 값이 입력되어 있으면 삭제가 안 된다. (단, FK 선언 때 ON DELETE CASCADE나 ON DELETE SET NULL옵션을 사용한 경우에는 삭제된다.)
- 부모 테이블을 삭제하기 위해서는 자식 테이블을 먼저 삭제해야 한다.
- 서로 제약에 의해 참조하는 경우는 서로 삭제되지 않는다. 제약조건을 먼저 삭제해야 한다.



5. 제약 삭제

ALTER TABLE 테이블명
	DROP CONSTRAINT (참조)제약명;

--> 잘못 지정된 제약을 수정하려면 삭제 후 추가해야 한다.

*/

CREATE TABLE jobs (
	jikwi_id NUMBER
	,jikwi_name VARCHAR2(10)
);

ALTER TABLE jobs
	 ADD CONSTRAINT JOBS_JIKWI_ID_PK PRIMARY KEY(jikwi_id);
  

INSERT INTO jobs (jikwi_id, jikwi_name)
  VALUES (1, 'CLERK');
INSERT INTO jobs (jikwi_id, jikwi_name)
  VALUES (2, 'MANAGER');
INSERT INTO jobs (jikwi_id, jikwi_name)
  VALUES (3, 'PRESIDENT');
INSERT INTO jobs (jikwi_id, jikwi_name)
  VALUES (3, 'VICE PRES'); --X
INSERT INTO jobs (jikwi_id, jikwi_name)
  VALUES (4, 'VICE PRES'); --O
COMMIT;

SELECT * FROM jobs;


CREATE TABLE employees (
	sid NUMBER
	,name VARCHAR2(10) 
	,jikwi_id NUMBER
);

ALTER TABLE employees
	ADD CONSTRAINT EMPLOYEES_SID_PK PRIMARY KEY(sid);
ALTER TABLE employees
	ADD CONSTRAINT EMPLOYEES_JIKWI_ID_FK 
			FOREIGN KEY(jikwi_id)
			REFERENCES jobs(jikwi_id);

INSERT INTO employees (sid, name, jikwi_id)
  VALUES (1, 'hong', 1); --O
INSERT INTO employees (sid, name, jikwi_id)
  VALUES (2, 'park', 2); --O
INSERT INTO employees (sid, name, jikwi_id)
  VALUES (3, 'choi', 2); --FK 중복 허용. O
INSERT INTO employees (sid, name, jikwi_id)
  VALUES (3, 'kim', 3); --PK 중복 X. X
INSERT INTO employees (sid, name, jikwi_id)
  VALUES (4, 'hwang', 5); --FK 허용 범위 초과. X
COMMIT;

SELECT sid, name, e.jikwi_id, jikwi_name
  FROM employees e, jobs j
  WHERE e.jikwi_id=j.jikwi_id;
  
  
  
  
--문제) hr 스키마를 분석 하고, 그 결과를 쿼리로 작성.

--테이블 생성 쿼리
--CREATE TABLE
--7개



--제약 조건 지정
--PRIMARY KEY, FOREIGN KEY 제약 분석 및 쿼리 작성.
--테이블 생성 후 제약 추가


  
  
  
----------------------------------
--제약 분석 쿼리

/*
1. SELECT *
  FROM user_constraints;
--CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION, R_CONSTRAINT_NAME


2.SELECT *
  FROM user_cons_columns;
--CONSTRAINT_NAME, TABLE_NAME, COLUMN_NAME  


3. SELECT *
  FROM user_constraints UC, user_cons_columns UCC
  WHERE UC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME;
--CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION, R_CONSTRAINT_NAME, COLUMN_NAME



4. 
SELECT uc.TABLE_NAME AS TABLE_NAME
	, COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
	, CONSTRAINT_TYPE
	, SEARCH_CONDITION
    , R_CONSTRAINT_NAME
    ,(SELECT R_TABLE_NAME
  FROM (SELECT uc.TABLE_NAME AS R_TABLE_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_TABLE_NAME
   ,(SELECT R_COLUMN_NAME
  FROM (SELECT COLUMN_NAME AS R_COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_COLUMN_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME
  AND uc.table_name='EMPLOYEES';
  

5. 
SELECT utc.table_name AS table_name --제약이 지정된 테이블명
	, utc.column_name AS column_name --제약이 지정된 컬럼명
	, data_type   --제약이 지정된 컬럼의 자료형
	, data_length   --제약이 지정된 컬럼의 크기(length)
	, data_precision   --제약이 지정된 컬럼의 크기(precision)
	, nullable    --제약이 지정된 컬럼의 NULL 허용 여부
	, data_default    --제약이 지정된 컬럼의 DEFAULT 값
	, constraint_name    --제약명
	, constraint_type     --제약종류
	, search_condition  --CHECK 제약인 경우 조건식
	, delete_rule    --FOREIGN KEY 제약인 경우 ON DELETE CASCADE 지정 여부
	, r_table_name   --FOREIGN KEY 제약인 경우 참조 테이블명
	, r_conlumn_name   --FOREIGN KEY 제약인 경우 참조 컬럼명
	FROM 
	(SELECT  uc.table_name AS table_name
	, ucc.column_name AS column_name
	, uc.constraint_name AS constraint_name
	, uc.constraint_type AS constraint_type
	, uc.search_condition AS search_condition
	, uc.delete_rule AS delete_rule
	, (SELECT table_name 
		FROM user_cons_columns 
		WHERE constraint_name=uc.r_constraint_name) 
		AS r_table_name
	, (SELECT column_name 
		FROM user_cons_columns 
		WHERE constraint_name=uc.r_constraint_name) 
		AS r_conlumn_name
	FROM user_constraints uc, user_cons_columns ucc
	WHERE uc.constraint_name = ucc.constraint_name) ucc
		, user_tab_columns utc
	WHERE ucc.table_name(+)=utc.table_name
		AND ucc.column_name(+)=utc.column_name;
*/


SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION, R_CONSTRAINT_NAME
  FROM user_constraints
  WHERE table_name='JOBS';
  
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION, R_CONSTRAINT_NAME
  FROM user_constraints
  WHERE table_name='EMPLOYEES';  
  
  
SELECT CONSTRAINT_NAME, TABLE_NAME, COLUMN_NAME  
  FROM user_cons_columns
  WHERE table_name='EMPLOYEES';  
  
  
SELECT uc1.CONSTRAINT_NAME AS CONSTRAINT_NAME
	, CONSTRAINT_TYPE
	, uc1.TABLE_NAME AS TABLE_NAME
    , SEARCH_CONDITION
    , R_CONSTRAINT_NAME
    , COLUMN_NAME
  FROM user_constraints uc1, user_cons_columns ucc
  WHERE uc1.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME
    AND uc1.table_name='EMPLOYEES';  
  
  
--특정 테이블에 추가된 제약의 종류 확인하는 쿼리  
SELECT uc.TABLE_NAME AS TABLE_NAME
	, COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
	, CONSTRAINT_TYPE
	, SEARCH_CONDITION
    , R_CONSTRAINT_NAME
    ,(SELECT R_TABLE_NAME
  FROM (SELECT uc.TABLE_NAME AS R_TABLE_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_TABLE_NAME
   ,(SELECT R_COLUMN_NAME
  FROM (SELECT COLUMN_NAME AS R_COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_COLUMN_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME
  AND uc.table_name='EMPLOYEES';
  
  

--특정 테이블에 추가된 제약의 종류 확인하는 쿼리  -> 뷰로 등록 (뷰 생성 권한 필요)
CREATE OR REPLACE VIEW constraintsCheckView
AS
SELECT uc.TABLE_NAME AS TABLE_NAME
	, COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
	, CONSTRAINT_TYPE
	, SEARCH_CONDITION
    , R_CONSTRAINT_NAME
    ,(SELECT R_TABLE_NAME
  FROM (SELECT uc.TABLE_NAME AS R_TABLE_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_TABLE_NAME
   ,(SELECT R_COLUMN_NAME
  FROM (SELECT COLUMN_NAME AS R_COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_COLUMN_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME;
  

--뷰 등록후 제약 조건 확인 쿼리 실행
SELECT *  
    FROM constraintsCheckView
  WHERE table_name='EMPLOYEES';
  
  
  
  
  
-------------------------------------------------------
--ON DELETE CASCADE 옵션
-- FK 제약 지정시 부모 테이블의 row(PK)가 삭제될 때 자식 테이블의 row(FK)의 삭제 여부 결정




---------------------------
--ON DELETE CASCADE 옵션 지정 전
CREATE TABLE jobs (
	jikwi_id NUMBER
	,jikwi_name VARCHAR2(10)
	,CONSTRAINT JOBS_JIKWI_ID_PK PRIMARY KEY(jikwi_id)
);

INSERT INTO jobs (jikwi_id, jikwi_name) VALUES (1, '과장');
INSERT INTO jobs (jikwi_id, jikwi_name) VALUES (2, '대리');
INSERT INTO jobs (jikwi_id, jikwi_name) VALUES (3, '사원');
COMMIT;


--FK 제약 지정
CREATE TABLE employees (
	sid NUMBER PRIMARY KEY
	,name VARCHAR2(10) 
	,jikwi_id NUMBER REFERENCES jobs(jikwi_id)
);

INSERT INTO employees (sid, name, jikwi_id)
	VALUES (1, '홍길동', 1);
INSERT INTO employees (sid, name, jikwi_id)
	VALUES (2, '김길동', 2);
COMMIT;

--employees 테이블 자료 확인
SELECT * FROM employees;

--employees 테이블에서 '김길동' 자료 삭제 시도. --O
DELETE FROM employees WHERE sid=2;

--employees 테이블 자료 확인
SELECT * FROM employees;

--jobs 테이블 자료 확인
SELECT * FROM jobs;

--jobs 테이블에서 '과장' 자료 삭제 시도. --X
DELETE FROM jobs WHERE jikwi_id=1;

--jobs 테이블에서 '사원' 자료 삭제 시도. --O
DELETE FROM jobs WHERE jikwi_id=3;

--jobs 테이블 자료 확인
SELECT * FROM jobs;

--> ON DELETE CASCADE 옵션 지정이 필요합니다.
--> employees 테이블에서 FK 제약 제거 후 다시 FK 제약 지정
SELECT * FROM user_constraints WHERE table_name='EMPLOYEES';
--> DELETE_RULE 컬럼의 값 확인 -> NO_ACTION -> ON DELETE CASCADE 옵션 지정 X -> 부모 row 삭제시, 자식 row가 같이 삭제되지 않는다. 기본값.


--기존 FK 제약 삭제
ALTER TABLE employees
    DROP CONSTRAINT SYS_C007031;
    
----------------------------
--ON DELETE CASCADE 옵션 지정 후
ALTER TABLE employees
	ADD CONSTRAINT EMPLOYEES_JIKWI_ID_FK
		FOREIGN KEY (jikwi_id)
		REFERENCES jobs(jikwi_id)
		ON DELETE CASCADE;


SELECT * FROM user_constraints WHERE table_name='EMPLOYEES';
--> DELETE_RULE 컬럼의 값 확인 -> CASCADE -> ON DELETE CASCADE 옵션 지정 O -> 부모 row 삭제시, 자식 row가 같이 삭제될 수 있다.

SELECT * FROM jobs;
SELECT * FROM employees;
        
--jobs 테이블에서 '과장' 자료 삭제 시도. --O
DELETE FROM jobs WHERE jikwi_id=1;
--> employees 테이블의 자료가 같이 삭제된다.

SELECT * FROM jobs;
SELECT * FROM employees;



--DELETE_RULE 확인을 위한 사용자 뷰 생성
CREATE OR REPLACE VIEW constraintsCheckView
AS
SELECT utc.table_name AS table_name --제약이 지정된 테이블명
	, utc.column_name AS column_name --제약이 지정된 컬럼명
	, data_type   --제약이 지정된 컬럼의 자료형
	, data_length   --제약이 지정된 컬럼의 크기(length)
	, data_precision   --제약이 지정된 컬럼의 크기(precision)
	, nullable    --제약이 지정된 컬럼의 NULL 허용 여부
	, data_default    --제약이 지정된 컬럼의 DEFAULT 값
	, constraint_name    --제약명
	, constraint_type     --제약종류
	, search_condition  --CHECK 제약인 경우 조건식
	, delete_rule    --FOREIGN KEY 제약인 경우 ON DELETE CASCADE 지정 여부
	, r_table_name   --FOREIGN KEY 제약인 경우 참조 테이블명
	, r_conlumn_name   --FOREIGN KEY 제약인 경우 참조 컬럼명
	FROM 
	(SELECT  uc.table_name AS table_name
	, ucc.column_name AS column_name
	, uc.constraint_name AS constraint_name
	, uc.constraint_type AS constraint_type
	, uc.search_condition AS search_condition
	, uc.delete_rule AS delete_rule
	, (SELECT table_name 
		FROM user_cons_columns 
		WHERE constraint_name=uc.r_constraint_name) 
		AS r_table_name
	, (SELECT column_name 
		FROM user_cons_columns 
		WHERE constraint_name=uc.r_constraint_name) 
		AS r_conlumn_name
	FROM user_constraints uc, user_cons_columns ucc
	WHERE uc.constraint_name = ucc.constraint_name) ucc
		, user_tab_columns utc
	WHERE ucc.table_name(+)=utc.table_name
		AND ucc.column_name(+)=utc.column_name;

--뷰 등록후 제약 조건 확인 쿼리 실행
SELECT *  
    FROM constraintsCheckView
  WHERE table_name='EMPLOYEES';
  
-------------------------------------------------------




