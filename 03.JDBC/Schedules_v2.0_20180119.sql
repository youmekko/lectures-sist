--일정 관리 v2.0을 위한 테이블 생성

--일정 정보 테이블(schedules) 생성
--일정번호, 일정날짜및시간, 일정내용
CREATE TABLE schedules(
    sid_ NUMBER --PK
    ,datetime DATE
    ,content_ NVARCHAR2(200)
);


--제약조건 추가
ALTER TABLE schedules
ADD CONSTRAINT schedules_sid_pk PRIMARY KEY(sid_);


--샘플 자료 입력
INSERT INTO schedules (sid_, datetime, content_) 
VALUES ((SELECT NVL(MAX(sid_),0) + 1 FROM schedules)
, TO_DATE('2018-01-01/10', 'YYYY-MM-DD/HH24'), '신정');
INSERT INTO schedules (sid_, datetime, content_) 
VALUES ((SELECT NVL(MAX(sid_),0) + 1 FROM schedules)
, TO_DATE('2018-05-05/10', 'YYYY-MM-DD/HH24'), '어린이날');
INSERT INTO schedules (sid_, datetime, content_) 
VALUES ((SELECT NVL(MAX(sid_),0) + 1 FROM schedules)
, TO_DATE('2018-12-25/10', 'YYYY-MM-DD/HH24'), '크리스마스');
INSERT INTO schedules (sid_, datetime, content_) 
VALUES ((SELECT NVL(MAX(sid_),0) + 1 FROM schedules)
, TO_DATE('2018-01-19/10', 'YYYY-MM-DD/HH24'), '일정관리 프로그램 작성중');


--COMMIT;
COMMIT;


----------------------------------------
--일정 정보 검색 쿼리
--오늘 일정 기준
SELECT sid_, TO_CHAR(datetime, 'YYYY-MM-DD/HH24') datetime, content_
FROM schedules
WHERE TO_CHAR(datetime, 'YYYY-MM-DD') = TO_CHAR(SYSDATE, 'YYYY-MM-DD')
ORDER BY datetime;

--특정 일 기준
SELECT sid_, TO_CHAR(datetime, 'YYYY-MM-DD/HH24') datetime, content_
FROM schedules
WHERE TO_CHAR(datetime, 'YYYY-MM-DD') = '2018-01-01'
ORDER BY datetime;

--특정 월 기준
SELECT sid_, TO_CHAR(datetime, 'YYYY-MM-DD/HH24') datetime, content_
FROM schedules
WHERE TO_CHAR(datetime, 'YYYY-MM') = '2018-01'
ORDER BY datetime;

--특정 단어 포함 기준
SELECT sid_, TO_CHAR(datetime, 'YYYY-MM-DD/HH24') datetime, content_
FROM schedules
WHERE INSTR(content_, '일정') > 0
ORDER BY datetime;

--전체 기준
SELECT sid_, TO_CHAR(datetime, 'YYYY-MM-DD/HH24') datetime, content_
FROM schedules
ORDER BY datetime;


------------------------------------------
--월별 일정 건수 출력 쿼리
SELECT TO_CHAR(datetime, 'YYYY-MM') datetime, COUNT(*) count_
FROM schedules
GROUP BY TO_CHAR(datetime, 'YYYY-MM')
ORDER BY datetime;



