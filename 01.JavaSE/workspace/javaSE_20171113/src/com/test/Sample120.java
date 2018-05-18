package com.test;

import java.util.Arrays;

public class Sample120 {

	public static void main(String[] args) {
		
		//문제) 여러개의 요소를 가진 int 자료형 배열에서 가장 큰 값, 가장 작은 값 출력하는 코드 작성.
		//임의의 수는 난수(0~100)로 준비한다.
		//Arrays 클래스의 sort 메소드 적용 후, max, min 얻는다.
		

		int[] arr = new int[5];

		for (int a = 0; a < arr.length; a++) {
			arr[a] = (int) (Math.random() * 101);
		}
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		System.out.printf("최소값 : [%d]%n", arr[0]);
		System.out.printf("최대값 : [%d]%n", arr[arr.length - 1]);

	}

}
