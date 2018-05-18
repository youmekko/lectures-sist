------------------------
--JOIN
/*

1. ������ ����ϸ� ���̺� ���� ���� ���踦 �������� �� �̻��� ���̺��� �����͸� �˻��� �� �ִ�.

INNER JOIN - ���� ���� ������ ������ �����ϴ� ROW�� ���
OUTER JOIN - ���� ���� ������ ������ �����ϴ� ��� �ܿ��� ���

EQUI JOIN - =(equal) �����ڸ� �̿��� ������ ����� JOIN
NON-EQUI JOIN - =(equal) ������ ���� �����ڸ� �̿��� ������ ����� JOIN

SELF JOIN - �ڱ� �ڽ��� �� ���� ���� ���̺�� ���� JOIN�ϴ� ���. ��Ī ���.

ANSI JOIN - JOIN ������ ����Ŭ ����� �ƴ϶� ǥ������ ������� �ۼ��� ��.



2. employees, departments, job_history, jobs, locations, countries, regions ���̺��� ���� �м�

*/


-------------------------------
--3.EQUI JOIN

/*
�� �� �̻��� ���̺� ����Ǵ� �÷����� ������ ��ġ�ϴ� ��쿡 ����ϴ� ���� �Ϲ����� join ���·� WHERE ���� '='(��ȣ)�� ����Ѵ�. ���� PRIMARY KEY, FOREIGN KEY ���踦 �̿��ϸ� ����Ŭ������ NATURAL JOIN�� EQUI JOIN�� �����ϴ�. �Ǵ� USING ���� ����Ͽ� EQUI JOIN�� ������ ����� ��� �Ѵ�.
PRIMARY KEY, FOREIGN KEY ������ �ɷ��ִ� �÷��� ������ ��ġ�ϵ��� �Ǿ� �ִ�.


����-1
SELECT *
	FROM ���̺�_��1, ���̺�_��2
	WHERE ���̺�_��1.�÷�_��1=���̺�_��2.�÷�_��1;

SELECT ���̺�_��1.�÷�_��, ���̺�_��2.�÷�_�� 
	FROM ���̺�_��1, ���̺�_��2
	WHERE ���̺�_��1.�÷�_��1=���̺�_��2.�÷�_��1;

SELECT ��Ī1.�÷�_��, ��Ī2.�÷�_�� 
	FROM ���̺�_��1 ��Ī1, ���̺�_��2 ��Ī2
	WHERE ��Ī1.�÷�_��1=��Ī2.�÷�_��1
    AND ���ǽ�
    GROUP BY �÷�, ...
    ...;

����-ANSI SQL
SELECT ���̺�_��1.�÷�_��, ���̺�_��2.�÷�_�� 
	FROM ���̺�_��1 JOIN ���̺�_��2 
	ON ���̺�_��1.�÷�_��1=���̺�_��2.�÷�_��1
    WHERE ���ǽ�
    GROUP BY �÷�, ...
    ...;
*/



--PK, FK ������ �ִ� ���̺� �� �÷��� Ȯ���ϸ� JOIN ������ ���� �̷������.
--�������, hr.employees, hr.departments ���̺��̴�. ���� �÷��� department_id
--JOIN�� �̷������ hr.employees, hr.departments ���̺��� �� ���� ���� ���̺��� �ȴ�.
--��, ���� ���̺� ��� �����ϴ� �÷��� ��� ���̺�� ǥ�� �ʼ�.
/*
SELECT *
	FROM ���̺�_��1, ���̺�_��2
	WHERE ���̺�_��1.�÷�_��1=���̺�_��2.�÷�_��1;
*/

SELECT *
FROM hr.departments;
--27

SELECT *
FROM hr.employees;
--107

SELECT *
FROM hr.employees, hr.departments
WHERE hr.employees.department_id = hr.departments.department_id;
--106


SELECT employee_id, first_name, last_name
    , department_name
    , hr.employees.department_id
FROM hr.employees, hr.departments
WHERE hr.employees.department_id = hr.departments.department_id;
--106


--Oracle JOIN
SELECT employee_id, first_name, last_name
    , department_name
    , e.department_id
FROM hr.employees e, hr.departments d
WHERE e.department_id = d.department_id;
--106


--ANSI JOIN
SELECT employee_id, first_name, last_name
    , department_name
    , e.department_id
