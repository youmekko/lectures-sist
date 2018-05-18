package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class Sample147 {

	public static void main(String[] args) {
		
		//학생수, 점수입력, 점수리스트, 분석, 종료 기능을 가진 프로그램 작성.
		//1단계) 학생의 점수 여러개를 배열에 저장하고, 점수리스트 출력
		//2단계) 최고점수, 평균점수 추가 출력
		//3단계) 점수를 외부 입력 받아서 배열에 저장
		//4단계) 학생수에 대한 외부 입력 받아서 배열의 크기 지정
		//5단계) 메뉴 액션 처리 추가
		//6단계) 학생수(배열 크기)를 가변적으로 운영하도록 수정. 초기값 5. 자동 확장(+5).
		/*
		출력예)
		------------------------------------
		2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
		------------------------------------
		선택>2
		scores[0]>66
		입력을 계속할까요(y/n)?y
		scores[1]>70
		입력을 계속할까요(y/n)?n
		------------------------------------
		2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
		------------------------------------
		선택>2
		scores[2]>68
		입력을 계속할까요(y/n)?n
		------------------------------------
		2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
		------------------------------------
		선택>3
		scores[0] : 66
		scores[1] : 70
		scores[2] : 68
		------------------------------------
		2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
		------------------------------------
		선택>4
		최고 점수 :70
		평균 점수 :68.0
		------------------------------------
		2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
		------------------------------------
		선택>5
		프로그램이 종료되었습니다.
		
		*/
		
		Scanner sc = new Scanner(System.in);

		int[] scores = new int[5];

		int studentNum = 0;
		boolean run = true;

		while (run) {
			System.out.println("------------------------------------");
			System.out.println("2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("------------------------------------");
			System.out.print("선택>");

			int selectNo = sc.nextInt();
			sc.nextLine();

			// 학생수에 대한 외부 입력 및 배열 크기 지정
			if (selectNo == 2) {
				// 점수에 대한 외부 입력
				while(true) {
					System.out.printf("scores[%d] >", studentNum);
					scores[studentNum] = sc.nextInt();
					sc.nextLine();
					++studentNum;
					
					//자동 확장
					if (studentNum >= scores.length) {
						scores = Arrays.copyOf(scores, scores.length + 5);
					}
					
					System.out.printf("입력을 계속할까요(y/n)?");
					String m = sc.next();
					sc.nextLine();
					if (m.equalsIgnoreCase("n")) {
						break;
					}
				}
			} else if (selectNo == 3) {
				// 점수 리스트 출력
				for (int a = 0; a < studentNum; ++a) {
					System.out.printf("scores[%d] : %d%n", a, scores[a]);
				}
			} else if (selectNo == 4) {
				// 최고점수, 평균점수 출력
				int sum = 0;
				int max = scores[0];
				for (int a = 0; a < studentNum; ++a) {
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
