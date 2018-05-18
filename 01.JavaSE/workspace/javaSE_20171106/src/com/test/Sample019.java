package com.test;

public class Sample019 {

	public static void main(String[] args) {
		
		//산술연산자 주의사항
		//NaN : Not a Number
		
		int a = 10;
		double b = 0.0;
		
		//어떤 값을 0.0으로 나머지 연산 시도하면 NaN 결과
		//NaN
		System.out.println(a % b);
		
		
		String c = "100";
		int d = 100;
		//String + int => String
		System.out.println(c + d);
		//int + int => int
		System.out.println(Integer.valueOf(c) + d);

		String f = "NaN";
		//NaN + 어떤 값 => NaN
		System.out.println(Double.valueOf(f) + d);
		
		
	}

}
