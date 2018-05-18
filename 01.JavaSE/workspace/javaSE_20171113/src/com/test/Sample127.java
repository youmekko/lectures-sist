package com.test;

import java.util.Scanner;

public class Sample127 {

	public static void main(String[] args) {
		
		//문제) 여러명의 이름, 점수를 외부 입력 받고, 출력시 이름(오름차순) 또는 점수(내림차순)를 정렬시켜서 출력하는 코드 작성.
		//배열을 이름 저장용, 점수 저장용 따로 준비하고, 이름, 점수를 매칭하기 위해서 동일 인덱스 사용.
		//Scanner 클래스의 next() 메소드, nextLine() 메소드, nextInt() 메소드 사용.
		
		String[] names = new String[5];
		int[] scores = new int[5];

		/*
		names[0]  = "hong";
		scores[0] = 100;
		
		names[1]  = "park";
		scores[1] = 90;
		*/
		
		Scanner sc = new Scanner(System.in);

		//외부 입력
		for (int a = 0; a < names.length; ++a) {

			System.out.print("name?");
			String name = sc.next();
			sc.nextLine();

			System.out.print("score(0~100)?");
			int score = sc.nextInt();
			sc.nextLine();
			
			names[a] = name;
			scores[a] = score;

		}
		
		
		//정렬 액션
		//이름(점수) 기준 정렬시 점수(이름)도 같이 움직여야 한다.
		/*
		for (int m = 1; m < names.length; m++) {
			for (int n = 0; n < names.length - m; n++) {
				if (names[n].compareTo(names[n + 1]) > 0) {
					String temp = names[n + 1];
					names[n + 1] = names[n];
					names[n] = temp;
					int temp1 = scores[n + 1];
					scores[n + 1] = scores[n];
					scores[n] = temp1;
				}
			}
		}
		*/
		
		/*
		for (int m = 1; m < scores.length; ++m) {
			for (int a = 0; a < scores.length - m; ++a) {
				if (scores[a] < scores[a + 1]) {
					int temp1 = scores[a + 1];
					String temp2 = names[a + 1];
					scores[a + 1] = scores[a];
					names[a + 1] = names[a];
					scores[a] = temp1;
					names[a] = temp2;
				}
			}
		}
		*/

		//정렬 후 출력
		for (int a = 0; a < names.length; ++a) {
			System.out.printf("%s - %d %n", names[a], scores[a]);
		}
		
		sc.close();
		System.out.println("프로그램 종료.");
		

	}

}
