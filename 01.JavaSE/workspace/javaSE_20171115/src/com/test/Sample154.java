package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sample154 {

	public static void main(String[] args) {

		// 시스템의 날짜 및 시간 정보 확인
		// java.util 패키지의 Date, Calendar 클래스
		// java.time 패키지의 LocalDateTime 클래스(Java 8.0 이상)

		// Instantiate a Date object
		Date date = new Date();

		// display time and date using toString()
		System.out.println(date.toString());
		// Wed Nov 15 11:48:28 KST 2017

		
		//날짜 및 시간에 대한 서식 지정
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println("Current Date: " + ft.format(date));
		//Current Date: 수 2017.11.15 at 11:49:51 오전 KST
		

	}

}
