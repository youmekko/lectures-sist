package com.test;

public class Sample024 {

	public static void main(String[] args) {
		
		//비교 연산자 주의사항
		//boolean 자료형의 비교

		boolean a = true;
		boolean b = false;
		boolean c = true;
		
		System.out.println(a == b);
		System.out.println(a != b);
		
		//boolean 자료형은 크기 비교 불가
		System.out.println(a > b);
		System.out.println(a >= c);
		
	}

}
