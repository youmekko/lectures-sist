package com.polymorphism005;

//자식 역할 클래스
public class SubClass extends SuperClass {
	
	//SuperClass의 method1() 오버라이딩
	@Override
	public void method1() {
		System.out.println("SubClass의 method1()");
	}	
	

	public void method2() {
		System.out.println("SubClass의 method2()");
	}

	
}
