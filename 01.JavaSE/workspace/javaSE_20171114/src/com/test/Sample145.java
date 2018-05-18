package com.test;

import java.util.Scanner;

public class Sample145 {

	public static void main(String[] args) {
		
		//학생수, 점수입력, 점수리스트, 분석, 종료 기능을 가진 프로그램 작성.
		//1단계) 학생의 점수 여러개를 배열에 저장하고, 점수리스트 출력
		//2단계) 최고점수, 평균점수 추가 출력
		//3단계) 점수를 외부 입력 받아서 배열에 저장
		//4단계) 학생수에 대한 외부 입력 받아서 배열의 크기 지정
		/*
		출력예)
		학생수>3
		scores[0]>100
		scores[1]>80
		scores[2]>90
		scores[0]: 100
		scores[1]: 80
		scores[2]: 90
		최고 점수:100
		평균 점수:90.0
		프로그램 종료.
		
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int[] scores = null;
		
		int studentNum = 0;
		
		//학생수에 대한 외부 입력 및 배열 크기 지정
		System.out.printf("학생수>");
		studentNum = sc.nextInt();
		sc.nextLine();
		
		scores = new int[studentNum];
		
		
		//점수에 대한 외부 입력
		for (int a=0; a<scores.length; ++a) {
			System.out.printf("scores[%d]>", a);
			scores[a] = sc.nextInt();
			sc.nextLine();
		}
		
		//점수 리스트 출력
		for (int a=0; a<scores.length; ++a) {
			System.out.printf("scores[%d]: %d%n", a, scores[a]);
		}
		
		//최고점수, 평균점수 출력
		int sum = 0;
		int max = scores[0];
		for (int a=0; a<scores.length; ++a) {
			sum += scores[a];
			if (max < scores[a]) {
				max = scores[a];
			}
		}
		double avg = sum / (double)studentNum;
		System.out.printf("최고 점수:%d%n", max);
		System.out.printf("평균 점수:%.1f%n", avg);
		
		
		sc.close();
		System.out.println("프로그램 종료.");

	}

}
