package com.test;

import java.util.Arrays;

public class Sample116 {

	public static void main(String[] args) {
		
		//배열의 복사
		//Arrays 클래스의 copyOf(원본배열, 크기) 메소드 사용
		//얕은 복사(참조 주소만 복사된 상태), 깊은 복사(참조 주소 및 실제 자료까지 복사된 상태)
		
		
		int[] arr1 = {10, 20, 30, 40, 50};
		
		//---------------------------
		int[] arr2 = arr1;
		
		System.out.println(arr1[0]);
		System.out.println(arr2[0]);
		
		++arr1[0];
		
		System.out.println(arr1[0]);
		System.out.println(arr2[0]);
		
		
		//---------------------------
		int[] arr3 = new int[arr1.length];
		for (int a=0; a<arr3.length; ++a) {
			arr3[a] = arr1[a];
		}
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr3));
		
		++arr1[0];
		
		System.out.println(arr1[0]);
		System.out.println(arr3[0]);
		
		
		//----------------------------
		int[] arr4 = Arrays.copyOf(arr1, arr1.length);

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr4));
		
		++arr1[0];
		
		System.out.println(arr1[0]);
		System.out.println(arr4[0]);
		
	}

}
