package com.test;

public class Sample131 {

	public static void main(String[] args) {

		//다차원 배열(배열의 배열)
		//1차원 배열의 요소로서 또다른 1차원 배열이 들어 있는 상태.
		
		/*
		
		자료형[][] 변수 = new 자료형[크기1][];
		
		크기1은 바깥쪽 1차원 배열의 크기
		크기2는 생략
		바깥쪽 배열의 요소에 동적 생성된 1차원 배열을 지정한다.
		안쪽 1차원 배열의 크기는 서로 다르게 지정한다.
		
		*/
		
		int[][] arr = new int[2][];
		arr[0] = new int[2];
		arr[1] = new int[3];
		
		//자동 초기화 지원
		//[0][0], [0][1], [1][0], [1][1], [1][2]
		
		System.out.println(arr[0][0]);
		System.out.println(arr[0][1]);
		System.out.println(arr[1][0]);
		System.out.println(arr[1][1]);
		System.out.println(arr[1][2]);

		//중첩 for문 + length 필드를 이용한 인덱스 접근
		for (int a=0; a<arr.length; ++a) {
			for (int b=0; b<arr[a].length; ++b) {
				System.out.println(arr[a][b]);
			}
		}

		
	}

}
