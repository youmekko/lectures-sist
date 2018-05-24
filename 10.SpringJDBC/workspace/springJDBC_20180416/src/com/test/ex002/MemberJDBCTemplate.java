package com.test.ex002;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

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
	public List<Member> deptList() {

		String sql = "SELECT deptId, deptName FROM dept ORDER BY deptId";
		List<Member> result = this.jdbcTemplateObject.query(sql, new DeptMapper());
		
		return result;
	}

	@Override
	public int memberAdd(Member m) {
		
		String sql = "INSERT INTO members (mid_, name_, phone, email, regDate, deptId) VALUES ((SELECT * FROM (SELECT CONCAT('M', LPAD(IFNULL(SUBSTRING(MAX(mid_), 2), 0) + 1, 2, 0)) AS newMid FROM members) m) , ?, ?, ?, ?, ?)";
		int result = this.jdbcTemplateObject.update(sql, m.getName_(), m.getPhone(), m.getEmail(), m.getRegDate().toString(), m.getDeptId());
		return result;
		
	}

}
