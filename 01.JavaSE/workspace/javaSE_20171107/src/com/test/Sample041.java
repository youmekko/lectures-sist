package com.test;

public class Sample041 {

	public static void main(String[] args) {
		
		//(로컬) 변수의 사용 범위
		
		int a = 10;
		
		if (true) {
			int b = 20;
			
			System.out.println(a);
			System.out.println(b);
		}
		
		System.out.println(a);
		
		//b cannot be resolved to a variable
		System.out.println(b);

	}

}
