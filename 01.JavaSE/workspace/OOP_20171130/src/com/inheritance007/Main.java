package com.inheritance007;

//실행 테스트 클래스
public class Main {

	public static void main(String[] args) {

		//자식 클래스의 객체 생성 및 멤버 확인
		SubClass sub = new SubClass();
		
		sub.method1(); //SuperClass
		sub.method2(); //SubClass
		sub.method3(); //SubClass
		
		//toString() - 객체의 정보 반환
		System.out.println(sub.toString()); //java.lang.Object
		
		String str = new String("TEST");
		//toString() - String 객체가 가진 문자열 반환
		//->toString() 메소드의 원래 기능이 아닌 경우 오버라이딩 상태가 된다. 
		System.out.println(str.toString()); //java.lang.String
		
		Integer i = new Integer(10);
		//toString() - Integer 객체가 가진 숫자를 문자열 형태로 반환
		//->toString() 메소드의 원래 기능이 아닌 경우 오버라이딩 상태가 된다. 
		System.out.println(i.toString() + 10); //1010 java.lang.Integer
		System.out.println(i + 10); //20
		
	}

}
