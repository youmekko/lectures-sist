-----------------------------------------------------------
--�����ͺ��̽� ��ü

/*
1. �����ͺ��̽��� ����Ǵ� �͵��� ���̺� �ܿ� ��Ÿ ���� ���� �͵��� ����Ǵµ� �̰��� �����ͺ��̽� ��ü(Database Objects)��� �θ���.

2. TABLE
�ϳ� �Ǵ� ���� �÷�(Column)���� �� �ϳ��� ���ڵ带 �̷��, �̷��� ���ڵ���� �� ���̺��̵ȴ�. ���� ��� "���" ���̺��� ���, �̸�, �μ� �� ���� �÷��� ���� �ǰ� �������ŭ�� ���ڵ带 ���� �ȴ�.

3.
CREATE ��
�����ͺ��̽� ���� ��� ��ü�� ������ �� ����ϴ� ����
ALTER ��
�̹� ������ ��ü�� ������ ����
DROP ��
������ ��ü�� ����

=>����) �����ڿ� ���� RESOURCE ������ �ο� ���� ����ڸ� �۾� ����

*/


----------------------------------------------
--���̺� �ۼ�

/*
1. ���̺��� ���� �����ͺ��̽��� ������ ������ ���� �̿�Ǵ� ��ü�̸�, ��� �� �� ���� spread sheet�� ����� ������� �����͸� ǥ���Ѵ�.

���� ���, ���� ���� ����� ���̺��� �ִٸ�
column  column  column column column
��ȣ(PK) �̸�     ����   ����   ����
1        ȫ�浿   100    100    100    -> row
2        �ڱ浿    90     80     90    -> row
3        �ֱ浿   100     70     80    -> row

2.
CREATE [GLOBAL TEMPORARY] TABLE [��Ű��.]���̺�_�̸� (
	��_�̸� ������Ÿ�� [DEFAULT ǥ����] [��������]
	[, ��_�̸� ������Ÿ�� [DEFAULT ǥ����] [��������] ]
	[ ,...]
);

���̺� ������ PK ������ ������ �� �ִ� �÷��� �ݵ�� �߰��� ��.

���� ���, ���� ���� ����� ���̺��� ����ٸ�
--���̺� ����
CREATE TABLE sungjuk (
  sid NUMBER --������ȣ ����� �÷�(PK). �ʼ� �׸�.
  ,name VARCHAR2(20) --�̸� ����� �÷�. ������ 20�� �̳�. �ѱ� ����� NVARCHAR2(20) �ѱ� 20�� �̳�.
  ,kor NUMBER(3) --���� ���� ����� �÷�. 0~100
  ,eng NUMBER(3) --���� ���� ����� �÷�. 0~100
  ,mat NUMBER(3) --���� ���� ����� �÷�. 0~100
);

--���̺� ���� Ȯ��
SELECT * FROM user_tables;

*/




-------------------------------------------
--������ Ÿ��(�ڷ���)

/*
1. ����Ŭ�� �����ϴ� ������ Ÿ���� ���� ���� �����ϴ� ��Į�� ������ Ÿ��, ���� ���� �����͸� ������ �� �ִ� �÷��� ������ Ÿ�� �׸���, �÷��� �ٸ� ���̺� ��ü�� �����ϴ� ���� ������ Ÿ�����ִ�.

2. VARCHAR2
���� : VARCHAR2(n)
���� ���� ���� �����͸� �����ϸ� �ִ� ���̴� 4000���̰�, �ݵ�� ���̸� ����ؾ� �Ѵ�.
NLS(������ ��� ����)�� �ѱ۰� ������ ����
VARCHAR �� �ִ� 2000�� ���ڸ� �����ϸ� VARCHAR2�ʹ� �ٸ��� VARCHAR(10)�� �����ϸ� null�� ä�� �����δ� 10���� ������ ����Ѵ�. ������ VARCHAR2(10)�� �ʿ��� ���ڱ����� �����ϴ� variable length�̸� �ִ� 4000�� ���ڱ��� ������ �� �ִ�.

�ѱ� ����� NVARCHAR2(n) �ڷ���


3. NUMBER
���� : NUMBER(P, S)
P(1~38)�� ���е��� ��ü �ڸ����� ��Ÿ���� �⺻ ���� 38�̰� S(-84~127)�� �Ҽ��� ������ �ڸ����̴�.
������ �Ǽ� �����ϱ� ���� ���������� ǥ�� ���� �����̴�.

4.DATE
����/��/�� ��:��:�ʡ����� �����ϸ�, �⺻������ ��/��/�� ������ ����Ѵ�.
*/



