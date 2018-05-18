package com.test;

public class Sample015 {

	public static void main(String[] args) {

		// 산술 연산자
		// +, -, *, /, %, ++, --
		//주의) 나누기 연산에서 정수 나누기 정수는 정수 결과(몫)
		//주의) 나누기 연산에서 실수 결과를 얻기를 원하면 실수 항목이 포함되어야 한다.
		
		int a = 10;
		int b = 20;
		int c = 25;
		int d = 25;

		//(이항 연산자)
		//int 자료 + int 자료 => int 결과
		//문자열(String) 자료 + 임의의 자료 => 문자열 결과 
		System.out.println("a + b = " + (a + b));
		
		System.out.println("a - b = " + (a - b));
		System.out.println("a * b = " + (a * b));
		
		//int 자료 / int 자료 => int 자료(몫 연산)
		System.out.println("b / a = " + (b / a));
		System.out.println("c / a = " + (c / a));
		
		//강제(명시적) 형변환 포함
		System.out.println("c / (double)a = " + (c / (double)a));

		//int 자료 % int 자료 => int 자료(나머지 연산)
		System.out.println("b % a = " + (b % a));
		System.out.println("c % a = " + (c % a));
		

		//(단항 연산자)증감 연산자
		//현재 변수의 값을 +1, -1 연산
		//주의) 전위형, 후위형
		System.out.println("(a++)   = " + (a++));
		System.out.println("++a   = " + ++a);
		System.out.println("a++   = " + a++);
		System.out.println("(b--)   = " + (b--));
		System.out.println("--b   = " + --b);
		System.out.println("b--   = " + b--);

	}

}
