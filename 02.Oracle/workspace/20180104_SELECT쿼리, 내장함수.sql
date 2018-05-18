--------------------------------------------------
/*
�Լ�(Function)
-- ���� �Լ�, ����� ���� �Լ�
-- �Ű������� � ���� �����ϸ�, �������� ó���� �����ϰ�, ����� ��ȯ�ϵ��� ������� �ڵ�.
-- ������ �Լ�(��� ��� �� ��)�� ������ �Լ�(�������� ���� �����ϸ� ��� �� ��)�� ���еȴ�.
-- ������ �Լ��� �����Լ�, �����Լ�, ��¥�Լ�, ��ȯ�Լ�, �Ϲ��Լ��� ����.
*/



----------------------------------------------
--DECODE() �Լ�
--IF ~ ELSE IF ~ ELSE �� ������ �ϴ� �Լ�.
--Ư�� ����(��ġ�ϴ� ��츸 �˻� ����)�� �����ϴ����� ���� �ٸ� ����� ��ȯ�ϴ� �Լ�.
--DECOCE(�÷�, �񱳰�1, �����1, �񱳰�2, �����2,....) �������� ���.
--DECOCE(�÷�, �񱳰�1, �����1)
--DECOCE(�÷�, �񱳰�1, �����1, �񱳰�2, �����2)
--DECOCE(�÷�, �񱳰�1, �����1, �񱳰�2, �����2, �����3)
--������ ������� CASE ~ END ������ �ִ�. Ư�� ���ǿ��� ��ġ�ϴ� ��츸�� �ƴ϶�, ũ��, �۴� � �˻� ����.

--hr.employees ���̺��� �μ���ȣ(department_id)�� 10 -> 'Administration', 20 -> 'Marketing', 30 -> 'Purchasing', 40�� ���Ĵ� '.etc' ���.

SELECT department_id, department_name
FROM hr.departments;
/*
10	Administration
20	Marketing
30	Purchasing
40~110 .etc
*/

SELECT employee_id, first_name, last_name
    , department_id
    , DECODE(department_id
    , 10, 'Administration'
    , 20, 'Marketing'
    , 30, 'Purchasing', '.etc') department_name
FROM hr.employees
ORDER BY department_name;


-----------------------------
--CASE ~ END ����
--IF ~ ELSE IF ~ ELSE �� ������ �ϴ� ����.
--Ư�� ������ �����ϴ����� ���� �ٸ� ����� ��ȯ�ϴ� ����.
--�⺻ ����
/*
--�����ڰ� =�� ���
CASE �÷�
    WHEN ��1 THEN ���1
    WHEN ��2 THEN ���2
    WHEN ��3 THEN ���3
    ...
    ELSE ���
END

--�����ڰ� =�� �ƴ� ���
CASE 
    WHEN ���ǽ�1 THEN ���1
    WHEN ���ǽ�2 THEN ���2
    WHEN ���ǽ�3 THEN ���3
    ...
    ELSE ���
END
*/

 
--hr.employees ���̺��� �μ���ȣ(department_id)�� 10 -> 'Administration', 20 -> 'Marketing', 30 -> 'Purchasing', 40�� ���Ĵ� '.etc' ���. CASE ~ END ���� ���.
SELECT employee_id, first_name, last_name
    , department_id
    , CASE department_id
        WHEN 10 THEN 'Administration'
        WHEN 20 THEN 'Marketing'
        WHEN 30 THEN 'Purchasing'
        ELSE '.etc'
    END department_name
FROM hr.employees
ORDER BY department_name;


--hr.employees ���̺��� �μ���ȣ(department_id)�� 10 -> 'Administration', 20 -> 'Marketing', 30 -> 'Purchasing', 40�� ���Ĵ� '.etc' ���. CASE ~ END ���� ���.
SELECT employee_id, first_name, last_name
    , department_id
    , CASE 
        WHEN department_id=10 THEN 'Administration'
        WHEN department_id=20 THEN 'Marketing'
        WHEN department_id=30 THEN 'Purchasing'
        ELSE '.etc'
    END department_name
