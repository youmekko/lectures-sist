package com.test;

public class Sample092 {

	public static void main(String[] args) {
		
		//배열 생성 및 초기화
		int[] arr1 = {10, 20, 30, 40, 50};
		
		//반복문을 이용한 배열 요소 접근
		for(int a=0; a<arr1.length; ++a) {
			System.out.printf("arr1[%d]: %d%n", a, arr1[a]);
		}
	}

}
