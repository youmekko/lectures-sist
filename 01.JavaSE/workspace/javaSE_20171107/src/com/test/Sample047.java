package com.test;

public class Sample047 {

	public static void main(String[] args) {
		
		//제어문 for
		
		//반복문 : 일정한 패턴을 가진 실행문을 여러번 반복 실행하고자 할 때 사용.
		
		/*
		
		for(initialization; Boolean_expression; update) {
		   // Statements
		}
		 
		*/
		
		for (int x = 10; x < 20; x = x + 1) {
			System.out.print("value of x : " + x);
			//줄바꿈 문자 출력
			System.out.print("\n");
		}
		 
	}

}