FROM hr.employees e INNER JOIN hr.departments d
ON e.department_id = d.department_id;
--106



-------------------------------------
--JOIN(���� ����) + �Ϲ� ����


SELECT employee_id, first_name, last_name
    , department_id
FROM hr.employees
WHERE department_id = 100;


--Oracle JOIN
SELECT employee_id, first_name, last_name
    , e.department_id
    , department_name
FROM hr.employees e, hr.departments d
WHERE e.department_id = d.department_id  
AND e.department_id = 100;


--ANSI JOIN
SELECT employee_id, first_name, last_name
    , e.department_id
    , department_name
FROM hr.employees e INNER JOIN hr.departments d
ON e.department_id = d.department_id  
WHERE e.department_id = 100;





--����) hr.employees, hr.jobs ���̺��� ���� �����ϰ�
--, ���� ���̺� �÷� ������ ��� ���.

--Oracle JOIN

--ANSI JOIN




--����) hr.employees, hr.jobs ���̺��� ���� �����ϰ�
--job_title�� 'Stock Manager'�� ���� ���� ���.

--Oracle JOIN

--ANSI JOIN



------------------------------------

--job_title�� 'Stock Manager', 'Stock Clerk'�� ���� ���� ���
SELECT *
FROM hr.employees e, hr.jobs j
WHERE e.job_id = j.job_id
AND j.job_title = 'Stock Manager' OR j.job_title = 'Stock Clerk';

--job_title�� 'Stock Manager', 'Stock Clerk'�� ���� ���� ���
SELECT employee_id, first_name, last_name
    , job_title
FROM hr.employees e, hr.jobs j
WHERE e.job_id = j.job_id 
AND job_title IN ('Stock Manager', 'Stock Clerk');




--------------------------------------------
--4. Non-Equi Join
/*
- Join ���ǿ��� = ������ �ƴ� ��� ��츦 ���Ѵ�.
- �� ����� �÷� ���� �������� ��� �����ϴ�.

SELECT �÷�����Ʈ(��Ī ��� �ʿ�)
	FROM ���̺�1 ��Ī1, ���̺�2 ��Ī2
	WHERE ��Ī1.�÷� <= ��Ī2.�÷�;

SELECT �÷�����Ʈ(��Ī ��� �ʿ�)
	FROM ���̺�1 ��Ī1, ���̺�2 ��Ī2
	WHERE ��Ī1.�÷� >= ��Ī2.�÷�;
*/






-------------------------------------------------------
--5. Outer Join

/*
- ���� ���̺� ������ ���� �����ϴ� ��츸 ��µǴ� ���� Equi Join(Inner Join)�̰�,
������ ���� ��� �� �� ���̺��� �ڷ�� ��� ��µǴ� ���� Outer Join�Դϴ�.

--LEFT OUTER JOIN(���̺�2�� NULL�� ��µǴ� ����)
--���̺�1�� ��ü ���, ���̺�2�� �κ� ���(Equi Join ���� �����ϴ� ��츸 ���)
--¦�� ���� ��� NULL�� ��µȴ�.
--(+)�� NULL ��� ����ʿ� ���δ�.
SELECT �÷�����Ʈ
	FROM ���̺�1 ��Ī1, ���̺�2 ��Ī2
	WHERE ��Ī1.�÷� = ��Ī2.�÷�(+);

--RIGHT OUTER JOIN(���̺�1�� NULL�� ��µǴ� ����)
SELECT �÷�����Ʈ
	FROM ���̺�1 ��Ī1, ���̺�2 ��Ī2
	WHERE ��Ī1.�÷�(+) = ��Ī2.�÷�;

--ANSI LEFT OUTER JOIN(���̺�1�� �ڷ�� ��� ���)
SELECT �÷�����Ʈ
	FROM ���̺�1 ��Ī1 LEFT OUTER JOIN ���̺�2 ��Ī2
	ON ��Ī1.�÷� = ��Ī2.�÷�;
*/


--Oracle JOIN
SELECT employee_id, first_name, last_name
    , department_name
    , e.department_id
FROM hr.employees e, hr.departments d
WHERE e.department_id = d.department_id(+);
--107


--ANSI JOIN
SELECT employee_id, first_name, last_name
    , department_name
    , e.department_id
