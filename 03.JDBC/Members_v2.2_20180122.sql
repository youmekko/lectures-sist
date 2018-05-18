--ȸ������ v2.2�� ���� ���̺� ����

--ȸ�� ���� ���̺�(members) ����
-->ȸ����ȣ(PK), �̸�, ��ȭ��ȣ, �̸���, �����, �μ���ȣ(FK)
-->mid, name_, phone, email, regDate, deptId
CREATE TABLE members (
    mid VARCHAR2(3) --PK
    ,name_ NVARCHAR2(20) NOT NULL
    ,phone VARCHAR2(20) NOT NULL
    ,email VARCHAR2(50)
    ,regDate DATE
    ,deptId VARCHAR2(3) --FK
);

--�μ� ���� ���̺�(dept) ����
-->�μ���ȣ(PK), �μ���
-->deptId, deptName
-->�μ� ������ ���ߺ�(B01), �����ú�(B02), �ѹ���(B03)�� �����Ѵٰ� ����
CREATE TABLE dept (
    deptId VARCHAR2(3) --PK
    ,deptName NVARCHAR2(20) NOT NULL
);


--�������� �߰�
ALTER TABLE members
ADD CONSTRAINT members_mid_pk PRIMARY KEY(mid);
ALTER TABLE dept
ADD CONSTRAINT dept_deptId_pk PRIMARY KEY(deptId);
--����) members ���̺��� deptId �÷��� FK ���� ���� �߰�.
ALTER TABLE members
ADD CONSTRAINT members_deptId_fk FOREIGN KEY(deptId)
        REFERENCES dept(deptId);



--���� �ڷ� �Է�
INSERT INTO dept (deptId, deptName) VALUES ('B01', '���ߺ�');
INSERT INTO dept (deptId, deptName) VALUES ('B02', '�����ú�');
INSERT INTO dept (deptId, deptName) VALUES ('B03', '�ѹ���');

--COMMIT;
COMMIT;


----------------------------------------
--ȸ�� ���� �Է� ����
--1. ȸ�� ���� �Է�
--����) mid �÷��� ���� �ڵ� �����ǵ��� �������� ����.
/*
�Է� ��)
M01 hong 010-1234-1234 hong@naver.com 2017-04-28 B01
M02 choi 010-5678-1234 choi@naver.com 2017-05-01 B01
M03 park 010-4321-4321 park@naver.com 2017-05-10 B02
*/

INSERT INTO members (mid, name_, phone, email, regDate, deptId) 
VALUES ((SELECT CONCAT('M', LPAD(NVL(SUBSTR(MAX(mid), 2), 0) + 1, 2, 0)) AS newMid FROM members)
        , 'hong', '010-1234-1234', 'hong@naver.com', '2017-04-28', 'B01');
INSERT INTO members (mid, name_, phone, email, regDate, deptId) 
VALUES ((SELECT CONCAT('M', LPAD(NVL(SUBSTR(MAX(mid), 2), 0) + 1, 2, 0)) AS newMid FROM members)
        , 'choi', '010-5678-1234', 'choi@naver.com', '2017-05-01', 'B01');
INSERT INTO members (mid, name_, phone, email, regDate, deptId) 
VALUES ((SELECT CONCAT('M', LPAD(NVL(SUBSTR(MAX(mid), 2), 0) + 1, 2, 0)) AS newMid FROM members)
        , 'park', '010-4321-4321', 'park@naver.com', '2017-05-10', 'B02');
ROLLBACK;



---------------------------------------
--ȸ�� ���� ��� ����
--2. ȸ�� ���� ���
/*
��� ��)
M01 hong 010-1234-1234 hong@naver.com 2017-04-28 ���ߺ�
M02 choi 010-5678-1234 choi@naver.com 2017-05-01 ���ߺ�
M03 park 010-4321-4321 park@naver.com 2017-05-10 �����ú�
*/
SELECT mid, name_, phone, email, regDate, deptName
FROM members m, dept d
WHERE m.deptId = d.deptId;
-->�� ��� ����
CREATE OR REPLACE VIEW membersView
AS
SELECT mid, name_, phone, email, regDate, deptName
FROM members m, dept d
WHERE m.deptId = d.deptId;
--�並 �̿��ؼ� ���� ����
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView;



