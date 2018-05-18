package com.test;

import java.util.Arrays;

public class Sample115 {

	public static void main(String[] args) {
		
		//배열의 요소값 채우기
		
		//자동 초기화
		int[] arr1 = new int[5];
		
		//배열 요소 출력
		System.out.println(Arrays.toString(arr1));
		
		//같은 자료로 요소 채우기
		Arrays.fill(arr1, 10);
		
		//배열 요소 출력
		System.out.println(Arrays.toString(arr1));
		
		//임의의 난수로 요소 채우기
		for (int a=0; a<arr1.length; ++a) {
			arr1[a] = (int)(Math.random() * 101);
		}
		
		//배열 요소 출력
		System.out.println(Arrays.toString(arr1));
		
	}

}