-------------------------------------------------
--INSERT

/*
1. INSERT ���� ���̺� �� ��(row)�� �߰��ϴµ� �̿��ϸ�, single table insert�̳� multi table insert�� ������ �� �ִ�.

Single table insert : ���� �ϳ��� ���̺��̳� �信 ���� �ϳ��� ��(row)�� ������ ������ �� �ִ�.

Multi table insert : �ϳ� �̻��� ���̺�κ��� ���� ������ ���� ���� ��(row)�� �����ϴ� ����̴�.

2.
INSERT INTO ���̺�_�� [(�÷�_��1, �÷�_��2, ...)] VALUES (��1, ��2, ...);

����) �÷���� ���� ���� ��ġ(����, ����, �ڷ���)�ؾ� �Ѵ�.
����) INSERT ��� ����� �޸𸮿����� �Էµ� �����̹Ƿ�, ������ ������ �ʿ��ϸ� COMMIT; ��� ���� �ʿ�.
*/


----------------------------------
--���� ����

/*
Primary key - ������ ���� �����ϴ� ����. �ߺ��� �ڷᰡ �Էµ��� �ʵ��� �����ϴ� ����.

���� �߰� ����� ���̺� ������, ���̺� ������ ���� �߰� ����.

ALTER TABLE ���̺��
    ADD [CONSTRAINT �����] PRIMARY KEY(�÷���);

������� ����ڰ� �ۼ��ϴ� ���� �����Ѵ�.

*/




--------------------------------------
--���� ���̺� ���� ����
--�̸�, ��ȭ��ȣ ����� ���̺� ����
--PK(������ ���� �����ϴ� ����) �÷� �߰� �ʿ�
/*
CREATE TABLE ���̺�� (
    �÷� �ڷ���
    , �÷� �ڷ���
    , ...
);
*/
CREATE TABLE members (
    mid NUMBER   --PK ����. ���� ����.
    , name_ NVARCHAR2(10)  --�ѱ�, ������ ����. 10�� �̳�.
    , phone VARCHAR2(10) --������ ����. 10�� �̳�.
);

--PK ���� �߰�
--����� �ۼ��� '���̺��_�÷���_��������' ǥ�� ����
ALTER TABLE members
    ADD CONSTRAINT members_mid_pk PRIMARY KEY(mid);
    

--������ ���̺� Ȯ��
SELECT * 
    FROM user_tables;
    
--������ ���̺� ����(�÷���, �ڷ���, null ����) Ȯ��
DESC members;

--������ ���̺� ���� ������ �Է�
INSERT INTO members (mid, name_, phone) VALUES (1, 'ȫ�浿', '1234');
INSERT INTO members (mid, name_, phone) VALUES (2, '�ڱ浿', '5678');
COMMIT;

--������ ���̺� �Էµ� �ڷ� Ȯ��
SELECT mid, name_, phone
    FROM members;






----------------------------------------
--NUMBER �ڷ��� �׽�Ʈ
CREATE TABLE test1 (
	col1 NUMBER       --38�ڸ�
	,col2 NUMBER(3)   --3�ڸ�
	,col3 NUMBER(5,2) --5�ڸ�, �Ҽ� ���� 2�ڸ�
);

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 123, 123);  --123, 123, 123
SELECT * FROM test1;

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 123.45, 123.45); --123, 123, 123.45
SELECT * FROM test1;

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 123.456, 123.456); --123, 123, 123.46
SELECT * FROM test1;

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 1234, 1234); --ORA-01438: value larger than specified precision allowed for this column
SELECT * FROM test1;

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 123, 123456); --ORA-01438: value larger than specified precision allowed for this column
SELECT * FROM test1;

INSERT INTO test1 (col1, col2, col3) 
	VALUES (123, 123, 123.456); --123, 123, 123.46
