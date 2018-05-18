package com.test001;

public class OuterClass {
	
	//중첩 클래스
	/*
	
	- 클래스 선언 내부에 또다른 클래스 선언이 포함된 상태
	- 일반적으로 클래스 멤버는 필드와 메소드(생성자 포함)로 구성된다. 멤버 구성에 중첩 클래스를 추가할 수 있다.
	- 중첩 클래스 분류
	1. Non-static Nested Classes - inner class, method local inner class, anonymous inner class로 세분류
	2. static nested classes
	
	*/
	
	//인스턴스 멤버 메소드
	public void outerMethod() {
		System.out.println("OuterClass의 outerMethod()");
		
		//InnerClass에 대한 객체 생성 및 멤버 접근
		InnerClass inner = new InnerClass();
		inner.innerMethod();
		
	}
	
	
	//인스턴스 멤버 클래스
	//- static 키워드 없이 선언된 중첩 클래스
	//- 내부에서만 사용할 목적으로 선언하기 때문에 주로 private 지정. default 지정 가능. public 권장 하지 않는다.
	//- 객체 생성시 OuterClass의 객체가 생성되어야 InnerClass의 객체 생성 가능
	private class InnerClass {
		
		//자기만의 고유한 필드, 메소드 구성 가능
		//주의) 정적 멤버를 가질 수 없다.
		
		//인스턴스 멤버 메소드
		public void innerMethod() {
			System.out.println("InnerClass의 innerMethod()");
		}
		
	}

}
