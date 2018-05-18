package com.test009;

import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		
		//Chapter11 확인문제10 
		
		//정규표현식 조건
		//1. 첫 글자는 알파벳 문자(대소문자 가능) -> [a-zA-Z]
		//2. 두 번째 이후 글자는 숫자, 문자(대소문자 가능) 허용 -> \w
		//3. 전체 글자수 8자~12자 -> {8,12}
		//=> "[a-zA-Z]\\w{7,11}"
		
		String idPattern = "[a-zA-Z]\\w{7,11}";
		
		String sample1 = "abcd1234";
		String sample2 = "Angel1004";
		String sample3 = "5Angel1004";
		
		System.out.println(Pattern.matches(idPattern, sample1));
		System.out.println(Pattern.matches(idPattern, sample2));
		System.out.println(Pattern.matches(idPattern, sample3));
		
	}

}
