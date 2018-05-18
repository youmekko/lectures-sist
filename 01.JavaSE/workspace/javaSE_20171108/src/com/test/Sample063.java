package com.test;

public class Sample063 {

	public static void main(String[] args) {
		
		//continue 키워드
		
		//반복문 내부에서 실행문을 실행하지 않고 다음 반복으로 이동할 때 사용.
		//반복문 진행시 특정 조건을 만족하는 경우는 실행문 실행을 제외한다.
		
		/*
		
		for(initialization; Boolean_expression; update) {
		
			if (조건) continue;
			
		   	// Statements
		}
		 
		*/
		
		//1부터 100까지의 수를 출력하되, 단, 10의 배수는 제외.
		for (int a=1; a<=100; ++a) {
			
			if (a%10 == 0) continue;
			
			System.out.print(" " + a);
		}
		

	}

}
