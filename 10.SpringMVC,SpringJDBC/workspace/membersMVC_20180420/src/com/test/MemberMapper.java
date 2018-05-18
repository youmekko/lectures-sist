package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		String mid_ = rs.getString("mid_");
		String name_ = rs.getString("name_");
		String phone = rs.getString("phone");
		String email = rs.getString("email");
		String regDate = rs.getString("regDate");
		String deptName = rs.getString("deptName");

		Member m = new Member();
		m.setMid_(mid_);
		m.setName_(name_);
		m.setPhone(phone);
		m.setEmail(email);
		m.setRegDate(regDate);
		m.setDeptName(deptName);
		
		return m;
	}

}
