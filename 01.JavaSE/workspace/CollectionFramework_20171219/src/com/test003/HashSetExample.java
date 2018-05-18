package com.test003;

import java.util.*;

public class HashSetExample {

	public static void main(String[] args) {
		
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "박길동"));
		set.add(new Student(1, "최길동")); //중복 객체(같은 학번) -> 입력 실패
		
		//Iterator를 이용한 반복문 출력
		//향상된 for를 이용한 반복문 출력
		for (Student s : set) {
			System.out.printf("%s:%s%n", s.getStudentNum(), s.getName());
		}

	}

}
