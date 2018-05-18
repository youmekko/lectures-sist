package com.test;

public class Sample058 {

	public static void main(String[] args) {
		
		//반복문 테스트
		
		//문제) 1부터 100까지의 수 중에서 홀수만 출력.
		//->1부터 출발하되, 2씩 증가하면서 출력
		
		int i = 1;
		while ( i <= 100) {
			System.out.print(" " + i);
			i += 2;
		}
		
	}

}
