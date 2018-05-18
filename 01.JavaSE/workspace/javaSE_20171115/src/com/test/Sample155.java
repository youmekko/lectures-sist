package com.test;

import java.util.Calendar;

public class Sample155 {

	public static void main(String[] args) {

		// 시스템의 날짜 및 시간 정보 확인
		// java.util 패키지의 Date, Calendar 클래스
		// java.time 패키지의 LocalDateTime 클래스(Java 8.0 이상)

		
		//Calendar 클래스의 객체 생성
		Calendar cal = Calendar.getInstance();
		
		//get() 메소드와 날짜,시간 상수를 이용해서 날짜, 시간 정보 확인
		
		//년도
		int year = cal.get(Calendar.YEAR);
		
		//월(+1 연산 필요)
		int month = cal.get(Calendar.MONTH) + 1;
		
		//일
		int day = cal.get(Calendar.DAY_OF_MONTH);

		//요일(숫자로 출력, 1~7)
		int week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		
		//오전/오후(숫자로 출력, 0~1)
		int ampm = cal.get(Calendar.AM_PM);
		System.out.println(ampm);
		
		//시(12시간제, 0~11)
		int hour = cal.get(Calendar.HOUR);
		System.out.println(hour);
		
		//분
		int minute = cal.get(Calendar.MINUTE);

		//초
		int second = cal.get(Calendar.SECOND);
		
		//날짜 출력
		System.out.printf("%d년 %d월 %d일%n", year, month, day);
		
		//요일 출력
		String[] weeks = {"", "일", "월", "화", "수", "목", "금", "토"};
		System.out.printf("%s요일%n", weeks[week]);
		
		//시간 출력
		String[] ampms = {"오전", "오후"};
		System.out.printf("%s %s:%s:%s%n", ampms[ampm], (hour==0)?12:hour, minute, second);

		
		//주의) 윤년 확인 메소드 지원 불가
		System.out.println(cal.isLeapYear());
		
		
	}

}
