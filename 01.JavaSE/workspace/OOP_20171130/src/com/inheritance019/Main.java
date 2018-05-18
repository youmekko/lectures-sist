package com.inheritance019;

public class Main {

	public static void main(String[] args) {
		
		//protected 메소드가 있는 클래스 객체 생성 및 멤버 확인
		SuperClass sup = new SuperClass();
		
		//protected 메소드 접근 가능 -> 같은 패키지
		sup.method();
		
	}

}
