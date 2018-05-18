package com.test008;

import java.time.*;

public class Main {

	public static void main(String[] args) {
		
		//날짜 문자열 분석 -> LocalDate 클래스의 parse() 메소드
		
		//올바른 날짜
		String date1 = "2017-12-13";
		
		//올바르지 않은 날짜인 경우 -> 예외 발생
		String date2 = "1234-56-78";
		
		System.out.println(LocalDate.parse(date1));
		
		//DateTimeParseException
		System.out.println(LocalDate.parse(date2));
		

	}

}
