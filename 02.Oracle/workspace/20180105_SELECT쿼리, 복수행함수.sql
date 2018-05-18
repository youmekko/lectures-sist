--------------------------------------------------
/*
�Լ�(Function)
-- ���� �Լ�, ����� ���� �Լ�
-- �Ű������� � ���� �����ϸ�, �������� ó���� �����ϰ�, ����� ��ȯ�ϵ��� ������� �ڵ�.
-- ������ �Լ�(��� ��� �� ��)�� ������ �Լ�(�������� ���� �����ϸ� ��� �� ��)�� ���еȴ�.
-- ������ �Լ��� �����Լ�, �����Լ�, ��¥�Լ�, ��ȯ�Լ�, �Ϲ��Լ��� ����.
*/



-------------------------------------------------------
--���Խ� �Լ�
--���Խ� ǥ���� �̿��ؼ� �˻�, ġȯ ���� �����ϴ� �Լ�.
--REGEXP_LIKE(), REGEXP_REPLACE(), REGEXP_SUBSTR(), REGEXP_COUNT()


-------------------------------------
--REGEXP_LIKE() �Լ�
--Ư�� ����(����ǥ����)�� ��Ī�Ǵ� ����� ��ȯ�ϴ� �Լ�


-------------------------------------
--hr.employees ���̺��� first_name�� �빮�ڰ� �� ������ ��� ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, '[A-Z]{2}');


--hr.employees ���̺��� �μ���ȣ(department_id)�� 3�ڸ��� ������ ��츦 ���.
SELECT employee_id, first_name, last_name, department_id
FROM hr.employees
WHERE REGEXP_LIKE(department_id, '[0-9]{3}');



----------------------------------
--hr.employees ���̺���  first_name�� 'A', 'B', 'C', 'M'�� �����ϴ� ��츸 ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, '[A-C, M]');
--23


--hr.employees ���̺���  first_name�� 'A', 'B', 'C', 'M'�� �����ϴ� ��츸 ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, '^[A-C, M]');
--22


--hr.employees ���̺��� first_name�� 'M'���� �����ϴ� ��� ���
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, '^M');
--6

--hr.employees ���̺��� first_name�� 'Ma' �Ǵ� 'Mo'�� �����ϴ� ��� ���
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, '^M(a|o)');
--4


--hr.employees ���̺���  first_name�� 'a', 'b', 'c'�� ������ ��츸 ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, '[a-c]$');
--16


--hr.employees ���̺���  first_name�� 'son'�� ������ ��츸 ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, 'son$');


------------------------------
--hr.employees ���̺���  first_name�� 'A', 'B', 'C'�� ������ ������ ���ڷ� �����ϴ� ��츸 ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, '^[^A-C]');


---------------------------
--hr.employees ���̺���  first_name�� 'n'���� ������ ��츦 ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE REGEXP_LIKE(first_name, 'n$');
--20

--hr.employees ���̺���  first_name�� 'n'���� ������ �ʴ� ��츦 ���.
SELECT employee_id, first_name, last_name
FROM hr.employees
WHERE NOT REGEXP_LIKE(first_name, 'n$');
--87


--------------------------------
--hr.employees ���̺��� ��ȭ��ȣ(phone_number)�� XXX.XXX.XXXX ������ ��� ���
SELECT employee_id, first_name, last_name, phone_number
FROM hr.employees
WHERE REGEXP_LIKE(phone_number, '[0-9]{3}.[0-9]{3}.[0-9]{4}');
--72

--hr.employees ���̺��� ��ȭ��ȣ(phone_number)�� XXX.XXX.1234 ������ ��� ���
SELECT employee_id, first_name, last_name, phone_number
FROM hr.employees
WHERE REGEXP_LIKE(phone_number, '[0-9]{3}.[0-9]{3}.1234');
--2


-------------------------------------
--REGEXP_REPLACE() �Լ�
--Ư�� ����(����ǥ����)�� ��Ī�Ǵ� ����� ġȯ�ϴ� �Լ�

--hr.employees ���̺��� ��ȭ��ȣ(phone_number)�� ���ڸ� '*'���ڷ� ġȯ.
SELECT employee_id, first_name, last_name
, phone_number
, REGEXP_REPLACE(phone_number, '[0-9]', '*')
FROM hr.employees;

