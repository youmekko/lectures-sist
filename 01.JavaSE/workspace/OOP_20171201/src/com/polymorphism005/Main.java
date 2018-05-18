package com.polymorphism005;

//실행 테스트 클래스
public class Main {

	public static void main(String[] args) {

		//다형성 구현 및 멤버 확인
		//->부모 클래스의 메소드만 접근 가능
		//->단, 오버라이딩 상태인 경우 자식 클래스의 메소드가 호출된다.
		SuperClass sub2 = new SubClass();
		sub2.method1();

		
	}

}

