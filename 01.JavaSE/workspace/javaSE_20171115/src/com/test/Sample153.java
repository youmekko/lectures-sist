package com.test;

public class Sample153 {

	public static void main(String[] args) {
		
		//Chapter5,  확인문제8 풀이
		
		int[][] array = {{95, 86}, {83, 92, 96}, {78, 83, 93, 87, 88}};
		
		int sum = 0;
		double avg = 0.0;
		
		//합계 및 평균 계산 과정 추가
		//-> 중첩 for문 사용
		//-> 요소의 갯수를 확인하는 변수 선언 추가
		int count = 0;
		for (int[] arr : array) {
			for (int a : arr) {
				sum += a;
				++count;
			}
		}
		avg = sum / (double)count;
		
		System.out.println("sum:" + sum);
		System.out.println("avg:" + avg);
		

	}

}
