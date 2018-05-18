package com.abstraction01;

public class Main {

	public static void main(String[] args) {
	
		//추상 클래스의 객체 생성 테스트
		//Cannot instantiate the type SuperClass
		//SuperClass sup = new SuperClass();
		
		//자식 클래스의 객체 생성 테스트
		SubClass sub = new SubClass();
		sub.method1(); //SuperClass
		sub.method2(); //SubClass
		
	}

}
