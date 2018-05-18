------------------------------------
--DEFAULT 표현식

/*
1. insert와 update 문에서 특정 값이 아닌 디폴트값을 입력할 수 도 있다.

2.
컬럼명 데이터타입 DEFAULT 디폴트값

3. INSERT 명령 실행시 해당 컬럼에 값을 할당하지 않거나, DEFAULT 키워드에 의해서 디폴트값을 입력할 수 있다.

4. DEFAULT 키워드와 다른 제약 (NOT NULL 등) 표기가 같이 오는 DEFAULT 키워드 를 먼저 표기할 것.

*/


--DEFAULT 표현식 테스트
CREATE TABLE bbs (
	sid NUMBER PRIMARY KEY  --글번호(자동 번호 증가, 자동 입력)
	,name VARCHAR2(10)      --글쓴이 이름
	,content VARCHAR2(100)  --글내용
	,writeday DATE  DEFAULT SYSDATE  --글쓴 날짜(현재 날짜 자동 입력)
);
--> sid 운영하려면 시퀀스 객체 필요함.
--> 자동 입력되는 컬럼은 입력 항목에서 제외해야 됩니다.

INSERT INTO bbs (sid, name, content) --writeday 컬럼 지정 제외
	VALUES (1, 'hong', 'TEST');
INSERT INTO bbs (sid, name, content) --writeday 컬럼 지정 제외
	VALUES (2, 'park', 'ABCD');
COMMIT;

SELECT * FROM bbs; 
--> 출력해보면 writeday 컬럼에 날짜가 자동 입력된 것을 확인할 수 있다.


--DEFAULT 표현식 확인
SELECT * FROM user_tab_columns 
	WHERE table_name='BBS';
--> data_default 컬럼의 값 확인

--테이블 생성 후 DEFAULT 표현식 추가
/*
ALTER TABLE 테이블명
	MODIFY 컬럼명 [자료형] DEFAULT 값;
*/


--DEFAULT 표현식 삭제
/*
ALTER TABLE 테이블명
	MODIFY 컬럼명 [자료형] DEFAULT NULL;
*/

--DEFAULT 제약 확인용 사용자 뷰 실행
SELECT *
    FROM constraintsCheckView
     WHERE table_name='BBS';



-------------------------------------
--제약 조건(P, R, U, C) 및  NOT NULL, DEFAULT 확인용 뷰 생성 (뷰 생성 권한 필요)
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
  
  
  
  
  
  
  
------------------------------------------------------------
--UPDATE

/*
1. 테이블에서 기존의 데이터를 변경한다.

2. UPDATE 테이블_명
	SET 컬럼_명= 변경할_값[, 컬럼_명= 변경할_값, ...]
	[WHERE 조건];
*/

--------------------------
--한 개의 row를 상대로 한 개의 항목 수정
--원본 상태 확인
SELECT * FROM members;

--박길동 전화번호 변경 시도
--주의) 검색 조건 지정 중요
UPDATE members
    SET tel = '1111'
    WHERE mid=2;
COMMIT;

--변경된 전화번호 확인
SELECT * FROM members;


---------------------
--한 개의 row를 상대로 여러개의 항목 수정
--원본 상태 확인
SELECT * FROM insa;
--basicpay 2610000	sudang 200000

--홍길동 기본급, 수당 변경 시도
--주의) 검색 조건 지정 중요
UPDATE insa
    SET basicpay = 3000000, sudang = 500000
    WHERE num=1001;
COMMIT;

--변경된 기본급, 수당 확인
SELECT * FROM insa;
--basicpay 3000000	sudang 500000


---------------------
--여러개의 row를 상대로 한 개의 항목 수정
--원본 상태 확인
SELECT * FROM insa
    WHERE buseo='개발부';
--sudang 102000 ~ 210000

--개발부 직원 전체의 수당 변경 시도
--주의) 검색 조건 지정 중요
UPDATE insa
    SET sudang = sudang + (sudang * 0.01)
    WHERE buseo='개발부';
COMMIT;

--변경된 수당 확인
SELECT * FROM insa
    WHERE buseo='개발부';
--sudang 103020 ~ 212100



-------------------------------------------------
--주의) WHERE 조건절을 지정하지 않거나, 잘못된 조건인 경우 원하지 않는 row까지 수정의 범위에 포함된다.

--홍길동의 전화번호 변경시 WHERE 조건절 지정 하지 않는 경우를 상정
SELECT * FROM insa
    WHERE num=1001; --조건 지정시 유일한 값(PK 컬럼의 값)을 가지고 검색 권장
--011-2356-4528

--올바른 수정 예    
UPDATE insa
    SET tel = '010-1234-1234'
    WHERE num=1001;
COMMIT;

SELECT * FROM insa
    WHERE num=1001;
--010-1234-1234

--잘못된 수정 예    
UPDATE insa
    SET tel = '010-1234-1234';
--COMMIT;

SELECT * FROM insa;
-->모든 직원의 전화번호가 변경된 상태가 된다.
-->ROLLBACK;



------------------------------------------------------
--서브쿼리를 UPDATE 구문의 일부로 사용 가능

