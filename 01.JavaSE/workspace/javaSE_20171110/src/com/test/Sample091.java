package com.test;

public class Sample091 {

	public static void main(String[] args) {
		
		//배열 생성
		int[] arr1 = new int[5];
		
		//사용자가 임의의 값으로 배열에 저장
		//배열명[인덱스] = 값;
		arr1[0] = 10;
		//...
		arr1[4] = 10;

		//반복문을 이용한 배열 요소 접근
		for(int a=0; a<arr1.length; ++a) {
			System.out.printf("arr1[%d]: %d%n", a, arr1[a]);
		}
	}

}
