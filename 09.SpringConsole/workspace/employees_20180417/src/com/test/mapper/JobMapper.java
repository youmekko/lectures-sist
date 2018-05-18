package com.test.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.test.domain.Employee;

public class JobMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		String job_id = rs.getString("job_id");
		String job_title = rs.getString("job_title");
		int deleteCheck = rs.getInt("deleteCheck");
		
		Employee e = new Employee();
		e.setJob_id(job_id);
		e.setJob_title(job_title);
		e.setDeleteCheck(deleteCheck);
		
		return e;
	}

}
