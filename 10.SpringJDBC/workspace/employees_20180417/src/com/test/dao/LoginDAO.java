package com.test.dao;

import org.springframework.dao.DataAccessException;

import com.test.domain.Login;

public interface LoginDAO {

	public Login login(Login login) throws DataAccessException;
	
}
