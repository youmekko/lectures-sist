package com.test;

import java.util.Scanner;

public class Sample139 {

	public static void main(String[] args) {
		
		//배열의 배열
		/*
		외부 입력을 이용해서 배열의 크기를 결정하고 2차원 배열을 달팽이 형태로 초기화
		
		출력예)
		크기를 입력해 주세요(MAX:14, exit:0) : 5
		
		  1  2  3  4  5
		 16 17 18 19  6
		 15 24 25 20  7
		 14 23 22 21  8
		 13 12 11 10  9
		 
		계속하려면 Enter키를 누르십시오... 
		 
		*/
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("크기를 입력해 주세요(MAX:14, exit:0) : ");
			int size = sc.nextInt();
			sc.nextLine();
			
			if (size == 0) break;
			
			int[][] arr = new int[size][size];
			
			//배열의 초기화
			//1부터 (size*size)까지의 수를 순차적으로 초기화
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
	
			System.out.println("계속하려면 Enter키를 누르십시오... ");
			sc.nextLine();
		}
		
		sc.close();
		System.out.println("프로그램 종료.");
		
	}

}
