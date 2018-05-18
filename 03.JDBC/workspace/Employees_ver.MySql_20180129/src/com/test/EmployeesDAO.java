package com.test;

import java.sql.*;
import java.util.*;

//자료 저장소(MySQL 데이터베이스)에 대한 액션 클래스
public class EmployeesDAO {
	
	//직원 정보 정렬 출력 메소드
	//->전체 출력시 사번, 이름 등 기준으로 정렬 지원
	public List<Employees> list(String key) {
		List<Employees> result = new ArrayList<Employees>();

		
		/*
		CREATE VIEW empView AS
		SELECT 
		    eid,
		    name_,
		    ssn,
		    hiredate,
		    phone,
		    e.reg_id,
		    reg_name,
		    e.dept_id,
		    dept_name,
		    e.job_id,
		    job_title,
		    basicpay,
		    extrapay,
		    basicpay + extrapay AS pay
		FROM
		    employees e
		        INNER JOIN
		    regions r ON e.reg_id = r.reg_id
		        INNER JOIN
		    departments d ON e.dept_id = d.dept_id
		        INNER JOIN
		    jobs j ON e.job_id = j.job_id
		ORDER BY eid;
		*/
		
		String sql = "SELECT eid, name_, ssn, hiredate, phone, reg_id, reg_name, dept_id, dept_name, job_id, job_title, basicpay, extrapay, pay FROM  empView";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			//정렬 기준에 따른 ORDER BY 구문 추가
			switch (key) {
			case "eid":
				sql += " ORDER BY eid";
				break;
			case "name_":
				sql += " ORDER BY name_";
				break;
			case "reg_name":
				sql += " ORDER BY reg_name";
				break;
			case "dept_name":
				sql += " ORDER BY dept_name";
				break;
			case "job_title":
				sql += " ORDER BY job_title";
				break;
			}
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				Employees e = new Employees();
				e.setEid(rs.getString("eid"));
				e.setName_(rs.getString("name_"));
				e.setSsn(rs.getString("ssn"));
				e.setHiredate(rs.getString("hiredate"));
				e.setPhone(rs.getString("phone"));
				e.setReg_id(rs.getString("reg_id"));
				e.setDept_id(rs.getString("dept_id"));
				e.setJob_id(rs.getString("job_id"));
				e.setReg_name(rs.getString("reg_name"));
				e.setDept_name(rs.getString("dept_name"));
				e.setJob_title(rs.getString("job_title"));
				e.setBasicpay(rs.getInt("basicpay"));
				e.setExtrapay(rs.getInt("extrapay"));
				e.setPay(rs.getInt("pay"));
				
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
	
	//직원 정보 검색 출력 메소드
	//->사번, 이름 등 기준으로 검색하고 사번 정렬된 상태로 출력.
	public List<Employees> list(String key, String value) {
		List<Employees> result = new ArrayList<Employees>();
		
		
		/*
		CREATE VIEW empView AS
		SELECT 
		    eid,
		    name_,
		    ssn,
		    hiredate,
		    phone,
		    e.reg_id,
		    reg_name,
		    e.dept_id,
		    dept_name,
		    e.job_id,
		    job_title,
		    basicpay,
		    extrapay,
		    basicpay + extrapay AS pay
		FROM
		    employees e
		        INNER JOIN
		    regions r ON e.reg_id = r.reg_id
		        INNER JOIN
		    departments d ON e.dept_id = d.dept_id
		        INNER JOIN
		    jobs j ON e.job_id = j.job_id
		ORDER BY eid;
		*/
		
		String sql = "SELECT eid, name_, ssn, hiredate, phone, reg_id, reg_name, dept_id, dept_name, job_id, job_title, basicpay, extrapay, pay FROM  empView";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			//검색 기준에 따른 WHERE 구문 추가
			switch (key) {
			case "eid":
				sql += " WHERE eid = ?";
				break;
			case "name_":
				sql += " WHERE INSTR(name_, ?) > 0";
				break;
			case "reg_name":
				sql += " WHERE INSTR(reg_name, ?) > 0";
				break;
			case "dept_name":
				sql += " WHERE INSTR(dept_name, ?) > 0";
				break;
			case "job_title":
				sql += " WHERE INSTR(job_title, ?) > 0";
				break;
			}
			sql += " ORDER BY eid";
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				Employees e = new Employees();
				e.setEid(rs.getString("eid"));
				e.setName_(rs.getString("name_"));
				e.setSsn(rs.getString("ssn"));
				e.setHiredate(rs.getString("hiredate"));
				e.setPhone(rs.getString("phone"));
				e.setReg_id(rs.getString("reg_id"));
				e.setDept_id(rs.getString("dept_id"));
				e.setJob_id(rs.getString("job_id"));
				e.setReg_name(rs.getString("reg_name"));
				e.setDept_name(rs.getString("dept_name"));
				e.setJob_title(rs.getString("job_title"));
				e.setBasicpay(rs.getInt("basicpay"));
				e.setExtrapay(rs.getInt("extrapay"));
				e.setPay(rs.getInt("pay"));
				
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

	//직원 정보 입력 메소드
	public int add(Employees emp) {
		int result = 0;
		
		String sql = "INSERT INTO employees  (eid, name_, ssn, hiredate, phone, reg_id, dept_id, job_id, basicpay, extrapay) VALUES ((SELECT * FROM (SELECT CONCAT('E', LPAD(IFNULL(SUBSTRING(MAX(eid), 2), 0) + 1, 4, 0)) AS newMid FROM employees) m), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			pstmt.setString(1, emp.getName_());
			pstmt.setString(2, emp.getSsn());
			pstmt.setString(3, emp.getHiredate());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getReg_id());
			pstmt.setString(6, emp.getDept_id());
			pstmt.setString(7, emp.getJob_id());
			pstmt.setInt(8, emp.getBasicpay());
			pstmt.setInt(9, emp.getExtrapay());
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
	
	//직원 정보 삭제 메소드
	public int remove(String eid) {
		int result = 0;
		
		String sql = "DELETE FROM employees WHERE eid = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			pstmt.setString(1, eid);
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
	
	
	//부서 정보 출력 메소드->삭제 가능 여부 포함
	public List<Employees> departmentList() {
		List<Employees> result = new ArrayList<Employees>();
		
		String sql = "SELECT dept_id, dept_name, (SELECT COUNT(*) FROM employees WHERE dept_id = d.dept_id) AS deleteCheck FROM departments d ORDER BY dept_id";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String dept_id = rs.getString("dept_id");
				String dept_name = rs.getString("dept_name");
				int deleteCheck = rs.getInt("deleteCheck");
				
				Employees e = new Employees();
				e.setDept_id(dept_id);
				e.setDept_name(dept_name);
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
	
	
	//부서 정보 삭제 메소드
	public int departmentDelete(String dept_id) {
		int result = 0;
		
		String sql = "DELETE FROM departments WHERE dept_id=?";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			pstmt.setString(1, dept_id);
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
	
	//부서 정보 입력 메소드
	public int departmentInsert(String dept_name) {
		int result = 0;
		
		String sql = "INSERT INTO departments (dept_id, dept_name) VALUES ((SELECT * FROM (SELECT CONCAT('DEPT', LPAD(IFNULL(SUBSTRING(MAX(dept_id), 5), 0) + 1, 2, 0)) AS newMid FROM departments) m), ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			pstmt.setString(1, dept_name);
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



	//직위 정보 출력 메소드->삭제 가능 여부 포함
	public List<Employees> jobList() {
		List<Employees> result = new ArrayList<Employees>();
		
		String sql = "SELECT job_id, job_title, (SELECT COUNT(*) FROM employees WHERE job_id = d.job_id) AS deleteCheck FROM jobs d ORDER BY job_id";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String job_id = rs.getString("job_id");
				String job_title = rs.getString("job_title");
				int deleteCheck = rs.getInt("deleteCheck");
				
				Employees e = new Employees();
				e.setJob_id(job_id);
				e.setJob_title(job_title);
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
	
	
	//직위 정보 삭제 메소드
	public int jobDelete(String job_id) {
		int result = 0;
		
		String sql = "DELETE FROM jobs WHERE job_id=?";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			pstmt.setString(1, job_id);
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
	
	//직위 정보 입력 메소드
	public int jobInsert(String job_title) {
		int result = 0;
		
		String sql = "INSERT INTO jobs (job_id, job_title) VALUES ((SELECT * FROM (SELECT CONCAT('JOB', LPAD(IFNULL(SUBSTRING(MAX(job_id), 4), 0) + 1, 2, 0)) AS newMid FROM jobs) m), ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = MySQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			//외부데이터 바인딩 과정 추가하는 위치
			pstmt.setString(1, job_title);
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
