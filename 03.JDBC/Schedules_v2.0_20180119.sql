--���� ���� v2.0�� ���� ���̺� ����

--���� ���� ���̺�(schedules) ����
--������ȣ, ������¥�׽ð�, ��������
CREATE TABLE schedules(
    sid_ NUMBER --PK
    ,datetime DATE
    ,content_ NVARCHAR2(200)
);


--�������� �߰�
ALTER TABLE schedules
ADD CONSTRAINT schedules_sid_pk PRIMARY KEY(sid_);


--���� �ڷ� �Է�
INSERT INTO schedules (sid_, datetime, content_) 
VALUES ((SELECT NVL(MAX(sid_),0) + 1 FROM schedules)
, TO_DATE('2018-01-01/10', 'YYYY-MM-DD/HH24'), '����');
INSERT INTO schedules (sid_, datetime, content_) 
VALUES ((SELECT NVL(MAX(sid_),0) + 1 FROM schedules)
, TO_DATE('2018-05-05/10', 'YYYY-MM-DD/HH24'), '��̳�');
INSERT INTO schedules (sid_, datetime, content_) 
VALUES ((SELECT NVL(MAX(sid_),0) + 1 FROM schedules)
, TO_DATE('2018-12-25/10', 'YYYY-MM-DD/HH24'), 'ũ��������');
INSERT INTO schedules (sid_, datetime, content_) 
VALUES ((SELECT NVL(MAX(sid_),0) + 1 FROM schedules)
, TO_DATE('2018-01-19/10', 'YYYY-MM-DD/HH24'), '�������� ���α׷� �ۼ���');


--COMMIT;
COMMIT;


----------------------------------------
--���� ���� �˻� ����
--���� ���� ����
SELECT sid_, TO_CHAR(datetime, 'YYYY-MM-DD/HH24') datetime, content_
FROM schedules
WHERE TO_CHAR(datetime, 'YYYY-MM-DD') = TO_CHAR(SYSDATE, 'YYYY-MM-DD')
ORDER BY datetime;

--Ư�� �� ����
SELECT sid_, TO_CHAR(datetime, 'YYYY-MM-DD/HH24') datetime, content_
FROM schedules
WHERE TO_CHAR(datetime, 'YYYY-MM-DD') = '2018-01-01'
ORDER BY datetime;

--Ư�� �� ����
SELECT sid_, TO_CHAR(datetime, 'YYYY-MM-DD/HH24') datetime, content_
FROM schedules
WHERE TO_CHAR(datetime, 'YYYY-MM') = '2018-01'
ORDER BY datetime;

--Ư�� �ܾ� ���� ����
SELECT sid_, TO_CHAR(datetime, 'YYYY-MM-DD/HH24') datetime, content_
FROM schedules
WHERE INSTR(content_, '����') > 0
ORDER BY datetime;

--��ü ����
SELECT sid_, TO_CHAR(datetime, 'YYYY-MM-DD/HH24') datetime, content_
FROM schedules
ORDER BY datetime;


------------------------------------------
--���� ���� �Ǽ� ��� ����
SELECT TO_CHAR(datetime, 'YYYY-MM') datetime, COUNT(*) count_
FROM schedules
GROUP BY TO_CHAR(datetime, 'YYYY-MM')
ORDER BY datetime;



