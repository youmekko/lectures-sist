package com.polymorphism004;

//실행 테스트 클래스
public class Main {

	public static void main(String[] args) {

		//자식 클래스의 객체 생성 및 멤버 확인
		SubClass sub1 = new SubClass();
		sub1.method1();
		sub1.method2();
		

		//다형성 구현 및 멤버 확인
		//->부모 클래스의 메소드만 접근 가능
		SuperClass sub2 = new SubClass();
		sub2.method1();
		sub2.method2();
		
		
		//다형성 구현 및 멤버 확인
		//->부모 클래스의 메소드만 접근 가능
		Object sub3 = new SubClass();
		sub3.method1();
		sub3.method2();
		
		
		//상위 자료형 변수에 저장된 하위 자료형 객체를 원래 자료형으로 형변환
		//->강제(명시적) 형변환
		//->하위 자료형 클래스의 메소드 접근 가능
		SubClass sub4 = (SubClass)sub3;
		sub4.method1();
		sub4.method2();
		
	}

}
