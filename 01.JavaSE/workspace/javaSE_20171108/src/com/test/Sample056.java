package com.test;

public class Sample056 {

	public static void main(String[] args) {
		
		//반복문 테스트
		
		//1부터 100까지의 수를 합산한 결과(5050)를 출력
		// (((0 + 1) + 2) + 3)  ... + 100
		//-> 어떤 수에 (+ 어떤 값) 연산을 반복 수행
		//-> 초기값 0에 1부터 100까지의 수를 반복 합산
		
		//합산 결과 저장용 변수
		int temp = 0;

		//1부터 100까지의 수를 변화시키기 위한 변수
		for (int a = 1; a<=100; ++a) {
		
			//1부터 100까지의 수를 temp 변수에 합산 연산
			temp = temp + a;

		}

		//결과 출력
		System.out.println(temp);
		
		
		
		
		
	}

}
