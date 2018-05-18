package com.test;

public class Sample101 {

	public static void main(String[] args) {
		
		//향상된 for문
		//배열 또는 컬렉션 객체 탐색 전용 반복문
		//배열 객체를 순차적으로 탐색해서 요소를 임시변수에 저장한다.
		/*
		 
		 for (자료형 임시변수 : 배열객체) {
		 }
		 
		*/
		
		int[] arr = {10, 20, 30, 40, 50};
		
		//일반 for문
		for (int a=0; a<arr.length; ++a) {
			int b = arr[a];
			System.out.printf("arr[%d]:%d%n", a, b);
		}
		
		//향상된 for문
		for (int b : arr) {
			System.out.println(b);
		}

	}

}
