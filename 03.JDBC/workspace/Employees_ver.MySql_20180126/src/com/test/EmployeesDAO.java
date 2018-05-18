package com.test;

import java.sql.*;
import java.util.*;

//자료 저장소(MySQL 데이터베이스)에 대한 액션 클래스
public class EmployeesDAO {
	
	
	//지역 정보 출력 메소드->삭제 가능 여부 포함
	public List<Employees> regionList() {
		List<Employees> result = new ArrayList<Employees>();
		
		String sql = "SELECT reg_id, reg_name, (SELECT COUNT(*) FROM employees WHERE reg_id = r.reg_id) AS deleteCheck FROM regions r ORDER BY reg_id";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String reg_id = rs.getString("reg_id");
				String reg_name = rs.getString("reg_name");
				int deleteCheck = rs.getInt("deleteCheck");
				
				Employees e = new Employees();
				e.setReg_id(reg_id);
				e.setReg_name(reg_name);
				e.setDeleteCheck(deleteCheck);
				
				result.add(e);
				
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
				MySQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}
	
	
	//지역 정보 삭제 메소드
	public int regionDelete(String reg_id) {
		int result = 0;
		
		String sql = "DELETE FROM regions WHERE reg_id=?";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			pstmt.setString(1, reg_id);
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
				MySQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}
	
	//지역 정보 입력 메소드
	public int regionInsert(String reg_name) {
		int result = 0;
		
		String sql = "INSERT INTO regions (reg_id, reg_name) VALUES ((SELECT * FROM (SELECT CONCAT('REG', LPAD(IFNULL(SUBSTRING(MAX(reg_id), 4), 0) + 1, 2, 0)) AS newMid FROM regions) m), ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			pstmt.setString(1, reg_name);
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
				MySQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}

}
