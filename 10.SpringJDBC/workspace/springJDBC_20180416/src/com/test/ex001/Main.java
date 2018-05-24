package com.test.ex001;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
	     ApplicationContext context = new ClassPathXmlApplicationContext("/com/test/ex001/beans.xml");

	      StudentJDBCTemplate studentJDBCTemplate = 
	         (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
	      
	      System.out.println("------Records Creation--------" );
	      Student s1 = new Student();
	      s1.setName_("Zara");
	      s1.setAge(11);
	      studentJDBCTemplate.studentAdd(s1);
	      Student s2 = new Student();
	      s2.setName_("Nuha");
	      s2.setAge(12);
	      studentJDBCTemplate.studentAdd(s2);
	      
	      System.out.println("------Listing Multiple Records--------" );
	      List<Student> students = studentJDBCTemplate.studentList();
	      for (Student record : students) {
	         System.out.print("ID : " + record.getId() );
	         System.out.print(", Name : " + record.getName_() );
	         System.out.println(", Age : " + record.getAge());
	      }
	      
	      ((ClassPathXmlApplicationContext)context).close();
	      

	}

}
