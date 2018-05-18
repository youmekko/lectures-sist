package com.test.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.test.domain.Employee;

public class RegionMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		String reg_id = rs.getString("reg_id");
		String reg_name = rs.getString("reg_name");
		int deleteCheck = rs.getInt("deleteCheck");
		
		Employee e = new Employee();
		e.setReg_id(reg_id);
		e.setReg_name(reg_name);
		e.setDeleteCheck(deleteCheck);
		
		return e;
	}

}
