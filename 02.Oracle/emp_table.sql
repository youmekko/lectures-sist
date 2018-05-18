-- ����1) �纻 ���̺��� employees ���̺� �غ��ϰ�, insa ���̺� ���� �ڷḦ employees ���̺�� �뷮 ����.
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

 
 
-- ����2) ������ ����� ���� ���̺� �غ�
CREATE TABLE regions (
    reg_id VARCHAR2(10)   --�Ϸù�ȣ (reg001, reg002, ... )
    ,reg_name  VARCHAR2(10)  --�ߺ����� ���� ���ø�
);
 
 
-- ����3) insa ���̺��� city �÷� ������ �ߺ����� �ʰ� �о�ͼ� regions ���̺��� reg_name �÷��� �Է��Ѵ�. ��, reg_id �÷����� �Ϸù�ȣ�� �ڵ� �Էµǵ��� �Ѵ�.
 
INSERT INTO regions
    SELECT CONCAT('reg', LPAD(ROW_NUMBER() OVER(ORDER BY reg_name),3,'0')) AS reg_id, reg_name
        FROM (SELECT DISTINCT city AS reg_name FROM insa);
 
 
-- ����4) �μ��� ����� ���̺� �غ�
CREATE TABLE departments (
    dept_id VARCHAR2(10)   --�Ϸù�ȣ (dept001, dept002, ... )
    ,dept_name  VARCHAR2(15) NOT NULL
);
 
 
/*
����5) insa ���̺��� buseo �÷� �����͸� �ߺ����� �ʰ� �о�ͼ� departments ���̺��� dept_name �÷��� �Է��Ѵ�. ��, dept_id�� �Ϸù�ȣ�� �ڵ� �Էµǵ��� �Ѵ�.
*/
 
INSERT INTO departments
    SELECT CONCAT('dept', LPAD(ROW_NUMBER() OVER(ORDER BY dept_name),3,'0')) AS dept_id, dept_name
        FROM (SELECT DISTINCT buseo AS dept_name FROM insa);
 
 
-- ����6) ������ ����� ���̺� �غ�
CREATE TABLE jobs (
    job_id VARCHAR2(10)   --�Ϸù�ȣ (job001, job002, ... )
    ,job_title  VARCHAR2(15) NOT NULL
);
 
 
--����7) insa ���̺��� jikwi �÷� �����͸� �ߺ����� �ʰ� �о�ͼ� jobs ���̺��� job_title �÷��� �Է��Ѵ�. ��, job_id�� �Ϸù�ȣ�� �ڵ� �Էµǵ��� �Ѵ�.
 
INSERT INTO jobs
    SELECT CONCAT('job', LPAD(ROW_NUMBER() OVER(ORDER BY job_title),3,'0')) AS job_id, job_title
        FROM (SELECT DISTINCT jikwi AS job_title FROM insa);
 
 
COMMIT;
 
 
--����8) employees ���̺� reg_id, dept_id, job_id �÷� �߰�.
 
ALTER TABLE employees
 ADD (reg_id VARCHAR2(10) , dept_id VARCHAR2(10) , job_id VARCHAR2(10) );
 
 
 
/*����9) employees ���̺��� ���� ������ reg_name, dept_name, job_title ������ ������
�ű� �÷��� reg_id, dept_id, job_id �÷��� ���� �ϰ� �����Ѵ�.*/
UPDATE employees e
  SET (reg_id, dept_id, job_id) = (SELECT reg_id, dept_id, job_id
                FROM regions, departments, jobs
                WHERE reg_name = e.reg_name
                AND dept_name = e.dept_name
                AND job_title = e.job_title);
 
 
--����10) employees ���̺��� reg_name, dept_name, job_title �÷� ����.
 
ALTER TABLE employees
DROP (reg_name, dept_name, job_title);
 
 
COMMIT;
 
 
--����11) employees, regions, departments, jobs ���̺� ���� ���� �߰� (PK, FK)
 
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
 
 
 
-- ����12) jobs ���̺� min_basicPay �÷�(�ּ� �⺻��) �߰� �� min_basicPay ���� �Է�. min_basicPay �÷��� �ڷ����� NUMBER�� ����. ������ �ּ� �⺻�� �׼��� ���Ƿ� ����. ���� ���, ����� �ּ� �⺻���� 1000000��.
ALTER TABLE jobs
    ADD (min_basicpay NUMBER);
    
    
UPDATE jobs
    SET min_basicpay = (
    CASE
        WHEN JOB_TITLE = '����' THEN 2000000
        WHEN JOB_TITLE = '�븮' THEN 1500000
        WHEN JOB_TITLE = '����' THEN 3000000
        WHEN JOB_TITLE = '���' THEN 1000000
        END
    );
 
 
/*
����13) employees, regions, departments, jobs ���̺��� ������, ���� ������ ������� ����� �� �ִ� JOIN ���� �ۼ�.
��¿�)
1001    ȫ�浿    771212-1022432    98/10/11    011-2356-4528    ����    ��ȹ��    ����    2610000    200000 2810000
1002    �̼���    801007-1544236    00/11/29    010-4758-6532    ���    �ѹ���    ���    1320000    200000 1520000
1003    �̼���    770922-2312547    99/02/25    010-4231-1236    ��õ    ���ߺ�    ����    2550000    160000 2710000
...
*/
SELECT eid ,name_ ,ssn ,hiredate, phone ,reg_name, dept_name ,job_title ,basicpay ,extrapay, (basicpay + extrapay) pay
FROM employees e, regions r, departments d, jobs j
WHERE e.REG_ID = r.REG_ID
    and e.DEPT_ID = d.DEPT_ID
    and e.JOB_ID = j.JOB_ID;
 
 
COMMIT;
 
 
/*
����14)  employees, regions, departments, jobs ���̺��� ������, ���� ������ ������� ����� �� �ִ� JOIN ���� �ۼ� �� �� �ۼ� (empView).
CREATE OR REPLACE VIEW empView
AS
SELECT ����;
*/
 
 
/*
����15) �ϰ�ó���� ���� emp_table.sql ���� �ۼ�.
*/
 
 
/*
����16) �׽�Ʈ ���� ����(������ �׼�) �� �׽�Ʈ ���� �α���, insa.sql, emp_table.sql ���� ���� �׽�Ʈ(����� �׼�).
@��θ�/insa.sql
@��θ�/emp_table.sql
*/
 