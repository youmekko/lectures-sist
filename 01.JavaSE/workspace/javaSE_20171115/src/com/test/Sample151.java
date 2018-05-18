package com.test;

import java.util.*;

public class Sample151 {

	public static void main(String[] args) {
		
		//시스템의 날짜 및 요일 확인
		//java.util.Calendar 클래스 및 Week 열거자료형
		
		//Calendar 클래스의 객체 생성
		Calendar cal = Calendar.getInstance();
		
		//get() 메소드는 이용해서 시스템의 날짜, 요일 정보 확인
		//일(1), 월(2), 화(3), 수(4), 목(5), 금(6), 토(7)
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		Week today = null;
		
		switch (week) {
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUESDAY;
			break;
		case 4:
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}
		
		System.out.printf("오늘 요일은 %s 입니다.%n", today.name());
		
		
	}

}
