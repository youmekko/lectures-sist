------------------------------------
--DEFAULT ǥ����

/*
1. insert�� update ������ Ư�� ���� �ƴ� ����Ʈ���� �Է��� �� �� �ִ�.

2.
�÷��� ������Ÿ�� DEFAULT ����Ʈ��

3. INSERT ��� ����� �ش� �÷��� ���� �Ҵ����� �ʰų�, DEFAULT Ű���忡 ���ؼ� ����Ʈ���� �Է��� �� �ִ�.

4. DEFAULT Ű����� �ٸ� ���� (NOT NULL ��) ǥ�Ⱑ ���� ���� DEFAULT Ű���� �� ���� ǥ���� ��.

*/


--DEFAULT ǥ���� �׽�Ʈ
CREATE TABLE bbs (
	sid NUMBER PRIMARY KEY  --�۹�ȣ(�ڵ� ��ȣ ����, �ڵ� �Է�)
	,name VARCHAR2(10)      --�۾��� �̸�
	,content VARCHAR2(100)  --�۳���
	,writeday DATE  DEFAULT SYSDATE  --�۾� ��¥(���� ��¥ �ڵ� �Է�)
);
--> sid ��Ϸ��� ������ ��ü �ʿ���.
--> �ڵ� �ԷµǴ� �÷��� �Է� �׸񿡼� �����ؾ� �˴ϴ�.

INSERT INTO bbs (sid, name, content) --writeday �÷� ���� ����
	VALUES (1, 'hong', 'TEST');
INSERT INTO bbs (sid, name, content) --writeday �÷� ���� ����
	VALUES (2, 'park', 'ABCD');
COMMIT;

SELECT * FROM bbs; 
--> ����غ��� writeday �÷��� ��¥�� �ڵ� �Էµ� ���� Ȯ���� �� �ִ�.


--DEFAULT ǥ���� Ȯ��
SELECT * FROM user_tab_columns 
	WHERE table_name='BBS';
--> data_default �÷��� �� Ȯ��

--���̺� ���� �� DEFAULT ǥ���� �߰�
/*
ALTER TABLE ���̺��
	MODIFY �÷��� [�ڷ���] DEFAULT ��;
*/


--DEFAULT ǥ���� ����
/*
ALTER TABLE ���̺��
	MODIFY �÷��� [�ڷ���] DEFAULT NULL;
*/

--DEFAULT ���� Ȯ�ο� ����� �� ����
SELECT *
    FROM constraintsCheckView
     WHERE table_name='BBS';



-------------------------------------
--���� ����(P, R, U, C) ��  NOT NULL, DEFAULT Ȯ�ο� �� ���� (�� ���� ���� �ʿ�)
CREATE OR REPLACE VIEW constraintsCheckView
AS
SELECT utc.table_name AS table_name --������ ������ ���̺��
	, utc.column_name AS column_name --������ ������ �÷���
	, data_type   --������ ������ �÷��� �ڷ���
	, data_length   --������ ������ �÷��� ũ��(length)
	, data_precision   --������ ������ �÷��� ũ��(precision)
	, nullable    --������ ������ �÷��� NULL ��� ����
	, data_default    --������ ������ �÷��� DEFAULT ��
	, constraint_name    --�����
	, constraint_type     --��������
	, search_condition  --CHECK ������ ��� ���ǽ�
	, delete_rule    --FOREIGN KEY ������ ��� ON DELETE CASCADE ���� ����
	, r_table_name   --FOREIGN KEY ������ ��� ���� ���̺��
	, r_conlumn_name   --FOREIGN KEY ������ ��� ���� �÷���
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


--�� ����� ���� ���� Ȯ�� ���� ����
SELECT *  
    FROM constraintsCheckView
  WHERE table_name='EMPLOYEES'; 
  
  
  
  
  
  
  
------------------------------------------------------------
--UPDATE

