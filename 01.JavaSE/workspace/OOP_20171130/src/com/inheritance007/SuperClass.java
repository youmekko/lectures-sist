package com.inheritance007;

//부모 역할 클래스
//상속 지정이 없는 경우 자바의 모든 클래스는 java.lang.Object 클래스를 자동 상속 받는다.
public class SuperClass {
	
	//java.lang.Object 클래스의 toString() 메소드가 상속 받은 상태이다.
	
	public void method1() {
		System.out.println("SuperClass의 method1()");
	}
	
	public void method2() {
		System.out.println("SuperClass의 method2()");
	}

}