FROM hr.employees
ORDER BY department_name;


--hr.employees ���̺��� �޿�(salary) ���ؿ� ���� 'A', 'B', 'C' ������� ���.
--�޿��� 20000 �̻��� ��� 'A'
--�޿��� 10000 �̻��� ��� 'B'
--�޿��� 10000 �̸��� ��� 'C'

SELECT employee_id, first_name, last_name
    , salary
    , CASE 
        WHEN salary>=20000 THEN 'A'
        WHEN salary>=10000 AND salary<20000 THEN 'B'
        ELSE 'C'
    END salaryGrade
FROM hr.employees;


--hr.employees ���̺��� �޿�(salary) ���ؿ� ���� 'A', 'B', 'C' ������� ���.
--�޿��� 20000 �̻�(30000 �̸�)�� ��� 'A'
--�޿��� 10000 �̻�(20000 �̸�)�� ��� 'B'
--�޿��� 10000 �̸��� ��� 'C'
--> = �����ڷ� ���� �ذ� ����. DECODE() �Լ� ��� ����.
SELECT TRUNC(20000/10000)
    , TRUNC(29999/10000)
    , TRUNC(10000/10000)
    , TRUNC(19999/10000)
    , TRUNC(9999/10000)
FROM dual;

SELECT employee_id, first_name, last_name
    , salary
    , DECODE(TRUNC(salary/10000)
        , 0, 'C'
        , 1, 'B'
        , 2, 'A') salaryGrade
FROM hr.employees;



--------------------------------------------------
--INSA ���̺� ���� ���� Ǯ��


--1. INSA ���̺� ��ü�ڷ� ���
SELECT * FROM insa;

SELECT num AS "NUM", name AS "NAME", ssn, ibsadate, city, tel
    , buseo, jikwi, basicpay, sudang
  FROM insa;  
 

--2. �Ϲ� ����� ���� ���̺�(��ü) ��� Ȯ��
--user_tables ��ųʸ� ���
--user_XXX, all_XXX, dba_XXXX ��ųʸ�

SELECT * FROM user_tables;



--3. INSA ���̺� ����(�÷� ����) Ȯ��
DESC insa;

/*
�̸�       ��        ����           
-------- -------- ------------ 
NUM      NOT NULL NUMBER(5)    --������ȣ
NAME     NOT NULL NVARCHAR2(20)  --�̸�
SSN      NOT NULL VARCHAR2(14)   --�ֹι�ȣ
IBSADATE NOT NULL DATE           --�Ի���
TEL               VARCHAR2(15)   --��ȭ��ȣ
CITY              NVARCHAR2(10)   --����
BUSEO    NOT NULL NVARCHAR2(15)   --�μ�
JIKWI    NOT NULL NVARCHAR2(15)   --����
BASICPAY NOT NULL NUMBER(10)     --�⺻��
SUDANG   NOT NULL NUMBER(10)     --����
*/





---------------------------------------
--4. �̸�(name), �ֹι�ȣ(ssn), �Ի���(ibsadate), ��ȭ��ȣ(tel) ���
SELECT name, ssn, ibsadate, tel 
	FROM insa;


--5. �̸�(name), �⺻��(basicpay), ����(sudang), �⺻��+����(->�޿�) ���
SELECT name, basicpay, sudang
    , (basicpay+sudang) pay
  FROM insa;



--6. �̸�(name), ������(city), �μ���(buseo) ���. ����(Alias) ���.

SELECT name AS �̸�, city AS ����, buseo AS �μ���
  FROM insa;
SELECT name �̸�, city ����, buseo �μ���
  FROM insa;
SELECT name "�̸�", city "����", buseo "�μ���"
  FROM insa;



