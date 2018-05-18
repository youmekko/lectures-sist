package com.test;

import java.util.Arrays;

public class Sample117 {

	public static void main(String[] args) {
		
		//배열의 복사
		//원본 배열의 일부 요소만 복사
		//Arrays 클래스의 copyOfRange(원본배열, 시작인덱스, 끝인덱스) 메소드 사용
		
		int[] arr1 = {10, 20, 30, 40, 50};

		int[] arr4 = Arrays.copyOfRange(arr1, 0, 1);

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr4));
		
		++arr1[0];
		
		System.out.println(arr1[0]);
		System.out.println(arr4[0]);

	}

}
