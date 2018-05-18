package com.test;

public class Sample067 {

	public static void main(String[] args) {
		
		//중첩 for문 테스트
		
		//별문자(*)를 아래 형태로 출력하는 코드 작성.
		/*
		
		* 
		* * 
		* * * 
		* * * * 
		* * * * *
		 
		*/
		
		//바깥쪽 for문은 안쪽 for문의 결과(* * * * * \n)를 5번 반복 실행
		for (int a=1; a<=5; ++a) {
			//안쪽 for문은 별문자(*)를 특정 수만큼 반복 출력
			for (int b=1; b<=a; ++b) {
				System.out.print("* ");
			}
			//줄바꿈 문자 출력
			System.out.print("\n");
		}

	}

}
