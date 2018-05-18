package com.test;

import java.sql.*;
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
		
		SELECT mid, name_, phone, email, regDate, deptName
		FROM membersView

		SELECT mid, name_, phone, email, regDate, deptName
    		, (SELECT NVL(SUM(fee),0) FROM membersFee WHERE mid=m.mid) feeTotal
		FROM membersView m
		*/
		
		//회비납부총액 출력 과정 추가
		String sql = "SELECT mid, name_, phone, email, regDate, deptName, (SELECT NVL(SUM(fee),0) FROM membersFee WHERE mid=m.mid) feeTotal FROM membersView m";

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
				
				//회비납부총액 출력 과정 추가
				int feeTotal = rs.getInt("feeTotal");
				
				//회비납부총액 출력 과정 추가
				Member m = new Member(mid, name_, phone, email, regDate, deptName, feeTotal);
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
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
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
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
			
			//잘못된 자료 입력 시도
			//이름, 전화번호가 중복된 경우
			//기타...
			//->예외 발생 가능
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			//se.printStackTrace();
			
			//예외 발생 분석 필요
			//잘못된 자료 입력 시도
			//이름, 전화번호가 중복된 경우
			//기타...
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}
	
	
	//검색 액션 메소드
	//->외부에서 key, value를 전달 받는다.
	//->key 변수는 검색 기준 역할, value 변수는 검색값 역할
	public List<Member> memberList(String key, String value) {
		
		//회원번호, 이름, 전화번호 기준 등 여러가지 기준 검색 가능
		//-> key 변수의 값에 따라서 기준이 달라진다.
		
		List<Member> result = new ArrayList<Member>();
		
		/*
		CREATE OR REPLACE VIEW membersView
		AS
		SELECT mid, name_, phone, email, regDate, deptName
		FROM members m, dept d
		WHERE m.deptId = d.deptId;
		
		SELECT mid, name_, phone, email, regDate, deptName
		FROM membersView

		SELECT mid, name_, phone, email, regDate, deptName
    		, (SELECT NVL(SUM(fee),0) FROM membersFee WHERE mid=m.mid) feeTotal
		FROM membersView m
		*/
		
		String sql = "SELECT mid, name_, phone, email, regDate, deptName, (SELECT NVL(SUM(fee),0) FROM membersFee WHERE mid=m.mid) feeTotal FROM membersView m";
		
		//검색 기준에 따른 WHERE 구문 추가
		//주의) 식별자는 PreparedStatement 클래스의 바인딩 대상이 아니므로 문자열로만 처리 가능.
		//주의) 쿼리문 앞에 공백 문자 삽입
		switch (key) {
		case "mid":
			sql += " WHERE LOWER(mid) = LOWER(?)";
			break;
		case "name_":
			sql += " WHERE INSTR(LOWER(name_), LOWER(?)) > 0";
			break;
		case "phone":
			sql += " WHERE INSTR(phone, ?) > 0";
			break;
		case "email":
			sql += " WHERE INSTR(email, ?) > 0";
			break;
		case "regDate":
			sql += " WHERE INSTR(TO_CHAR(regDate, 'YYYY-MM-DD'), ?) > 0";
			break;
		case "deptName":
			sql += " WHERE INSTR(deptName, ?) > 0";
			break;
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			//검색 기준에 따른 검색값 바인딩 추가
			pstmt.setString(1, value);
			
			ResultSet rs = pstmt.executeQuery();
			
			//주의) 검색 결과가 존재하는 경우만 반복문 실행 가능 -> 채워진 컬렉션 반환
			//주의) 검색 결과가 없는 경우 빈 컬렉션 반환
			while (rs.next()) {
				
				String mid = rs.getString("mid");
				String name_ = rs.getString("name_");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				LocalDate regDate = rs.getDate("regDate").toLocalDate();
				String deptName = rs.getString("deptName");
				
				int feeTotal = rs.getInt("feeTotal");
				
				Member m = new Member(mid, name_, phone, email, regDate, deptName, feeTotal);
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}
	 

	//회비 입력 액션 메소드
	public int memberFeeAdd(Member m) {
		int result = 0;
		
		String sql = "INSERT INTO membersFee (mid, feeDate, fee) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMid());
			pstmt.setString(2, m.getFeeDate().toString());
			pstmt.setInt(3, m.getFee());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}
	
	
	public List<Member> memberFeeList(String value) {
		
		List<Member> result = new ArrayList<Member>();
		
		String sql = "SELECT mid, feeDate, fee FROM membersFee WHERE mid=? ORDER BY feeDate";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String mid = rs.getString("mid");
				LocalDate feeDate = rs.getDate("feeDate").toLocalDate();
				int fee = rs.getInt("fee");

				Member m = new Member(mid, feeDate, fee);
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}
	
	public int memberFeeTotal(String key, String value) {
		
		int result = 0;
		
		String sql = "SELECT NVL(SUM(fee),0) feeTotal FROM membersFee";
		if (key.equals("mid")) {
			sql += " WHERE mid=?";
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			if (key.equals("mid")) {
				pstmt.setString(1, value);
			}
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				result = rs.getInt("feeTotal");
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				DBConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}
	
}
