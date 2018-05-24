package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberJDBCTemplate implements MemberDAO {

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Member> memberList() {
		/*
		CREATE OR REPLACE VIEW membersView
		AS
		SELECT mid_, name_, phone, email, regDate, deptName
		FROM members m, dept d
		WHERE m.deptId = d.deptId;
		*/
		String sql = "SELECT mid_, name_, phone, email, regDate, deptName FROM membersView";
		List<Member> result = this.jdbcTemplateObject.query(sql, new MemberMapper());
		return result;
	}
	
	@Override
	public List<Member> memberList(String key, String value) {
		/*
		CREATE OR REPLACE VIEW membersView
		AS
		SELECT mid_, name_, phone, email, regDate, deptName
		FROM members m, dept d
		WHERE m.deptId = d.deptId;
		*/
		String sql = "SELECT mid_, name_, phone, email, regDate, deptName FROM membersView";
		// key, value를 이용한 검색 조건 지정
		switch (key) {
		case "mid_":
			sql += " WHERE mid_ = ?";
			break;
		case "name_":
			sql += " WHERE INSTR(name_, ?)";
			break;
		case "phone":
			sql += " WHERE INSTR(phone, ?)";
			break;
		case "email":
			sql += " WHERE INSTR(email, ?)";
			break;
		case "regDate":
			sql += " WHERE INSTR(regDate, ?)";
			break;
		case "deptName":
			sql += " WHERE INSTR(deptName, ?)";
			break;
		}
		sql += " ORDER BY mid_";
		
		List<Member> result = this.jdbcTemplateObject.query(sql, new MemberMapper(), value);
		return result;
	}

	@Override
	public List<Member> deptList() {

		String sql = "SELECT deptId, deptName FROM dept ORDER BY deptId";
		List<Member> result = this.jdbcTemplateObject.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Member m = new Member();
				m.setDeptId(rs.getString("deptId"));
				m.setDeptName(rs.getString("deptName"));
				
				return m;
				
			}
			
		});
		
		return result;
	}

	@Override
	public int memberAdd(Member m) {
		
		String sql = "INSERT INTO members (mid_, name_, phone, email, regDate, deptId) VALUES ((SELECT * FROM (SELECT CONCAT('M', LPAD(IFNULL(SUBSTRING(MAX(mid_), 2), 0) + 1, 2, 0)) AS newMid FROM members) m) , ?, ?, ?, ?, ?)";
		int result = this.jdbcTemplateObject.update(sql, m.getName_(), m.getPhone(), m.getEmail(), m.getRegDate().toString(), m.getDeptId());
		return result;
		
	}

}
