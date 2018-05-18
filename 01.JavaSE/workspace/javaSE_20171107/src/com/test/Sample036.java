package com.test;

public class Sample036 {

	public static void main(String[] args) {
		//조건문  if~else if~else
		/*
		 
			if(Boolean_expression1) {
				   // Executes when the Boolean expression1 is true
			} else if (Boolean_expression2) {
					// Executes when the Boolean expression1 is false, Boolean expression2 is true
			} else if (Boolean_expression3) {
					// Executes when the Boolean expression1 is false, Boolean expression2 is false,  Boolean expression3 is true
			} else {
					// Executes when the Boolean expression1, 2, 3 is false
			}
		 
		 */
		//주의) if 구문은 반드시 표기, else 구문 생략 가능
		//주의) else if 구문은 여러번 표기 가능
		
		//변수의 초기값을 난수(0~99)로 채운다
		int score = (int)(Math.random()*100);
		
		if (score >= 90) {
			System.out.println("점수가 90 이상 입니다.");
			System.out.println("등급은 A 입니다.");
		} else if (score >= 80) {
			System.out.println("점수가 80 이상 입니다.");
			System.out.println("등급은 B 입니다.");
		} else if (score >= 70) {
			System.out.println("점수가 70 이상 입니다.");
			System.out.println("등급은 C 입니다.");
		} else {
			System.out.println("점수가 70 미만 입니다.");
			System.out.println("등급은 D 입니다.");
		}
		
	}

}
