package com.inheritance003;

public class Main {

	public static void main(String[] args) {
		
		//자식 클래스의 객체 생성 및 멤버 확인
		SubClass sub = new SubClass();
		
		//System.out.println(sub.field1); //com.inheritance002.SuperClass
		System.out.println(sub.field2);
		//sub.method1(); //com.inheritance002.SuperClass
		sub.method2();

	}

}
