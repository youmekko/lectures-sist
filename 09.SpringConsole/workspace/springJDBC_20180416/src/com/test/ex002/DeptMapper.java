package com.test.ex002;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeptMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Member m = new Member();
		m.setDeptId(rs.getString("deptId"));
		m.setDeptName(rs.getString("deptName"));
		
		return m;
	}

}
