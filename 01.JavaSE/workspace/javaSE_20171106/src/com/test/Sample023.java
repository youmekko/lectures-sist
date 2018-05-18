package com.test;

public class Sample023 {

	public static void main(String[] args) {
		
		//비교 연산자 주의사항
		//char과 int 자료형의 비교
		//char과 char 자료형의 비교
		
		char a = 'A';
		int b = 65;
		char c = 'a';
		
		//char vs int => int vs int
		System.out.println(a == b);
		
		//문자도 크기 비교 가능
		//->유니코드
		System.out.println(a < c);

	}

}
