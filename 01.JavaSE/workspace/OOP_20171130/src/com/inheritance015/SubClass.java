package com.inheritance015;

public class SubClass extends SuperClass {


	//부모 생성자 호출
	//super(값, ...)
	
	public SubClass() {
		
		//현재 객체의 다른 생성자 호출
		this(0);
		
	}
	public SubClass(int a) {
		
		//SuperClass의 필드 a는 private 접근제한자 지정한 상태
		//this.a = a;
		//super.a = a;
		
		//부모 객체의 생성자 호출
		super(a);

	}
	
	//필드 a에 대한 값 확인->getter->상속
	
}
