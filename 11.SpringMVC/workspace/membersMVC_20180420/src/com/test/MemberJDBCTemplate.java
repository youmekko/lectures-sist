package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberJDBCTemplate implements MemberDAO {
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Member> list() {
		/*
		 * CREATE VIEW membersView 
		 * AS 
		 * SELECT mid_, name_, phone, email, regDate, deptName 
		 * FROM members INNER JOIN dept 
		 * USING(deptID) 
		 * ORDER BY mid_;
		 */
		String sql = "SELECT mid_, name_, phone, email, regDate, deptName FROM membersView ORDER BY mid_";
		List<Member> list = this.jdbcTemplate.query(sql, new MemberMapper());
		return list;
	}

	@Override
	public List<Member> list(String key, String value) {
		/*
		 * CREATE VIEW membersView 
		 * AS 
		 * SELECT mid_, name_, phone, email, regDate, deptName 
		 * FROM members INNER JOIN dept 
		 * USING(deptID) 
		 * ORDER BY mid_;
		 */
		String sql = "SELECT mid_, name_, phone, email, regDate, deptName FROM membersView";
		
		// key, value를 이용한 검색 조건 지정
		// ->key가 "ALL"인 경우는 전체 출력.
		switch (key) {
		case "ALL":
			sql += "";
			break;
		case "mid_":
			sql += " WHERE mid_ = ?";
			break;
		case "name_":
			sql += " WHERE INSTR(LOWER(name_), LOWER(?))";
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
		
		List<Member> list = null;
		
		if (key.equals("ALL")) {
			list = this.jdbcTemplate.query(sql, new MemberMapper());
		} else {
			list = this.jdbcTemplate.query(sql, new MemberMapper(), value);
		}
		
		return list;
	}

	@Override
	public int memberAdd(Member m) throws DataAccessException {
		
		String sql = "INSERT INTO members (mid_, name_, phone, email, regDate, deptId) VALUES ((SELECT * FROM (SELECT CONCAT('M', LPAD(IFNULL(SUBSTRING(MAX(mid_), 2), 0) + 1, 2, 0)) AS newMid FROM members) m) , ?, ?, ?, ?, ?)";
		int result = this.jdbcTemplate.update(sql, m.getName_(), m.getPhone(), m.getEmail(), m.getRegDate(), m.getDeptId());
		
		return result;
	}

	
	
	@Override
	public List<Member> deptList() {
		String sql = "SELECT deptId, deptName FROM dept ORDER BY deptId";
		List<Member> list = this.jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

				Member m = new Member();
				m.setDeptId(rs.getString("deptId"));
				m.setDeptName(rs.getString("deptName"));
				
				return m;
			}
			
		});
		return list;
	}

	@Override
	public int totalCount() {
		String sql = "SELECT COUNT(*) AS totalCount FROM membersView";
		int result = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return result;
	}

	@Override
	public int memberRemove(String mid_) throws DataAccessException {
		
		String sql = "DELETE FROM members WHERE mid_=?";
		int result = this.jdbcTemplate.update(sql, mid_);
		
		return result;
	}

	@Override
	public int memberModify(Member m) throws DataAccessException {
		
		String sql = "UPDATE members SET name_ = ?, phone = ?, email = ?, regDate = ?, deptId = ? WHERE mid_ = ?";
		int result = this.jdbcTemplate.update(sql, m.getName_(), m.getPhone(), m.getEmail(), m.getRegDate(), m.getDeptId(), m.getMid_());
		
		return result;
	}

}
