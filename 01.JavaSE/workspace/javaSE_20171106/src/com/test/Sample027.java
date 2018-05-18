package com.test;

public class Sample027 {

	public static void main(String[] args) {
		
		//복합 대입 연산자
		//+=, -=, *=, /=, %=, &=, !=, ^=, <<=, >>=, >>>=
		//산술 연산의 결과를 자기 자신에게 다시 대입하는 연산
		
		int a = 20;
		int b = 5;
		
		a += b;
		System.out.println(b);
		System.out.println(a);
		
		a -= b;
		System.out.println(a);
				
		a *= b;
		System.out.println(a);
		
		a /= b;
		System.out.println(a);
		
		a = a + 1;
		a += 1;
		++a;
		System.out.println(a);
		

	}

}
