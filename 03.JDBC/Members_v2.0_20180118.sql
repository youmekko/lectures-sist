--ȸ������ v2.0�� ���� ���̺� ����

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



