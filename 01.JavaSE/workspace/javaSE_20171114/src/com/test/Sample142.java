package com.test;

public class Sample142 {

	public static void main(String[] args) {
		
		//학생수, 점수입력, 점수리스트, 분석, 종료 기능을 가진 프로그램 작성.
		//1단계) 학생의 점수 여러개를 배열에 저장하고, 점수리스트 출력
		/*
		출력예)
		scores[0]: 90
		scores[1]: 100
		scores[2]: 80
		scores[3]: 70
		scores[4]: 90
		
		*/
		
		int[] scores = null;
		
		scores = new int[5];
		
		scores[0] = 90;
		scores[1] = 100;
		scores[2] = 80;
		scores[3] = 70;
		scores[4] = 90;
		
		for (int a=0; a<scores.length; ++a) {
			System.out.printf("scores[%d]: %d%n", a, scores[a]);
		}

	}

}
