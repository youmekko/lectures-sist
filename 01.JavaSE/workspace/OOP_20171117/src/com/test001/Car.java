package com.test001;

//자동차 클래스 선언
public class Car {
	
	//필드(멤버변수) 선언
	//객체의 상태 정보 저장용 변수 선언
	//접근제한자 자료형 변수명;
	//접근제한자 자료형 변수명 = 초기값;
	//자동 초기화 지원 -> 객체 생성시(new 연산자) 초기화
	//접근제한자는 외부에서 멤버 접근할 때 사용. 필드는 private 접근제한자 권장.
	//접근제한자는 생략 가능.
	
	//초기값 설정시 임의의 값 지정 가능
	String company = "현대자동차";
	String model = "그랜저";
	int maxSpeed = 300;
	
	//자동 초기화 지원
	//int형은 0, double형은 0.0, 참조형은 null로 초기화.
	int currentSpeed;

}
