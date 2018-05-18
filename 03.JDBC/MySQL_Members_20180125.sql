#회원관리 ver.MySQL을 위한 테이블 생성

#회원 정보 테이블(members) 생성
#>회원번호(PK), 이름, 전화번호, 이메일, 등록일, 부서번호(FK)
#>mid, name_, phone, email, regDate, deptId
CREATE TABLE members (
    mid_ VARCHAR(3) #PK
    ,name_ VARCHAR(20) NOT NULL
    ,phone VARCHAR(20) NOT NULL
    ,email VARCHAR(50)
    ,regDate DATE
    ,deptId VARCHAR(3) #FK
);

#부서 정보 테이블(dept) 생성
#>부서번호(PK), 부서명
#>deptId, deptName
#>부서 정보는 개발부(B01), 마케팅부(B02), 총무부(B03)만 존재한다고 가정
CREATE TABLE dept (
    deptId VARCHAR(3) #PK
    ,deptName VARCHAR(20) NOT NULL
);


#제약조건 추가
ALTER TABLE members
ADD CONSTRAINT members_mid_pk PRIMARY KEY(mid_);
ALTER TABLE dept
ADD CONSTRAINT dept_deptId_pk PRIMARY KEY(deptId);

#members 테이블에서 deptId 컬럼에 FK 제약 조건 추가.
ALTER TABLE members
ADD CONSTRAINT members_deptId_fk FOREIGN KEY(deptId)
        REFERENCES dept(deptId);



#샘플 자료 입력
INSERT INTO dept (deptId, deptName) VALUES ('B01', '개발부')
	,('B02', '마케팅부')
    ,('B03', '총무부');
    
SELECT  deptId, deptName
FROM dept;    


####################
#회원 정보 입력 쿼리
#1. 회원 정보 입력
#문제) mid_ 컬럼의 값이 자동 증가되도록 서브쿼리 지정.
/*
입력 예)
M01 hong 010-1234-1234 hong@naver.com 2017-04-28 B01
M02 choi 010-5678-1234 choi@naver.com 2017-05-01 B01
M03 park 010-4321-4321 park@naver.com 2017-05-10 B02
*/
INSERT INTO 
	members (mid_, name_, phone, email, regDate, deptId) 
VALUES 
	((SELECT * FROM (SELECT CONCAT('M', LPAD(IFNULL(SUBSTRING(MAX(mid_), 2), 0) + 1, 2, 0)) AS newMid FROM members) m)
      , 'hong', '010-1234-1234', 'hong@naver.com', '2017-04-28', 'B01');


SELECT * FROM members;

###################-
#문제) 회원 정보 출력 쿼리 -> 조인 쿼리
#2. 회원 정보 출력
/*
출력 예)
M01 hong 010-1234-1234 hong@naver.com 2017-04-28 개발부
M02 choi 010-5678-1234 choi@naver.com 2017-05-01 개발부
M03 park 010-4321-4321 park@naver.com 2017-05-10 마케팅부
*/
SELECT 
    mid_, name_, phone, email, regDate, deptName
FROM
    members
        INNER JOIN
    dept USING(deptId);
#>뷰 등록 권장
CREATE VIEW membersView
AS
SELECT 
    mid_, name_, phone, email, regDate, deptName
FROM
    members
        INNER JOIN
    dept USING(deptId);
#뷰를 이용해서 쿼리 실행
SELECT mid_, name_, phone, email, regDate, deptName
FROM membersView;



###################-
#부서 정보 출력 쿼리
#1. 회원 정보 입력
SELECT deptId, deptName
FROM dept;


####################################
#번호 기준 검색
SELECT 
    mid_, name_, phone, email, regDate, deptName
FROM
    membersView
WHERE
    mid_ = 'm02';
 
#이름 기준 부분 검색
SELECT 
    mid_, name_, phone, email, regDate, deptName
FROM
    membersView
WHERE
	INSTR(name_, 'PARK') > 0;
    
#전화번호 기준 부분 검색
SELECT 
    mid_, name_, phone, email, regDate, deptName
FROM
    membersView
WHERE
	INSTR(phone, '1234') > 0;
    
#이메일 기준 부분 검색
SELECT 
    mid_, name_, phone, email, regDate, deptName
FROM
    membersView
WHERE
	INSTR(email, 'test') > 0;
    
#등록일 기준 부분 검색
SELECT 
    mid_, name_, phone, email, regDate, deptName
FROM
    membersView
WHERE
	INSTR(regDate, '2018-01') > 0;
    
#부서명 기준 부분 검색
SELECT 
    mid_, name_, phone, email, regDate, deptName
FROM
    membersView
WHERE
	INSTR(deptName, '개발') > 0;




