package com.test;

public class Sample135 {

	public static void main(String[] args) {
		
		//배열의 배열
		/*
		출력 형태가 아래와 같이 되도록 2차원 배열 초기화
		
		  1  2  3  4  5
		 10  9  8  7  6 
		 11 12 13 14 15
		 20 19 18 17 16
		 21 22 23 24 25
		
		*/
		
		int[][] arr = new int[5][5];
		
		//배열의 초기화
		//1부터 25까지의 수를 순차적으로 초기화
		int c = 0;
		for (int a=0; a<arr.length; ++a) {
			for (int b=0; b<arr[a].length; ++b) {
				if (a%2==0) {
					arr[a][b] = ++c;
				} else {
					arr[a][arr[a].length - b -1] = ++c;
				}
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