--7. ������(city)�� '����'�� ������ �̸�(name), ������(city), �μ���(buseo), ������(jikwi) ���. WHERE ���� �߰�.

SELECT name, city, buseo, jikwi
	FROM insa
	WHERE city='����';
--20





/*
8.������(city)�� '����'�̸鼭
 �⺻��(basicpay)�� 150���� �̻��� ���
 ��� (name, city, basicpay, ssn)
 --> �������� AND ���
*/


--9.������(city)�� '��õ'�̸鼭, �⺻��(basicpay)�� 100����~200������ ��츸 ���. BETWEEN ������ ���.


 
--10.�������� '����'�̰ų�, �μ����� '���ߺ�'�� �ڷ� ��� (name, city, buseo). �������� OR ���.

 
--11.������(city)�� '����', '���'�� ����� ��� (name, city, buseo). IN ������ ���.


--12.�μ���(buseo)�� '���ߺ�', '������'�� ����� ���. IN ������ ���.



/*
13. �޿�(basicpay + sudang)�� 250���� �̻��� ���. --> WHERE ����
(name, basicpay, sudang, basicpay+sudang)
*/



/*
14. �ֹι�ȣ(ssn)�� �������� ���� ������ ���. (�̸�, ������, ����, �ֹι�ȣ). 
SUBSTR() �Լ� �̿�.
*/

 
/* 
15. �ֹι�ȣ(ssn)�� �������� 80���(1980~1989) �¾ ����� ���. (�̸�, ������, ����, �ֹι�ȣ). 
SUBSTR() �Լ� �̿�.
*/



--16. �������� '����' �߿��� 70���(1970~1979) �¾ ���� ���. SUBSTR() �Լ� �̿�.  (�̸�, ������, ����, �ֹι�ȣ). 


--17. ������(city)�� '����' �߿��� 70���(1970~1979) �¾ ���� ������ ���. SUBSTR() �Լ� �̿�.  (�̸�, ������, ����, �ֹι�ȣ). 

		
 
/* 
18. ������(city)�� '����' �̸鼭 �达�� ���(������ 1�ڶ�� ����). (�̸�, ������). 
SUBSTR() �Լ� �̿�.
*/


/*
19. 2000�⵵�� �Ի��� ��� ���. (�̸�, ������, �Ի���). 
SUBSTR() �Ǵ� TO_CHAR() �Լ� �̿�.
*/



--20. 2000�� 10���� �Ի��� ��� ���. (�̸�, ������, �Ի���). 


/*
21. �ֹι�ȣ(ssn)�� �������� ������ ���� ���ϱ�. (�̸�, ����, �ֹι�ȣ, ����)
���� ����� (���� �⵵ - �¾ �⵵ + 1) �� ���.
*/
SELECT TO_CHAR(SYSDATE, 'YYYY') AS "����⵵"
  ,TO_CHAR(TO_DATE(SUBSTR(ssn, 1, 6)), 'YYYY') AS "���س⵵"
  ,TO_CHAR(SYSDATE, 'YYYY') -
  TO_CHAR(TO_DATE(SUBSTR(ssn, 1, 6)), 'YYYY') + 1 AS "�����"
  FROM insa;




/*
22. �ֹι�ȣ(ssn) �������� ���� ���̴밡 30���� ����� ���. (�̸�, ����, �ֹι�ȣ, ����)
���� ����� (���� �⵵ - �¾ �⵵ + 1) �� ���.
*/



--23. �ֹι�ȣ(ssn) �������� 5���޻��� ���. SUBSTR() �Լ� �̿�. (�̸�, ����, �ֹι�ȣ, ����)

WHERE SUBSTR(ssn, 3, 2) = '05'


/*
24. �ֹι�ȣ(ssn) �������� 5���޻��� ���. (�̸�, ����, �ֹι�ȣ, ����)
�ֹι�ȣ�� ������� �κи��� ����->��¥�� �ڷ�� ��ȯ->�� �κи� ����.
*/
WHERE TO_CHAR(TO_DATE(SUBSTR(ssn, 1, 6)), 'MM')='05'



