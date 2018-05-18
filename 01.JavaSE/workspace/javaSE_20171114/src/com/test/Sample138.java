package com.test;

public class Sample138 {

	public static void main(String[] args) {
		
		//배열의 배열
		/*
		문제) 출력 형태가 아래와 같이 되도록 2차원 배열 초기화
		
		  1  2  3  4  5
		 16 17 18 19  6
		 15 24 25 20  7
		 14 23 22 21  8
		 13 12 11 10  9
		 
		*/
		
		int size = 5;
		int[][] arr = new int[size][size];
		
		//배열의 초기화
		//1부터 25까지의 수를 순차적으로 초기화
		int y = -1;
		int x = 0;
		int d = 1;
		int cnt = 0;
		while (size >= 0) {
			for (int i = 0; i < size; i++) {
				y = y + d;
				arr[x][y] = ++cnt;
			}
			size--;
			for (int i = 0; i < size; i++) {
				x = x + d;
				arr[x][y] = ++cnt;
			}
			d = -d;
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
