package com.test;

public class Sample083 {

	public static void main(String[] args) {
		
		//String 클래스의 indexOf() 메소드
		
		//책 제목들 중에서 특정 단어가 포함된 책 검색
		
		//책 제목들 -> 배열을 이용해서 준비
		String[] books = { "이것이 자바다", "자바의 정석", "JSP 웹프로그래밍"
				, "스프링 웹프로젝트", "안드로이드 프로그래밍"
				, "오라클 SQL과 PL/SQL" };
		
		String keyword = "자바";
		
		//배열 탐색 전용 for문
		for (String book : books) {
			if (book.indexOf(keyword) >= 0) {
				System.out.println(book);
			}
		}
		

	}

}
