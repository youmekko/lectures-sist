#-----------------------
#MySQL Workbench
#-----------------------

CREATE TABLE regions (
    reg_id VARCHAR(5)   #PK (REG01, REG02, ... )
    ,reg_name  VARCHAR(10)
);

CREATE TABLE departments (
    dept_id VARCHAR(6)   #PK (DEPT01, DEPT02, ... )
    ,dept_name  VARCHAR(15) NOT NULL
);

CREATE TABLE jobs (
    job_id VARCHAR(5)   #PK (JOB01, JOB02, ... )
    ,job_title  VARCHAR(15) NOT NULL
);

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

CREATE TABLE login (
	id_ VARCHAR(20) #PK
	, pw_ VARCHAR(20)
	, grade TINYINT #0(관리자), 1(강사), 2(수강생, 기본값)
);




