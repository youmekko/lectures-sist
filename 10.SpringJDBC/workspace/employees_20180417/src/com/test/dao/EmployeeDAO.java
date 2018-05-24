package com.test.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.test.domain.Employee;

public interface EmployeeDAO {

	public List<Employee> list(String key) throws DataAccessException;
	public List<Employee> list(String key, String value) throws DataAccessException;
	public int add(Employee emp) throws DataAccessException;
	public int remove(String eid) throws DataAccessException;
	
	public List<Employee> regionList() throws DataAccessException;
	public int regionDelete(String reg_id) throws DataAccessException;
	public int regionInsert(String reg_name) throws DataAccessException;
	
	public List<Employee> departmentList() throws DataAccessException;
	public int departmentDelete(String dept_id) throws DataAccessException;
	public int departmentInsert(String dept_name) throws DataAccessException;
	
	public List<Employee> jobList() throws DataAccessException;
	public int jobDelete(String job_id) throws DataAccessException;
	public int jobInsert(String job_title) throws DataAccessException;
	
}
