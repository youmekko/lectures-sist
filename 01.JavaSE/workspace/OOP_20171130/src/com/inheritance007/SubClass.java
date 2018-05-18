package com.inheritance007;

//자식 역할 클래스
public class SubClass extends SuperClass {
	
	//메소드 오버라이딩(Overriding)
	/*
	
	- 상속 관계인 경우 부모의 멤버(메소드)를 자식 클래스에서 재정의(Overriding)해서 사용할 수 있다.
	- 재정의는 부모 메소드의 기능을 무시하고 자식 클래스에서 새롭게 구현하는 상태.
	- 부모 메소드의 시그니처와 동일한 시그니처를 가진 자식 메소드를 구현하면 된다.
	- @Override 어노테이션(annotation) 지정 가능
	
	*/
	
	//java.lang.Object 클래스의 toString() 메소드가 상속 받은 상태이다.
	//SuperClass의 method1()은 상속 받게 된다.

	//SuperClass의 method2()와 동일하기 때문에 오버라이딩 상태가 된다.
	@Override
	public void method2() {
		System.out.println("SubClass의 method2()");
	}

	//SubClass의 전용 메소드
	public void method3() {
		System.out.println("SubClass의 method3()");
	}
	
}
