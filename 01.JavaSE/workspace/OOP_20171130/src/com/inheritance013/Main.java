package com.inheritance013;

public class Main {

	public static void main(String[] args) {

		//자식 클래스 객체 생성 및 멤버 확인
		SubClass sub = new SubClass();
		
		sub.method3();
		
		//SuperClass의 상수 멤버(A) 접근
		System.out.println(SuperClass.A);
		
		
	}

}