--hr.employees ���̺��� ��ȭ��ȣ(phone_number)�� ���ڸ� '*'���ڷ� ġȯ.
SELECT employee_id, first_name, last_name
, phone_number
, REGEXP_REPLACE(phone_number, '[[:digit:]]', '*')
FROM hr.employees;

--hr.employees ���̺��� ��ȭ��ȣ(phone_number)�� '.'�� ������ ���·� ���.
SELECT employee_id, first_name, last_name
, phone_number
, REGEXP_REPLACE(phone_number, '\.', '')
FROM hr.employees;


--hr.employees ���̺��� ��ȭ��ȣ(phone_number)�� ù ��° '.'�� ')'�� ������ ���·� ���.
SELECT employee_id, first_name, last_name
, phone_number
, REGEXP_REPLACE(phone_number, '\.', ')', 1, 1)
FROM hr.employees;


--hr.employees ���̺��� �̸�(first_name)���� ���� ���� ������ ���·� ���.
--���� ���, 'Jose Manuel'�� 'JoseManuel' ���·� ���.
SELECT employee_id, first_name, last_name
, REGEXP_REPLACE(first_name, '( ){1,}', '')
FROM hr.employees;


-------------------------------------
--REGEXP_SUBSTR() �Լ�
--Ư�� ����(����ǥ����)�� ��Ī�Ǵ� ������� �κ� ���ڿ��� ��ȯ�ϴ� �Լ�

SELECT employee_id, first_name, last_name, job_id
, REGEXP_SUBSTR(job_id, '[A-C]')
, REGEXP_SUBSTR(job_id, 'MAN')
FROM hr.employees;


SELECT employee_id, first_name, last_name, job_id
FROM hr.employees
WHERE REGEXP_SUBSTR(job_id, 'MAN') = 'MAN';



----------------------------------------------
--������ �Լ�
--�������� ���� �����ؼ� �� ���� ����� ��ȯ�ϴ� �Լ�
--����) NULL ���� ���� �ڷ�� ������ �Լ� ����� ���ܵȴ�. ���� ���, SUM() �Լ� ���� NULL ���� ������ �ڵ����� ���ܵȴ�.
--COUNT(), SUM(), AVG(), MAX(), MIN() ���� �ִ�.
--����) �Լ� ���� ������ �Լ�, �Ϲ� �÷��� ������ �Լ��� ȥ���� �� ����.

-------------------------------------------
--COUNT() �Լ�
--���Ե� ���� ���� ��ȯ�ϴ� �Լ�

SELECT COUNT(employee_id) --107
FROM hr.employees;
--NULL���� ������� �ʴ� �÷�(PK)�� ������� ī���� �׼��� �ϴ� ���� ����.

SELECT COUNT(department_id) --106
FROM hr.employees;
--NULL���� �ִ� ���� ī���� �׼ǿ��� ���ܵȴ�.

SELECT COUNT(*) --107
FROM hr.employees;
-- * ���� NULL���� ī���� �׼ǿ� ���Խ�Ų��.

--hr.employees ���̺��� �μ���ȣ(department_id)�� 100�� ����� ���� ���.
SELECT COUNT(*) --6
FROM hr.employees
WHERE department_id = 100;


----------------------------
--SUM() �Լ�
--���Ե� ���� ��(���� �ڷ���)���� ��� �ջ��� ��� ��ȯ.

--hr.employees ���̺��� ��� ������ �޿� �� ���.
SELECT SUM(salary) --691416
FROM hr.employees;


----------------------------
--AVG() �Լ�
--���Ե� ���� ��(���� �ڷ���)���� ��� ��� ��ȯ.
--����) NULL ���� ���ܵǱ� ������ ��� ��� ����� �ٸ��� ���� �� �ִ�.
SELECT SUM(salary)/COUNT(*) --????
FROM hr.employees;

SELECT AVG(salary) --????
FROM hr.employees;

--NULL���� ���� �ڷḦ ��� ����� ������ ���ڷ� ��ȯ. NVL() �Լ�.
SELECT AVG(NVL(salary, 0)) --????
FROM hr.employees;


