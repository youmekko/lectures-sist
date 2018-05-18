package com.test018;

public class Main {

	public static void main(String[] args) {

		// 캡슐화(Encapsulation) 테스트

		// private 접근 지정한 필드 멤버 접근 테스트
		// instance 필드 접근시 객체 생성 필요
		Sample s1 = new Sample();

		// 객체의 상태를 직접 확인 불가
		// The field Sample.currentSpeed is not visible
		// System.out.println(s1.currentSpeed);

		// 객체의 상태를 직접 변경 불가
		// The field Sample.currentSpeed is not visible
		// s1.currentSpeed = 10;

		// 객체의 상태를 간접 확인 가능
		System.out.println(s1.getCurrentSpeed()); //0
		
		// 객체의 상태를 간접 변경 가능
		s1.setCurrentSpeed(10);

		// 객체의 상태를 간접 확인 가능
		System.out.println(s1.getCurrentSpeed()); //10

		
		//객체의 상태를 변경. 비정상적 자료를 가지고 변경 시도.
		s1.setCurrentSpeed(-10);
		
		// 객체의 상태를 간접 확인 가능
		System.out.println(s1.getCurrentSpeed()); //10
		
	}

}
