package com.test024;

//생성자 테스트 클래스
public class Sample {

	//생성자 오버로딩(Overloading)
	/*
	- 클래스 내에 생성자가 여러개 선언된 상태.
	- 같은 이름을 가진 식별자(클래스, 변수, 기타) 여러개가 존재하는 것은 잘못된 표현.
	- 생성자 중복 정의 -> 시그니처(매개변수 구성)가 달라야 한다.
	- 기본 생성자(필수) + 매개변수 목록 있는 생성자 등으로 구성
	*/
	
	private int a;
	private int b;
	
	public Sample() {
	}
	
	public Sample(int a) {
		this.a = a;
	}
	
	public Sample(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	//필드의 저장된 값을 외부에서 확인할 수 있도록 메소드 추가
	//->getter
	//instance 메소드
	//객체 생성 이후 여러번 호출 가능
	public int getA() {
		return this.a;
	}
	
	public int getB() {
		return this.b;
	}
	
	
}
