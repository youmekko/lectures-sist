package com.test.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.domain.Employee;
import com.test.mapper.DepartmentMapper;
import com.test.mapper.EmployeeMapper;
import com.test.mapper.JobMapper;
import com.test.mapper.RegionMapper;

public class EmployeeJDBCTemplate implements EmployeeDAO {
	
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}	

	@Override
	public List<Employee> list(String key) throws DataAccessException {
		
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
		
		List<Employee> result = this.jdbcTemplateObject.query(sql, new EmployeeMapper());
		
		return result;
	}

	@Override
	public List<Employee> list(String key, String value) throws DataAccessException {
		
		String sql = "SELECT eid, name_, ssn, hiredate, phone, reg_id, reg_name, dept_id, dept_name, job_id, job_title, basicpay, extrapay, pay FROM  empView";
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
		
		List<Employee> result = this.jdbcTemplateObject.query(sql, new EmployeeMapper(), value);
		
		return result;
	}

	@Override
	public int add(Employee emp) throws DataAccessException {
		String sql = "INSERT INTO employees  (eid, name_, ssn, hiredate, phone, reg_id, dept_id, job_id, basicpay, extrapay) VALUES ((SELECT * FROM (SELECT CONCAT('E', LPAD(IFNULL(SUBSTRING(MAX(eid), 2), 0) + 1, 4, 0)) AS newMid FROM employees) m), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = this.jdbcTemplateObject.update(sql, emp.getName_(), emp.getSsn(), emp.getHiredate(), emp.getPhone(), emp.getReg_id(), emp.getDept_id(), emp.getJob_id(), emp.getBasicpay(), emp.getExtrapay() );
		return result;
	}

	@Override
	public int remove(String eid) throws DataAccessException {
		String sql = "DELETE FROM employees WHERE eid = ?";
		int result = this.jdbcTemplateObject.update(sql, eid);
		return result;
	}

	@Override
	public List<Employee> regionList() throws DataAccessException {
		String sql = "SELECT reg_id, reg_name, (SELECT COUNT(*) FROM employees WHERE reg_id = r.reg_id) AS deleteCheck FROM regions r ORDER BY reg_id";
		List<Employee> result = this.jdbcTemplateObject.query(sql, new RegionMapper());
		return result;
	}

	@Override
	public int regionDelete(String reg_id) throws DataAccessException {
		String sql = "DELETE FROM regions WHERE reg_id=?";
		int result = this.jdbcTemplateObject.update(sql, reg_id);
		return result;
	}

	@Override
	public int regionInsert(String reg_name) throws DataAccessException {
		String sql = "INSERT INTO regions (reg_id, reg_name) VALUES ((SELECT * FROM (SELECT CONCAT('REG', LPAD(IFNULL(SUBSTRING(MAX(reg_id), 4), 0) + 1, 2, 0)) AS newMid FROM regions) m), ?)";
		int result = this.jdbcTemplateObject.update(sql, reg_name);
		return result;
	}

	@Override
	public List<Employee> departmentList() throws DataAccessException {
		String sql = "SELECT dept_id, dept_name, (SELECT COUNT(*) FROM employees WHERE dept_id = d.dept_id) AS deleteCheck FROM departments d ORDER BY dept_id";
		List<Employee> result = this.jdbcTemplateObject.query(sql, new DepartmentMapper());
		return result;
	}

	@Override
	public int departmentDelete(String dept_id) throws DataAccessException {
		String sql = "DELETE FROM departments WHERE dept_id=?";
		int result = this.jdbcTemplateObject.update(sql, dept_id);
		return result;
	}

	@Override
	public int departmentInsert(String dept_name) throws DataAccessException {
		String sql = "INSERT INTO departments (dept_id, dept_name) VALUES ((SELECT * FROM (SELECT CONCAT('DEPT', LPAD(IFNULL(SUBSTRING(MAX(dept_id), 5), 0) + 1, 2, 0)) AS newMid FROM departments) m), ?)";
		int result = this.jdbcTemplateObject.update(sql, dept_name);
		return result;
	}

	@Override
	public List<Employee> jobList() throws DataAccessException {
		String sql = "SELECT job_id, job_title, (SELECT COUNT(*) FROM employees WHERE job_id = d.job_id) AS deleteCheck FROM jobs d ORDER BY job_id";
		List<Employee> result = this.jdbcTemplateObject.query(sql, new JobMapper());
		return result;
	}

	@Override
	public int jobDelete(String job_id) throws DataAccessException {
		String sql = "DELETE FROM jobs WHERE job_id=?";
		int result = this.jdbcTemplateObject.update(sql, job_id);
		return result;
	}

	@Override
	public int jobInsert(String job_title) throws DataAccessException {
		String sql = "INSERT INTO jobs (job_id, job_title) VALUES ((SELECT * FROM (SELECT CONCAT('JOB', LPAD(IFNULL(SUBSTRING(MAX(job_id), 4), 0) + 1, 2, 0)) AS newMid FROM jobs) m), ?)";
		int result = this.jdbcTemplateObject.update(sql, job_title);
		return result;
	}

}
