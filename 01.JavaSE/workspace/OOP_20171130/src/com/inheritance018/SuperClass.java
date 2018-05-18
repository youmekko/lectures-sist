package com.inheritance018;

public class SuperClass {
	
	//final 키워드
	/*
	
	- final 키워드는 불변의 특성을 가지는 클래스, 멤버(필드, 메소드) 선언시 사용.
	- final 메소드는 오버라이딩 불가. 메소드 원본 기능 유지.
	- final 메소드 형식
	public final 반환자료형 메소드이름(매개변수 리스트) {
	}
	
	- 이 클래스 안에 있는 일부 메소드는 오버라이딩 금지.
	
	*/

	public final void method1() {
		System.out.println("SuperClass의 method1()");
	}
	
	public void method2() {
		System.out.println("SuperClass의 method2()");
	}
	
}
