package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

//자료 저장소(데이터베이스) 액션 전용 클래스
public class MemberDAO {

	// 출력 액션 메소드
	// -> 반환 자료형을 컬렉션 객체로 지정
	public List<Member> memberList() {
		List<Member> result = new ArrayList<Member>();
		
		/*
		CREATE OR REPLACE VIEW membersView
		AS
		SELECT mid, name_, phone, email, regDate, deptName
		FROM members m, dept d
		WHERE m.deptId = d.deptId;
		*/
		
		String sql = "SELECT mid, name_, phone, email, regDate, deptName FROM membersView";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String mid = rs.getString("mid");
				String name_ = rs.getString("name_");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				LocalDate regDate = rs.getDate("regDate").toLocalDate();
				String deptName = rs.getString("deptName");
				
				Member m = new Member(mid, name_, phone, email, regDate, deptName);
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	
	// 출력 액션 메소드
	// -> 반환 자료형을 컬렉션 객체로 지정
	public Map<String, String> deptList() {
		Map<String, String> result = new HashMap<String, String>();

		String sql = "SELECT deptId, deptName FROM dept";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String deptId = rs.getString("deptId");
				String deptName = rs.getString("deptName");
				
				result.put(deptId, deptName);
				
			}
			rs.close();
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	
	//입력 액션 메소드
	// ->입력에 필요한 데이터는 외부에서 전달 받는다.
	// ->매개변수 Member m
	// ->여러개의 항목을 모두 가지고 있다.
	// -> 주의) mid 컬럼(PK)의 값은 외부에서 전달 받지 않고, 서브쿼리에 의해 자동 관리 예정.
	public int memberAdd(Member m) {
		int result = 0;
		
		String sql = "INSERT INTO members (mid, name_, phone, email, regDate, deptId) VALUES ((SELECT CONCAT('M', LPAD(NVL(SUBSTR(MAX(mid), 2), 0) + 1, 2, 0)) AS newMid FROM members) , ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getName_());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getRegDate().toString());
			pstmt.setString(5, m.getDeptId());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
