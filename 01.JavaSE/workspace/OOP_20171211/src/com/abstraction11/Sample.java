package com.abstraction11;

public class Sample {
	
	//SubClass01 또는 SubClass02 객체를 사용하는 입장 -> 포함 관계
	//포함 관계 적용시 해당 객체를 명시적 지정하지 않고, 추상 객체를 이용해서 연결하는 것을 권장 -> 약한 결합
	
	//해당 객체를 추상적 객체(인터페이스)로 지정 -> 약한 결합
	//SubClass01 또는 SubClass02 객체의 부모 역할 인터페이스 -> Super
	private Super sub;

	public Sample() {
	}
	
	//매개변수에 의한 다형성 구현
	public Sample(Super sub) {
		this.sub = sub;
	}
	
	public Super getSub() {
		return sub;
	}
	
	public void method() {
		//인터페이스 Super의 자식 클래스(SubClass01 또는 SubClass02)에 대한 오버라이딩 메소드 호출
		this.sub.method();
	}

}
