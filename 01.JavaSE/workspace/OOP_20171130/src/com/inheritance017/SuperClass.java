package com.inheritance017;

public final class SuperClass {
	
	//final 키워드
	/*
	
	- final 키워드는 불변의 특성을 가지는 클래스, 멤버(필드, 메소드) 선언시 사용.
	- final 클래스는 상속 불가 클래스. 최종 클래스. 부모 클래스 지정 불가 상태.
	- final 클래스 형식
	public final class 클래스이름 {
	}
	
	- 대표적인 final 클래스는 java.lang.String 클래스이다.
	- 이 클래스 안에 있는 모든 메소드는 오버라이딩 금지.
	
	*/

	public void method() {
		System.out.println("SuperClass의 method()");
	}
	
	
}
