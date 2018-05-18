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

CREATE TABLE new_table (    
    no_ NUMBER(3)
    , name_ VARCHAR2(10)
    , birth DATE
);




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

DESC new_table;

--������ ���̺� ���� ������ �Է�
INSERT INTO members (mid, name_, phone) VALUES (1, 'ȫ�浿', '1234');
INSERT INTO members (mid, name_, phone) VALUES (2, '�ڱ浿', '5678');
INSERT INTO members (mid, name_, phone) VALUES (3, '�ֱ浿', '1111');
INSERT INTO members (mid, name_, phone) VALUES (4, '��浿', '2345');
INSERT INTO members (mid, name_, phone) VALUES (5, 'Ȳ�浿', '5432');

COMMIT;

--������ ���̺� �Էµ� �ڷ� Ȯ��
SELECT mid, name_, phone
    FROM members;

--Ư����(�̸��� 'ȫ�浿'�� ���)�� ���� ���

--Ư����(��ȣ�� 2�� ���)�� ���� ���

--��ȭ��ȣ�� '3'�� ���Ե� ��� ���


CREATE TABLE insa(
        num NUMBER(5) NOT NULL CONSTRAINT insa_pk PRIMARY KEY
       ,name NVARCHAR2(20) NOT NULL
       ,ssn  VARCHAR2(14) NOT NULL
       ,ibsaDate DATE     NOT NULL
       ,tel   VARCHAR2(15)
       ,city  NVARCHAR2(10)
       ,buseo NVARCHAR2(15) NOT NULL
       ,jikwi NVARCHAR2(15) NOT NULL
       ,basicPay NUMBER(10) NOT NULL
       ,sudang NUMBER(10) NOT NULL
);



INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1001, 'ȫ�浿', '771212-1022432', '1998-10-11', '����', '011-2356-4528', '��ȹ��', 
   '����', 2610000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1002, '�̼���', '801007-1544236', '2000-11-29', '���', '010-4758-6532', '�ѹ���', 
   '���', 1320000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1003, '�̼���', '770922-2312547', '1999-02-25', '��õ', '010-4231-1236', '���ߺ�', 
   '����', 2550000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1004, '������', '790304-1788896', '2000-10-01', '����', '019-5236-4221', '������', 
   '�븮', 1954200, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1005, '�Ѽ���', '811112-1566789', '2004-08-13', '����', '018-5211-3542', '�ѹ���', 
   '���', 1420000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1006, '�̱���', '780505-2978541', '2002-02-11', '��õ', '010-3214-5357', '���ߺ�', 
   '����', 2265000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1007, '����ö', '780506-1625148', '1998-03-16', '����', '011-2345-2525', '���ߺ�', 
   '�븮', 1250000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1008, '�迵��', '821011-2362514', '2002-04-30', '����', '016-2222-4444', 'ȫ����',    
