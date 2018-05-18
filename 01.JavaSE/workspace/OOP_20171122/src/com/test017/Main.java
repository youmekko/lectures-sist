package com.test017;

public class Main {

	public static void main(String[] args) {
		
		//캡슐화(Encapsulation) 테스트
		
		//private 접근 생략한 필드 멤버 접근 테스트
		//instance 필드 접근시 객체 생성 필요
		Sample s1 = new Sample();
		
		//객체의 상태를 확인
		System.out.println(s1.currentSpeed); //0
		
		//객체의 상태를 변경
		s1.currentSpeed = 10;

		//객체의 상태를 확인
		System.out.println(s1.currentSpeed); //10
		
		//객체의 상태를 변경. 비정상적 자료를 가지고 변경 시도.
		//->객체의 무결성이 깨진 상태가 된다.
		//->데이터 은닉(캡슐화) 필요
		s1.currentSpeed = -10;
		
		//객체의 상태를 확인
		System.out.println(s1.currentSpeed); //-10

		
	}

}
