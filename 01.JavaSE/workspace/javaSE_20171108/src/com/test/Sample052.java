package com.test;

public class Sample052 {

	public static void main(String[] args) {
		
		//반복문 while
		
		//반복문 : 일정한 패턴을 가진 실행문을 여러번 반복 실행하고자 할 때 사용.
		
		/*
		 
		for(initialization; Boolean_expression; update) {
		   // Statements
		}
		
		initialization;
		while(Boolean_expression) {
		   // Statements
		   update;
		}

		*/

		/*
		for (int x = 1; x < 11; ++x) {
			System.out.print("value of x : " + x);
			System.out.print("\n");
		}
		*/
		
		int x = 1;
		while(x < 11) {
			System.out.print("value of x : " + x);
			System.out.print("\n");
			++x;
		}

	}

}
