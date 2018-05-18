package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

//자료 저장소(MySQL 데이터베이스)에 대한 액션 클래스
public class LoginDAO {
	
	//로그인 검증 메소드
	public Login login(Login login) {
		Login result = null;
		
		//로그인 확인 절차 진행
		//성공하면 Login 객체 반환. id_, grade 정보 저장.
		//실패하면 NULL 반환.
		String sql = "SELECT * FROM	login WHERE id_=? AND pw_=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();

			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			pstmt.setString(1, login.getId_());
			pstmt.setString(2, login.getPw_());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String id_ = rs.getString("id_");
				int grade = rs.getInt("grade");
				result = new Login(id_, grade);
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
				MySQLConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}	
		
		return result;
	}

}
