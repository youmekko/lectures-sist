package com.test.ex001;

import java.util.List;

public interface StudentDAO {
	
	public List<Student> studentList();
	
	public int studentAdd(Student s);

}
