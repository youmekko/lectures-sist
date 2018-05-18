package com.test;

import java.util.Arrays;
import java.util.Comparator;

public class Sample122 {

	public static void main(String[] args) {
		
		//내림차순 정렬
		//Arrays 클래스의 sort() 메소드를 이용한 내림차순 정렬
		
		Integer[] arr = {3, 5, 4, 2, 1};

		//정렬 전 출력
		System.out.println(Arrays.toString(arr));
		
		//내림차순 정렬 액션
		//주의) Integer 자료형의 배열만 사용 가능
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		//정렬 후 출력
		System.out.println(Arrays.toString(arr));

	}

}