SELECT * FROM test1;

COMMIT;

DROP TABLE test1;





----------------------------------
--VARCHAR2 �ڷ��� �׽�Ʈ
CREATE TABLE test2 (
	col0 VARCHAR2     --ORA-00906: missing left parenthesis
);
--> ���̺� ���� ����

CREATE TABLE test2 (
	col0 VARCHAR2(5000)     --ORA-00910: specified length too long for its datatype
);
--> ���̺� ���� ����

CREATE TABLE test2 (
	col1 VARCHAR2(1)     --1����(����, ���� ����)
	,col2 VARCHAR2(10)   --10����(10byte)
	,col3 VARCHAR2(4000) --MAX
);
-->���̺� ���� ����


INSERT INTO test2 (col1, col2, col3)
	VALUES ('T', 'TEST', 'TEST');
SELECT * FROM test2;

INSERT INTO test2 (col1, col2, col3)
	VALUES ('TEST', 'TEST', 'TEST');  --ORA-12899: value too large for column "MINJONG"."TEST2"."COL1" (actual: 4, maximum: 1)
SELECT * FROM test2;

INSERT INTO test2 (col1, col2, col3)
	VALUES ('T', 'ȫ�浿', 'ȫ�浿');
SELECT * FROM test2;

INSERT INTO test2 (col1, col2, col3)
	VALUES ('T', '���ѹα�', '���ѹα�');  --ORA-12899: value too large for column "MINJONG"."TEST2"."COL2" (actual: 12, maximum: 10)
SELECT * FROM test2;

COMMIT;

DROP TABLE test2;





-----------------------------------
--NVARCHAR2 �ڷ��� �׽�Ʈ
CREATE TABLE test3 (
	col1 NVARCHAR2(1)     --1����(�ѱ�, ����, ���� ����)
	,col2 NVARCHAR2(10)   --10����
	,col3 NVARCHAR2(2000) --MAX
);
-->���̺� ���� ����

INSERT INTO test3 (col1, col2, col3)
	VALUES ('T', '���ѹα�', '���ѹα�');
SELECT * FROM test3;

COMMIT;

DROP TABLE test3;





---------------------------------------
--DATE �ڷ��� �׽�Ʈ
CREATE TABLE test4 (
	col1 DATE     --��/��/�� ��:��:�� ����
	,col2 DATE
);

--��¥�� �ð� ���� ��� ����ǹǷ� 
--SYSDATE�� ���� ���� �ð����� ����ȴ�.
INSERT INTO test4 (col1, col2) 
	VALUES (SYSDATE, TO_DATE('20120118')); --���ڸ� ��¥������ ��ȯ
INSERT INTO test4 (col1, col2) 
	VALUES (SYSDATE, '20120118'); --���ڸ� �ڵ� ����ȯ
INSERT INTO test4 (col1, col2) 
	VALUES (SYSDATE, SYSDATE);
COMMIT;

SELECT * FROM test4; --��/��/�ϸ� ��µ�.
SELECT TO_CHAR(col1, 'YYYY-MM-DD HH24:MI:SS') AS col1
	,TO_CHAR(col2, 'YYYY-MM-DD HH24:MI:SS') AS col2
	FROM test4; --��-��-�� ��:��:�ʷ� ��µ�

DROP TABLE test4;




-----------------------------------------------
--���̺� ����

/*
***1. �� ���̺� ����
CREATE TABLE ���̺��̸� (
	�÷� �ڷ��� [��Ÿ����]
	,...
);
*/


------------------------------------
/*
2. ���� ���̺� ����(�÷���, �ڷ���) Ȯ��
SELECT * 
  FROM user_tab_columns
  WHERE table_name='���̺��'; --���̺� �̸� �빮�ڷ� ǥ���� ��.

DESC ���̺��̸�;
*/
SELECT * 
  FROM user_tab_columns
  WHERE table_name='INSA';

SELECT * 
  FROM user_tab_columns
  WHERE table_name='MEMBERS';

DESC members;



------------------------------------
/*
3. ���� ���̺� ���� �����ؼ� �� ���̺� ���� (���������� ������� �ʴ´�)
CREATE TABLE �����̺��
AS
SELECT �÷�����Ʈ FROM �������̺�� WHERE 1=0;
*/

