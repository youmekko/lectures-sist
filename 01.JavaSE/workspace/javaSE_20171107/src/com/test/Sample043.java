package com.test;

public class Sample043 {

	public static void main(String[] args) {
		
		//char 자료형
		//0 -> 48
		//A -> 65
		//a -> 97
		
		//변수 a에 임의의 문자가 저장된 상태
		char a = 'A';
		
		//대문자 범위(65~90), 소문자 범위(97~122), 숫자 범위(48~57), 기타 문자 구분
		//char 연산 int => int 연산 int
		//자동(암시적) 형변환
		if (a >= 65 && a <= 90) {
			System.out.println("대문자 범위에 있습니다.");
		} else if (a >= 97 && a <= 122) {
			System.out.println("소문자 범위에 있습니다.");
		} else if (a >= 48 && a <= 57) {
			System.out.println("숫자 범위에 있습니다.");
		} else {
			System.out.println("기타 문자 범위에 있습니다.");
		}
		
	}

}
