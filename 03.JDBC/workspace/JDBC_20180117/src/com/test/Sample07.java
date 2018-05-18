package com.test;

import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Sample07 {
	
	public static void main(String[] args) {

		// employees, departments, jobs, regions 테이블을 (INNER)조인한 후 전체 출력하는 프로그램 작성.
		String sql = "SELECT eid, name_, ssn, hiredate, phone, reg_name, dept_name, job_title, basicpay, extrapay, (basicpay + extrapay) pay FROM employees e, regions r, departments d, jobs j WHERE e.reg_id = r.reg_id AND e.dept_id = d.dept_id AND e.job_id = j.job_id";

		//주의) 날짜 패턴 지정시 대소문자 구분
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd"); 

		/*
		 * 출력예) 
		  1012 정한국 760909-1333333 99/10/16 018-2222-4242 강원 홍보부 사원 880,000 114,000 994,000
		  1054 정상호 810705-1212141 99/10/16 016-1919-4242 강원 홍보부 사원 980,000 114,000 1,094,000
		  1002 이순신 801007-1544236 00/11/29 010-4758-6532 경기 총무부 사원 1,320,000 200,000 1,520,000
		  ...
		 */

		Connection conn = null;
		Statement stmt = null;
		try {
			
			//데이터베이스 연결 액션 처리
			conn = DBConnection.connect();

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			
			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String eid = rs.getString("eid");
				String name_ = rs.getString("name_");
				String ssn = rs.getString("ssn");
				LocalDate hiredate = rs.getDate("hiredate").toLocalDate();
				String phone = rs.getString("phone");
				String reg_name = rs.getString("reg_name");
				String dept_name = rs.getString("dept_name");
				String job_title = rs.getString("job_title");
				int basicpay = rs.getInt("basicpay");
				int extrapay = rs.getInt("extrapay");
				int pay = rs.getInt("pay");

				// Display values
				System.out.printf("%s %s %s %s %s %s %s %s %,d %,d %,d%n",
						eid, name_, ssn
						, hiredate.format(formatter)
						, phone, reg_name, dept_name, job_title, basicpay, extrapay, pay);
			}
			rs.close();
			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				//데이터베이스 연결 종료 액션 처리
				DBConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");

	}

}