--25. ������(city) ������������ �����ϰ�, ������(city)�� ������ �⺻��(basicpay) ��������

SELECT name, city, buseo, jikwi, basicpay
	FROM insa
	ORDER BY city ASC, basicpay DESC;

SELECT name, city, buseo, jikwi, basicpay
	FROM insa
	ORDER BY city, basicpay DESC;



/* 
26. ������(city)�� '����' �߿��� �⺻��+����(->�޿�) ������������ ����. 
(�̸�, ������, �⺻��+����->�޿�)
*/


 
--27. ���� �� �μ�(buseo) ������������ �����ϰ�, �μ��� ������ �⺻��(basicpay) �������� ����. (�̸�, �ֹι�ȣ, �μ�, �⺻��)



/*
28. ���� �߿��� ���̸� �������� �������� �����ؼ� ���. (�̸�, ����, �ֹι�ȣ, ����)
���� ����� (���� �⵵ - �¾ �⵵ + 1) �� ���.
*/



--29. ������(city)�� '����' �߿��� �Ի���(ibsaDate)�� ���� ����� ���� ���.



/*
30. ������ �达�� �ƴ� ��� ���. (�̸�, ����, �⺻��). 
LIKE ������ �Ǵ� SUBSTR() �Լ� �̿�.
*/



/*
31. ������(city)�� '����', '�λ�', '�뱸' �̸鼭 
��ȭ��ȣ(tel)�� 5 �Ǵ� 7�� ���Ե� �ڷ� ����ϵ� 
�μ���(buseo)�� ������ '��'�� ��µ��� �ʵ�����. 
(�̸�, ������, �μ���, ��ȭ��ȣ)
*/

SELECT  name, city, tel
    , RTRIM(buseo, '��') buseo
  FROM insa
  WHERE (city IN ('����', '�λ�', '�뱸'))  AND
    (INSTR(tel, '5', 1, 1)>0  OR INSTR(tel, '7', 1, 1)>0);


--32. ��ȭ��ȣ(tel)�� ������ '-'�� �����ϰ� ����ϰ�, ������ '��ȭ��ȣ����'�� ���

SELECT name, tel
  , DECODE(tel
      , null, '��ȭ��ȣ ����'
      , SUBSTR(tel, 1, 3) || SUBSTR(tel, 5, 4) || SUBSTR(tel, 10, 4)) tel4
  FROM insa;


SELECT name, tel
  , DECODE(tel
      , null, '��ȭ��ȣ ����'
      , REPLACE(tel, '-')) tel4
  FROM insa;  


-------------------------------------------------------
--���Խ� �Լ�
--���Խ� ǥ���� �̿��ؼ� �˻�, ġȯ ���� �����ϴ� �Լ�.
--REGEXP_LIKE(), REGEXP_REPLACE(), REGEXP_SUBSTR(), REGEXP_COUNT()

--REGEXP_LIKE() �Լ�
--Ư�� ����(����ǥ����)�� ��Ī�Ǵ� ����� ��ȯ�ϴ� �Լ�

--hr.employees ���̺���  first_name�� 'A', 'B', 'C'�� �����ϴ� ��츸 ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, '[A-C]');
--16

--hr.employees ���̺���  first_name�� 'A', 'B', 'C'�� �����ϴ� ��츸 ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE SUBSTR(first_name,1,1) IN ('A', 'B', 'C');
--16


--hr.employees ���̺��� first_name�� ������ ���Ե� ��� ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, '[a-zA-Z] ');


--hr.employees ���̺��� first_name�� ������ ���Ե� ��� ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE INSTR(first_name, ' ') > 0;


--hr.employees ���̺��� first_name�� �빮�ڰ� �� ������ ��� ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, '[A-Z]{2}');




