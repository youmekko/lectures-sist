package com.inheritance018;

public class SubClass extends SuperClass {
	
	//부모 메소드의 시그시처를 동일하게 작성 -> 오버라이딩(Overriding)
	//Cannot override the final method from SuperClass
	/*
	@Override
	public final void method1() {
		System.out.println("SubClass의 method1()");
	}
	*/
	
	
	//부모 메소드의 시그시처를 동일하게 작성 -> 오버라이딩(Overriding)
	@Override
	public void method2() {
		System.out.println("SubClass의 method2()");
	}
	
}
