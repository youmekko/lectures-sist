---------------------------------------------
--���Ἲ

/*
1. ���Ἲ���� ��ü ���Ἲ(Entity Integrity), ���� ���Ἲ(Relational Integrity), ������ ���Ἲ(Domain Integrity)�� �ִ�.

2. ��ü ���Ἲ
��ü ���Ἲ�� �����̼ǿ� ����Ǵ� Ʃ��(tuple)�� ���ϼ��� �����ϱ� ���� ���������̴�.

3.���� ���Ἲ
���� ���Ἲ�� �����̼� ���� �������� �ϰ����� �����ϱ� ���� ���������̴�.

4. ������ ���Ἲ
������ ���Ἲ�� �Ӽ����� ��� ������ ���� ������ �����ϱ� ���� ���������̴�.

���� ���, �л� ���� ����� ���̺��� ����ٸ�
--���̺� ����
CREATE TABLE member (     --���̺� �̸� member
	sid NUMBER        --������ȣ ����� �÷�
	,name VARCHAR2(10) --�̸�, 10���ڸ� ���
	,kor NUMBER(3)     --����, ���� 3�ڸ��� ���(0~999). 0~100 ����.
	,eng NUMBER(3)     --����, ���� 3�ڸ��� ���
	,mat NUMBER(3)     --����, ���� 3�ڸ��� ���
);

5. �������� ����
- PRIMARY KEY(PK) : �ش� �÷� ���� �ݵ�� �����ؾ� �ϸ�, �����ؾ� ��(NOT NULL�� UNIQUE ���������� ������ ����)
- FOREIGN KEY(FK) : �ش� �÷� ���� �����Ǵ� ���̺��� �÷� �� ���� �ϳ��� ��ġ�ϰų� NULL�� ����
- UNIQUE KEY(UK) : ���̺����� �ش� �÷� ���� �׻� �����ؾ� ��
- NOT NULL : �÷��� NULL ���� ������ �� ����.
- CHECK(CK) : �ش� �÷��� ���� ������ ������ ���� ������ ���� ����
*/



------------------------------------------------
--***PRIMARY KEY (PK)

/*
1. ���̺� ���� �⺻ Ű�� �����Ѵ�.

2. ���̺��� �� ���� �����ϰ� �ĺ��ϴ� �÷� �Ǵ� �÷��� �����̴�. �⺻ Ű�� ���̺� �� �ϳ��� �����Ѵ�. �׷���, �ݵ�� �ϳ��� �÷����� �� �����Ǵ� ���� �ƴϴ�. NULL ���� �Էµ� �� ����, �̹� ���̺� �����ϰ� �ִ� �����͸� �ٽ� �Է��� �� ����. UNIQUE INDEX�� �ڵ����� ����� ����.


3.
�÷� ������ ����
�÷��� ������Ÿ�� [CONSTRAINT constraint��] PRIMARY KEY

���̺� ������ ����
�÷��� ������Ÿ��,
�÷��� ������Ÿ��,
...
[CONSTRAINT constraint��] PRIMARY KEY(�÷�1��, �÷�2��,...)

4. constraint�� �߰� �ÿ� constraint ���� �����ϸ� ����Ŭ ������ �ڵ������� constraint ���� �ο��Ѵ�. �Ϲ������� constraint���� ���̺��_�÷���_constraint����'ó�� ����Ѵ�.
*/


--���� ���� ���
CREATE TABLE test0 (
	col1 NUMBER(3)
	,col2 VARCHAR2(10)
);

INSERT INTO test0 (col1, col2) 
	VALUES (NULL, NULL);
COMMIT;

SELECT col1, col2
  FROM test0;



-------------------------------------------
--PK ���� �׽�Ʈ - (���̺� ������ ���� �߰�) �÷� ������ ����
CREATE TABLE test1 (
	col1 NUMBER(3) PRIMARY KEY
	,col2 VARCHAR2(10)
);

