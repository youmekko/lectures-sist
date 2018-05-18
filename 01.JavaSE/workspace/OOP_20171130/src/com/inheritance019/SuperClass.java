package com.inheritance019;

public class SuperClass {
	
	//protected 키워드
	/*
	
	- 접근 제한자(public, protected, default, private)의 한 종류
	- 같은 패키지내에서는 접근 가능. 다른 패키지인 경우 상속 관계일때만 접근 가능.
	- 메소드, 필드 등에 지정한다.
	
	*/
	
	protected void method() {
		System.out.println("com.inheritance019.SuperClass의 protected 메소드");
	}
	
}