FROM hr.employees e LEFT OUTER JOIN hr.departments d
ON e.department_id = d.department_id;
--107


--Oracle JOIN
SELECT d.department_id, d.department_name
    , e.employee_id, e.first_name, e.last_name
FROM hr.departments d, hr.employees e
WHERE d.department_id = e.department_id(+);
--122


--ANSI JOIN
SELECT d.department_id, d.department_name
    , e.employee_id, e.first_name, e.last_name
FROM hr.departments d LEFT OUTER JOIN hr.employees e
ON d.department_id = e.department_id;
--122



--------------------------
--����) OUTER JOIN�� ����� �÷��� �Ϲ� ���ǽĿ����� (+)�� ��� �ٿ��� �Ѵ�.
--Oracle JOIN
SELECT employee_id, first_name, last_name
    , department_name
    , e.department_id
FROM hr.employees e, hr.departments d
WHERE e.department_id = d.department_id(+)
AND d.department_id(+) = 50;
--107



--����) hr.employees, hr.jobs(job_title) ���̺��� (LEFT) OUTER JOIN ��� ���.

--hr.employees ��ü ��� ����. Oracle JOIN.
--107


--hr.jobs ��ü ��� ����. Oracle JOIN.



--hr.departments ���̺��� ������ ���� �μ� ���� ���.
SELECT d.department_id, d.department_name
    , e.employee_id
FROM hr.departments d, hr.employees e
WHERE d.department_id = e.department_id(+)
AND employee_id IS NULL;
--16


--����) hr.employees ���̺��� ���� ����(���� ������ ���� ����) ���� ���.
--�ڱ� �ڽ��� employee_id�� �ٸ� ������ manager_id�� ���� ����.
--���� ���, employee_id�� 150, 200�� ������ ���� �����̴�.
--SELF JOIN + OUTER JOIN ���





-------------------------------
--6. Self Join

/*
- �Ϲ����� Join�� �� ���� ���� �ٸ� ���̺��� ������� Join�� ������,
Self Join�� �ڱ� �ڽ��� ������ ���̺�(���̺�1, ���̺�2�� ��� �ڱ� �ڽ��� ����)�� �����ϰ� Join�� �����ϴ� ��.
- ��Ī ��� �ʼ�

SELECT �÷�����Ʈ
	FROM ���̺� ��Ī1, ���̺� ��Ī2
	WHERE ��Ī1.�÷� = ��Ī2.�÷�;

SELECT �÷�����Ʈ
	FROM ���̺� ��Ī1, ���̺� ��Ī2
	WHERE ��Ī1.�÷� <= ��Ī2.�÷�;

SELECT �÷�����Ʈ
	FROM ���̺� ��Ī1, ���̺� ��Ī2
	WHERE ��Ī1.�÷� >= ��Ī2.�÷�;
*/


SELECT e1.employee_id, e1.first_name, e1.last_name
, e2.employee_id, e2.first_name, e2.last_name
FROM hr.employees e1, hr.employees e2
WHERE e1.salary = e2.salary;


--hr.employees ���̺��� employee_id�� 150�� ������ �޿��� ���� �޿��� �޴� ���� ���� ���.
SELECT e1.employee_id, e1.first_name, e1.last_name
    , e1.salary
, e2.employee_id, e2.first_name, e2.last_name
, e2.job_id, e2.department_id
FROM hr.employees e1, hr.employees e2
WHERE e1.salary = e2.salary
AND e1.employee_id = 150;



--hr.employees ���̺��� employee_id�� 150�� ������ �޿����� �� ���� �޿��� �޴� ���� ���� ���.
SELECT e1.employee_id, e1.first_name, e1.last_name
    , e1.salary
, e2.employee_id, e2.first_name, e2.last_name
, e2.job_id, e2.department_id
, e2.salary
FROM hr.employees e1, hr.employees e2
WHERE e1.salary <= e2.salary
AND e1.employee_id = 150;
--19



--hr.employees ���̺��� Ư����(employee_id�� 150�� ����)�� �Ŵ��� ���� ���.
SELECT employee_id, first_name, last_name
    , manager_id
FROM hr.employees
WHERE employee_id=150;

SELECT employee_id, first_name, last_name
    , manager_id
FROM hr.employees
WHERE employee_id=100;


SELECT employee_id, first_name, last_name
    , manager_id