--------------------------
--MAX(), MIN() �Լ�
--�ִ밪, �ּҰ��� ��ȯ�ϴ� �Լ�

--hr.employees ���̺��� employee_id�� ��ȣ�� �ڵ����� +1 �����ϴ� �׼�.
SELECT MAX(employee_id)
, MAX(employee_id) + 1 
FROM hr.employees;

--NULL���� ���� �ڷḦ MAX() �Լ� ����� NULL ��ȯ. -> �ڵ� +1 ���� �׼� �Ұ�.
SELECT MAX(NVL(employee_id, 0))
, MAX(NVL(employee_id, 0)) + 1 
FROM hr.employees;


--------------------------------
--�Ϲ� �÷�(������ �Լ�)�� ������ �Լ��� ȥ���� �� ����.
SELECT department_id, COUNT(*)
FROM hr.employees
WHERE department_id = 100;
--ORA-00937: not a single-group group function
--GROUP BY ������ �̿��ϸ� ����

-------------------------------
--GROUP BY ����
--������ �Լ��� ���ԵǴ� ����� ���� �������� �׷����Ѵ�.
--���� ���, �μ���, ������, ����, ... ��.
--�⺻ ����
/*
SELECT �׷�����÷�, �������Լ�
FROM table_list
WHERE ���ǽ�
GROUP BY �׷�����÷�, ...
ORDER BY ���ı����÷�, ...;
*/

--hr.employees ���̺��� �μ���ȣ(department_id)���� �ο��� ���. COUNT() �Լ�.
SELECT department_id, COUNT(*)
FROM hr.employees
GROUP BY department_id
ORDER BY department_id;

--hr.employees ���̺��� �μ���ȣ(department_id)��, �������̵�(job_id)���� �ο��� ���. COUNT() �Լ�.
SELECT department_id, job_id, COUNT(*)
FROM hr.employees
GROUP BY department_id, job_id
ORDER BY department_id, job_id;


--hr.employees ���̺��� �Ի���(hire_date) ���� �߿��� �⵵���� �ο��� ���. COUNT() �Լ�.
SELECT TO_CHAR(hire_date, 'YYYY') hire_date, COUNT(*)
FROM hr.employees
GROUP BY TO_CHAR(hire_date, 'YYYY')
ORDER BY hire_date;


-------------------------------
--HAVING ����
--������ �Լ��� ����� ���� ���ǽ� �����ϴ� ����.
--�⺻ ����
/*
SELECT �׷�����÷�, �������Լ�
FROM table_list
WHERE ���ǽ�
GROUP BY �׷�����÷�, ...
HAVING (������ �Լ��� ����� ����)���ǽ�
ORDER BY ���ı����÷�, ...;
*/


--hr.employees ���̺��� �Ի���(hire_date) ���� �߿��� �⵵���� �ο��� ���. COUNT() �Լ�.
--��, �ο����� 10�� �̻��� ��츸 ��� ������� ����.
SELECT TO_CHAR(hire_date, 'YYYY') hire_date, COUNT(*)
FROM hr.employees
GROUP BY TO_CHAR(hire_date, 'YYYY')
HAVING COUNT(*)>=10
ORDER BY hire_date;


--hr.employees ���̺��� �Ի���(hire_date) ���� �߿��� �⵵���� �ο��� ���. COUNT() �Լ�.
--��, �Ի�⵵�� 2005�� �̻��̸鼭, �ο����� 10�� �̻��� ��츸 ��� ������� ����.
SELECT TO_CHAR(hire_date, 'YYYY') hire_date, COUNT(*)
FROM hr.employees
WHERE TO_CHAR(hire_date, 'YYYY')>=2005
GROUP BY TO_CHAR(hire_date, 'YYYY')
HAVING COUNT(*)>=10
ORDER BY hire_date;






--------------------------------------------------
--INSA ���̺� ���� ���� Ǯ��


/*
33. �޿�(basicpay+sudang)�� 100���� �̸�
, 100���� �̻�~200���� �̸�, 200���� �̻��� �������� �� ���.
--GROUP BY ����,  COUNT() �Լ�
*/

