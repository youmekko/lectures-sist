package com.inheritance006;

//자식 역할 클래스 선언
public class SubClass extends SuperClass {

	//부모가 가진 메소드 시그니처와 동일한 상태의 메소드 선언(Overriding)
	public void method() {
		
		//SuperClass의 method()가 호출되려면 super 키워드 사용.
		//->부모 객체의 instance 멤버 접근시 사용
		super.method();

		//System.out.println("SubClass의 method() 호출");
		
	}
	
	public void method2() {
		
	}
	
	public void method3() {
		//현재 객체의 다른 instance 멤버 접근시 사용
		//->this
		this.method2();
	}
	
}
