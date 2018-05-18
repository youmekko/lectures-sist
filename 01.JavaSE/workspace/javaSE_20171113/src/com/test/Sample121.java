package com.test;

import java.util.Arrays;

public class Sample121 {

	public static void main(String[] args) {
		
		//내림차순 정렬
		//버블정렬 알고리즘 내림차순 정렬
		
		int[] arr = {3, 5, 4, 2, 1};

		//정렬 전 출력
		System.out.println(Arrays.toString(arr));
		
		
		//내림차순 정렬 액션
		for (int m = 1; m < arr.length; ++m) {
			for (int n = 0; n < arr.length - m; ++n) {
				if (arr[n] < arr[n+1]) {
					int temp = arr[n+1];
					arr[n+1] = arr[n];
					arr[n] = temp;
				}
			}
		}
		
		
		//정렬 후 출력
		System.out.println(Arrays.toString(arr));

	}

}
