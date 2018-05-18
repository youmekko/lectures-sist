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




------------------------------------
--UNIQUE
--PK와 유사하게 유일성을 보장하는 제약
--NULL 허용, 하나의 테이블에 여러번 지정 가능.
--제약 지정
/*
ALTER TABLE 테이블명
	ADD CONSTRAINT 테이블명_컬럼명_UK UNIQUE(컬럼명);
*/


CREATE TABLE test4 (
	col1 NUMBER(3)  --PK
	,col2 VARCHAR2(10)  --UK
);

ALTER TABLE test4
    ADD CONSTRAINT test4_col1_pk PRIMARY KEY(col1);
ALTER TABLE test4
    ADD CONSTRAINT test4_col2_uk UNIQUE(col2);

INSERT INTO test4 (col1, col2) 
	VALUES (1, 'TEST');
INSERT INTO test4 (col1, col2) 
	VALUES (2, 'ABCD');
INSERT INTO test4 (col1, col2) 
	VALUES (3, NULL);
INSERT INTO test4 (col1, col2) 
	VALUES (2, 'ABCD'); --ORA-00001
INSERT INTO test4 (col1, col2) 
	VALUES (NULL, NULL); --ORA-01400
INSERT INTO test4 (col1, col2) 
	VALUES (4, 'ABCD'); --ORA-00001
INSERT INTO test4 (col1, col2) 
	VALUES (4, NULL);
COMMIT;

SELECT * FROM test4;

DROP TABLE test4;


------------------------------------
--CHECK
--특정 조건을 만족하는 경우만 입력 허용하는 제약. 예를 들어, 정수 입력시 양수만 입력 가능.
--하나의 테이블에 여러번 지정 가능.
--제약 지정
/*
ALTER TABLE 테이블명
	ADD CONSTRAINT 테이블명_컬럼명_CK CHECK(조건식);
*/

CREATE TABLE test5 (
	col1 NUMBER(3)  --PK
	,col2 NUMBER(3)  --CHECK (양수만 입력 가능)
);

ALTER TABLE test5
    ADD CONSTRAINT test5_col1_pk PRIMARY KEY(col1);
ALTER TABLE test5
    ADD CONSTRAINT test5_col2_ck CHECK(col2 > 0);
  
INSERT INTO test5 (col1, col2)
    VALUES (1, 10);
INSERT INTO test5 (col1, col2)
    VALUES (2, 20);
INSERT INTO test5 (col1, col2)
    VALUES (3, -30); --ORA-02290
COMMIT;    