---------------------------------------
--�μ� ���� ��� ����
--1. ȸ�� ���� �Է�
SELECT deptId, deptName
FROM dept;


----------------------------------------
--ȸ�� ���� �˻� ����
--����) membersView ��ϵ� ���� Ȯ��
--ȸ�� ��ȣ(PK) ����
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE LOWER(mid) = LOWER('M01');

--�̸� ����(�κ� �˻�)
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE INSTR(LOWER(name_), LOWER('hong')) > 0;

--��ȭ��ȣ ����(�κ� �˻�)
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE INSTR(phone, '1234') > 0;

--�̸��� ����(�κ� �˻�)
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE INSTR(email, 'naver') > 0;

--����� ����(�κ� �˻�)
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE INSTR(TO_CHAR(regDate, 'YYYY-MM-DD'), '2017-05') > 0;

--�μ��� ����(�κ� �˻�)
SELECT mid, name_, phone, email, regDate, deptName
FROM membersView
WHERE INSTR(deptName, '���ߺ�') > 0;


-------------------------------------------
--ȸ�� ���� ���� ���̺� ����

CREATE TABLE membersFee (
    mid VARCHAR2(3) --PK, FK 
    ,feeDate DATE --PK
    ,fee NUMBER --CK
);

--�������� �߰� mid + feeDate => PK
ALTER TABLE membersFee
ADD CONSTRAINT membersFee_mid_feeDate_pk PRIMARY KEY(mid, feeDate);

--�������� �߰� mid -> FK
ALTER TABLE membersFee
ADD CONSTRAINT membersFee_mid_fk FOREIGN KEY (mid)
        REFERENCES members(mid);

--�������� �߰� fee -> CK -> 10000 �̻�
ALTER TABLE membersFee
ADD CONSTRAINT membersFee_fee_ck CHECK (fee >= 10000);

--�Է� ���� ����
INSERT INTO membersFee (mid, feeDate, fee)
    VALUES ('M01', '2017-12-01', 10000);
INSERT INTO membersFee (mid, feeDate, fee)
    VALUES ('M01', '2018-01-01', 10000);
COMMIT;    


--ȸ����� �� ȸ�񳳺��Ѿ� ��� ����
SELECT mid, name_, phone, email, regDate, deptName
    , (SELECT NVL(SUM(fee),0) FROM membersFee WHERE mid=m.mid) feeTotal
FROM membersView m;


--Ư�� ȸ���� ȸ�� ���� ���� ���
SELECT mid, feeDate, fee
FROM membersFee
WHERE mid='M01'
ORDER BY feeDate;

--Ư�� ȸ���� ȸ�� ���� �Ѿ� ���
SELECT NVL(SUM(fee),0) feeTotal
FROM membersFee
WHERE mid='M01';

ROLLBACK;


--------------------------------------
--ȸ�� �ߺ� �˻�
--�̸�, ��ȭ��ȣ�� �ߺ� ������� �ʵ��� ���� �߰�
--Unique ����
ALTER TABLE members
ADD CONSTRAINT members_name_phone_uk UNIQUE(name_, phone);


INSERT INTO members (mid, name_, phone, email, regDate, deptId) 
VALUES ((SELECT CONCAT('M', LPAD(NVL(SUBSTR(MAX(mid), 2), 0) + 1, 2, 0)) AS newMid FROM members)
        , 'hong', '010-1234-1234', 'hong@naver.com', '2017-04-28', 'B01');
-->���� ���� ���� �߻�

---------------------------------------
