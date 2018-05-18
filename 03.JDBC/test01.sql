--JDBC ������ ���̺� ����
CREATE TABLE test01 (
    id_ NUMBER  --PK
    , age_ NUMBER
    , first_ VARCHAR2(255)
    , last_ VARCHAR2(255)
);

--����) Primary Key ���� ���� �߰�
ALTER TABLE test01
ADD CONSTRAINT test01_id_pk PRIMARY KEY(id_);


--���� �ڷ� �Է�
INSERT INTO test01 (id_, age_, first_, last_)  VALUES (100, 18, 'Zara', 'Ali');
INSERT INTO test01 (id_, age_, first_, last_)  VALUES (101, 25, 'Mahnaz', 'Fatma');
INSERT INTO test01 (id_, age_, first_, last_)  VALUES (102, 30, 'Zaid', 'Khan');
INSERT INTO test01 (id_, age_, first_, last_)  VALUES (103, 28, 'Sumit', 'Mittal');
COMMIT;

--��ü �ڷ� ���
SELECT id_, age_, first_, last_
FROM test01
ORDER BY id_;


--��ȣ(id_) �ڵ� ����
INSERT INTO test01 (id_, age_, first_, last_)  VALUES ((SELECT NVL(MAX(id_), 0) + 1 FROM test01), 28, 'choi', 'gildong');
ROLLBACK;


--(�����ϴ� row�� ���) �ڷ� ���� ����
DELETE FROM test01 WHERE id_ = 100;
--1 �� ��(��) �����Ǿ����ϴ�.
--(�������� �ʴ� row�� ���) �ڷ� ���� ����
DELETE FROM test01 WHERE id_ = 200;
--0�� �� ��(��) �����Ǿ����ϴ�.
ROLLBACK;

