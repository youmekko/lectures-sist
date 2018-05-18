package com.test;

public class Sample013 {

	public static void main(String[] args) {
		
		//대입 연산자
		//자료형 변수 = 값 또는 표현식;
		
		int a = 10;
		int b = 10, c = 20;
		
		int d, e, f;
		d = e = f = 10;
		
		int g = 10;
		System.out.println(g);
		
		g = g + 10;
		System.out.println(g);
		
		//결과값이 double 자료형이므로 int 자료형 변수에 대입할 수 없다.
		//->강제(명시적) 형변환 필요
		g = g + 10.0;
		System.out.println(g);

	}

}
