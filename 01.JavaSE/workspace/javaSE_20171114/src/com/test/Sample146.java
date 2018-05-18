package com.test;

import java.util.Scanner;

public class Sample146 {

	public static void main(String[] args) {
		
		//학생수, 점수입력, 점수리스트, 분석, 종료 기능을 가진 프로그램 작성.
		//1단계) 학생의 점수 여러개를 배열에 저장하고, 점수리스트 출력
		//2단계) 최고점수, 평균점수 추가 출력
		//3단계) 점수를 외부 입력 받아서 배열에 저장
		//4단계) 학생수에 대한 외부 입력 받아서 배열의 크기 지정
		//5단계) 메뉴 액션 처리 추가
		/*
		출력예)
		------------------------------------
		1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
		------------------------------------
		선택>1
		학생수 >3
		------------------------------------
		1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
		------------------------------------
		선택>2
		scores[0] >66
		scores[1] >70
		scores[2] >68
		------------------------------------
		1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
		------------------------------------
		선택>3
		scores[0] : 66
		scores[1] : 70
		scores[2] : 68
		------------------------------------
		1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
		------------------------------------
		선택>4
		최고 점수 :70
		평균 점수 :68.0
		------------------------------------
		1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
		------------------------------------
		선택>5
		프로그램이 종료되었습니다.
		
		*/
		
		Scanner sc = new Scanner(System.in);

		int[] scores = null;

		int studentNum = 0;
		boolean run = true;

		while (run) {
			System.out.println("------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("------------------------------------");
			System.out.print("선택>");

			int selectNo = sc.nextInt();
			sc.nextLine();

			// 학생수에 대한 외부 입력 및 배열 크기 지정
			if (selectNo == 1) {
				System.out.printf("학생수 >");
				studentNum = sc.nextInt();
				sc.nextLine();
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				// 점수에 대한 외부 입력
				for (int a = 0; a < scores.length; ++a) {
					System.out.printf("scores[%d] >", a);
					scores[a] = sc.nextInt();
					sc.nextLine();
				}
			} else if (selectNo == 3) {
				// 점수 리스트 출력
				for (int a = 0; a < scores.length; ++a) {
					System.out.printf("scores[%d] : %d%n", a, scores[a]);
				}
			} else if (selectNo == 4) {
				// 최고점수, 평균점수 출력
				int sum = 0;
				int max = scores[0];
				for (int a = 0; a < scores.length; ++a) {
					sum += scores[a];
					if (max < scores[a]) {
						max = scores[a];
					}
				}
				double avg = sum / (double) studentNum;
				System.out.printf("최고 점수 :%d%n", max);
				System.out.printf("평균 점수 :%.1f%n", avg);
			} else if (selectNo == 5) {
				run = false;
			}
		}

		sc.close();
		System.out.println("프로그램이 종료되었습니다.");

	}

}
