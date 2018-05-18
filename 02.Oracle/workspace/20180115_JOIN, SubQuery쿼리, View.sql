--------------------------------------------------
--employees, departments, jobs, regions ���̺� ���� ���� Ǯ��


--1. �̸�(name_), �ֹι�ȣ(ssn), �Ի���(hiredate), ��ȭ��ȣ(phone) ���
SELECT name_ AS �̸�
    , ssn AS �ֹι�ȣ
    , hiredate AS �Ի���
    , phone AS ��ȭ��ȣ
FROM employees;


--2. ������(reg_name)�� '����'�� ������ �̸�(name_), ������(reg_name), �μ���(dept_name), ������(job_title) ���. WHERE ���� �߰�.
SELECT eid, name_
    , reg_name
    , dept_name
    , job_title
FROM employees e, regions r, departments d, jobs j
WHERE e.job_id = j.job_id 
    AND e.dept_id = d.dept_id
    AND e.reg_id = r.reg_id
    AND r.reg_name = '����';
    

--3. �μ���(dept_name)�� '���ߺ�', '������'�� ����� ���. IN ������ ���.
SELECT eid, name_, dept_name
FROM employees e, departments d
WHERE e.dept_id = d.dept_id
    AND dept_name IN ('���ߺ�', '������');
    

--4. ������(reg_name) ������������ �����ϰ�, ������(reg_name)�� ������ �⺻��(basicpay) ��������
SELECT eid, name_
            , reg_name
            , basicpay
    FROM employees e, regions r
    WHERE e.reg_id = r.reg_id
    ORDER BY reg_name, basicpay DESC;



--5. �μ���(dept_name)�� '������'�̰�, ������ ���, ������ ��� �ο��� ���.  
/*
��� ��)
�������ο���   �����ο���   �����ο���
   XX	          XX	       XX
*/
SELECT COUNT(*) AS "�������ο���"
    , COUNT(DECODE(gender, 1, 1)) AS "�����ο���"
    , COUNT(DECODE(gender, 2, 2)) AS "�����ο���"    
FROM (SELECT SUBSTR(ssn, 8, 1) AS gender
    , dept_name
    FROM employees e, departments d
        WHERE e.dept_id = d.dept_id
        AND dept_name = '������');
    

--6. �μ���(dept_name)�� ���ڿ� ���� �ο��� ���ϱ�
/*
��¿�)
�ѹ���	7	4	3
���ߺ�	14	6	8
������	16	8	8
��ȹ��	7	4	3
�λ��	4	4	0
�����	6	2	4
ȫ����	6	3	3
*/
SELECT  dept_name
    COUNT(*) AS "�μ����ο���"
    , COUNT(DECODE(gender, 1, 1)) AS "�����ο���"
    , COUNT(DECODE(gender, 2, 2)) AS "�����ο���"    
FROM (SELECT SUBSTR(ssn, 8, 1) AS gender
    , dept_name
    FROM employees e, departments d
        WHERE e.dept_id = d.dept_id)
GROUP BY dept_name;
        


--7. ������(reg_name)�� ���ڿ� ���� �ο��� ���ϱ�
SELECT reg_name AS "������"
   , COUNT(DECODE(gender, 1, 1)) AS "�����ο���"
   , COUNT(DECODE(gender, 2, 2)) AS "�����ο���"
FROM (SELECT SUBSTR(ssn, 8, 1) AS gender
    , reg_name
FROM employees e, regions r
WHERE e.reg_id = r.reg_id)
GROUP BY reg_name
ORDER BY reg_name;



------------------------------------------------
--��(View)

/*
1. ��� �̹� Ư���� �����ͺ��̽� ���� �����ϴ� �ϳ� �̻��� ���̺��� ����ڰ� ��� ���ϴ� �����͵鸸�� ��Ȯ�ϰ� ���ϰ� �������� ���Ͽ� ������ ���ϴ� �÷��� ���� ��Ƽ� ����� ���� ������ ���̺�� ���� �� ���ȿ� ������ �ִ�. ������ ���̺��̶� �䰡 ������ �����ϴ� ���̺��� �ƴ϶� �ϳ� �̻��� ���̺��� �Ļ��� �� �ٸ� ������ �� �� �ִ� ��� �̸� �� �������� �����س��� SQL �����̶�� �� �� �ִ�.

2. CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW ���̸�
	[(alias[, alias]...]
	AS subquery
	[WITH CHECK OPTION]
	[WITH READ ONLY];
    
3. �� ���� ������ �ο� ���� ��츸 ���� ����    
*/

--�� ����
--DROP VIEW ���̸�;







--------------------------------------------
--�ζ��� ��
/*
1. �ζ��� ��� FROM ������ ���� ������ ����Ͽ� ������ �ӽ� ���̴�. �ζ��� ��� SQL ���� ����Ǵ� ���ȸ� �ӽ������� ���ǵȴ�. ��, ��ü�μ� ������� �ʴ´�.

2. �� ���� ���� ��� ���� ����.
*/

