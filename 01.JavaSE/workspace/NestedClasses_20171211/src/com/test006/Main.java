package com.test006;

public class Main {

	public static void main(String[] args) {

		//OuterClass 객체 생성 및 인스턴스 멤버 접근
		OuterClass outer = new OuterClass();
		outer.instanceMethod(); //OuterClass의 instanceMethod()
		
		//OuterClass 클래스의 정적 멤버 접근
		OuterClass.staticMethod(); //OuterClass의 staticMethod()
		
		//InnerClass 객체 생성 및 인스턴스 멤버 접근
		OuterClass.InnerClass inner = new OuterClass.InnerClass();
		inner.instanceMethod(); //InnerClass의 instanceMethod()
		
		//InnerClass 클래스의 정적 멤버 접근
		OuterClass.InnerClass.staticMethod(); //InnerClass의 staticMethod()
		
	}

}
