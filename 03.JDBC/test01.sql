--JDBC 연습용 테이블 생성
CREATE TABLE test01 (
    id_ NUMBER  --PK
    , age_ NUMBER
    , first_ VARCHAR2(255)
    , last_ VARCHAR2(255)
);

--문제) Primary Key 제약 조건 추가
ALTER TABLE test01
ADD CONSTRAINT test01_id_pk PRIMARY KEY(id_);


--샘플 자료 입력
INSERT INTO test01 (id_, age_, first_, last_)  VALUES (100, 18, 'Zara', 'Ali');
INSERT INTO test01 (id_, age_, first_, last_)  VALUES (101, 25, 'Mahnaz', 'Fatma');
INSERT INTO test01 (id_, age_, first_, last_)  VALUES (102, 30, 'Zaid', 'Khan');
INSERT INTO test01 (id_, age_, first_, last_)  VALUES (103, 28, 'Sumit', 'Mittal');
COMMIT;

--전체 자료 출력
SELECT id_, age_, first_, last_
FROM test01
ORDER BY id_;


--번호(id_) 자동 관리
INSERT INTO test01 (id_, age_, first_, last_)  VALUES ((SELECT NVL(MAX(id_), 0) + 1 FROM test01), 28, 'choi', 'gildong');
ROLLBACK;


--(존재하는 row인 경우) 자료 삭제 쿼리
DELETE FROM test01 WHERE id_ = 100;
--1 행 이(가) 삭제되었습니다.
--(존재하지 않는 row인 경우) 자료 삭제 쿼리
DELETE FROM test01 WHERE id_ = 200;
--0개 행 이(가) 삭제되었습니다.
ROLLBACK;

