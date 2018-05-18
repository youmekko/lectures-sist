package com.test;

public class Sample018 {

	public static void main(String[] args) {
		
		//산술연산자 주의사항
		//피연산자가 0인 경우 나누기, 나머지 연산 불가
		
		int a = 10;
		int b = 0;
		double c = 0.0;

		//어떤 값을 0으로 나누기 시도하면 예외발생
		//java.lang.ArithmeticException: / by zero
		//System.out.println(a / b);
		
		//어떤 값을 0.0으로 나누기 시도하면 무한대 결과
		//Infinity
		System.out.println(a / c);
		

	}

}
