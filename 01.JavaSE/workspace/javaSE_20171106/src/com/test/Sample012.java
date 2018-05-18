package com.test;

public class Sample012 {

	public static void main(String[] args) {
		
		//상수(Constants)
		//미리 정해진 값을 표현하는 방법
		//대표적인 상수로 PI는 3.141592... 라는 값을 가진다.
		//기본자료형은 모두 최소값, 최대값 상수를 가지고 있다.
		//int -> Integer.MIN_VALUE, Integer.MAX_VALUE
		//double -> Double.MIN_VALUE, Double.MAX_VALUE
		
		System.out.println(Math.PI);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
		
		int a = Integer.MAX_VALUE;
		System.out.println(a); //2147483647
		
		int b = Integer.MAX_VALUE + 1;
		System.out.println(b); //2147483647 + 1 => 2147483648(예상) => -2147483648(실제)
		
		
	}

}
