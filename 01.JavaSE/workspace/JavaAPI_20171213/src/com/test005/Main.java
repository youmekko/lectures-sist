package com.test005;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		//StringTokenizer를 이용한 문자열 분리
		//하나의 문자열을 여러개의 문자열로 분리해준다. 단, 분리 기준(문자열 표현)을 제시해야 한다.
		//예를 들어, "과목명1/과목명2/과목명3/..." 문자열이 있는 경우 StringTokenizer 객체로 반환.
		
		String test = "과목명1/과목명2/과목명3/...";
		System.out.println(test);
		
		StringTokenizer st = new StringTokenizer(test, "/");

		int count = st.countTokens();
		//주의) st.countTokens()는 for문 바깥쪽에서 실행해야 한다.
		for (int i=0; i<count; ++i) {
			System.out.println(st.nextToken());
		}
		

	}

}
