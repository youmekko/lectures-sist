------------------------------------------------
--뷰(View)

/*
1. 뷰란 이미 특정한 데이터베이스 내에 존재하는 하나 이상의 테이블에서 사용자가 얻기 원하는 데이터들만을 정확하고 편하게 가져오기 위하여 사전에 원하는 컬럼들 만을 모아서 만들어 놓은 가상의 테이블로 편리성 및 보안에 목적이 있다. 가상의 테이블이란 뷰가 실제로 존재하는 테이블이 아니라 하나 이상의 테이블에서 파생된 또 다른 정보를 볼 수 있는 방법 이며 그 정보들을 추출해내는 SQL 문장이라고 볼 수 있다.

2. CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름
	[(alias[, alias]...]
	AS subquery
	[WITH CHECK OPTION]
	[WITH READ ONLY];
    
3. 뷰 생성 권한을 부여 받은 경우만 실행 가능    
*/

--뷰 삭제
--DROP VIEW 뷰이름;



--------------------------------------------
--인라인 뷰
/*
1. 인라인 뷰는 FROM 절에서 서브 쿼리를 사용하여 생성한 임시 뷰이다. 인라인 뷰는 SQL 문이 실행되는 동안만 임시적으로 정의된다. 즉, 객체로서 저장되지 않는다.

2. 뷰 생성 권한 없어도 실행 가능.
*/

------------------------------------------
--특정 순위까지만 출력
--ROW_NUMBER() OVER(순서) 함수
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



