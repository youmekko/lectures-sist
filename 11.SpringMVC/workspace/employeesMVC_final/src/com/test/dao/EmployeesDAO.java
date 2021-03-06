package com.test.dao;

import java.util.List;

import com.test.domain.Employees;

public interface EmployeesDAO {
	
	public List<Employees> list(String key);
	public List<Employees> list(String key, String value);
	public List<Employees> regionList();
	public List<Employees> departmentList();
	public List<Employees> jobList();
	
	public int add(Employees emp);
	public int regionInsert(String reg_name);
	public int departmentInsert(String dept_name);
	public int jobInsert(Employees emp);
	
	public int getminbasicpay(String job_id);
	
	public int pictureAdd(Employees emp);
	public int pictureModify(Employees emp);
	
	public int remove(String eid);
	public int regionDelete(String reg_id);
	public int departmentDelete(String dept_id);
	public int jobDelete(String job_id);
	public int pictureRemove(String eid);
	
	public int modify(Employees emp);
	public int regionUpdate(Employees emp);
	public int departmentUpdate(Employees emp);
	public int jobUpdate(Employees emp);
	
}
