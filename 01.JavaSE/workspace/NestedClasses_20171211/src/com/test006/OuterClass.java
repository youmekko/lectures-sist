package com.test006;

//부모 역할 클래스
public class OuterClass {
	
	//정적 멤버 클래스(Static Nested Class)
	//- static 키워드를 이용해서 선언된 중첩 클래스
	//- 자기만의 고유한 필드, 메소드 구성 가능
	//- 정적 멤버를 가질 수 있다.
	static class InnerClass {
		
		//인스턴스 멤버 메소드
		public void instanceMethod() {
			System.out.println("InnerClass의 instanceMethod()");
		}
		
		//정적 멤버 메소드
		public static void staticMethod() {
			System.out.println("InnerClass의 staticMethod()");
		}
		
	}
	
	//인스턴스 멤버 메소드
	public void instanceMethod() {
		System.out.println("OuterClass의 instanceMethod()");
	}
	
	//정적 멤버 메소드
	public static void staticMethod() {
		System.out.println("OuterClass의 staticMethod()");
	}
	
}