SELECT TRUNC((basicpay+sudang)/1000000) pay
  FROM insa;

SELECT DECODE(TRUNC((basicpay+sudang)/1000000)
      , 0, '100�� �̸�'
      , 1, '100�� �̻�~200�� �̸�'
      , 2, '200�� �̻�') AS title
  , COUNT(*) AS ������
  FROM insa
  GROUP BY TRUNC((basicpay+sudang)/1000000);

/*
��¿�)
title			������
--------------------------------
100�� �̻�~200�� �̸�	30
200�� �̻�		26
100�� �̸�		4
*/



--34. �ֹι�ȣ(ssn)�� ������ ��������� �⵵�� ������ ���. 
--   SUBSTR(), COUNT(), GROUP BY �̿�.



/*
35. �ֹι�ȣ(ssn)�� �������� ���� ��������, ���� ������ �⵵ �������� ���. 
(�̸�, �ֹι�ȣ) . 
SUBSTR(), ORDER BY  �̿�.
*/



/*
36. �Ի���(ibsaDate)�� ��������  ���� ��������, ���� ������ �⵵ �������� ���. 
����. �Ի����� �ڷ����� DATE�Դϴ�.
����. 2000�⵵ ���� �Ի��ڴ� �������� ������ �ڷ� ���� �����Ƿ� ������ ��.
TO_CHAR(�Ի���, 'YYYY')
TO_CHAR(�Ի���, 'MM')
*/


/*
37. ��ü�ο���, �����ο���, �����ο����� ���� ���.
��� ��)

��ü�ο���   �����ο���   �����ο���
   60	     31	          29
*/

SELECT COUNT(*) ��ü�ο���
  , COUNT(DECODE(SUBSTR(ssn, 8, 1), 1, 1)) �����ο���
  , COUNT(DECODE(SUBSTR(ssn, 8, 1), 1, null, 2)) �����ο���
  FROM insa;


/*
�ο��� ����  �ο���
�����ο���   31
�����ο���   29
��ü�ο���   60
*/


SELECT DECODE(SUBSTR(ssn, 8, 1)
        , 1, '�����ο���'
        , 2, '�����ο���'
        , '��ü�ο���') "�ο��� ����"
        , COUNT(*) �ο���
  FROM insa
  GROUP BY ROLLUP(SUBSTR(ssn, 8, 1));



/*
38. '���ߺ�', '������', '�ѹ���' �ο��� ���. COUNT(), DECODE() �Լ� �̿�.
���ߺ�->14
������->16
�ѹ���->7
*/


/*
39. ������(city)�� '����'�̸鼭, ������ ������ ������ ���.
COUNT(), WHERE �̿�
*/



/*
40. �μ�(buseo)�� '������'�̰�, ������ ���, ������ ��� �ο��� ���.  
COUNT(), DECODE() , WHERE �̿�.
��� ��)
�������ο���   �����ο���   �����ο���
   XX	          XX	       XX
*/


/*
41. '���ߺ�', '������', '�ѹ���' �ο��� ���. ��, ������(city)�� '����'�� ����.
��� ��)
�������ο���   ���ߺ��ο���   �ѹ����ο���
   XX	          XX	       XX
*/


/*
42. ������(city)�� '����'�� ���ڿ� ������ �⺻��(basicpay) �� ���.
WHERE, DECODE(), SUM()
*/


SELECT 
    SUM( DECODE(SUBSTR(ssn, 8, 1), 1, basicpay) )  ���ڱ⺻����
  , SUM( DECODE(SUBSTR(ssn, 8, 1), 2, basicpay) ) ���ڱ⺻����
  FROM insa
  WHERE city='����';


/*
43. ���ڿ� ������ �⺻��(basicpay) ��հ� ���. AVG(), DECODE() �Լ� �̿�.

���� ���->1676168
���� ���->1428634
*/


/*
44. '���ߺ�' ���ڿ� '���ߺ�' ������ �⺻��(basicpay) ��հ� ���. AVG(), DECODE() �Լ� �̿�.

���ߺ� ���� ���->1392500
���ߺ� ���� ���->1384375
*/


/*
45. �μ�(buseo)�� ���ڿ� ���� �ο��� ���ϱ�
*/

