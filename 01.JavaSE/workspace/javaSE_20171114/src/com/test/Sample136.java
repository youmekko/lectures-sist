package com.test;

public class Sample136 {

	public static void main(String[] args) {
		
		//배열의 배열
		/*
		문제) 출력 형태가 아래와 같이 되도록 2차원 배열 초기화
		
		 1  6 11 16 21
		 2  7 12 17 22
		 3  8 13 18 23
		 4  9 14 19 24
		 5 10 15 20 25
		
		*/
		
		int[][] arr = new int[5][5];
		
		//배열의 초기화
		//1부터 25까지의 수를 순차적으로 초기화
		int c = 0;
		for (int a = 0; a < arr.length; a++) {
			for (int b = 0; b < arr[a].length; b++) {
				arr[b][a] = ++c;
			}
		}
		
		//배열의 배열을 2차원 구조로 출력
		for (int a=0; a<arr.length; ++a) {
			for (int b=0; b<arr[a].length; ++b) {
				System.out.printf("%3d", arr[a][b]);
			}
			//줄바꿈 문자 출력
			System.out.print("\n");
		}

	}

}
