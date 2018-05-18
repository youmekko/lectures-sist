package com.inheritance013;

public class SubClass extends SuperClass {

	//SuperClass의 method1() 메소드 오버라이딩 구현
	@Override
	public void method1() {
		System.out.println("SubClass의 method1()");
	}
	
	public void method2() {
		System.out.println("SubClass의 method2()");
	}
	
	public void method3() {
		super.method1(); //SuperClass의 method1()
		this.method1(); //SubClass의 method1()
	}
	
}
