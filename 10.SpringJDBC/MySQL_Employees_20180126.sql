#--------------------------------------------------
#직원관리 v2.0 MySQL을 위한 테이블 생성

#--------------------------------------------------
CREATE TABLE regions (
    reg_id VARCHAR(5)   #PK (REG01, REG02, ... )
    ,reg_name  VARCHAR(10)
);

#PK 제약조건 지정 쿼리
ALTER TABLE regions
ADD CONSTRAINT regions_reg_id_pk PRIMARY KEY(reg_id);

#샘플 자료 입력 쿼리
#reg_id 컬럼에는 자동 번호(REG01, REG02, ... ) 증가하도록 서브 쿼리 작성.
INSERT INTO regions  (reg_id, reg_name)
VALUES ((SELECT * FROM (SELECT CONCAT('REG', LPAD(IFNULL(SUBSTRING(MAX(reg_id), 4), 0) + 1, 2, 0)) AS newMid FROM regions) m), '서울')
, ((SELECT * FROM (SELECT CONCAT('REG', LPAD(IFNULL(SUBSTRING(MAX(reg_id), 4), 0) + 1, 2, 0)) AS newMid FROM regions) m), '경기');

#전체 정보 출력 쿼리
SELECT reg_id, reg_name
FROM regions r
ORDER BY reg_id;

#삭제 가능 여부 확인 쿼리
SELECT 
    reg_id,
    reg_name,
    (SELECT 
            COUNT(*)
        FROM
            employees
        WHERE
            reg_id = r.reg_id) AS deleteCheck
FROM
    regions r
ORDER BY reg_id;


#--------------------------------------------------
CREATE TABLE departments (
    dept_id VARCHAR(6)   #PK (DEPT01, DEPT02, ... )
    ,dept_name  VARCHAR(15) NOT NULL
);

#PK 제약조건 지정 쿼리
ALTER TABLE departments
ADD CONSTRAINT departments_dept_id_pk PRIMARY KEY(dept_id);

#샘플 자료 입력 쿼리
#dept_id 컬럼에는 자동 번호(DEPT01, DEPT02, ... ) 증가하도록 서브 쿼리 작성.
INSERT INTO departments  (dept_id, dept_name)
VALUES ((SELECT * FROM (SELECT CONCAT('DEPT', LPAD(IFNULL(SUBSTRING(MAX(dept_id), 5), 0) + 1, 2, 0)) AS newMid FROM departments) m), '개발부')
, ((SELECT * FROM (SELECT CONCAT('DEPT', LPAD(IFNULL(SUBSTRING(MAX(dept_id), 5), 0) + 1, 2, 0)) AS newMid FROM departments) m), '마케팅부');

#전체 정보 출력 쿼리
SELECT dept_id, dept_name
FROM departments d
ORDER BY dept_id;


#--------------------------------------------------
CREATE TABLE jobs (
    job_id VARCHAR(5)   #PK (JOB01, JOB02, ... )
    ,job_title  VARCHAR(15) NOT NULL
);

#PK 제약조건 지정 쿼리
ALTER TABLE jobs
ADD CONSTRAINT jobs_job_id_pk PRIMARY KEY(job_id);

#샘플 자료 입력 쿼리
#job_id 컬럼에는 자동 번호(JOB01, JOB02, ... ) 증가하도록 서브 쿼리 작성.
INSERT INTO jobs  (job_id, job_title)
VALUES ((SELECT * FROM (SELECT CONCAT('JOB', LPAD(IFNULL(SUBSTRING(MAX(job_id), 4), 0) + 1, 2, 0)) AS newMid FROM jobs) m), '사원')
, ((SELECT * FROM (SELECT CONCAT('JOB', LPAD(IFNULL(SUBSTRING(MAX(job_id), 4), 0) + 1, 2, 0)) AS newMid FROM jobs) m), '과장');

#전체 정보 출력 쿼리
SELECT job_id, job_title
FROM jobs j
ORDER BY job_id;



#--------------------------------------------------
CREATE TABLE employees (
        eid VARCHAR(5) #PK (E0001, E0002, ... )
       ,name_ VARCHAR(20) NOT NULL
       ,ssn  VARCHAR(14) NOT NULL
       ,hiredate DATE     NOT NULL
       ,phone   VARCHAR(15)
       ,reg_id  VARCHAR(10) #FK
       ,dept_id VARCHAR(15) #FK
       ,job_id VARCHAR(15) #FK
       ,basicpay INT NOT NULL
       ,extrapay INT NOT NULL
);