FROM hr.employees
WHERE manager_id IS NULL;


SELECT e1.employee_id, e1.first_name, e1.last_name
    , e1.manager_id
    , e1.department_id
    , e2.employee_id, e2.first_name, e2.last_name
    , e2.department_id
FROM hr.employees e1, hr.employees e2
WHERE e1.manager_id = e2.employee_id
AND e1.employee_id=150;


SELECT e1.employee_id, e1.first_name, e1.last_name
    , e1.manager_id
    , e1.department_id
    , e2.employee_id, e2.first_name, e2.last_name
    , e2.department_id
FROM hr.employees e1, hr.employees e2
WHERE e1.manager_id = e2.employee_id
AND e1.employee_id=100;


--����) hr.employees ���̺��� ���� ����(���� ������ ���� ����) ���� ���.
--�ڱ� �ڽ��� employee_id�� �ٸ� ������ manager_id�� ���� ����.
--���� ���, employee_id�� 150, 200�� ������ ���� �����̴�.
--89



SELECT employee_id, first_name, last_name, job_id, manager_id, department_id
FROM hr.employees 
WHERE employee_id NOT IN (SELECT manager_id
FROM hr.employees
WHERE manager_id IS NOT NULL
GROUP BY manager_id)
ORDER BY employee_id;



SELECT employee_id, first_name,last_name,job_id, manager_id
FROM hr.employees
WHERE employee_id NOT IN (SELECT DISTINCT manager_id
FROM hr.employees
WHERE manager_id IS NOT NULL)
ORDER BY employee_id;



SELECT employee_id, first_name,last_name,job_id, manager_id
FROM hr.employees e
WHERE NOT EXISTS (SELECT * FROM hr.employees 
                WHERE manager_id=e.employee_id);






-------------------------------------------
--���̺� 3�� �̻� JOIN

/*
SELECT �÷�����Ʈ
    FROM ���̺�1, ���̺�2, ���̺�3, ...
    WHERE ���̺�1.�÷��� = ���̺�2.�÷���
            AND ���̺�2.�÷��� = ���̺�3.�÷���
            AND ... ;
*/








--------------------------------------------
--JOIN ���� Ǯ�� (HR ��Ű�� �̿�)


--1. hr.departments, hr.employees ���̺�. �μ���(department_name), �μ����� �̸�(first_name, last_name) ���. ���� ���� �̿�.
--JOIN ���� �̿��� ���

--���� ���� �̿��� ���


--2. hr.employees, hr.jobs ���̺�. 'Neena', 'Kochhar' ������ ������(job_title)���� ���. ���� ���� �̿�.
--JOIN ���� �̿��� ���

--���� ���� �̿��� ���



--3. hr.employees, hr.jobs ���̺�. ������(job_title)�� �ּұ޿�(min_salary)�� �޴� ���� ���. ���� ���� �̿�.
--JOIN ���� �̿��� ���

--���� ���� �̿��� ���




--4. hr.jobs, hr.employees ���̺�. ������(job_title)�� ������ �� ���. ���� ���� �̿�.
--JOIN ���� �̿��� ���

--���� ���� �̿��� ���



--5. hr.employees, hr.departments ���̺��� 'David', 'Austin' ������ ���� �μ���(department_name), �μ���(manager)�̸�(first_name, last_name) ���. ���� ���� �̿�.
--JOIN ���� �̿��� ���


--���� ���� �̿��� ���





--6. hr.employees ���̺��� 'Steven', 'King' ������ ���� ���� ���. ���� ����.
--JOIN ���� �̿��� ���


--���� ���� �̿��� ���


--7. hr.employees, hr.jobs, hr.job_history ���̺�. employee_id�� 101�� ������ �������丮(first_name, last_name, start_date, end_date, job_title) ���.
--JOIN ���� �̿��� ���


--���� ���� �̿��� ���




--8. hr.employees ���̺��� ���� ������ ���� ���� ���.
--JOIN ���� �̿��� ���


--���� ���� �̿��� ���




--9. hr.employees ���̺��� Ư�� ����(first_name�� 'Gerald', last_name�� 'Cambrault'�� ����)�� salary���� �޿��� �� ���� �޴� ���� ���� ���.
--JOIN ���� �̿��� ���



--���� ���� �̿��� ���



