package com.test;

import java.sql.*;
import java.util.*;

//자료 저장소(데이터베이스) 액션 전용 클래스
public class TestDAO {

	// 출력 액션 메소드
	// -> 반환 자료형을 컬렉션 객체로 지정
	public List<Test> list() {
		// 데이터베이스 액션 처리
		// ->결과(데이터 집합)는 컬렉션 객체에 저장 및 반환
		List<Test> result = new ArrayList<Test>();

		// 주의) 문장 끝에 ; 가 있으면 안된다.
		String sql = "SELECT id_, age_, first_, last_ FROM test01 ORDER BY id_";

		// 준비된 SELECT 쿼리 실행 액션 코드 작성
		// ->결과를 컬렉션 객체에 저장
		// ->SELECT 쿼리의 결과는 레코드의 집합체이다.
		// Java에서 집합 자료형은 컬렉션이므로 레코드의 집합체를 Java 자료형으로 받으려면 컬렉션을 사용한다.
		// 레코드의 집합체를 일괄적으로 형변환하는 것은 불가능하고, 레코드 단위로 읽어내서 그 결과를 컬렉션에 순차적으로 추가해야 한다.
		Connection conn = null;

		//Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.connect();
			
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			
			//외부데이터 바인딩 과정 추가하는 위치
			
			//ResultSet rs = stmt.executeQuery(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				
				int id_ = rs.getInt("id_");
				int age_ = rs.getInt("age_");
				String first_ = rs.getString("first_");
				String last_ = rs.getString("last_");
				
				Test t = new Test(id_, age_, first_, last_);
				result.add(t);
				
			}
			rs.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//if (stmt != null)
				//	stmt.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return result;
	}

	// 입력 액션 메소드
	// ->입력에 필요한 데이터는 외부에서 전달 받는다.
	// ->매개변수 Test t
	// ->age_, first_, last_ 항목을 모두 가지고 있다.
	// -> 주의) id_ 컬럼(PK)의 값은 외부에서 전달 받지 않고, 서브쿼리에 의해 자동 관리 예정.
	public int add(Test t) {
		int result = 0;

		// 데이터베이스 액션 처리

		// 외부에서 전달된 자료를 INSERT 쿼리에서 컬럼과 매핑시켜야 한다.
		// 외부 데이터를 쿼리에 바인딩 하는 과정 추가 필요.
		// -> 바인딩 전용 기호인 ? 사용
		// 주의) 문장 끝에 ; 가 있으면 안된다.
		// -> PK 제약이 있는 컬럼인 경우 동일한 자료를 두 번 입력 시도하면 오류 발생. 자동 관리 액션 처리 필요.
		
		//String sql = String.format("INSERT INTO test01 (id_, age_, first_, last_)  VALUES ((SELECT NVL(MAX(id_), 0) + 1 FROM test01), %s, '%s', '%s')"
		//		, t.getAge_(), t.getFirst_(), t.getLast_());
		String sql = "INSERT INTO test01 (id_, age_, first_, last_)  VALUES ((SELECT NVL(MAX(id_), 0) + 1 FROM test01), ?, ?, ?)";

		// 준비된 INSERT 쿼리 실행 액션 코드 작성
		Connection conn = null;
		
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.connect();
			
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);

			//외부 데이터를 쿼리에 바인딩 하는 과정 추가 필요.
			//->setXXX(인덱스, 데이터) 메소드
			//->주의) 인덱스는 1부터 시작된다.
			//->쿼리 문자열의 ? 기호를 외부 데이터와 바인딩
			pstmt.setInt(1, t.getAge_());
			pstmt.setString(2, t.getFirst_());
			pstmt.setString(3, t.getLast_());
			
			//주의) DML문 실행시 AutoCommit 상태이므로 COMMIT 명령을 추가로 실행하지 않아도 된다.
			//result = stmt.executeUpdate(sql);
			result = pstmt.executeUpdate();
			

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//if (stmt != null)
				//	stmt.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	//삭제 액션 메소드
	//->외부에서 PK 컬럼(id_)의 값을 전달 받는다.
	//->반환값 분석을 위해서 반환자료형을 int로 지정한다.
	public int remove(int id_) {
		int result = 0;
		
		//외부 데이터를 쿼리에 바인딩 하는 과정 추가 필요.
		//-> 바인딩 전용 기호인 ? 사용
		// 주의) 문장 끝에 ; 가 있으면 안된다.
		//String sql = String.format("DELETE FROM test01 WHERE id_ = %s", id_);
		String sql = "DELETE FROM test01 WHERE id_ = ?";
		
		Connection conn = null;
		
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.connect();
			
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			
			//외부 데이터를 쿼리에 바인딩 하는 과정 추가 필요.
			//->setXXX(인덱스, 데이터) 메소드
			//->주의) 인덱스는 1부터 시작된다.
			//->쿼리 문자열의 ? 기호를 외부 데이터와 바인딩
			pstmt.setInt(1, id_);
			
			//주의) DML문 실행시 AutoCommit 상태이므로 COMMIT 명령을 추가로 실행하지 않아도 된다.
			//주의) DELETE 쿼리인 경우 반환값 분석 필요하다.
			//result = stmt.executeUpdate(sql);
			result = pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//if (stmt != null)
				//	stmt.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return result;
	}
	

}
