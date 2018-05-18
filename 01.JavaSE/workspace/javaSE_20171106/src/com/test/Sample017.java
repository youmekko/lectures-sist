package com.test;

public class Sample017 {

	public static void main(String[] args) {
		
		//산술연산자 주의사항
		//부동소수점수 연산시 부정확한 결과
		
		int a = 1;
		double b = 0.1;
		int c = 7;
		
		//1 - (0.1 * 7) => 1 - 0.7 => 0.3(예상) => 0.29999999999999993(실제)
		double result = a - (b * c);
		System.out.println(result);
		
		
		//부동소수점수를 정수로 표현한 후 연산
		//((1*10) - 7) / 10.0 => (10 - 7) / 10.0 => 3 / 10.0 => 0.3(실제)
		double d = ((a * 10) - c) / 10.0;
		System.out.println(d);
		

	}

}
