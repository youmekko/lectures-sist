package com.test;

public class Sample099 {

	public static void main(String[] args) {
		
		//배열 사용시 주의사항
		
		//배열의 인덱스를 초과해서 접근 시도하면 안된다.
		
		int[] arr1 = new int[5];
		
		//올바른 예
		for(int a=0; a<arr1.length; ++a) {
			System.out.println(arr1[a]);
		}

		//틀린 예
		//ArrayIndexOutOfBoundsException
		for(int a=0; a<=arr1.length; ++a) {
			System.out.println(arr1[a]);
		}

	}

}