CREATE TABLE members2
AS
SELECT * FROM members WHERE 1=0;  --���� ����� ������ �������� ����

DESC members;  --������ ���� �ܿ� �������ǵ� �ִ�.
DESC members2; --�纻�� ������ ����Ǿ� �ִ�.

SELECT * FROM members2; -- 0 rows




------------------------------------
/*
**4. ���� ���̺� ���� �� ���� �ڷ� �����ؼ� �� ���̺� ���� �� �ڷ� �Է� (���������� ������� �ʴ´�)
CREATE TABLE �����̺��
AS
SELECT �÷�����Ʈ FROM �������̺�� [WHERE ���ǽ�];
*/

CREATE TABLE members3
AS
SELECT * FROM members;

SELECT * FROM members3; --2 rows


CREATE TABLE members4
AS
SELECT * FROM members WHERE mid = 1;

SELECT * FROM members4; --1 rows


CREATE TABLE members5
AS
SELECT mid, name_ FROM members WHERE mid = 1;

SELECT * FROM members5; --1 rows




------------------------------
/*
5. ���� ���̺� �� �� �߰�

ALTER TABLE �������̺��
	ADD (���̸� �ڷ���, ...);
--> ���� ���̺� �����Ͱ� �ִ� ���� ���� ������� �÷��� �����ʹ� NULL�� ä������.
--> NULL�� ä���� �÷��� �ڷḦ ä����� UPDATE ����� �̿��Ѵ�.
--> �÷� ������ �ڵ����� �⺻���� ä����� DEFAULT Ű���带 �̿��Ѵ�.
*/

DESC members;
/*
MID   NOT NULL NUMBER        
NAME_          NVARCHAR2(10) 
PHONE          VARCHAR2(10) 
*/
--> �����(regDate) �÷� �߰�

ALTER TABLE members
	ADD (regDate DATE);
--> �÷��� �߰������� �ڷ�� NULL�� ä������.

SELECT * FROM members;
--> regDate �÷��� NULL�� ä���� �����̴�.
--> �ڷḦ �Է��Ϸ��� UPDATE ���� ���




--------------------------
/*
6. ���� ���̺��� ���� �� �ڷ��� ����
ALTER TABLE �������̺��
	MODIFY (�������̸� ���ο��ڷ���);
--> ���� ���̺� �����Ͱ� �ִ� ���� ���ο� �ڷ����� ���� �ڷῡ �����ؾ� �Ѵ�.
*/

DESC members;
/*
MID     NOT NULL NUMBER        
NAME_            NVARCHAR2(10) 
PHONE            VARCHAR2(20)  
REGDATE          DATE 
*/
--> PHONE �÷��� ũ�� Ȯ��. 10->20

ALTER TABLE members
	MODIFY (phone VARCHAR2(20));
    
DESC members;
--> phone �÷��� ũ�� Ȯ��

SELECT * FROM members;
--> ���� �ڷ� �״�� ���� �ִ�.




---------------------------------------
/*
7. ���� ���̺��� ���� �� �̸� ����
ALTER TABLE �������̺��
	RENAME COLUMN �������̸� TO �����̸�;
--> ���� ���̺� �����Ͱ� �־ �����ϴ�.
*/

DESC members;
/*
MID     NOT NULL NUMBER        
NAME_            NVARCHAR2(10) 
PHONE            VARCHAR2(20)  
REGDATE          DATE   
*/
--> phone �÷����� tel �÷������� ����

ALTER TABLE members
	RENAME COLUMN phone TO tel;
    
DESC members;
--> �÷����� ����Ǿ� �ִ�.




----------------------------------
/*
8. ���� ���̺��� ���� �� ����
ALTER TABLE �������̺��
	DROP (���̸�, ...);
--> ���� ���̺� ���� �����Ͱ� ���� �����ȴ�. ���� �Ұ�.
*/

DESC members;
/*
MID     NOT NULL NUMBER        
NAME_            NVARCHAR2(10) 
PHONE            VARCHAR2(20)  
REGDATE          DATE   
*/
--> regDate �÷��� ����

