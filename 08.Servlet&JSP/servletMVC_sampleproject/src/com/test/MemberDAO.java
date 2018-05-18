package com.test;

import java.sql.*;
import java.util.*;
import java.time.*;

public class MemberDAO {

	// ��ü ��� ��¿� �޼ҵ�
	public List<Member> list() {
		List<Member> result = new ArrayList<Member>();

		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();

			

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
