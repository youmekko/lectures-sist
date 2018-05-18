package com.test;

public class Sample044 {

	public static void main(String[] args) {
		//switch 구문
		/*
		
		switch(expression) {
		   case value :
		      // Statements
		      break; // optional
		   
		   case value :
		      // Statements
		      break; // optional
		   
		   // You can have any number of case statements.
		   default : // Optional
		      // Statements
		} 
		 
		*/
		
		//주의) switch 구문은 특정 조건(expression == value)을 만족하는 경우에만 실행된다.
		//주의) switch 구문에서 break; 구문은 특정 case 구문을 실행하고 switch 블럭을 빠져나갈때 사용된다.
		//주의) case 구문 안에 실행문 여러개를 사용하지 않는다.
		//주의) switch 구문에서 expression은 자료형에 제한(byte, char, short, int, long, String)이 있다.
		
		//주사위 숫자 범위(1~6)의 난수 발생
		//(int)(Math.random()*6) + 1
		
		int num = (int)(Math.random()*6) + 1;
		
		switch (num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;
		default:
			System.out.println("6번이 나왔습니다.");
			break;
		}
		
		

	}

}
