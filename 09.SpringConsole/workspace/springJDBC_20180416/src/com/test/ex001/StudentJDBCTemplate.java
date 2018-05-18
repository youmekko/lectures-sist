package com.test.ex001;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Student> studentList() {
		String sql = "SELECT id, name_, age FROM student";
		List<Student> result = this.jdbcTemplateObject.query(sql, new StudentMapper());
		return result;
	}

	@Override
	public int studentAdd(Student s) {
		
		String sql = "INSERT INTO student (name_, age) VALUES (?, ?)";
		int result = this.jdbcTemplateObject.update(sql, s.getName_(), s.getAge());
		System.out.println("Created Record Name = " + s.getName_() + " Age = " + s.getAge());
		return result;
		
	}

}