/*
UPDATE 테이블명
    SET 컬럼명 = (서브쿼리)
    WHERE (서브쿼리를 이용한 조건식);
    
    
예를 들어,
UPDATE employees
	SET salary = salary*1.1
	WHERE department_id IN (SELECT department_id
				 FROM departments
				 WHERE department_name='IT');
                 
                 

UPDATE (서브쿼리-JOIN 쿼리를 이용한 가상 테이블)
    SET 컬럼명 = 값
    WHERE 조건식;
    -
예를 들어,
UPDATE (SELECT e.first_name, e.last_name, e.salary, d.department_name
	FROM employees e, departments d
	WHERE e.department_id = d.department_id)  
  SET salary=salary*1.1
  WHERE department_name='IT';
  
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
  VALUES (4, 'VICE PRES'); --O
COMMIT;


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
COMMIT;


--수당 항목 추가 + 기본값 추가
ALTER TABLE employees
    ADD (extrapay NUMBER DEFAULT 100000);


--원본 상태 확인
SELECT sid, name, e.extrapay , e.jikwi_id, jikwi_name
  FROM employees e, jobs j
  WHERE e.jikwi_id=j.jikwi_id;
/*  
1	hong	100000	1	CLERK
2	park	100000	2	MANAGER
3	choi	100000	2	MANAGER
*/


--jobs.jikwi_name 이 'CLERK'인 직원의 수당(employees.extrapay) 변경
UPDATE employees
    SET extrapay = 20000
    WHERE jikwi_name = 'CLERK'; --ORA-00904: "JIKWI_NAME": invalid identifier
    
--방법1    
UPDATE employees
    SET extrapay = 20000
    WHERE jikwi_id = (SELECT jikwi_id FROM jobs WHERE jikwi_name = 'CLERK');    
    
--방법2
UPDATE (SELECT extrapay, jikwi_name
            FROM employees emp, jobs j
            WHERE emp.jikwi_id = j.jikwi_id)
    SET extrapay = 20000
    WHERE jikwi_name = 'CLERK';
COMMIT;

--수정된 상태 확인
SELECT sid, name, e.extrapay , e.jikwi_id, jikwi_name
  FROM employees e, jobs j
  WHERE e.jikwi_id=j.jikwi_id;
/*  
1	hong	20000	1	CLERK
2	park	100000	2	MANAGER
3	choi	100000	2	MANAGER
*/  


--jobs.jikwi_name이 'CLERK'인 직원의 수당(employees.extrapay) 20% 인상. jobs.jikwi_name이 'MANAGER'인 직원의 수당(employees.extrapay) 10% 인상.
--> DECODE() 함수 사용.
UPDATE (SELECT extrapay, jikwi_name
            FROM employees emp, jobs j
            WHERE emp.jikwi_id = j.jikwi_id)
    SET extrapay = DECODE(jikwi_name, 'CLERK', extrapay*1.2, 'MANAGER', extrapay*1.1, extrapay);
COMMIT;

--수정된 상태 확인
SELECT sid, name, e.extrapay , e.jikwi_id, jikwi_name
  FROM employees e, jobs j
  WHERE e.jikwi_id=j.jikwi_id;
/*  
1	hong	24000	1	CLERK
2	park	110000	2	MANAGER
3	choi	110000	2	MANAGER
*/



------------------------------------------------
--DELETE

/*
1. 테이블에서 지정한 행을 삭제하는데 사용한다.

2. DELETE [FROM] 테이블_명 [WHERE 조건];
*/



--------------------------
--한 개의 row를 상대로 삭제
--원본 상태 확인
SELECT * FROM members;

--박길동 자료 삭제 시도
--주의) 검색 조건 지정 중요
DELETE FROM members
    WHERE mid=2;
COMMIT;

--삭제된 상태 확인
SELECT * FROM members;




--------------------------
--여러 개의 row를 상대로 삭제
--원본 상태 확인
SELECT * FROM insa;

--'개발부' 전체 자료 삭제 시도
--주의) 검색 조건 지정 중요
DELETE FROM insa
    WHERE buseo='개발부';
COMMIT;

--삭제된 상태 확인
SELECT * FROM insa;



-------------------------------------------------
--주의) WHERE 조건절을 지정하지 않거나, 잘못된 조건인 경우 원하지 않는 row까지 삭제의 범위에 포함된다.

DELETE FROM insa;
--COMMIT;

--삭제된 상태 확인
SELECT * FROM insa;
--> 모든 자료가 삭제된 상태이다.
--> ROLLBACK;



--jobs.jikwi_name 이 'CLERK'인 직원(employees 테이블)만 삭제 시도
DELETE FROM (SELECT extrapay, jikwi_name
            FROM employees emp, jobs j
            WHERE emp.jikwi_id = j.jikwi_id)
    WHERE jikwi_name = 'CLERK';
COMMIT;

--삭제된 상태 확인
SELECT *
        FROM employees emp, jobs j
        WHERE emp.jikwi_id = j.jikwi_id;
      
      
--주의) jobs 테이블의 row를 삭제하는 경우(참조 당하는 경우 삭제 불가)        
SELECT * FROM jobs;

DELETE FROM jobs
    WHERE jikwi_id = 2; --ORA-02292: integrity constraint (MINJONG.EMPLOYEES_JIKWI_ID_FK) violated - child record found

--> FK 제약 생성시 ON DELETE CASCADE 옵션 지정하면 삭제 가능


---------------------------------------
