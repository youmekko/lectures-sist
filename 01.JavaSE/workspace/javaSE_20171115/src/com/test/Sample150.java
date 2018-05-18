package com.test;

public class Sample150 {

	public static void main(String[] args) {


		//열거타입(참조형)
		
		//열거타입명 변수 = 열거타입.열거상수;

		//today1, today2 변수에 MONDAY 값을 가진 Week 객체의 참조주소가 전달된다.
		Week today1 = Week.MONDAY;
		Week today2 = Week.MONDAY;
		
		System.out.println(today1);
		
		//참조형 값을 가진 변수에 대한 == 연산은 참조주소를 비교한다.
		System.out.println(today1 == today2);
		
		
	}

}