INSERT INTO test1 (col1, col2) 
	VALUES (1, 'TEST');
INSERT INTO test1 (col1, col2) 
	VALUES (2, 'ABCD');
INSERT INTO test1 (col1, col2) 
	VALUES (3, NULL);
INSERT INTO test1 (col1, col2) 
	VALUES (2, 'ABCD');  --ORA-00001 (�ߺ��� ��ȣ �Է� �Ұ�)
INSERT INTO test1 (col1, col2) 
	VALUES (NULL, NULL); --ORA-01400 (NULL �Է� �Ұ�)
COMMIT;


DESC test1;
/*
�̸�   ��        ����           
---- -------- ------------ 
COL1 NOT NULL NUMBER(3)      -->PK ���� Ȯ�� �Ұ�
COL2          VARCHAR2(10) 
*/


--���� ���� Ȯ��
SELECT * FROM user_constraints;

SELECT * FROM user_constraints 
	WHERE table_name='TEST1'; --���̺� �̸� �빮��

--������ ������ �÷� Ȯ��
SELECT * FROM user_cons_columns
  WHERE table_name='TEST1'; --���̺� �̸� �빮��

--������ �ɸ� ������, �����, ���̺�, ��������, �÷� ���� Ȯ��
SELECT uc.owner, uc.constraint_name, uc.table_name, uc.constraint_type, ucc.column_name
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.constraint_name = ucc.constraint_name
    AND uc.table_name='TEST1';  --���̺� �̸� �빮��




-------------------------------
--PK ���� �׽�Ʈ -  (���̺� ������ ���� �߰�) ���̺� ������ ����
--> ������� ����ڰ� �����Ѵ�
--> ������� '���̺��_�÷���_PK' �������� �ۼ��Ѵ�.

CREATE TABLE test2 (
	col1 NUMBER(3)
	,col2 VARCHAR2(10)
	,CONSTRAINT TEST2_COL1_PK PRIMARY KEY(col1)
);

INSERT INTO test2 (col1, col2) 
	VALUES (1, 'TEST');
INSERT INTO test2 (col1, col2) 
	VALUES (2, 'ABCD');
INSERT INTO test2 (col1, col2) 
	VALUES (3, NULL);
INSERT INTO test2 (col1, col2) 
	VALUES (2, 'ABCD');  --ORA-00001
INSERT INTO test2 (col1, col2) 
	VALUES (NULL, NULL); --ORA-01400
COMMIT;

--������ �ɸ� ������, �����, ���̺�, ��������, �÷� ���� Ȯ��
SELECT uc.owner, uc.constraint_name, uc.table_name, uc.constraint_type, ucc.column_name
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.constraint_name = ucc.constraint_name
    AND uc.table_name='TEST2';  --���̺� �̸� �빮��


--------------------------------------
--PK ���� �׽�Ʈ - ���� �÷� PK ���� (����Ű)
CREATE TABLE test3 (
	col1 NUMBER(3)
	,col2 VARCHAR2(10)
	,CONSTRAINT TEST3_COL1_COL2_PK PRIMARY KEY(col1, col2)
);

INSERT INTO test3 (col1, col2) 
	VALUES (1, 'TEST');
INSERT INTO test3 (col1, col2) 
	VALUES (2, 'ABCD');
INSERT INTO test3 (col1, col2) 
	VALUES (3, NULL); --ORA-01400
INSERT INTO test3 (col1, col2) 
	VALUES (3, 'ABCD'); --col1�� �ٸ� ������, col2�� ���� ������
INSERT INTO test3 (col1, col2) 
	VALUES (2, 'KOREA'); --col1�� ���� ������, col2�� �ٸ� ������
INSERT INTO test3 (col1, col2) 
	VALUES (NULL, NULL); --ORA-01400
INSERT INTO test3 (col1, col2) 
	VALUES (2, 'ABCD'); --col1, col2 ��� ���� ������. ORA-00001

COMMIT;


