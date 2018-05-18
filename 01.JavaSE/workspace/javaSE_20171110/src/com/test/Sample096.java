package com.test;

public class Sample096 {

	public static void main(String[] args) {
		
		//배열 사용시 주의사항
		
		//선언하는 과정에서 값목록에 의한 배열 생성시 변수 선언문과 같이 사용.
		
		//올바른 표현
		int[] arr1 = {1, 2, 3};
		
		//틀린 표현
		int[] arr2;
		arr2 = {1, 2, 3};
		
		//올바른 표현
		int[] arr3;
		arr3 = new int[] {1, 2, 3};
		

	}

}
