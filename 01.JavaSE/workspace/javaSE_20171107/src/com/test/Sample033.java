package com.test;

public class Sample033 {

	public static void main(String[] args) {
		//조건문  if~else
		/*
		 
			if(Boolean_expression) {
				   // Executes when the Boolean expression is true
			} else {
				   // Executes when the Boolean expression is false
			}
		 
		 */
		
		int score = 83;
		
		if (score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A 입니다.");
		} else {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B 입니다.");
		}
		
	}

}
