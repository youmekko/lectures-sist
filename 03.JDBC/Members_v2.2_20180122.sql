--회원관리 v2.2을 위한 테이블 생성

--회원 정보 테이블(members) 생성
-->회원번호(PK), 이름, 전화번호, 이메일, 등록일, 부서번호(FK)
-->mid, name_, phone, email, regDate, deptId
CREATE TABLE members (
    mid VARCHAR2(3) --PK
    ,name_ NVARCHAR2(20) NOT NULL
    ,phone VARCHAR2(20) NOT NULL
    ,email VARCHAR2(50)
    ,regDate DATE
    ,deptId VARCHAR2(3) --FK
);

--부서 정보 테이블(dept) 생성
-->부서번호(PK), 부서명
-->deptId, deptName
-->부서 정보는 개발부(B01), 마케팅부(B02), 총무부(B03)만 존재한다고 가정
CREATE TABLE dept (
    deptId VARCHAR2(3) --PK
    ,deptName NVARCHAR2(20) NOT NULL
);


--제약조건 추가
ALTER TABLE members
ADD CONSTRAINT members_mid_pk PRIMARY KEY(mid);
ALTER TABLE dept
ADD CONSTRAINT dept_deptId_pk PRIMARY KEY(deptId);
--문제) members 테이블에서 deptId 컬럼에 FK 제약 조건 추가.
ALTER TABLE members
ADD CONSTRAINT members_deptId_fk FOREIGN KEY(deptId)
        REFERENCES dept(deptId);



--샘플 자료 입력
INSERT INTO dept (deptId, deptName) VALUES ('B01', '개발부');
INSERT INTO dept (deptId, deptName) VALUES ('B02', '마케팅부');
INSERT INTO dept (deptId, deptName) VALUES ('B03', '총무부');

--COMMIT;
COMMIT;


----------------------------------------
--회원 정보 입력 쿼리
--1. 회원 정보 입력
--문제) mid 컬럼의 값이 자동 증가되도록 서브쿼리 지정.
/*
입력 예)
M01 hong 010-1234-1234 hong@naver.com 2017-04-28 B01
M02 choi 010-5678-1234 choi@naver.com 2017-05-01 B01
M03 park 010-4321-4321 park@naver.com 2017-05-10 B02
*/

INSERT INTO members (mid, name_, phone, email, regDate, deptId) 
VALUES ((SELECT CONCAT('M', LPAD(NVL(SUBSTR(MAX(mid), 2), 0) + 1, 2, 0)) AS newMid FROM members)
        , 'hong', '010-1234-1234', 'hong@naver.com', '2017-04-28', 'B01');
INSERT INTO members (mid, name_, phone, email, regDate, deptId) 
VALUES ((SELECT CONCAT('M', LPAD(NVL(SUBSTR(MAX(mid), 2), 0) + 1, 2, 0)) AS newMid FROM members)
        , 'choi', '010-5678-1234', 'choi@naver.com', '2017-05-01', 'B01');
INSERT INTO members (mid, name_, phone, email, regDate, deptId) 
VALUES ((SELECT CONCAT('M', LPAD(NVL(SUBSTR(MAX(mid), 2), 0) + 1, 2, 0)) AS newMid FROM members)
        , 'park', '010-4321-4321', 'park@naver.com', '2017-05-10', 'B02');
ROLLBACK;



---------------------------------------
--회원 정보 출력 쿼리
--2. 회원 정보 출력
/*
출력 예)
M01 hong 010-1234-1234 hong@naver.com 2017-04-28 개발부
M02 choi 010-5678-1234 choi@naver.com 2017-05-01 개발부
M03 park 010-4321-4321 park@naver.com 2017-05-10 마케팅부
*/
SELECT mid, name_, phone, email, regDate, deptName
FROM members m, dept d
WHERE m.deptId = d.deptId;
-->뷰 등록 권장
CREATE OR REPLACE VIEW membersView
AS
SELECT mid, name_, phone, email, regDate, deptName
FROM members m, dept d
WHERE m.deptId = d.deptId;
--뷰를 이용해서 쿼리 실행
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView;



---------------------------------------
--부서 정보 출력 쿼리
--1. 회원 정보 입력
SELECT deptId, deptName
FROM dept;


----------------------------------------
--회원 정보 검색 쿼리
--주의) membersView 등록된 상태 확인
--회원 번호(PK) 기준
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE LOWER(mid) = LOWER('M01');

--이름 기준(부분 검색)
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE INSTR(LOWER(name_), LOWER('hong')) > 0;

--전화번호 기준(부분 검색)
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE INSTR(phone, '1234') > 0;

--이메일 기준(부분 검색)
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE INSTR(email, 'naver') > 0;

--등록일 기준(부분 검색)
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE INSTR(TO_CHAR(regDate, 'YYYY-MM-DD'), '2017-05') > 0;

--부서명 기준(부분 검색)
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE INSTR(deptName, '개발부') > 0;


-------------------------------------------
--회비 내역 관리 테이블 생성

CREATE TABLE membersFee (
    mid VARCHAR2(3) --PK, FK 
    ,feeDate DATE --PK
    ,fee NUMBER --CK
);

--제약조건 추가 mid + feeDate => PK
ALTER TABLE membersFee
ADD CONSTRAINT membersFee_mid_feeDate_pk PRIMARY KEY(mid, feeDate);

--제약조건 추가 mid -> FK
ALTER TABLE membersFee
ADD CONSTRAINT membersFee_mid_fk FOREIGN KEY (mid)
        REFERENCES members(mid);

--제약조건 추가 fee -> CK -> 10000 이상
ALTER TABLE membersFee
ADD CONSTRAINT membersFee_fee_ck CHECK (fee >= 10000);

--입력 쿼리 샘플
INSERT INTO membersFee (mid, feeDate, fee)
    VALUES ('M01', '2017-12-01', 10000);
INSERT INTO membersFee (mid, feeDate, fee)
    VALUES ('M01', '2018-01-01', 10000);
COMMIT;    


--회원명단 및 회비납부총액 출력 쿼리
SELECT mid, name_, phone, email, regDate, deptName
    , (SELECT NVL(SUM(fee),0) FROM membersFee WHERE mid=m.mid) feeTotal
FROM membersView m;


--특정 회원의 회비 납부 내역 출력
SELECT mid, feeDate, fee
FROM membersFee
WHERE mid='M01'
ORDER BY feeDate;

--특정 회원의 회비 납부 총액 출력
SELECT NVL(SUM(fee),0) feeTotal
FROM membersFee
WHERE mid='M01';

ROLLBACK;


--------------------------------------
--회원 중복 검사
--이름, 전화번호가 중복 저장되지 않도록 제약 추가
--Unique 제약
ALTER TABLE members
ADD CONSTRAINT members_name_phone_uk UNIQUE(name_, phone);


INSERT INTO members (mid, name_, phone, email, regDate, deptId) 
VALUES ((SELECT CONCAT('M', LPAD(NVL(SUBSTR(MAX(mid), 2), 0) + 1, 2, 0)) AS newMid FROM members)
        , 'hong', '010-1234-1234', 'hong@naver.com', '2017-04-28', 'B01');
-->제약 위반 오류 발생

---------------------------------------
