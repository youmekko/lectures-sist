package com.test004;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		//split() 메소드를 이용한 문자열 분리
		//하나의 문자열을 여러개의 문자열로 분리해준다. 단, 분리 기준(정규표현식 사용)을 제시해야 한다.
		//예를 들어, "과목명1/과목명2/과목명3/..." 문자열이 있는 경우 {"과목명1", "과목명2", "과목명3", ...} 형태로 분리해서 문자열 배열로 반환.
		
		String test = "과목명1/과목명2/과목명3/...";
		System.out.println(test);
		
		String[] subjects = test.split("/");
		System.out.println(Arrays.toString(subjects));  //["과목명1", "과목명2", "과목명3", ...]
		

	}

}
