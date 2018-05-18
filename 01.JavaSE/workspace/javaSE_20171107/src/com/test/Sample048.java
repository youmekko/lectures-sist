package com.test;

public class Sample048 {

	public static void main(String[] args) {
		
		//제어문 for
		
		//반복문 : 일정한 패턴을 가진 실행문을 여러번 반복 실행하고자 할 때 사용.
		
		/*
		
		for(initialization; Boolean_expression; update) {
		   // Statements
		}
		 
		*/
		
		//1부터 10까지의 수를 출력
		//-> 변수 x의 값이 변화되는 횟수가 10번 
		for (int x = 1; x < 11; ++x) {
			System.out.print("value of x : " + x);
			//줄바꿈 문자 출력
			System.out.print("\n");
		}
		 
	}

}
