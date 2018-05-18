package com.inheritance020;

import com.inheritance019.*;

public class Main {

	public static void main(String[] args) {
		
		//다른 패키지에 있는 protected 메소드가 있는 클래스 객체 생성 및 멤버 확인
		SuperClass sup = new SuperClass();
		
		//protected 메소드 접근 불가 -> 다른 패키지
		//The method method() from the type SuperClass is not visible
		//sup.method();
		
		
		//다른 패키지에 있는 protected 메소드가 있는 클래스 상속 받은 자식 클래스 객체 생성
		SubClass sub = new SubClass();
		//부모 메소드 호출 기능이 있는 자식 메소드 호출
		sub.method();
		
	}

}
