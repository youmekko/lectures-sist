package com.abstraction12;

public class Main {

	public static void main(String[] args) {
		
		//인터페이스의 디폴트 메소드 확인

		//디폴트 메소드 -> 인터페이스를 구현한 모든 자식 객체의 공통 메소드
		//자식 객체를 부모 자료형(인터페이스 포함) 변수에 저장 가능 -> 다형성
		Super sub1 = new SubClass01();
		sub1.method();
		
		Super sub2 = new SubClass02();
		sub2.method();
		
		//주의) 다형성 구현시 부모 객체의 멤버만 접근 가능
		//sub2.method2();
		SubClass02 sub3 = (SubClass02)sub2;
		sub3.method();
		sub3.method2();

	}

}
