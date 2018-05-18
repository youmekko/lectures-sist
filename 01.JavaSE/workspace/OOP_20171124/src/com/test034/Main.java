package com.test034;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		//static 초기화 블럭에 의한 초기화 테스트
		int[] result = Sample.getArr();
		
		//[난수1, 난수2, ...]
		//Arrays.sort(result);
		System.out.println(Arrays.toString(result));

	}

}
