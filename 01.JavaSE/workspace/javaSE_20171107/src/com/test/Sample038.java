package com.test;

public class Sample038 {

	public static void main(String[] args) {
		//중첩 if문
		/*
		 
		if(Boolean_expression 1) {
		   // Executes when the Boolean expression 1 is true
		   if(Boolean_expression 2) {
		      // Executes when the Boolean expression 1 is true, Boolean expression 2 is true
		   }
		} else {
		   if(Boolean_expression 3) {
		      // Executes when the Boolean expression 1 is false, Boolean expression 3 is true
		   }
		}
		 
		*/

		//주의) if문 또는 else문 안에 또다른 if문 포함 가능.

		//입력과정 ----------------------
		//변수의 초기값을 난수(0~99)로 채운다
		int score = (int)(Math.random()*100);
		
		//처리과정 ----------------------
		//처리 과정의 결과를 저장하기 위한 임시 변수
		String result = "";
		if (score >= 90) {
			if (score >= 95) {
				result = "A+";
			} else {
				result = "A";
			}
		} else if (score >= 80) {
			if (score >= 85) {
				result = "B+";
			} else {
				result = "B";
			}
		} else if (score >= 70) {
			if (score >= 75) {
				result = "C+";
			} else {
				result = "C";
			}
		} else {
			result = "D";
		}
		
		
		//출력과정----------------------
		System.out.println("점수는 " + score + " 입니다.");
		System.out.println("등급은 " + result + " 입니다.");
		
	}

}
