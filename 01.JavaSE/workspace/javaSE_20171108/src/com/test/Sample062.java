package com.test;

public class Sample062 {

	public static void main(String[] args) {
		
		//break 키워드
		
		//특정 블럭 탈출시 사용.
		//반복문 내부와 switch 구문 내부에서만 사용 가능.
		//중첩된 반복문인 경우 한 번의 블럭만 탈출 가능.
		
		//일반적으로 무한반복 구문에서 특정 조건 만족시 탈출 구문으로 사용.
		
		/*
		
		while(true) {
		
			if (조건) break;
			
		   	// Statements
		}
		 
		*/
		
		
		int count = 0;
		while(true) {
			System.out.println("무한실행 상태...");
			count++;
			if (count > 10) {
				System.out.println("블럭 탈출!");
				break;
			}
		}
		
		//무한실행 블럭 내부에 break; 키워드가 없다면 Unreachable code가 된다.
		System.out.println("프로그램 종료.");

	}

}
