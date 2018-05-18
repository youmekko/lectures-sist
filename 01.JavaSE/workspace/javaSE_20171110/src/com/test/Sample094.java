package com.test;

public class Sample094 {

	public static void main(String[] args) {
		
		//문제) int 자료형 배열에 임의의 수(난수 0~100) 여러개(5개)를 준비하고
		//배열 요소 출력 및 합, 평균(소수 이하 자리수) 계산해서 출력하는 코드 작성.
		//출력예)
		/*
		arr1[0]: 10
		arr1[1]: 20
		arr1[2]: 30
		arr1[3]: 40
		arr1[4]: 50
		------------
		합 : ???
		평균 : ???.?
		*/
		
		int[] arr = new int[5];
		int sum = 0;
		double avg = 0.0;
		StringBuilder sb = new StringBuilder();
		
		//입력 과정 ----------------
		for (int i = 0; i < arr.length; i++) {
			int num = (int) (Math.random() * 101);
			arr[i] = num;
			sb.append(String.format("array[%d]=%d%n", i, num));
		}
		
		//처리 과정 ----------------
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			avg = sum / (double)arr.length;
		}
		
		//출력 과정 ----------------
		System.out.print(sb.toString());
		System.out.println("------------");
		System.out.printf("합계:%d%n", sum);
		System.out.printf("평균:%.1f%n", avg);
		  
	}

}