ALTER TABLE members
	DROP (regDate);
    
DESC members;
--> �÷��� �����Ǿ� �ִ�.




----------------------------------
/*
9. ���� ���̺� �̸� ����
RENAME �������̺�� TO ���ο����̺��;
*/

SELECT * FROM user_tables;
--> INSA ���̺���� EMP ���̺������ ����

SELECT * FROM insa;

RENAME insa TO emp;

SELECT * FROM emp;




----------------------------
/*
10. ���� ���̺� ���� (������ ��� ����)
DROP TABLE ���̺��̸�;
--> ���̺� ������ ���� ��ü(��������, �ε���, Ʈ���� ��)���� ���� �����ȴ�.
--> ���� ���谡 �ִ� ���̺��� �������ǿ� ���� ���� �ȵǴ� ��찡 �ִ�.
--> �ܵ� ���̺��� �׻� ���� ����.
*/

CREATE TABLE test1 (
    col NUMBER
);

INSERT INTO test1 (col) VALUES (1);
COMMIT;

SELECT * FROM test1;

SELECT * FROM user_tables;
--> test1 ���̺� ���� Ȯ��

DROP TABLE test1;  --������ ���. ���� ����.

SELECT * FROM user_tables;
--> test1 ���̺� ���� Ȯ��



------------------------------------------------
/*
--�����뿡 �ִ� ��ü Ȯ��
SELECT *
	FROM recyclebin;

--�����뿡 �ִ� ��ü ���� (���̺���� ������ ������ �ο��� �ӽ� ��ü��)
FLASHBACK TABLE ���̺�� TO BEFORE DROP;

--������ ����
PURGE recyclebin;

DROP TABLE ���̺��̸� PURGE;
*/

SELECT *
	FROM recyclebin;
--> ������ ���̺� ��ü Ȯ�� ����

FLASHBACK TABLE "BIN$GN3ZdqRIRwa9C4GaGAWpYg==$0" TO BEFORE DROP;

SELECT * FROM user_tables;
--> test1 ���̺� ���� Ȯ��

SELECT * FROM test1;
--> ���� �ڷ� Ȯ��


--������ ����
PURGE recyclebin;
--> ���� �Ұ�

--������ ����� ��ġ�� �ʰ� ���� ����
DROP TABLE test1 PURGE;
--> ���� �Ұ�





-----------------------------------
/*
���� ���谡 �ִ� ���̺��� ������ �ȵǴ� ��찡 �ִ�.
���� �ϴ� �ʿ��� ���� ���� ROW�� �����ؾ� ���� ���ϴ� ���̺��� ������ �� �ִ�.
�Ǵ� CASCADE �ɼ��� �߰��ϸ� �ȴ�.
*/

CREATE TABLE test1 (
    col2 NUMBER --PK ����
);
--> ���� ���谡 ������ �Ŀ��� ���̺� ���� �Ұ�
--> FK ������ ������ �� ���̺� ���� �õ��ϸ� ���� ����
--> FK ������ �ִ� ���̺��� ���� �����ؾ� �ڱ� �ڽ� ���� ����
--> CASCADE �ɼ� ������ ���·� ���� �õ��ϸ� ���� ����


CREATE TABLE test2 (
    col2 NUMBER --FK ���� (���� ����)
);
--> ���� ���谡 ������ �Ŀ��� ���̺� ���� ����


--���� ���� ����
ALTER TABLE test1
    ADD CONSTRAINT test1_col2_pk PRIMARY KEY(col2);
ALTER TABLE test2
    ADD CONSTRAINT test2_col2_fk FOREIGN KEY(col2)
            REFERENCES test1(col2);

    
DROP TABLE test1;
--ORA-02449: unique/primary keys in table referenced by foreign keys
--> test1 ���̺��� ���� ���ϴ� �����̹Ƿ� ���� �Ұ�

DROP TABLE test1 CASCADE CONSTRAINTS;
--> test1 ���̺��� �����ȴ�. ���������� FK ������ ������ ��, ���̺� �����Ѵ�.

SELECT * FROM user_tables;
--> test2 ���̺��� �״�� ���� �ִ�. ��, FK ������ ������ �����̴�.


-----------------------------------------