/*
1. ���̺��� ������ �����͸� �����Ѵ�.

2. UPDATE ���̺�_��
	SET �÷�_��= ������_��[, �÷�_��= ������_��, ...]
	[WHERE ����];
*/

--------------------------
--�� ���� row�� ���� �� ���� �׸� ����
--���� ���� Ȯ��
SELECT * FROM members;

--�ڱ浿 ��ȭ��ȣ ���� �õ�
--����) �˻� ���� ���� �߿�
UPDATE members
    SET tel = '1111'
    WHERE mid=2;
COMMIT;

--����� ��ȭ��ȣ Ȯ��
SELECT * FROM members;


---------------------
--�� ���� row�� ���� �������� �׸� ����
--���� ���� Ȯ��
SELECT * FROM insa;
--basicpay 2610000	sudang 200000

--ȫ�浿 �⺻��, ���� ���� �õ�
--����) �˻� ���� ���� �߿�
UPDATE insa
    SET basicpay = 3000000, sudang = 500000
    WHERE num=1001;
COMMIT;

--����� �⺻��, ���� Ȯ��
SELECT * FROM insa;
--basicpay 3000000	sudang 500000


---------------------
--�������� row�� ���� �� ���� �׸� ����
--���� ���� Ȯ��
SELECT * FROM insa
    WHERE buseo='���ߺ�';
--sudang 102000 ~ 210000

--���ߺ� ���� ��ü�� ���� ���� �õ�
--����) �˻� ���� ���� �߿�
UPDATE insa
    SET sudang = sudang + (sudang * 0.01)
    WHERE buseo='���ߺ�';
COMMIT;

--����� ���� Ȯ��
SELECT * FROM insa
    WHERE buseo='���ߺ�';
--sudang 103020 ~ 212100



-------------------------------------------------
--����) WHERE �������� �������� �ʰų�, �߸��� ������ ��� ������ �ʴ� row���� ������ ������ ���Եȴ�.

--ȫ�浿�� ��ȭ��ȣ ����� WHERE ������ ���� ���� �ʴ� ��츦 ����
SELECT * FROM insa
    WHERE num=1001; --���� ������ ������ ��(PK �÷��� ��)�� ������ �˻� ����
--011-2356-4528

--�ùٸ� ���� ��    
UPDATE insa
    SET tel = '010-1234-1234'
    WHERE num=1001;
COMMIT;

SELECT * FROM insa
    WHERE num=1001;
--010-1234-1234

--�߸��� ���� ��    
UPDATE insa
    SET tel = '010-1234-1234';
--COMMIT;

SELECT * FROM insa;
-->��� ������ ��ȭ��ȣ�� ����� ���°� �ȴ�.
-->ROLLBACK;



------------------------------------------------------
--���������� UPDATE ������ �Ϻη� ��� ����

/*
UPDATE ���̺��
    SET �÷��� = (��������)
    WHERE (���������� �̿��� ���ǽ�);
    
    
���� ���,
UPDATE employees
	SET salary = salary*1.1
	WHERE department_id IN (SELECT department_id
				 FROM departments
				 WHERE department_name='IT');
                 
                 

UPDATE (��������-JOIN ������ �̿��� ���� ���̺�)
    SET �÷��� = ��
    WHERE ���ǽ�;
    -
���� ���,
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
  VALUES (3, 'choi', 2); --FK �ߺ� ���. O
COMMIT;


--���� �׸� �߰� + �⺻�� �߰�
ALTER TABLE employees
    ADD (extrapay NUMBER DEFAULT 100000);


--���� ���� Ȯ��
SELECT sid, name, e.extrapay , e.jikwi_id, jikwi_name
  FROM employees e, jobs j
  WHERE e.jikwi_id=j.jikwi_id;
/*  
1	hong	100000	1	CLERK
2	park	100000	2	MANAGER
3	choi	100000	2	MANAGER
*/


