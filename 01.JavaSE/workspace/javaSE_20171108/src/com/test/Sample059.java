package com.test;

public class Sample059 {

	public static void main(String[] args) {
		
		//반복문 테스트
		
		//문제) 1부터 100까지의 수 중에서 3의 배수만 출력.
		//-> 1부터 100까지의 수 중에서 3의 배수를 만족하는 수(3으로 나눈 나머지가 0인 상태) 출력
		//-> 반복문(1부터 100까지의 수 변화) + if문(3의 배수 검사)
		
		String result = "";
		int a = 1;

		while (a <= 100) {
			if (a % 3 == 0) {
				result += " " + a;
			}
			a++;
		}

		System.out.println(result);
		
	}

}
