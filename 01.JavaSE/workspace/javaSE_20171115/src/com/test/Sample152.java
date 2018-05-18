package com.test;

import java.util.*;

public class Sample152 {

	public static void main(String[] args) {
		
		//시스템의 날짜 및 요일 확인
		//java.util.Calendar 클래스 및 Week 열거자료형
		
		//Calendar 클래스의 객체 생성
		Calendar cal = Calendar.getInstance();
		
		//get() 메소드는 이용해서 시스템의 날짜, 요일 정보 확인
		//일(1), 월(2), 화(3), 수(4), 목(5), 금(6), 토(7)
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		int week = cal.get(Calendar.DAY_OF_WEEK);

		//if문, switch문 대신 배열을 이용해서 열거형 값을 얻을 수 있다.
		Week[] todays = {null, Week.SUNDAY, Week.MONDAY, Week.TUESDAY, Week.WEDNESDAY
				, Week.THURSDAY, Week.FRIDAY, Week.SATURDAY};
		
		System.out.printf("오늘 요일은 %s 입니다.%n", todays[week]);
		
		//열거형 자료형의 값을 순차적으로 모두 출력
		//->values() 메소드 
		//->배열 객체
		for (Week a : Week.values()) {
			System.out.println(a);
		}
		
		Week[] todays2 = Week.values();
		System.out.printf("오늘 요일은 %s 입니다.%n", todays2[week-1]);
		
	}

}
