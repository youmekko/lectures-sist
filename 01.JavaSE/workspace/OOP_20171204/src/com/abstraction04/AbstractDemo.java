package com.abstraction04;

/* File name : AbstractDemo.java */
public class AbstractDemo {

	public static void main(String[] args) {
		
		/* Following is not allowed and would raise error */
		//Cannot instantiate the type Employee
		Employee e = new Employee("George W.", "Houston, TX", 43);
		
		System.out.println("\n Call mailCheck using Employee reference--");
		e.mailCheck();
		
	}
}