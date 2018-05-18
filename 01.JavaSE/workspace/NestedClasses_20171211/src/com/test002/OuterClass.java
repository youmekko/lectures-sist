package com.test002;

public class OuterClass {
	
	//인스턴스 멤버 메소드
	public void outerMethod() {
		System.out.println("OuterClass의 outerMethod()");
	}
	
	
	//인스턴스 멤버 클래스
	//- static 키워드 없이 선언된 중첩 클래스
	//- 내부에서만 사용할 목적으로 선언하기 때문에 주로 private 지정. default 지정 가능. public 권장 하지 않는다.
	//- 객체 생성시 OuterClass의 객체가 생성되어야 InnerClass의 객체 생성 가능
	class InnerClass {
		
		//자기만의 고유한 필드, 메소드 구성 가능
		//주의) 정적 멤버를 가질 수 없다.
		
		//인스턴스 멤버 메소드
		public void innerMethod() {
			System.out.println("InnerClass의 innerMethod()");
		}
		
	}

}