--����, ���� ���. 
SELECT '771212-1022432'
    , SUBSTR('771212-1022432', 8, 1) AS ����
    , DECODE(SUBSTR('771212-1022432', 8, 1)
            , 1, '����'
            , 2, '����') AS ����
  FROM dual;

SELECT name, ssn
    , SUBSTR(ssn, 8, 1) AS ����
    , DECODE(SUBSTR(ssn, 8, 1)
            , 1, '����'
            , 2, '����') AS ����
  FROM insa;

--���� �ο��� ���
SELECT COUNT(*) AS "�����ο���"
  FROM insa
  WHERE SUBSTR(ssn, 8, 1)=1;

--���� �ο��� ���
SELECT COUNT(*) AS "�����ο���"
  FROM insa
  WHERE SUBSTR(ssn, 8, 1)=2;

--����, ���� �ο��� ���
SELECT COUNT(DECODE(SUBSTR(ssn, 8, 1), 1, 1)) AS "�����ο���"
  , COUNT(DECODE(SUBSTR(ssn, 8, 1), 2, 1)) AS "�����ο���"
      FROM insa;


--�μ��� �ѿ�, ����, ���� �ο��� ���
SELECT buseo
    , COUNT(*) AS "�ο���"
   , COUNT(DECODE(SUBSTR(ssn, 8, 1), 1, 1)) AS "�����ο���"
  , COUNT(DECODE(SUBSTR(ssn, 8, 1), 2, 1)) AS "�����ο���"
    FROM insa
    GROUP BY buseo;

/*
�ѹ���	7	4	3
���ߺ�	14	6	8
������	16	8	8
��ȹ��	7	4	3
�λ��	4	4	0
�����	6	2	4
ȫ����	6	3	3
*/


/*
46. ����(city)�� ���ڿ� ���� �ο��� ���ϱ�
*/


/*
47. �Ի�⵵(ibsaDate)�� ���ڿ� ���� �ο��� ���ϱ�
*/


/*
48. '������', '�ѹ���' �ο����� ������ �Ի�⵵(ibsaDate)�� ���ڿ� ���� �ο��� ���ϱ�
*/


/*
49. ������(city)�� '����'�� ��� �μ�(buseo)�� ���ڿ� �����ο���, ���ڿ� ���� �޿��� ���.
*/


/*
50. �μ�(buseo)�� �ο��� ���. �ο����� 10 �̻��� ��츸. GROUP BY, COUNT(), HAVING �̿�.
*/

/*
51. �μ�(buseo)�� ��,�� �ο��� ���. �����ο����� 5�� �̻��� �μ��� ���.
*/


/*
52. �μ�(buseo)�� ��� �޿��� ����ϵ�, A, B, C ������� ������ ���.
200���� �ʰ� - A���
150~200���� - B���
150���� �̸� - C���

DECODE �Ǵ� CASE ~ END
*/

 
/*
53. �̸�, ����, ���� ���
       ����: �ֹι�ȣ 1,3->����, 2,4->���� (DECODE ���)
       ����: �ֹι�ȣ �̿��ؼ�
*/
 
 
 
/* 
54. ������(city)�� '����'�̸鼭 �⺻��(basicpay)�� 200���� �̻��� ����. (�̸�, �⺻��)
*/


/* 
55. �Ի���� �ο��� ���ϱ�. (��, �ο���)   COUNT, GROUP BY, TO_CHAR ���
        ������� ----------
        ��      �ο���
        1��    10��
        2��    25��
*/

SELECT CONCAT(TO_NUMBER(TO_CHAR(ibsadate, 'MM')), '��') AS ��
      , CONCAT(COUNT(*),'��') AS �ο���
  FROM insa
  GROUP BY TO_CHAR(ibsadate, 'MM')
  ORDER BY TO_CHAR(ibsadate, 'MM');


/*
56. �̸�, �������, �⺻��, ������ ���.
       ��������� �ֹι�ȣ ���� (2000-10-10 �������� ���)
       �⺻���� \1,000,000 �������� ���
���� ���� ���� => TO_CHAR(���ڵ�����, '999,999,999,999')
*/

