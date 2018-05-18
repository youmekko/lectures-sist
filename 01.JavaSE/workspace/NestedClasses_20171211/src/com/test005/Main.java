package com.test005;

public class Main {

	public static void main(String[] args) {

		//중첩 클래스 객체 생성 및 멤버 접근 테스트
		Sample s = new Sample();
		OuterClass inner = s.getInner();
		inner.outerMethod();  //AnonymouseInnerClass에서 오버라이딩한 outerMethod()
		
	}

}
