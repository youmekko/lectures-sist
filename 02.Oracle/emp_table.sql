-- 문제1) 사본 테이블인 employees 테이블 준비하고, insa 테이블에 대한 자료를 employees 테이블로 대량 복사.
CREATE TABLE employees (
        eid NUMBER(5) CONSTRAINT emp_eid_pk PRIMARY KEY
       ,name_ VARCHAR2(20) NOT NULL
       ,ssn  VARCHAR2(14) NOT NULL
       ,hiredate DATE     NOT NULL
       ,phone   VARCHAR2(15)
       ,reg_name  VARCHAR2(10)
       ,dept_name VARCHAR2(15) NOT NULL
       ,job_title VARCHAR2(15) NOT NULL
       ,basicpay NUMBER(10) NOT NULL
       ,extrapay NUMBER(10) NOT NULL
);
 
INSERT INTO employees (eid, name_, ssn, hiredate, phone, reg_name, dept_name, job_title, basicpay, extrapay)
SELECT num AS eid, NAME AS name_, SSN, IBSADATE AS hiredate, TEL AS phone, CITY AS reg_name, BUSEO AS dept_name, JIKWI AS job_title, BASICPAY, SUDANG AS extrapay FROM insa;

 
 
-- 문제2) 지역명 저장용 전용 테이블 준비
CREATE TABLE regions (
    reg_id VARCHAR2(10)   --일련번호 (reg001, reg002, ... )
    ,reg_name  VARCHAR2(10)  --중복되지 않은 도시명
);
 
 
-- 문제3) insa 테이블의 city 컬럼 정보를 중복되지 않게 읽어와서 regions 테이블의 reg_name 컬럼에 입력한다. 단, reg_id 컬럼에는 일련번호가 자동 입력되도록 한다.
 
INSERT INTO regions
    SELECT CONCAT('reg', LPAD(ROW_NUMBER() OVER(ORDER BY reg_name),3,'0')) AS reg_id, reg_name
        FROM (SELECT DISTINCT city AS reg_name FROM insa);
 
 
-- 문제4) 부서명 저장용 테이블 준비
CREATE TABLE departments (
    dept_id VARCHAR2(10)   --일련번호 (dept001, dept002, ... )
    ,dept_name  VARCHAR2(15) NOT NULL
);
 
 
/*
문제5) insa 테이블에서 buseo 컬럼 데이터를 중복되지 않게 읽어와서 departments 테이블의 dept_name 컬럼에 입력한다. 단, dept_id는 일련번호가 자동 입력되도록 한다.
*/
 
INSERT INTO departments
    SELECT CONCAT('dept', LPAD(ROW_NUMBER() OVER(ORDER BY dept_name),3,'0')) AS dept_id, dept_name
        FROM (SELECT DISTINCT buseo AS dept_name FROM insa);
 
 
-- 문제6) 직위명 저장용 테이블 준비
CREATE TABLE jobs (
    job_id VARCHAR2(10)   --일련번호 (job001, job002, ... )
    ,job_title  VARCHAR2(15) NOT NULL
);
 
 
--문제7) insa 테이블에서 jikwi 컬럼 데이터를 중복되지 않게 읽어와서 jobs 테이블의 job_title 컬럼에 입력한다. 단, job_id는 일련번호가 자동 입력되도록 한다.
 
INSERT INTO jobs
    SELECT CONCAT('job', LPAD(ROW_NUMBER() OVER(ORDER BY job_title),3,'0')) AS job_id, job_title
        FROM (SELECT DISTINCT jikwi AS job_title FROM insa);
 
 
COMMIT;
 
 
--문제8) employees 테이블에 reg_id, dept_id, job_id 컬럼 추가.
 
ALTER TABLE employees
 ADD (reg_id VARCHAR2(10) , dept_id VARCHAR2(10) , job_id VARCHAR2(10) );
 
 
 