/*
57. �̸�, ������, �⺻���� ����ϵ� ������ �������� ���(1�� ���� ����). 
�������� ������ �⺻�� �������� ���(2�� ���� ����).
*/
 
 
/*
58. ��ȭ��ȣ(tel)�� NULL�� �ƴѰ͸� ���. (�̸�, ��ȭ��ȣ)
*/


/* 
59. �ٹ������ 10�� �̻��� ��� ���. (�̸�, �Ի���)
*/

/* 
60. �ֹι�ȣ(ssn)�� �������� 75~82��� ���. (�̸�, �ֹι�ȣ, ������). 
SUBSTR() �Լ�, BEWTEEN AND ����, TO_NUMBER() �Լ� �̿�.
*/


/*
61. �ٹ������ 10~15���� ��� ���. (�̸�, �Ի���)
*/
 
 
/* 
62. �达, �̾�, �ھ��� ��� (�̸�, �μ�). SUBSTR() �Լ� �̿�.
*/


/*
63. �Ի���(ibsaDate)�� "��-��-�� ����" �������� ���ڸ� ��� (�̸�, �ֹι�ȣ, �Ի���)
*/


/*
64. �μ�(buseo)��, ����(jikwi)�� �޿��� ���ϱ�. (�μ�, ����, �޿���)
*/


--�μ���, ������ ������
SELECT buseo, jikwi, COUNT(*) count_
  FROM insa
  GROUP BY buseo, jikwi
  ORDER BY buseo, jikwi;

/*
���ߺ�	����	2
���ߺ�	�븮	2
���ߺ�	����	1
���ߺ�	���	9
��ȹ��	�븮	3
��ȹ��	����	2
��ȹ��	���	2
������	����	1
������	�븮	5
������	����	2
������	���	8
�λ��	����	1
...
*/

 
/*
65. �μ�(buseo)��, ����(jikwi)�� �ο����� ���ϵ� �ο����� 5�� �̻��� ��츸 ���.
*/

/*
66. 2000�⵵�� �Ի��� ������. (�̸�, �ֹι�ȣ, �Ի���)
*/

/*
67. ������ �� ����(��, ��, �� ��)��� �����Ͽ� ������ �ο��� (����, �ο���)
*/ 

/*
68. ����(city)��, ���� �ο���.
*/

/*
69. �μ�(buseo)�� �����ο����� 5�� �̻��� �μ��� �����ο���.
*/
 
 
/* 
70. �Ի�⵵(ibsaDate)�� �ο���.
*/


/*
71. ��ü�ο���, 2000��, 1999��, 1998�⵵�� �Ի��� �ο��� ������ �������� ���.
        ��ü 2000 1999 1998
         60    x    x    x
*/


/*
72. �Ʒ� �������� ����(city)�� �ο��� ���. ROLLUP ���� �̿�.
*/

/*
        ��ü ����  ��õ  ���
         60    x     x     x
*/
/*
	������ �ο���
	����   XX
	��õ   XX
	���   XX
	��ü  XX
*/
----------------
SELECT 
   COUNT(*) ��ü
  ,COUNT(DECODE(city, '����', 1)) ����
  ,COUNT(DECODE(city, '���', 1)) ���
  ,COUNT(DECODE(city, '�泲', 1)) �泲
  ,COUNT(DECODE(city, '���', 1)) ���
  ,COUNT(DECODE(city, '�λ�', 1)) �λ�
  ,COUNT(DECODE(city, '����', 1)) ����
  ,COUNT(DECODE(city, '��õ', 1)) ��õ
  ,COUNT(DECODE(city, '����', 1)) ����
  ,COUNT(DECODE(city, '����', 1)) ����
  ,COUNT(DECODE(city, '����', 1)) ����
  ,COUNT(DECODE(city, '�泲', 1)) �泲
  FROM insa;

/*
��ü   ����    ���    �泲     ...
60	2	13	1	...
*/

---------------
SELECT DECODE(city, NULL, '��ü', city) city, COUNT(*) count_
  FROM insa
  GROUP BY ROLLUP(city);

/*
����	2
���	13
�泲	1
���	1
�λ�	3
����	20
��õ	9
����	3
����	5
����	2
�泲	1
��ü	60
*/


