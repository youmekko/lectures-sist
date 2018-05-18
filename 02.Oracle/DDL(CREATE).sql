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

--생성된 테이블에 샘플 데이터 입력
INSERT INTO members (mid, name_, phone) VALUES (1, '홍길동', '1234');
INSERT INTO members (mid, name_, phone) VALUES (2, '박길동', '5678');
COMMIT;

--생성된 테이블에 입력된 자료 확인
SELECT mid, name_, phone
    FROM members;






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


-----------------------------------------


