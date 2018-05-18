package com.test;

public class Sample031 {

	public static void main(String[] args) {
		
		//조건문 if
		/*
		  
		 if(Boolean_expression) {
   				// Statements will execute if the Boolean expression is true
		 }
		  
		 */
		
		int score = 93;
		
		if (score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A 입니다.");
		}
		
		if (score < 90) {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B 입니다.");
		}

		//주의) {} 블럭이 없으면 if 범위는 한 문장만 포함된다.
		if (score < 90)
			System.out.println("점수가 90보다 작습니다.");

		System.out.println("등급은 B 입니다.");
	
	}

}