/*문제9) employees 테이블에서 기존 직원의 reg_name, dept_name, job_title 정보를 가지고
신규 컬럼인 reg_id, dept_id, job_id 컬럼의 값을 일괄 수정한다.*/
UPDATE employees e
  SET (reg_id, dept_id, job_id) = (SELECT reg_id, dept_id, job_id
                FROM regions, departments, jobs
                WHERE reg_name = e.reg_name
                AND dept_name = e.dept_name
                AND job_title = e.job_title);
 
 
--문제10) employees 테이블에서 reg_name, dept_name, job_title 컬럼 삭제.
 
ALTER TABLE employees
DROP (reg_name, dept_name, job_title);
 
 
COMMIT;
 
 
--문제11) employees, regions, departments, jobs 테이블에 제약 조건 추가 (PK, FK)
 
ALTER TABLE regions
ADD CONSTRAINT regions_reg_id_pk PRIMARY KEY(reg_id);
 
ALTER TABLE departments
ADD CONSTRAINT departments_dept_id_pk PRIMARY KEY(dept_id);
 
ALTER TABLE jobs
ADD CONSTRAINT jobs_job_id_pk PRIMARY KEY(job_id);
 
ALTER TABLE employees
    ADD (CONSTRAINT employees_reg_id_fk FOREIGN KEY (reg_id) REFERENCES regions(reg_id)
        , CONSTRAINT employees_dept_id_fk FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
        , CONSTRAINT employees_job_id_fk FOREIGN KEY (job_id) REFERENCES jobs(job_id));
 
 
 
-- 문제12) jobs 테이블에 min_basicPay 컬럼(최소 기본급) 추가 및 min_basicPay 정보 입력. min_basicPay 컬럼의 자료형은 NUMBER로 지정. 직위별 최소 기본급 액수는 임의로 지정. 예를 들어, 사원의 최소 기본급은 1000000원.
ALTER TABLE jobs
    ADD (min_basicpay NUMBER);
    
    
UPDATE jobs
    SET min_basicpay = (
    CASE
        WHEN JOB_TITLE = '과장' THEN 2000000
        WHEN JOB_TITLE = '대리' THEN 1500000
        WHEN JOB_TITLE = '부장' THEN 3000000
        WHEN JOB_TITLE = '사원' THEN 1000000
        END
    );
 
 
/*
문제13) employees, regions, departments, jobs 테이블을 가지고, 원시 데이터 모습으로 출력할 수 있는 JOIN 쿼리 작성.
출력예)
1001    홍길동    771212-1022432    98/10/11    011-2356-4528    서울    기획부    부장    2610000    200000 2810000
1002    이순신    801007-1544236    00/11/29    010-4758-6532    경기    총무부    사원    1320000    200000 1520000
1003    이순애    770922-2312547    99/02/25    010-4231-1236    인천    개발부    부장    2550000    160000 2710000
...
*/
SELECT eid ,name_ ,ssn ,hiredate, phone ,reg_name, dept_name ,job_title ,basicpay ,extrapay, (basicpay + extrapay) pay
FROM employees e, regions r, departments d, jobs j
WHERE e.REG_ID = r.REG_ID
    and e.DEPT_ID = d.DEPT_ID
    and e.JOB_ID = j.JOB_ID;
 
 
COMMIT;
 
 
/*
문제14)  employees, regions, departments, jobs 테이블을 가지고, 원시 데이터 모습으로 출력할 수 있는 JOIN 쿼리 작성 및 뷰 작성 (empView).
CREATE OR REPLACE VIEW empView
AS
SELECT 쿼리;
*/
 
 
/*
문제15) 일괄처리를 위한 emp_table.sql 파일 작성.
*/
 
 
/*
문제16) 테스트 계정 생성(관리자 액션) 및 테스트 계정 로그인, insa.sql, emp_table.sql 파일 실행 테스트(사용자 액션).
@경로명/insa.sql
@경로명/emp_table.sql
*/
 