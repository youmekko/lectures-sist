package com.test;

public class Sample088 {

	public static void main(String[] args) {
		
		
		//문제) 문자열을 아래 형태로 출력하는 코드 작성.
		//중첩 for문, ASCII 코드 65~
		/*
		
		A B C D E
		B C D E F
		C D E F G
		D E F G H
		E F G H I
		
		*/
		
		//A B C D E 출력 
 		for (int a=65; a<70; ++a) {
			System.out.printf("%c ", a);
		}
		System.out.print("\n");
		

	}

}
