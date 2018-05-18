package com.test;

public class Sample020 {

	public static void main(String[] args) {
		
		//String 자료형(Reference 타입)
		//문자열 연결(결합) 연산자
		//문자열 + 문자열 => 문자열
		//문자열 + 다른 자료 => 문자열
		
		String a = "A";
		String b = "B";
		int c = 10;
		int d = 20;
		System.out.println(a + b);
		System.out.println(a + c);
		System.out.println(a + c + d);
		System.out.println(a + (c + d));
		System.out.println(c + d + a);
		System.out.println((c + d) + a);

	}

}
