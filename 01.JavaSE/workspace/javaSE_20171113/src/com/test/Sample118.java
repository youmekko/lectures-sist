package com.test;

import java.util.Arrays;

public class Sample118 {

	public static void main(String[] args) {
		
		//배열 요소 검색
		//Arrays 클래스의 binarySearch() 메소드 사용
		//주의) 정렬된 상태에서만 검색 가능.
		
		int[] arr1 = {3, 5, 4, 2, 1};
		
		//-------------------
		int temp = 20;
		int idx = -1;
		for (int a=0; a<arr1.length; ++a) {
			if (arr1[a] == temp) {
				idx = a;
			}
		}
		System.out.println(idx);
		
		
		//-------------------
		Arrays.sort(arr1);
		System.out.println(Arrays.binarySearch(arr1, 5));
		System.out.println(Arrays.binarySearch(arr1, 20));

		
		//-------------------
		String[] arr2 = {"java", "oracle", "html", "javascript", "css"};

		Arrays.sort(arr2);
		System.out.println(Arrays.binarySearch(arr2, "css"));
		System.out.println(Arrays.binarySearch(arr2, "korea"));
		

	}

}
