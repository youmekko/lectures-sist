package com.test;

import java.util.Arrays;

public class Sample114 {

	public static void main(String[] args) {
		
		//배열 요소 출력
		
		//java.util.Arrays 클래스의 toString() 메소드를 이용한 출력
		//->java.util 패키지 등록 필요
		
		String[] arr = {"java", "oracle", "html", "javascript", "css"};
		
		//정렬 전 출력
		//[java, oracle, html, javascript, css]
		System.out.println(Arrays.toString(arr));

		//정렬 과정
		Arrays.sort(arr);
		
		//정렬 후 출력
		//[css, html, java, javascript, oracle]
		System.out.println(Arrays.toString(arr));
		
		
	}

}
