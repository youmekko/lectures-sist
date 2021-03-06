package com.test023;

//생성자 테스트 클래스
public class Sample {
	
	//매개변수 목록 있는 생성자의 명시적 선언
	//생성자는 객체가 가지고 있는 멤버(필드)의 사용자 정의 초기화를 담당
	//매개변수는 외부에서 전달되는 값(자료)에 대한 수신. local 변수이다.
	//->사용자가 명시적 선언한 생성자가 있다면 컴파일러에 의한 기본 생성자 자동 생성이 진행되지 않는다.
	/*
	 
	public 클래스이름(매개변수 리스트) {
		//필드에 사용자 정의 초기화 액션
	}
	
	*/
	
	//instance 변수
	//자동 초기화 -> 0
	private int a; //0

	//매개변수 목록 있는 생성자의 명시적 선언
	//객체 생성시 한 번만 호출
	public Sample(int a) {
		//local 변수 - this 키워드 사용 불가

		//instance 멤버 접근시 this 키워드 사용 권장
		//외부에서 전달된 값을 가진 local 변수 a의 자료를 instance 변수 a에 대입.
		//필드에 사용자 정의 초기화 액션
		this.a = a; //10
		
	}
	
	//필드의 저장된 값을 외부에서 확인할 수 있도록 메소드 추가
	//->getter
	//instance 메소드
	//객체 생성 이후 여러번 호출 가능
	public int getA() {
		return this.a; //10
	}
	
	

}
