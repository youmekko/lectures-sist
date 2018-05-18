package com.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Sample156 {

	public static void main(String[] args) {

		// 시스템의 날짜 및 시간 정보 확인
		// java.util 패키지의 Date, Calendar 클래스
		// java.time 패키지의 LocalDateTime 클래스(Java 8.0 이상)

		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		int year;
		// Create a Gregorian calendar initialized
		// with the current date and time in the
		// default locale and timezone.

		GregorianCalendar gcalendar = new GregorianCalendar();

		// Display current time and date information.
		System.out.print("Date: ");
		System.out.print(months[gcalendar.get(Calendar.MONTH)]);
		System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
		System.out.println(year = gcalendar.get(Calendar.YEAR));
		System.out.print("Time: ");
		System.out.print(gcalendar.get(Calendar.HOUR) + ":");
		System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
		System.out.println(gcalendar.get(Calendar.SECOND));

		// Test if the current year is a leap year
		if (gcalendar.isLeapYear(year)) {
			System.out.println("The current year is a leap year");
		} else {
			System.out.println("The current year is not a leap year");
		}

	}

}
