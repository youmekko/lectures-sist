package com.test;

public class Sample095 {

	public static void main(String[] args) {
		//int 자료형 배열에 임의의 수(난수 0~100) 여러개(5개)를 준비하고
		//배열 요소 출력 및 최대값을 얻어내고 출력하는 코드 작성.
		//출력예)
		/*
		arr1[0]: 10
		arr1[1]: 20
		arr1[2]: 30
		arr1[3]: 40
		arr1[4]: 50
		------------
		최대값: ????
		*/
		
		int[] arr = new int[5];
		int max = 0;
		StringBuilder sb = new StringBuilder();
		
		//입력 과정 ----------------
		for (int i = 0; i < arr.length; i++) {
			int num = (int) (Math.random() * 101);
			arr[i] = num;
			sb.append(String.format("array[%d]=%d%n", i, num));
		}
		
		//처리 과정 --------------------
		max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		//출력 과정 -----------------------
		System.out.print(sb.toString());
		System.out.println("------------");
		System.out.printf("최대값:%d%n", max);
		
		
	}

}
