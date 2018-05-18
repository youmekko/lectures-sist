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
    , emp_id, name_, phone
    FROM emp;

SELECT ROW_NUMBER() OVER(ORDER BY name_) AS num_
    , emp_id, name_, phone
    FROM emp
    WHERE num_ <= 5; --ORA-00904: "NUM_": invalid identifier

SELECT *
    FROM (SELECT ROW_NUMBER() OVER(ORDER BY name_) AS num_
        , emp_id, name_, phone
        FROM emp)
    WHERE num_ <= 5; --O



--'���' ������ �����鸸�� ������� (�⺻�� �������� ���Ľ�) Ư�� �������� ���
SELECT *
    FROM (SELECT ROW_NUMBER() OVER(ORDER BY basicpay DESC) AS num_
            , emp_id, name_, phone,  job_title, basicpay
     FROM (SELECT emp_id, name_, phone,  job_title, basicpay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_title = '���')
    WHERE num_ <= 5; --O
/*    
1	1005	�Ѽ���	018-5211-3542	���	1420000
2	1002	�̼���	010-4758-6532	���	1320000
3	1049	�̹̼�	010-6654-8854	���	1300000
4	1043	��̿�	016-8548-6547	���	1100000
5	1025	�����	010-4563-2587	���	1100000
*/
--> ������ ó�� �ȵ� ����


------------------------------------------
--Ư�� ���������� ��� (������ ó�� ����)
--RANK() OVER(����) �Լ�

SELECT *
    FROM (SELECT RANK() OVER(ORDER BY basicpay DESC) AS num_
            , emp_id, name_, phone,  job_title, basicpay
     FROM (SELECT emp_id, name_, phone,  job_title, basicpay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_title = '���')
    WHERE num_ <= 5; --O
/*    
1	1005	�Ѽ���	018-5211-3542	���	1420000
2	1002	�̼���	010-4758-6532	���	1320000
3	1049	�̹̼�	010-6654-8854	���	1300000
4	1043	��̿�	016-8548-6547	���	1100000
4	1014	Ȳ����	010-3214-5467	���	1100000
4	1025	�����	010-4563-2587	���	1100000
4	1034	������	011-3697-7412	���	1100000
*/
--> ������ ó���� ����



-----------------------------------------
--'���' ������ ���� ���� ���� ���
SELECT *
     FROM (SELECT emp_id, name_, phone,  job_title
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_title = '���';
     
--���� Ȯ��     
SELECT emp_id, name_, phone,  job_title
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id;     

--'���' ������ ���� ���� ���� ����
DELETE FROM (SELECT emp_id, name_, phone,  job_title
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_title = '���';

--���� Ȯ��
SELECT emp_id, name_, phone,  job_title
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id;     

--����
ROLLBACK;


---------------------------------
--���� Ȯ��     
SELECT emp_id, name_, phone,  job_title, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id;    
/*            
1054	����ȣ	016-1919-4242	���	114000
1055	���ѳ�	016-2424-4242	���	104000
1059	�Ӽ���	011-4151-4154	���	102000
*/

--'���' ����(jobs.job_title)�� ���� ������ ����(emp.extrapay)�� 10% �λ�.
UPDATE (SELECT emp_id, name_, phone,  job_title, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
	SET extrapay = (extrapay * 1.1)
	 WHERE job_title = '���';
    
--���� Ȯ��     
SELECT emp_id, name_, phone,  job_title, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id;    
/*            
1054	����ȣ	016-1919-4242	���	125400
1055	���ѳ�	016-2424-4242	���	114400
1059	�Ӽ���	011-4151-4154	���	112200
*/

--����
ROLLBACK;





--------------------------------
-- WITH CHECK OPTION ���� ��
/*
WITH CHECK OPTION ���� ����ϸ� �並 ���� ���� ���Ἲ(reference integrity)�� �˻��� �� �ְ� DB ���������� constraint ������ �����ϴ�.
*/


--------------------------------
--WITH CHECK OPTION ���� �� ���� �� �ڷ� �Է� �׽�Ʈ

--'���' ������ ���� ���� ���� ���
SELECT *
     FROM (SELECT emp_id, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='���');
     
     
--'���' ������ ���� ���� ������ �����ִ� �� ����
CREATE OR REPLACE VIEW emp_jobs_view
AS
SELECT *
     FROM (SELECT emp_id, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='���');
     
     
--�並 �̿��� �ڷ� �Է� (������ '���'�� �ƴ� ��� �غ�)
INSERT INTO emp_jobs_view (emp_id, name_ , ssn, hiredate, phone
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

SELECT * FROM emp;
--> ���� ���̺����� �˻� ����

ROLLBACK;
--> 1200, ȫ�浿 �ڷ� ���


-------------------------------------------
--WITH CHECK OPTION ���� �� ���� �� �ڷ� �Է� �׽�Ʈ
--'���' ������ ���� ���� ������ �����ִ� �� ����
CREATE OR REPLACE VIEW emp_jobs_view
AS
SELECT *
     FROM (SELECT emp_id, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='���')
WITH CHECK OPTION;

--�並 �̿��� �ڷ� �Է� (������ '���'�� �ƴ� ��� �غ�)
INSERT INTO emp_jobs_view (emp_id, name_ , ssn, hiredate, phone
                    , job_id, basicpay, extrapay)
            VALUES ('1200', 'ȫ�浿', '901212-1234567'
                    , '2010-10-05', '010-1212-3434'
                    , (SELECT job_id FROM jobs WHERE job_title='����')
                    , 2000000, 1000000);
--> ORA-01402: view WITH CHECK OPTION where-clause violation

--�並 �̿��� �ڷ� �Է� (������ '���'�� ��� �غ�)
INSERT INTO emp_jobs_view (emp_id, name_ , ssn, hiredate, phone
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
     FROM (SELECT emp_id, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='���')
WITH READ ONLY;


--�並 �̿��� �ڷ� �Է� (������ '���'�� ��� �غ�)
INSERT INTO emp_jobs_view (emp_id, name_ , ssn, hiredate, phone
                    , job_id, basicpay, extrapay)
            VALUES ('1200', 'ȫ�浿', '901212-1234567'
                    , '2010-10-05', '010-1212-3434'
                    , (SELECT job_id FROM jobs WHERE job_title='���')
                    , 2000000, 1000000);
-->ORA-42399: cannot perform a DML operation on a read-only view


SELECT * FROM emp_jobs_view;
--> �ڷ� �˻� ����


---------------------------------------------
