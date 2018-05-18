/*

SELECT ����

- �⺻ ����
SELECT select_list FROM source_list;
- SELECT ������ Ư�� ���̺� ����� �ڷḦ ��ȸ�ϴ� ����.
- SELECT ������ ��� ����� �����ϴ� �κ�. ���� ���, �÷��� ����. �̸�, ��ȭ��ȣ ��.
- FROM ������ �ڷᰡ ����Ǿ� �ִ� Ư�� ���̺��� �����Ѵ�. ���� ���, hr.employees
- SELECT ~ FROM ~ Ű����� ���� �Ұ�.

*/

SELECT first_name, last_name 
FROM hr.employees;

SELECT 'Hello, Oracle World!'
FROM dual;


--��� �÷� ��ȸ�ϱ�
--Ư�� ���̺��� ��� �׸�(�÷�) ��ȸ�Ϸ��� �÷����� ��� �����ϰų�, *(���ϵ�ī��) ��ȣ�� ����Ѵ�.
--SELECT * FROM source_list;

SELECT * FROM hr.employees;
SELECT employee_id, first_name, last_name, email, phone_number   
        , hire_date, job_id, salary, commission_pct, manager_id, department_id
FROM hr.employees;


--���ϴ� �÷��� ��ȸ�ϱ�
--Ư�� ���̺��� Ư�� �׸�(�÷�) ��ȸ�Ϸ��� �÷����� �����Ѵ�.
--SELECT column1, column2,...  FROM source_list;

SELECT employee_id, first_name, last_name, email, phone_number   
FROM hr.employees;

SELECT department_id, department_name
FROM hr.departments;

SELECT job_id, job_title
FROM hr.jobs;

--ǥ������ ����ؼ� ����ϱ�
--�ڷ� ��½� Ư�� ���ڿ��� �����ؼ� ����Ϸ��� ǥ����(��������ǥ�� ���� ���ڿ�) ���.
--SELECT column1,  'ǥ����'  FROM source_list;

SELECT first_name, '[', last_name, ']'
FROM hr.employees;

SELECT 'Hello, World!'
FROM hr.employees;

SELECT 'Hello, World!'
FROM dual;

--�÷� ��Ī(Alias) ����Ͽ� ����ϱ�
--Ư�� ���̺��� Ư�� �÷� ��½� �÷��� ��� ��Ī ���� ����.
--��Ī���� �ĺ��� ��Ģ�� �����ϴ� �ƹ� �̸��̳� ��� ����. �� ������ ���Ե� ��� "(ū ����ǥ)�� ��� ǥ��. ����Ŭ���� ����ϴ� Ű����� ��� �Ұ�.
--����) ��´���� ǥ����(�Ǵ� ����)�� ��� ��Ī ��� ����.
--SELECT column1  ��Ī1, column2  ��Ī2, ...  FROM source_list;
--SELECT column1  "��Ī1", column2  "��Ī2", ...  FROM source_list;
--SELECT column1 AS  ��Ī1, column2 AS ��Ī2, ...  FROM source_list;

SELECT employee_id empId
        , first_name fname
        , last_name lname
        , email 
        , phone_number phone
FROM hr.employees;

SELECT first_name || ' ' || last_name full_name
FROM hr.employees;