'���', 950000 , 145000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1009, '������', '810810-1552147', '2003-10-10', '���', '019-1111-2222', '�λ��', 
   '���', 840000 , 220400);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1010, '������', '751010-1122233', '1997-08-08', '�λ�', '011-3214-5555', '������', 
   '����', 2540000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1011, '������', '801010-2987897', '2000-07-07', '����', '010-8888-4422', '������', 
   '���', 1020000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1012, '���ѱ�', '760909-1333333', '1999-10-16', '����', '018-2222-4242', 'ȫ����', 
   '���', 880000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1013, '���̼�', '790102-2777777', '1998-06-07', '���', '019-6666-4444', 'ȫ����', 
   '�븮', 1601000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1014, 'Ȳ����', '810707-2574812', '2002-02-15', '��õ', '010-3214-5467', '���ߺ�', 
   '���', 1100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1015, '������', '800606-2954687', '1999-07-26', '���', '016-2548-3365', '�ѹ���', 
   '���', 1050000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1016, '�̻���', '781010-1666678', '2001-11-29', '���', '010-4526-1234', '���ߺ�', 
   '����', 2350000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1017, '�����', '820507-1452365', '2000-08-28', '��õ', '010-3254-2542', '���ߺ�', 
   '���', 950000 , 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1018, '�̼���', '801028-1849534', '2004-08-08', '����', '018-1333-3333', '���ߺ�', 
   '���', 880000 , 123000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1019, '�ڹ���', '780710-1985632', '1999-12-10', '����', '017-4747-4848', '�λ��', 
   '����', 2300000, 165000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1020, '������', '800304-2741258', '2003-10-10', '����', '011-9595-8585', '�����', 
   '���', 880000 , 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1021, 'ȫ�泲', '801010-1111111', '2001-09-07', '���', '011-9999-7575', '���ߺ�', 
   '���', 875000 , 120000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1022, '�̿���', '800501-2312456', '2003-02-25', '����', '017-5214-5282', '��ȹ��', 
   '�븮', 1960000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1023, '���μ�', '731211-1214576', '1995-02-23', '����', NULL           , '������', 
   '����', 2500000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1024, '�踻��', '830225-2633334', '1999-08-28', '����', '011-5248-7789', '��ȹ��', 
   '�븮', 1900000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1025, '�����', '801103-1654442', '2000-10-01', '����', '010-4563-2587', '������', 
   '���', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1026, '�����', '810907-2015457', '2002-08-28', '���', '010-2112-5225', '������', 
   '���', 1050000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1027, '�迵��', '801216-1898752', '2000-10-18', '����', '019-8523-1478', '�ѹ���', 
   '����', 2340000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1028, '�̳���', '810101-1010101', '2001-09-07', '����', '016-1818-4848', '�λ��', 
   '���', 892000 , 110000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1029, '�踻��', '800301-2020202', '2000-09-08', '����', '016-3535-3636', '�ѹ���', 
   '���', 920000 , 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1030, '������', '790210-2101010', '1999-10-17', '�λ�', '019-6564-6752', '�ѹ���', 
   '����', 2304000, 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1031, '����ȯ', '771115-1687988', '2001-01-21', '����', '019-5552-7511', '��ȹ��', 
   '����', 2450000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1032, '�ɽ���', '810206-2222222', '2000-05-05', '����', '016-8888-7474', '�����', 
   '���', 880000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1033, '��̳�', '780505-2999999', '1998-06-07', '����', '011-2444-4444', '������', 
   '���', 1020000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1034, '������', '820505-1325468', '2005-09-26', '���', '011-3697-7412', '��ȹ��', 
   '���', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1035, '������', '831010-2153252', '2002-05-16', '��õ', NULL           , '���ߺ�', 
   '���', 1050000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1036, '���翵', '701126-2852147', '2003-08-10', '����', '011-9999-9999', '�����', 
   '���', 960400 , 190000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1037, '�ּ���', '770129-1456987', '1998-10-15', '��õ', '011-7777-7777', 'ȫ����', 
   '����', 2350000, 187000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1038, '���μ�', '791009-2321456', '1999-11-15', '�λ�', '010-6542-7412', '������', 
   '�븮', 2000000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1039, '�����', '800504-2000032', '2003-12-28', '���', '010-2587-7895', '������', 
   '�븮', 2010000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1040, '�ڼ���', '790509-1635214', '2000-09-10', '���', '016-4444-7777', '�λ��', 
   '�븮', 2100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1041, '�����', '721217-1951357', '2001-12-10', '�泲', '016-4444-5555', '�����', 
   '����', 2300000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1042, 'ä����', '810709-2000054', '2003-10-17', '���', '011-5125-5511', '���ߺ�', 
   '���', 1020000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1043, '��̿�', '830504-2471523', '2003-09-24', '����', '016-8548-6547', '������', 
   '���', 1100000, 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1044, '����ȯ', '820305-1475286', '2004-01-21', '����', '011-5555-7548', '������', 
   '���', 1060000, 220000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1045, 'ȫ����', '690906-1985214', '2003-03-16', '����', '011-7777-7777', '������', 
   '���', 960000 , 152000);			
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1046, '����', '760105-1458752', '1999-05-04', '�泲', '017-3333-3333', '�ѹ���', 
   '����', 2650000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1047, '�긶��', '780505-1234567', '2001-07-15', '����', '018-0505-0505', '������', 
   '�븮', 2100000, 112000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1048, '�̱��', '790604-1415141', '2001-06-07', '����', NULL           , '���ߺ�', 
   '�븮', 2050000, 106000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1049, '�̹̼�', '830908-2456548', '2000-04-07', '��õ', '010-6654-8854', '���ߺ�', 
   '���', 1300000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1050, '�̹���', '810403-2828287', '2003-06-07', '���', '011-8585-5252', 'ȫ����', 
   '�븮', 1950000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1051, '�ǿ���', '790303-2155554', '2000-06-04', '����', '011-5555-7548', '������', 
   '����', 2260000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1052, '�ǿ���', '820406-2000456', '2000-10-10', '���', '010-3644-5577', '��ȹ��', 
   '���', 1020000, 105000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1053, '��̽�', '800715-1313131', '1999-12-12', '����', '011-7585-7474', '�����', 
   '���', 960000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1054, '����ȣ', '810705-1212141', '1999-10-16', '����', '016-1919-4242', 'ȫ����', 
   '���', 980000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1055, '���ѳ�', '820506-2425153', '2004-06-07', '����', '016-2424-4242', '������', 
   '���', 1000000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1056, '������', '800605-1456987', '2004-08-13', '��õ', '010-7549-8654', '������', 
   '�븮', 1950000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1057, '�̹̰�', '780406-2003214', '1998-02-11', '���', '016-6542-7546', '�����', 
   '����', 2520000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1058, '�����', '800709-1321456', '2003-08-08', '��õ', '010-2415-5444', '��ȹ��', 
   '�븮', 1950000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1059, '�Ӽ���', '810809-2121244', '2001-10-10', '����', '011-4151-4154', '���ߺ�', 
   '���', 890000 , 102000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1060, '��ž�', '810809-2111111', '2001-10-10', '����', '011-4151-4444', '���ߺ�', 
   '���', 900000 , 102000);
