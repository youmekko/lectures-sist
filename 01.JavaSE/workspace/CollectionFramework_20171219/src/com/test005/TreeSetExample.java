package com.test005;

import java.util.*;

public class TreeSetExample {

	public static void main(String[] args) {
		
		//Student 클래스에서 Comparable 인터페이스 구현 필요
		TreeSet<Student> students = new TreeSet<Student>();
		
		students.add(new Student("hong", 70));
		students.add(new Student("park", 96));
		students.add(new Student("choi", 80));
		students.add(new Student("kim", 60));
		
		Student s1 = students.first();
		System.out.printf("%s:%s%n", s1.getId(), s1.getScore());
		
		Student s2 = students.last();
		System.out.printf("%s:%s%n", s2.getId(), s2.getScore());

	}

}
