package com.inheritance006;

//부모 역할 클래스 선언
public class SuperClass {
	
	public void method() {
		System.out.println("SuperClass의 method() 호출");
	}
	
	public void sample() {
		//Object 클래스의 객체 -> super 키워드
		System.out.println(super.toString());
	}

}
