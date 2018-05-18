package com.test;

public class Sample100 {

	public static void main(String[] args) {
		
		//배열 사용시 주의사항
		
		//메소드 매개변수로 배열 객체 전달시 값목록에 의한 배열은 전달 불가.
		//-> new 연산자 사용
		
		//올바른 예
		int[] arr1 = {1, 2, 3};
		//사용자가 준비한 메소드 호출 및 매개변수 값 전달
		test(arr1);
		
		//올바른 예
		test(new int[]{1, 2, 3});
		
		//틀린 예
		test({1, 2, 3});
		
	}
	
	//매개변수가 선언된 메소드
	public static void test(int[] arr) {
		for (int a=0; a<arr.length; ++a) {
			System.out.println(arr[a]);
		}
	}

}
