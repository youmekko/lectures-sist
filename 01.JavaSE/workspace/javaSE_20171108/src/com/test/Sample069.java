package com.test;

public class Sample069 {

	public static void main(String[] args) {
		
		//중첩 for문 테스트
		
		//문제) 별문자(*)를 아래 형태로 출력하는 코드 작성.
		/*
		
		* * * * *
		  * * * * 
		    * * * 
		      * * 
		        * 
		 
		*/
		//주의) 적정 수의 공백문자("  ")와 별문자("* ")를 같이 출력.
		for (int a=1; a<=5; ++a) {
			for (int b=1; b<=5; ++b) {
				
				if (a > b) {
					System.out.print("  ");
				} else {
					System.out.print("* ");
				}
				
			}
			//줄바꿈 문자 출력
			System.out.print("\n");
		}

	}

}