#PK 제약조건 지정 쿼리
ALTER TABLE employees
ADD CONSTRAINT employees_eid_pk PRIMARY KEY(eid);

#FK 제약조건 지정 쿼리
ALTER TABLE employees
ADD CONSTRAINT employees_reg_id_fk FOREIGN KEY(reg_id)
		REFERENCES regions(reg_id);
ALTER TABLE employees
ADD CONSTRAINT employees_dept_id_fk FOREIGN KEY(dept_id)
		REFERENCES departments(dept_id);
ALTER TABLE employees
ADD CONSTRAINT employees_job_id_fk FOREIGN KEY(job_id)
		REFERENCES jobs(job_id);

#샘플 자료 입력 쿼리
#eid 컬럼에는 자동 번호(E0001, E0002, ... ) 증가하도록 서브 쿼리 작성.
INSERT INTO employees  (eid, name_, ssn, hiredate, phone, reg_id, dept_id, job_id, basicpay, extrapay) VALUES ((SELECT * FROM (SELECT CONCAT('E', LPAD(IFNULL(SUBSTRING(MAX(eid), 2), 0) + 1, 4, 0)) AS newMid FROM employees) m), 'HONG', '8010101234567', '2000-01-01', '010-1234-1234', 'REG01', 'DEPT01', 'JOB01', 2000000, 2000000);

#전체 정보 출력 쿼리
SELECT 
    eid,
    name_,
    ssn,
    hiredate,
    phone,
    reg_id,
    dept_id,
    job_id,
    basicpay,
    extrapay
FROM
    employees e
ORDER BY eid;


#전체 정보 출력을 위한 조인 쿼리
SELECT 
    eid,
    name_,
    ssn,
    hiredate,
    phone,
    e.reg_id,
    reg_name,
    e.dept_id,
    dept_name,
    e.job_id,
    job_title,
    basicpay,
    extrapay,
    basicpay + extrapay AS pay
FROM
    employees e
        INNER JOIN
    regions r ON e.reg_id = r.reg_id
        INNER JOIN
    departments d ON e.dept_id = d.dept_id
        INNER JOIN
    jobs j ON e.job_id = j.job_id
ORDER BY eid;


#전체 정보 출력을 위한 조인 쿼리 -> 뷰 등록
CREATE VIEW empView AS
SELECT 
    eid,
    name_,
    ssn,
    hiredate,
    phone,
    e.reg_id,
    reg_name,
    e.dept_id,
    dept_name,
    e.job_id,
    job_title,
    basicpay,
    extrapay,
    basicpay + extrapay AS pay
FROM
    employees e
        INNER JOIN
    regions r ON e.reg_id = r.reg_id
        INNER JOIN
    departments d ON e.dept_id = d.dept_id
        INNER JOIN
    jobs j ON e.job_id = j.job_id
ORDER BY eid;


#뷰를 이용한 전체 정보 출력 쿼리
SELECT 
    eid,
    name_,
    ssn,
    hiredate,
    phone,
    reg_id,
    reg_name,
    dept_id,
    dept_name,
    job_id,
    job_title,
    basicpay,
    extrapay,
    pay
FROM
    empView;
    
    
#직원 정보 삭제 쿼리
DELETE FROM employees WHERE eid = 'E0001';
    


#--------------------------------------------------
CREATE TABLE login (
	id_ VARCHAR(20) #PK
	, pw_ VARCHAR(20)
	, grade TINYINT #0(관리자), 1(강사), 2(수강생, 기본값)
);

#PK 제약조건 지정 쿼리
ALTER TABLE login
ADD CONSTRAINT login_id_pk PRIMARY KEY(id_);

#grade 컬럼에는 0(관리자), 1(강사), 2(수강생, 기본값)만 넣을 수 있도록 설정. CHECK 제약.

#샘플 자료 입력 쿼리
#관리자 계정은 필수 입력
INSERT INTO login  (id_, pw_, grade)
VALUES ('admin', '1234', 0)
, ('hong', '1234', 1);

#전체 정보 출력 쿼리
SELECT id_, pw_, grade
FROM login l
ORDER BY id_;


#로그인 검증 쿼리
SELECT *
FROM login
WHERE id_='admin' AND pw_='1234';