------------------------------------------
--Ư�� ���������� ���
--ROW_NUMBER() OVER(����) �Լ�
SELECT ROW_NUMBER() OVER(ORDER BY name_) AS num_
    , eid, name_, phone
    FROM employees;

SELECT ROW_NUMBER() OVER(ORDER BY name_) AS num_
    , eid, name_, phone
    FROM employees
    WHERE num_ <= 5; --ORA-00904: "NUM_": invalid identifier

SELECT *
    FROM (SELECT ROW_NUMBER() OVER(ORDER BY name_) AS num_
    , eid, name_, phone
    FROM employees)
    WHERE num_ <= 5; --O



--'���' ������ �����鸸�� ������� (�⺻�� �������� ���Ľ�) Ư�� �������� ���

SELECT num_
    , eid, name_, phone, job_title, basicpay
FROM (SELECT ROW_NUMBER() OVER(ORDER BY basicpay DESC) AS num_, eid, name_, phone,  job_title, basicpay
    FROM employees e, jobs j
    WHERE e.job_id = j.job_id
    AND job_title = '���')
WHERE num_ <= 5;
    
/*    
1	1005	�Ѽ���	018-5211-3542	���	1420000
2	1002	�̼���	010-4758-6532	���	1320000
3	1049	�̹̼�	010-6654-8854	���	1300000
4	1043	��̿�	016-8548-6547	���	1100000
5	1025	�����	010-4563-2587	���	1100000
*/
--> ������ ó�� �ȵ� ����





-----------------------------------------
--'���' ����(jobs.job_title)�� ���� ���� ����(employees.*) ���
SELECT eid, name_, job_title
    FROM employees e, jobs j
    WHERE e.job_id = j.job_id
    AND job_title = '���';

--'���' ����(jobs.job_title)�� ���� ������ �� ���
SELECT COUNT(*) AS "�����"
FROM (SELECT eid, name_, job_title
    FROM employees e, jobs j
    WHERE e.job_id = j.job_id
    AND job_title = '���');

--'���' ������ ���� ���� ���� ����
DELETE FROM (SELECT eid, name_, job_title
    FROM employees e, jobs j
    WHERE e.job_id = j.job_id)
     WHERE job_title = '���';

ROLLBACK;



--'���' ����(jobs.job_title)�� ���� ������ ����(emp.extrapay)�� 10% �λ�.
UPDATE (SELECT eid, name_, job_title
    FROM employees e, jobs j
    WHERE e.job_id = j.job_id)
	SET extrapay = (extrapay * 1.1)
	 WHERE job_title = '���';
    
ROLLBACK;



--���� ���� �߿��� �μ����� �ְ�޿� �޴� ���� ���� ���.
--��½� �μ��� ��� ����.

SELECT e.dept_id, dept_name, max_
FROM (SELECT dept_id, MAX(basicpay + extrapay) max_
    FROM employees
    GROUP BY dept_id) e, departments d
WHERE e.dept_id = d.dept_id;


SELECT dept_name, MAX(pay) max_
FROM (SELECT eid, name_, e.dept_id, dept_name, (basicpay+extrapay) pay
FROM employees e, departments d
WHERE e.dept_id = d.dept_id)
GROUP BY dept_name;



--����) ���� ���� �߿��� �μ����� �ְ�޿� �޴� ���� ���� ���.
--��½� �������̵�(eid), �����̸�(name_), ������ȭ��ȣ(phone)
--, �μ���(dept_name), �ְ�޿�(max_) ��� ����.

SELECT eid, name_, phone, max_, e1.dept_id, dept_name
FROM (SELECT dept_id, MAX(basicpay + extrapay) max_
    FROM employees
    GROUP BY dept_id) e1
    , (SELECT eid, name_, phone, dept_id, (basicpay+extrapay) pay FROM employees) e2
    , departments d
WHERE e1.dept_id = d.dept_id
AND e1.max_ = e2.pay;
    
/*
1001	ȫ�浿	011-2356-4528	2810000	dept002	��ȹ��
1003	�̼���	010-4231-1236	2710000	dept001	���ߺ�
1010	������	011-3214-5555	2670000	dept003	������
1019	�ڹ���	017-4747-4848	2465000	dept004	�λ��
1023	���μ�		            2670000	dept003	������
1037	�ּ���	011-7777-7777	2537000	dept007	ȫ����
1046	����	017-3333-3333	2800000	dept006	�ѹ���
1057	�̹̰�	016-6542-7546	2680000	dept005	�����
*/






---------------------------------
--CREATE VIEW ���̸�, DROP VIEW ���̸�
--�� ���� ������ �ִ� ����ڸ� ���� ����
--����) ���� ������ join, sub query�� ��� �� ��� ����
/*
CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW ���̸�
	[(alias[, alias]...]
	AS subquery
	[WITH CHECK OPTION]
	[WITH READ ONLY];
*/
--OR REPLACE �ɼ� �߰��� ���� �� ���� ����


--'���' ����(jobs.job_title)�� ���� ������ �� ���
SELECT COUNT(*) AS "�����"
FROM (SELECT eid, name_, job_title
    FROM employees e, jobs j
    WHERE e.job_id = j.job_id
    AND job_title = '���');