--jobs.jikwi_name �� 'CLERK'�� ������ ����(employees.extrapay) ����
UPDATE employees
    SET extrapay = 20000
    WHERE jikwi_name = 'CLERK'; --ORA-00904: "JIKWI_NAME": invalid identifier
    
--���1    
UPDATE employees
    SET extrapay = 20000
    WHERE jikwi_id = (SELECT jikwi_id FROM jobs WHERE jikwi_name = 'CLERK');    
    
--���2
UPDATE (SELECT extrapay, jikwi_name
            FROM employees emp, jobs j
            WHERE emp.jikwi_id = j.jikwi_id)
    SET extrapay = 20000
    WHERE jikwi_name = 'CLERK';
COMMIT;

--������ ���� Ȯ��
SELECT sid, name, e.extrapay , e.jikwi_id, jikwi_name
  FROM employees e, jobs j
  WHERE e.jikwi_id=j.jikwi_id;
/*  
1	hong	20000	1	CLERK
2	park	100000	2	MANAGER
3	choi	100000	2	MANAGER
*/  


--jobs.jikwi_name�� 'CLERK'�� ������ ����(employees.extrapay) 20% �λ�. jobs.jikwi_name�� 'MANAGER'�� ������ ����(employees.extrapay) 10% �λ�.
--> DECODE() �Լ� ���.
UPDATE (SELECT extrapay, jikwi_name
            FROM employees emp, jobs j
            WHERE emp.jikwi_id = j.jikwi_id)
    SET extrapay = DECODE(jikwi_name, 'CLERK', extrapay*1.2, 'MANAGER', extrapay*1.1, extrapay);
COMMIT;

--������ ���� Ȯ��
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
1. ���̺��� ������ ���� �����ϴµ� ����Ѵ�.

2. DELETE [FROM] ���̺�_�� [WHERE ����];
*/



--------------------------
--�� ���� row�� ���� ����
--���� ���� Ȯ��
SELECT * FROM members;

--�ڱ浿 �ڷ� ���� �õ�
--����) �˻� ���� ���� �߿�
DELETE FROM members
    WHERE mid=2;
COMMIT;

--������ ���� Ȯ��
SELECT * FROM members;




--------------------------
--���� ���� row�� ���� ����
--���� ���� Ȯ��
SELECT * FROM insa;

--'���ߺ�' ��ü �ڷ� ���� �õ�
--����) �˻� ���� ���� �߿�
DELETE FROM insa
    WHERE buseo='���ߺ�';
COMMIT;

--������ ���� Ȯ��
SELECT * FROM insa;



-------------------------------------------------
--����) WHERE �������� �������� �ʰų�, �߸��� ������ ��� ������ �ʴ� row���� ������ ������ ���Եȴ�.

DELETE FROM insa;
--COMMIT;

--������ ���� Ȯ��
SELECT * FROM insa;
--> ��� �ڷᰡ ������ �����̴�.
--> ROLLBACK;



--jobs.jikwi_name �� 'CLERK'�� ����(employees ���̺�)�� ���� �õ�
DELETE FROM (SELECT extrapay, jikwi_name
            FROM employees emp, jobs j
            WHERE emp.jikwi_id = j.jikwi_id)
    WHERE jikwi_name = 'CLERK';
COMMIT;

--������ ���� Ȯ��
SELECT *
        FROM employees emp, jobs j
        WHERE emp.jikwi_id = j.jikwi_id;
      
      
--����) jobs ���̺��� row�� �����ϴ� ���(���� ���ϴ� ��� ���� �Ұ�)        
SELECT * FROM jobs;

DELETE FROM jobs
    WHERE jikwi_id = 2; --ORA-02292: integrity constraint (MINJONG.EMPLOYEES_JIKWI_ID_FK) violated - child record found

--> FK ���� ������ ON DELETE CASCADE �ɼ� �����ϸ� ���� ����


---------------------------------------
