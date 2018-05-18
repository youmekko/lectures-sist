package com.inheritance012;

public class SubClass extends SuperClass {

	//SuperClass의 method1() 메소드 상속
	
	public void method2() {
		System.out.println("SubClass의 method2()");
	}
	
	public void method3() {
		super.method1(); //SuperClass의 method1()
		this.method1(); //SuperClass의 method1()
	}
	
}