--'사원' 직위인 직원들만을 대상으로 (기본급 내림차순 정렬시) 특정 순위까지 출력
SELECT *
    FROM (SELECT ROW_NUMBER() OVER(ORDER BY basicpay DESC) AS num_
            , emp_id, name_, phone,  job_title, basicpay
     FROM (SELECT emp_id, name_, phone,  job_title, basicpay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_title = '사원')
    WHERE num_ <= 5; --O
/*    
1	1005	한석봉	018-5211-3542	사원	1420000
2	1002	이순신	010-4758-6532	사원	1320000
3	1049	이미성	010-6654-8854	사원	1300000
4	1043	양미옥	016-8548-6547	사원	1100000
5	1025	우재옥	010-4563-2587	사원	1100000
*/
--> 동점자 처리 안된 상태


------------------------------------------
--특정 순위까지만 출력 (동점자 처리 가능)
--RANK() OVER(순서) 함수

SELECT *
    FROM (SELECT RANK() OVER(ORDER BY basicpay DESC) AS num_
            , emp_id, name_, phone,  job_title, basicpay
     FROM (SELECT emp_id, name_, phone,  job_title, basicpay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_title = '사원')
    WHERE num_ <= 5; --O
/*    
1	1005	한석봉	018-5211-3542	사원	1420000
2	1002	이순신	010-4758-6532	사원	1320000
3	1049	이미성	010-6654-8854	사원	1300000
4	1043	양미옥	016-8548-6547	사원	1100000
4	1014	황진이	010-3214-5467	사원	1100000
4	1025	우재옥	010-4563-2587	사원	1100000
4	1034	이정석	011-3697-7412	사원	1100000
*/
--> 동점자 처리된 상태



-----------------------------------------
--'사원' 직위를 가진 직원 정보 출력
SELECT *
     FROM (SELECT emp_id, name_, phone,  job_title
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_title = '사원';
     
--원본 확인     
SELECT emp_id, name_, phone,  job_title
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id;     

--'사원' 직위를 가진 직원 정보 삭제
DELETE FROM (SELECT emp_id, name_, phone,  job_title
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_title = '사원';

--삭제 확인
SELECT emp_id, name_, phone,  job_title
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id;     

--복구
ROLLBACK;


---------------------------------
--원본 확인     
SELECT emp_id, name_, phone,  job_title, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id;    
/*            
1054	정상호	016-1919-4242	사원	114000
1055	정한나	016-2424-4242	사원	104000
1059	임수봉	011-4151-4154	사원	102000
*/

--'사원' 직위(jobs.job_title)를 가진 직원의 수당(emp.extrapay)을 10% 인상.
UPDATE (SELECT emp_id, name_, phone,  job_title, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
	SET extrapay = (extrapay * 1.1)
	 WHERE job_title = '사원';
    
--수정 확인     
SELECT emp_id, name_, phone,  job_title, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id;    
/*            
1054	정상호	016-1919-4242	사원	125400
1055	정한나	016-2424-4242	사원	114400
1059	임수봉	011-4151-4154	사원	112200
*/

--복구
ROLLBACK;





--------------------------------
-- WITH CHECK OPTION 지정 뷰
/*
WITH CHECK OPTION 절을 사용하면 뷰를 통해 참조 무결성(reference integrity)을 검사할 수 있고 DB 레벨에서의 constraint 적용이 가능하다.
*/


--------------------------------
--WITH CHECK OPTION 없는 뷰 생성 및 자료 입력 테스트

--'사원' 직위를 가진 직원 정보 출력
SELECT *
     FROM (SELECT emp_id, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='사원');
     
     
--'사원' 직위를 가진 직원 정보를 보여주는 뷰 생성
CREATE OR REPLACE VIEW emp_jobs_view
AS
SELECT *
     FROM (SELECT emp_id, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='사원');
     
     
--뷰를 이용한 자료 입력 (직위가 '사원'인 아닌 경우 준비)
INSERT INTO emp_jobs_view (emp_id, name_ , ssn, hiredate, phone
                    , job_id, basicpay, extrapay)
            VALUES ('1200', '홍길동', '901212-1234567'
                    , '2010-10-05', '010-1212-3434'
                    , (SELECT job_id FROM jobs WHERE job_title='과장')
                    , 2000000, 1000000);
-->1 행 이(가) 삽입되었습니다.

SELECT * FROM emp_jobs_view;
--> 신규 자료 검색 불가
--> '사원'이 아닌 자료는 검색되지 않는다.
--> 뷰를 이용한 입력시 잘못된 자료가 입력되는 것을 막을 수 없다.
--> WITH CHECK OPTION 지정 필요

SELECT * FROM emp;
--> 원본 테이블에서는 검색 가능

ROLLBACK;
--> 1200, 홍길동 자료 취소


-------------------------------------------
--WITH CHECK OPTION 지정 뷰 생성 및 자료 입력 테스트
--'사원' 직위를 가진 직원 정보를 보여주는 뷰 생성
CREATE OR REPLACE VIEW emp_jobs_view
AS
SELECT *
     FROM (SELECT emp_id, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='사원')
WITH CHECK OPTION;

--뷰를 이용한 자료 입력 (직위가 '사원'인 아닌 경우 준비)
INSERT INTO emp_jobs_view (emp_id, name_ , ssn, hiredate, phone
                    , job_id, basicpay, extrapay)
            VALUES ('1200', '홍길동', '901212-1234567'
                    , '2010-10-05', '010-1212-3434'
                    , (SELECT job_id FROM jobs WHERE job_title='과장')
                    , 2000000, 1000000);
--> ORA-01402: view WITH CHECK OPTION where-clause violation

--뷰를 이용한 자료 입력 (직위가 '사원'인 경우 준비)
INSERT INTO emp_jobs_view (emp_id, name_ , ssn, hiredate, phone
                    , job_id, basicpay, extrapay)
            VALUES ('1200', '홍길동', '901212-1234567'
                    , '2010-10-05', '010-1212-3434'
                    , (SELECT job_id FROM jobs WHERE job_title='사원')
                    , 2000000, 1000000);
-->1 행 이(가) 삽입되었습니다.

SELECT * FROM emp_jobs_view;
--> 신규 자료 검색 가능
--> '사원'인 자료만 검색된다.
--> 뷰를 이용한 입력시 잘못된 자료가 입력되는 것을 막을 수 있다.

ROLLBACK;
-->1200, 홍길동 자료 취소


-------------------------------------------
--WITH READ ONLY 지정 뷰 생성 및 자료 입력 테스트
--'사원' 직위를 가진 직원 정보를 보여주는 뷰 생성
CREATE OR REPLACE VIEW emp_jobs_view
AS
SELECT *
     FROM (SELECT emp_id, name_ , ssn, hiredate, phone
                   , e_.job_id, basicpay, extrapay
            FROM emp e_, jobs j
            WHERE e_.job_id = j.job_id)
     WHERE job_id =  (SELECT job_id FROM jobs WHERE job_title='사원')
WITH READ ONLY;


--뷰를 이용한 자료 입력 (직위가 '사원'인 경우 준비)
INSERT INTO emp_jobs_view (emp_id, name_ , ssn, hiredate, phone
                    , job_id, basicpay, extrapay)
            VALUES ('1200', '홍길동', '901212-1234567'
                    , '2010-10-05', '010-1212-3434'
                    , (SELECT job_id FROM jobs WHERE job_title='사원')
                    , 2000000, 1000000);
-->ORA-42399: cannot perform a DML operation on a read-only view


SELECT * FROM emp_jobs_view;
--> 자료 검색 가능


---------------------------------------------
