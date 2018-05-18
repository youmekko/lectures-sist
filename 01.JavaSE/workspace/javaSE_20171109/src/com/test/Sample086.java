package com.test;

public class Sample086 {

	public static void main(String[] args) {
		
		//StringBuilder 클래스
		//일반적인 String 클래스를 이용한 문자열 결합 연산은 메모리에 쓰레기 객체를 많이 발생시킨다.
		//문자열의 불변 특성 때문이다.
		//예를 들어, "ABC" + "DEF" => "ABCDEF" 연산 수행시 "ABC" 문자열은 쓰레기 객체가 되고, "ABCDEF" 객체가 반환된다.
		//-> StringBuilder 클래스의 append() 메소드를 이용하는 것을 권장.
		
		//여러개의 문자열을 하나의 문자열로 결합하는 액션
		String[] books = { "이것이 자바다", "자바의 정석", "JSP 웹프로그래밍"
				, "스프링 웹프로젝트", "안드로이드 프로그래밍"
				, "오라클 SQL과 PL/SQL" };
		
		//+ 연산자
		String result = "";
		for (int a=0; a<books.length; ++a) {
			result += String.format("%d) %s%n", (a+1), books[a]);
		}
		System.out.println(result);
		
		//append() 메소드
		StringBuilder sb = new StringBuilder();
		for (int a=0; a<books.length; ++a) {
			sb.append(String.format("%d) %s%n", (a+1), books[a]));
		}
		System.out.println(sb.toString());

	}

}
