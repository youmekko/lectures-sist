package com.test;

public class Sample143 {

	public static void main(String[] args) {
		
		//학생수, 점수입력, 점수리스트, 분석, 종료 기능을 가진 프로그램 작성.
		//1단계) 학생의 점수 여러개를 배열에 저장하고, 점수리스트 출력
		//2단계) 최고점수, 평균점수 추가 출력
		/*
		출력예)
		scores[0]: 90
		scores[1]: 100
		scores[2]: 80
		scores[3]: 70
		scores[4]: 90
		최고 점수:100
		평균 점수:86.0
		
		*/
		
		int[] scores = null;
		
		int studentNum = 5;
		scores = new int[studentNum];
		
		scores[0] = 90;
		scores[1] = 100;
		scores[2] = 80;
		scores[3] = 70;
		scores[4] = 90;
		
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
		

	}

}
