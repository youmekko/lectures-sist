package com.abstraction01;

//자식 역할 클래스
//The type SubClass must implement the inherited abstract method SuperClass.method2()
//주의) 부모 클래스가 추상 클래스이거나, 인터페이스인 경우 부모의 추상 메소드를 반드시 오버라이딩해야 한다.
public class SubClass extends SuperClass {
	
	//SuperClass의 method1()에 대한 상속

	@Override
	public void method2() {
		System.out.println("SuperClass의 method2()에 대한 오버라이딩 메소드");
	}
	
}