----------------------------------
--***PK ���� �׽�Ʈ - ���̺� ���� �� ���� �߰�
CREATE TABLE test4 (
	col1 NUMBER(3)
	,col2 VARCHAR2(10) 
);

--ALTER TABLE ���̺��
--	ADD CONSTRAINT ����� PRIMARY KEY(�÷���);

ALTER TABLE test4
	ADD CONSTRAINT TEST4_COL1_PK PRIMARY KEY(col1);

INSERT INTO test4 (col1, col2) 
	VALUES (1, 'TEST');
INSERT INTO test4 (col1, col2) 
	VALUES (2, 'ABCD');
INSERT INTO test4 (col1, col2) 
	VALUES (3, NULL);
INSERT INTO test4 (col1, col2) 
	VALUES (2, 'ABCD');  --ORA-00001
INSERT INTO test4 (col1, col2) 
	VALUES (NULL, NULL); --ORA-01400
COMMIT;

DROP TABLE test4;


----------------------------------------------------
--***FOREIGN KEY (FK)

/*
1. ���� Ű �Ǵ� �ܷ� Ű(FK)�� �� ���̺��� ������ �� ������ �����ϰ� ���� �����ϴ� �� ���Ǵ� ����
��. �� ���̺��� �⺻ Ű ���� �ִ� ���� �ٸ� ���̺� �߰��ϸ� ���̺� �� ������ ������ �� �ִ�. �� 
�� �� ��° ���̺� �߰��Ǵ� ���� �ܷ� Ű�� �ȴ�.

�ܷ� Ű�� ����� �÷����� ������ �Է½� �⺻ Ű �� ���� �������� �Է� ����.


2. �θ� ���̺��� ���� ������ �� �ڽ� ���̺�(foreign key�� �����ϴ� ���̺�)�� �����Ǿ�� �Ѵ�.

3.

�÷� ������ ����
�÷��� ������Ÿ�� CONSTRAINT constraint��
	REFERENCES ����_���̺�� (����_�÷���)
	[ON DELETE CASCADE | ON DELETE SET NULL]


���̺����� ����
�÷��� ������Ÿ��,
�÷��� ������Ÿ��,
...
CONSTRAINT constraint�� FOREIGN KEY(�÷�)
	REFERENCES ����_���̺�� (����_�÷���)
	[ON DELETE CASCADE | ON DELETE SET NULL]
    
    
���̺� ������ ���� �߰�
ALTER TABLE ���̺��
	ADD CONSTRAINT ����� FOREIGN KEY(�÷���)
			REFERENCES ����_���̺�� (����_�÷���);


4. FOREIGN KEY ���� �� ���ǻ���
- �����ϰ��� �ϴ� �θ� ���̺��� ���� �����ؾ� �Ѵ�.
- �����ϰ��� �ϴ� �÷��� PRIMARY KEY �Ǵ� UNIQUE ���������� �־�� �Ѵ�.
- ���̺� ���̿� PRIMARY KEY�� FOREIGN KEY�� ���� �Ǿ� ������, primary key ���� �� foreign key �÷��� �� ���� �ԷµǾ� ������ ������ �� �ȴ�. (��, FK ���� �� ON DELETE CASCADE�� ON DELETE SET NULL�ɼ��� ����� ��쿡�� �����ȴ�.)
- �θ� ���̺��� �����ϱ� ���ؼ��� �ڽ� ���̺��� ���� �����ؾ� �Ѵ�.
- ���� ���࿡ ���� �����ϴ� ���� ���� �������� �ʴ´�. ���������� ���� �����ؾ� �Ѵ�.



5. ���� ����

ALTER TABLE ���̺��
	DROP CONSTRAINT (����)�����;

--> �߸� ������ ������ �����Ϸ��� ���� �� �߰��ؾ� �Ѵ�.

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
  VALUES (3, 'VICE PRES'); --X
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
INSERT INTO employees (sid, name, jikwi_id)
  VALUES (3, 'kim', 3); --PK �ߺ� X. X
INSERT INTO employees (sid, name, jikwi_id)
  VALUES (4, 'hwang', 5); --FK ��� ���� �ʰ�. X
COMMIT;

SELECT sid, name, e.jikwi_id, jikwi_name
  FROM employees e, jobs j
  WHERE e.jikwi_id=j.jikwi_id;
  
  
  
----------------------------------
--���� �м� ����

/*
1. SELECT *
  FROM user_constraints;
--CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION, R_CONSTRAINT_NAME


2.SELECT *
  FROM user_cons_columns;
--CONSTRAINT_NAME, TABLE_NAME, COLUMN_NAME  


3. SELECT *
  FROM user_constraints UC, user_cons_columns UCC
  WHERE UC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME;
--CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION, R_CONSTRAINT_NAME, COLUMN_NAME



4. 
SELECT uc.TABLE_NAME AS TABLE_NAME
	, COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
	, CONSTRAINT_TYPE
	, SEARCH_CONDITION
    , R_CONSTRAINT_NAME
    ,(SELECT R_TABLE_NAME
  FROM (SELECT uc.TABLE_NAME AS R_TABLE_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_TABLE_NAME
   ,(SELECT R_COLUMN_NAME
  FROM (SELECT COLUMN_NAME AS R_COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_COLUMN_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME
  AND uc.table_name='EMPLOYEES';
  

5. 
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
*/


SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION, R_CONSTRAINT_NAME
  FROM user_constraints
  WHERE table_name='JOBS';
  
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, SEARCH_CONDITION, R_CONSTRAINT_NAME
  FROM user_constraints
  WHERE table_name='EMPLOYEES';  
  
  
SELECT CONSTRAINT_NAME, TABLE_NAME, COLUMN_NAME  
  FROM user_cons_columns
  WHERE table_name='EMPLOYEES';  
  
  
SELECT uc1.CONSTRAINT_NAME AS CONSTRAINT_NAME
	, CONSTRAINT_TYPE
	, uc1.TABLE_NAME AS TABLE_NAME
    , SEARCH_CONDITION
    , R_CONSTRAINT_NAME
    , COLUMN_NAME
  FROM user_constraints uc1, user_cons_columns ucc
  WHERE uc1.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME
    AND uc1.table_name='EMPLOYEES';  
  
  
--Ư�� ���̺� �߰��� ������ ���� Ȯ���ϴ� ����  
SELECT uc.TABLE_NAME AS TABLE_NAME
	, COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
	, CONSTRAINT_TYPE
	, SEARCH_CONDITION
    , R_CONSTRAINT_NAME
    ,(SELECT R_TABLE_NAME
  FROM (SELECT uc.TABLE_NAME AS R_TABLE_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_TABLE_NAME
   ,(SELECT R_COLUMN_NAME
  FROM (SELECT COLUMN_NAME AS R_COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_COLUMN_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME
  AND uc.table_name='EMPLOYEES';
  
  

--Ư�� ���̺� �߰��� ������ ���� Ȯ���ϴ� ����  -> ��� ��� (�� ���� ���� �ʿ�)
CREATE OR REPLACE VIEW constraintsCheckView
AS
SELECT uc.TABLE_NAME AS TABLE_NAME
	, COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
	, CONSTRAINT_TYPE
	, SEARCH_CONDITION
    , R_CONSTRAINT_NAME
    ,(SELECT R_TABLE_NAME
  FROM (SELECT uc.TABLE_NAME AS R_TABLE_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_TABLE_NAME
   ,(SELECT R_COLUMN_NAME
  FROM (SELECT COLUMN_NAME AS R_COLUMN_NAME
	, uc.CONSTRAINT_NAME AS CONSTRAINT_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME)
    WHERE CONSTRAINT_NAME=uc.R_CONSTRAINT_NAME) AS R_COLUMN_NAME
  FROM user_constraints uc, user_cons_columns ucc
  WHERE uc.CONSTRAINT_NAME=ucc.CONSTRAINT_NAME;
  

--�� ����� ���� ���� Ȯ�� ���� ����
SELECT *  
    FROM constraintsCheckView
  WHERE table_name='EMPLOYEES';
  
  
  
  
  
-------------------------------------------------------
--ON DELETE CASCADE �ɼ�
-- FK ���� ������ �θ� ���̺��� row(PK)�� ������ �� �ڽ� ���̺��� row(FK)�� ���� ���� ����




---------------------------
--ON DELETE CASCADE �ɼ� ���� ��
CREATE TABLE jobs (
	jikwi_id NUMBER
	,jikwi_name VARCHAR2(10)
	,CONSTRAINT JOBS_JIKWI_ID_PK PRIMARY KEY(jikwi_id)
);

INSERT INTO jobs (jikwi_id, jikwi_name) VALUES (1, '����');
INSERT INTO jobs (jikwi_id, jikwi_name) VALUES (2, '�븮');
INSERT INTO jobs (jikwi_id, jikwi_name) VALUES (3, '���');
COMMIT;


--FK ���� ����
CREATE TABLE employees (
	sid NUMBER PRIMARY KEY
	,name VARCHAR2(10) 
	,jikwi_id NUMBER REFERENCES jobs(jikwi_id)
);

INSERT INTO employees (sid, name, jikwi_id)
	VALUES (1, 'ȫ�浿', 1);
INSERT INTO employees (sid, name, jikwi_id)
	VALUES (2, '��浿', 2);
COMMIT;

--employees ���̺� �ڷ� Ȯ��
SELECT * FROM employees;

--employees ���̺��� '��浿' �ڷ� ���� �õ�. --O
DELETE FROM employees WHERE sid=2;

--employees ���̺� �ڷ� Ȯ��
SELECT * FROM employees;

--jobs ���̺� �ڷ� Ȯ��
SELECT * FROM jobs;

--jobs ���̺��� '����' �ڷ� ���� �õ�. --X
DELETE FROM jobs WHERE jikwi_id=1;

--jobs ���̺��� '���' �ڷ� ���� �õ�. --O
DELETE FROM jobs WHERE jikwi_id=3;

--jobs ���̺� �ڷ� Ȯ��
SELECT * FROM jobs;

--> ON DELETE CASCADE �ɼ� ������ �ʿ��մϴ�.
--> employees ���̺��� FK ���� ���� �� �ٽ� FK ���� ����
SELECT * FROM user_constraints WHERE table_name='EMPLOYEES';
--> DELETE_RULE �÷��� �� Ȯ�� -> NO_ACTION -> ON DELETE CASCADE �ɼ� ���� X -> �θ� row ������, �ڽ� row�� ���� �������� �ʴ´�. �⺻��.


--���� FK ���� ����
ALTER TABLE employees
    DROP CONSTRAINT SYS_C007031;
    
----------------------------
--ON DELETE CASCADE �ɼ� ���� ��
ALTER TABLE employees
	ADD CONSTRAINT EMPLOYEES_JIKWI_ID_FK
		FOREIGN KEY (jikwi_id)
		REFERENCES jobs(jikwi_id)
		ON DELETE CASCADE;


SELECT * FROM user_constraints WHERE table_name='EMPLOYEES';
--> DELETE_RULE �÷��� �� Ȯ�� -> CASCADE -> ON DELETE CASCADE �ɼ� ���� O -> �θ� row ������, �ڽ� row�� ���� ������ �� �ִ�.

SELECT * FROM jobs;
SELECT * FROM employees;
        
--jobs ���̺��� '����' �ڷ� ���� �õ�. --O
DELETE FROM jobs WHERE jikwi_id=1;
--> employees ���̺��� �ڷᰡ ���� �����ȴ�.

SELECT * FROM jobs;
SELECT * FROM employees;



--DELETE_RULE Ȯ���� ���� ����� �� ����
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
  
-------------------------------------------------------



