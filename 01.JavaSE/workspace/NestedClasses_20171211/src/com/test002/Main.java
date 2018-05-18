package com.test002;

public class Main {

	public static void main(String[] args) {

		//OuterClass에 대한 객체 생성
		OuterClass outer = new OuterClass();
		outer.outerMethod();
		
		//중첩 클래스 객체 생성 및 멤버 접근 테스트
		OuterClass.InnerClass inner = outer.new InnerClass();
		inner.innerMethod();

	}

}