COMMIT;   
   
SELECT * FROM insa;   



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

--ROLLBACK;
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



--����) ȸ�� ����(ȸ����ȣ, �̸�, ��ȭ��ȣ, �̸���, �����, �μ���ȣ)�� �μ� ����(�μ���ȣ, �μ���)�� �����ϴ� ���̺� ����.
--ȸ����ȣ(PK)�� 'M001', 'M002' ���·� ����
--�μ���ȣ(PK)�� 'B01', 'B02', ���·� ����


--�μ����� ���̺� ����

--ȸ������ ���̺� ����


--�μ� ���̺� ���� �ڷ� �Է�

--COMMIT;

--ȸ�� ���̺� ���� �ڷ� �Է�

--COMMIT;

--SELECT ����







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

SELECT * FROM members;

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

SELECT * FROM members;



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
	col1 NUMBER(3)     PRIMARY KEY
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

SELECT * FROM test1;


DESC test1;
/*
�̸�   ��        ����           
---- -------- ------------ 
COL1 NOT NULL NUMBER(3)      -->PK ���� Ȯ�� �Ұ�
COL2          VARCHAR2(10) 
*/


SELECT * FROM all_users;


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

SELECT * FROM test2;

--������ �ɸ� ������, �����, ���̺�, ��������, �÷� ���� Ȯ��

SELECT *
FROM user_constraints
WHERE table_name='TEST2';

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

SELECT * FROM test3;

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

SELECT * FROM test4;


DROP TABLE test4;



--����) ȸ�� ����(ȸ����ȣ, �̸�, ��ȭ��ȣ, �̸���, �����, �μ���ȣ)�� �μ� ����(�μ���ȣ, �μ���)�� �����ϴ� ���̺� ����.
--ȸ����ȣ(PK)�� 'M001', 'M002' ���·� ����
--�μ���ȣ(PK)�� 'B01', 'B02', ���·� ����


--�μ����� ���̺� ����

--ȸ������ ���̺� ����

--�μ�����,ȸ������ ���̺� Primary Key ���� ���� �߰�

--�μ� ���̺� ���� �ڷ� �Է�

--COMMIT;

--ȸ�� ���̺� ���� �ڷ� �Է�

--COMMIT;

--SELECT ����




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

SELECT * FROM jobs;


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
  
  
  
  
--����) hr ��Ű���� �м� �ϰ�, �� ����� ������ �ۼ�.

--���̺� ���� ����
--CREATE TABLE
--7��



--���� ���� ����
--PRIMARY KEY, FOREIGN KEY ���� �м� �� ���� �ۼ�.
--���̺� ���� �� ���� �߰�


  
  
  
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




