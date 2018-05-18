package com.test;

import java.util.Arrays;

public class Sample119 {

	public static void main(String[] args) {

		// 문제) 여러개의 요소를 가진 int 자료형 배열에서 가장 큰 값 출력하는 코드 작성.
		// 임의의 수는 난수(0~100)로 준비한다.
		// 버블 정렬 알고리즘 1회전 적용 후, 가장 오른쪽 요소를 얻는다. -> max

		int[] arr = new int[5];

		for (int a = 0; a < arr.length; a++) {
			arr[a] = (int) (Math.random() * 101);
		}

		for (int a = 0; a < arr.length - 1; a++) {
			if (arr[a] > arr[a + 1]) {
				int temp = arr[a + 1];
				arr[a + 1] = arr[a];
				arr[a] = temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.printf("최대값 : [%d]", arr[arr.length - 1]);
		  
	}

}