-->�� ��ü�� ���
CREATE OR REPLACE VIEW emp_job_view
AS
SELECT eid, name_, job_title
    FROM employees e, jobs j
    WHERE e.job_id = j.job_id;
-->�� ��ü�� �̿��� ���� ����
SELECT COUNT(*) AS "��� �ο���"
FROM emp_job_view
WHERE job_title = '���';

SELECT COUNT(*) AS "�븮 �ο���"
FROM emp_job_view
WHERE job_title = '�븮';


--DROP VIEW emp_job_view;


--------------------------------
-- WITH CHECK OPTION ���� ��
/*
WITH CHECK OPTION ���� ����ϸ� �並 ���� ���� ���Ἲ(reference integrity)�� �˻��� �� �ְ� DB ���������� constraint ������ �����ϴ�.
*/


--------------------------------
--WITH CHECK OPTION ���� �� ���� �� �ڷ� �Է� �׽�Ʈ

--'���' ������ ���� ���� ���� ���
SELECT *
     FROM (SELECT eid, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM employees e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='���');
     
     
--'���' ������ ���� ���� ������ �����ִ� �� ����
CREATE OR REPLACE VIEW emp_jobs_view
AS
SELECT *
     FROM (SELECT eid, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM employees e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='���');
     
     
--�並 �̿��� �ڷ� �Է� (������ '���'�� �ƴ� ��� �غ�)
INSERT INTO emp_jobs_view (eid, name_ , ssn, hiredate, phone
                    , job_id, basicpay, extrapay)
            VALUES ('1200', 'ȫ�浿', '901212-1234567'
                    , '2010-10-05', '010-1212-3434'
                    , (SELECT job_id FROM jobs WHERE job_title='����')
                    , 2000000, 1000000);
-->1 �� ��(��) ���ԵǾ����ϴ�.

SELECT * FROM emp_jobs_view;
--> �ű� �ڷ� �˻� �Ұ�
--> '���'�� �ƴ� �ڷ�� �˻����� �ʴ´�.
--> �並 �̿��� �Է½� �߸��� �ڷᰡ �ԷµǴ� ���� ���� �� ����.
--> WITH CHECK OPTION ���� �ʿ�

SELECT * FROM employees;
--> ���� ���̺����� �˻� ����

ROLLBACK;
--> 1200, ȫ�浿 �ڷ� ���


-------------------------------------------
--WITH CHECK OPTION ���� �� ���� �� �ڷ� �Է� �׽�Ʈ
--'���' ������ ���� ���� ������ �����ִ� �� ����
CREATE OR REPLACE VIEW emp_jobs_view
AS
SELECT *
     FROM (SELECT eid, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM employees e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='���')
WITH CHECK OPTION;

--�並 �̿��� �ڷ� �Է� (������ '���'�� �ƴ� ��� �غ�)
INSERT INTO emp_jobs_view (eid, name_ , ssn, hiredate, phone
                    , job_id, basicpay, extrapay)
            VALUES ('1200', 'ȫ�浿', '901212-1234567'
                    , '2010-10-05', '010-1212-3434'
                    , (SELECT job_id FROM jobs WHERE job_title='����')
                    , 2000000, 1000000);
--> ORA-01402: view WITH CHECK OPTION where-clause violation

--�並 �̿��� �ڷ� �Է� (������ '���'�� ��� �غ�)
INSERT INTO emp_jobs_view (eid, name_ , ssn, hiredate, phone
                    , job_id, basicpay, extrapay)
            VALUES ('1200', 'ȫ�浿', '901212-1234567'
                    , '2010-10-05', '010-1212-3434'
                    , (SELECT job_id FROM jobs WHERE job_title='���')
                    , 2000000, 1000000);
-->1 �� ��(��) ���ԵǾ����ϴ�.

SELECT * FROM emp_jobs_view;
--> �ű� �ڷ� �˻� ����
--> '���'�� �ڷḸ �˻��ȴ�.
--> �並 �̿��� �Է½� �߸��� �ڷᰡ �ԷµǴ� ���� ���� �� �ִ�.

ROLLBACK;
-->1200, ȫ�浿 �ڷ� ���



-------------------------------------------
--WITH READ ONLY ���� �� ���� �� �ڷ� �Է� �׽�Ʈ
--'���' ������ ���� ���� ������ �����ִ� �� ����
CREATE OR REPLACE VIEW emp_jobs_view
AS
SELECT *
     FROM (SELECT eid, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM employees e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='���')
WITH READ ONLY;


--�並 �̿��� �ڷ� �Է� (������ '���'�� ��� �غ�)
INSERT INTO emp_jobs_view (eid, name_ , ssn, hiredate, phone
                    , job_id, basicpay, extrapay)
            VALUES ('1200', 'ȫ�浿', '901212-1234567'
                    , '2010-10-05', '010-1212-3434'
                    , (SELECT job_id FROM jobs WHERE job_title='���')
                    , 2000000, 1000000);
-->ORA-42399: cannot perform a DML operation on a read-only view


SELECT * FROM emp_jobs_view;
--> �ڷ� �˻� ����


---------------------------------------------

