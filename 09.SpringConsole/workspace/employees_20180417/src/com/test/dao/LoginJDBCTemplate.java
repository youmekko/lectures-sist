package com.test.dao;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.domain.Login;
import com.test.mapper.LoginMapper;

public class LoginJDBCTemplate implements LoginDAO {

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Login login(Login login) throws DataAccessException {
		
		String sql = "SELECT id_, grade FROM login WHERE id_=? AND pw_=?";
		
		Login result = this.jdbcTemplateObject.queryForObject(sql, new LoginMapper(), login.getId_(), login.getPw_());
		
		return result;
	}

}
