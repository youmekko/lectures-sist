package com.test;

import java.util.Arrays;

public class Sample112 {

	public static void main(String[] args) {
		
		//배열 요소 정렬
		
		//정렬 : 요소를 크기순으로 나열하는 행위. 오름차순, 내림차순
		//java.util.Arrays 클래스의 sort() 메소드를 이용한 정렬
		//->java.util 패키지 등록 필요
		
		int[] arr = {3, 5, 4, 2, 1};
		
		//정렬 전 출력
		for (int a : arr) {
			System.out.printf("%d ", a);
		}
		System.out.print("\n");

		//정렬 과정
		Arrays.sort(arr);
		
		//정렬 후 출력
		for (int a : arr) {
			System.out.printf("%d ", a);
		}
		System.out.println();
		
		
	}

}
