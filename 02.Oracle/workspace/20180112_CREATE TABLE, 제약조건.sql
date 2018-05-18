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
- UNIQUE (UK) : ���̺����� �ش� �÷� ���� �׻� �����ؾ� ��
- NOT NULL : �÷��� NULL ���� ������ �� ����.
- CHECK (CK) : �ش� �÷��� ���� ������ ������ ���� ������ ���� ����
*/




------------------------------------
--UNIQUE
--PK�� �����ϰ� ���ϼ��� �����ϴ� ����
--NULL ���, �ϳ��� ���̺� ������ ���� ����.
--���� ����
/*
ALTER TABLE ���̺��
	ADD CONSTRAINT ���̺��_�÷���_UK UNIQUE(�÷���);
*/


CREATE TABLE test4 (
	col1 NUMBER(3)  --PK
	,col2 VARCHAR2(10)  --UK
);

ALTER TABLE test4
    ADD CONSTRAINT test4_col1_pk PRIMARY KEY(col1);
ALTER TABLE test4
    ADD CONSTRAINT test4_col2_uk UNIQUE(col2);

INSERT INTO test4 (col1, col2) 
	VALUES (1, 'TEST');
INSERT INTO test4 (col1, col2) 
	VALUES (2, 'ABCD');
INSERT INTO test4 (col1, col2) 
	VALUES (3, NULL);
INSERT INTO test4 (col1, col2) 
	VALUES (2, 'ABCD'); --ORA-00001
INSERT INTO test4 (col1, col2) 
	VALUES (NULL, NULL); --ORA-01400
INSERT INTO test4 (col1, col2) 
	VALUES (4, 'ABCD'); --ORA-00001
INSERT INTO test4 (col1, col2) 
	VALUES (4, NULL);
COMMIT;

SELECT * FROM test4;

DROP TABLE test4;


------------------------------------
--CHECK
--Ư�� ������ �����ϴ� ��츸 �Է� ����ϴ� ����. ���� ���, ���� �Է½� ����� �Է� ����.
--�ϳ��� ���̺� ������ ���� ����.
--���� ����
/*
ALTER TABLE ���̺��
	ADD CONSTRAINT ���̺��_�÷���_CK CHECK(���ǽ�);
*/

CREATE TABLE test5 (
	col1 NUMBER(3)  --PK
	,col2 NUMBER(3)  --CHECK (����� �Է� ����)
);

ALTER TABLE test5
    ADD CONSTRAINT test5_col1_pk PRIMARY KEY(col1);
ALTER TABLE test5
    ADD CONSTRAINT test5_col2_ck CHECK(col2 > 0);
  
INSERT INTO test5 (col1, col2)
    VALUES (1, 10);
INSERT INTO test5 (col1, col2)
    VALUES (2, 20);
INSERT INTO test5 (col1, col2)
    VALUES (3, -30); --ORA-02290
COMMIT;    
