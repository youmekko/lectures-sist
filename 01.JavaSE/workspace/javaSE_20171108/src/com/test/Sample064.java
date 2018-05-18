package com.test;

public class Sample064 {

	public static void main(String[] args) {
		
		//반복문 테스트
		
		//문제) 두 개의 주사위를 던져서 나온 수의 합이 일정 수가 아니면 무한 반복 및 출력. 
		//일정 수(합이 5인 경우)이면 무한 반복 탈출.
		//반복문, if문, 탈출문, 난수(1~6) 발생.
		
		while (true) {

			int dice1 = (int) (Math.random() * 6) + 1;

			int dice2 = (int) (Math.random() * 6) + 1;

			System.out.println("(" + dice1 + "+" + dice2 + ")=" + (dice1 + dice2));

			if (dice1 + dice2 == 5) {
				break;
			}

		}
		 

	}

}
