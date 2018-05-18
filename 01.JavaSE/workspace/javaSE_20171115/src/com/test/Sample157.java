package com.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Sample157 {

	public static void main(String[] args) {

		// 시스템의 날짜 및 시간 정보 확인
		// java.util 패키지의 Date, Calendar 클래스
		// java.time 패키지의 LocalDateTime 클래스(Java 8.0 이상)

		//시스템의 현재 날짜 및 시간 정보 확인
		LocalDateTime date = LocalDateTime.now();
		System.out.println(date);
		
		//년도
		System.out.println(date.getYear());
		
		//월
		System.out.println(date.getMonthValue());
		
		//일
		System.out.println(date.getDayOfMonth());
		
		//요일
		System.out.println(date.getDayOfWeek());
		
		//시(24시간제, 0~23)
		System.out.println(date.getHour());
		
		//분
		System.out.println(date.getMinute());
		
		//초
		System.out.println(date.getSecond());
		
		//윤년 확인
		LocalDate date2 = LocalDate.now();
		System.out.println(date2.isLeapYear());
		
		//윤년 확인
		LocalDate date3 = date.toLocalDate();
		System.out.println(date3.isLeapYear());
		
		
		//날짜 산술 연산
		System.out.printf("현재 날짜:%s%n", date);
		System.out.printf("연산 후 날짜:%s%n", date.plusDays(100));
		
		
		//현재 월의 마지막 날짜 확인
		System.out.println(date.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.println(date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth());
		
		
		//날짜 비교 연산
		LocalDate target1 = LocalDate.of(2017, 11, 5);
		LocalDate target2 = LocalDate.of(2017, 12, 5);
		System.out.println(date.toLocalDate().isBefore(target1));
		System.out.println(date.toLocalDate().isBefore(target2));
		
		
		//남은 날짜 계산
		System.out.println(ChronoUnit.DAYS.between(date.toLocalDate(), target2));
		
		
		//날짜 형식의 문자열을 날짜 객체로 변환
		LocalDate target3 = LocalDate.parse("2017-12-05");
		System.out.println(ChronoUnit.DAYS.between(date.toLocalDate(), target3));
		
		
		//날짜 서식 지정
		System.out.println(date);
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")));
		

	}

}
