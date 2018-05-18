package com.test;

public class Sample045 {

	public static void main(String[] args) {
		//switch 구문
		/*
		
		switch(expression) {
		   case value :
		   case value :
		      // Statements
		      break; // optional
		   
		   // You can have any number of case statements.
		   default : // Optional
		      // Statements
		} 
		 
		*/
		
		//변수 a에 임의의 등급(A, a, B, b, C, c)을 저장한다.
		char a = 'a';
		
		switch (a) {
		case 'A':
		case 'a':
			System.out.println("우수 회원입니다.");
			break;
		case 'B':
		case 'b':
			System.out.println("일반 회원입니다.");
			break;
		default:
			System.out.println("손님 회원입니다.");
			break;
		}
		
		
	}

}
