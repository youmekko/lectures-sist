package com.test;

public class Sample061 {

	public static void main(String[] args) {

		//반복문 테스트
		
		//문제) 1부터 100까지의 수에 대한 합산을 출력하되, 아래 형태로 출력.
		//-> 숫자 출력시 10단위마다 줄바꿈 출력
		//-> 10단위마다 합산의 중간 결과를 출력
		/*
		출력예)
		 1 2 3 4 5 6 7 8 9 10 => 55
		 11 12 13 14 15 16 17 18 19 20 => 210
		 ...
		 91 92 93 94 95 96 97 98 99 100 => 5050
		*/
		
		int temp = 0;
		
		//1부터 100까지의 수 변화
		for (int a=1; a<=100; ++a) {
			
			//합산
			temp = temp + a;
			
			//수 출력
			System.out.print(" " + a);
			
			//줄바꿈 문자 출력
			if (a % 10 == 0) {
				
				//중간 결과 출력
				System.out.print(" => " + temp);
				
				System.out.print("\n");
			}
		}

	}

}
