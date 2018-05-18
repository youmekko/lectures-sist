package com.test.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.test.domain.Employee;

public class DepartmentMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

		String dept_id = rs.getString("dept_id");
		String dept_name = rs.getString("dept_name");
		int deleteCheck = rs.getInt("deleteCheck");
		
		Employee e = new Employee();
		e.setDept_id(dept_id);
		e.setDept_name(dept_name);
		e.setDeleteCheck(deleteCheck);
		
		return e;
	}

}
