package com.test;

public class Sample050 {

	public static void main(String[] args) {
		
		//중첩 for문
		
		//for문 내부에 또다른 for문이 중첩된 상태
		//주의) 바깥쪽 for문 한 번 실행될 때 안쪽 for문 여러번 실행되는 상태가 된다.
		//주의) 바깥쪽 for문의 변수와 안쪽 for문의 변수는 서로 달라야 한다.
		
		/*
		
		for(initialization; Boolean_expression; update) {
			for(initialization; Boolean_expression; update) {
			   // Statements
			}
		}
		 
		*/

		//바깥쪽 for문의 반복횟수->10번
		for (int a = 1; a < 11; ++a) {
			//1부터 10까지의 수를 출력
			//-> 변수 b의 값이 변화되는 횟수가 10번
			for (int b = 1; b < 11; ++b) {
				System.out.print("value of b : " + b);
				//줄바꿈 문자 출력
				System.out.print("\n");
			}
		}
		
		
	}

}
