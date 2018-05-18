package com.inheritance014;

public class SubClass extends SuperClass {


	//부모 생성자 호출
	/*
	
	- 상속 관계인 경우 자식 객체에서 부모 객체의 생성자를 호출하는 것.
	- 생성자는 public 접근제한자를 가지고 있지만 상속 대상이 아니다.
	- 생성자 역할은 객체의 instance 필드 초기화 담당.
	- 자식 객체의 instance 필드가 부모의 필드를 상속 받은 경우라면 
	초기화 액션을 부모 객체의 생성자에서 해야 한다. 부모 생성자 호출 필요.
	- 자식 객체 생성자 내부에서만 부모 객체 생성자 호출 가능.
	- 형식
	super();
	super(값1, ...);
	- 자식 생성자 내부에서 첫 줄에만 표기 가능.
	- 명시적 선언이 없는 경우 super()는 자식 생성자 내부에서 자동 호출된다. 부모 클래스는 반드시 기본 생성자를 가지고 있어야 한다.
	
	*/
	
	//기본 생성자 생략 가능
	public SubClass() {
	
		//부모 생성자 호출 부분 생략 가능
		//->SuperClass 클래스의 생성자
		//super();
		System.out.println("SubClass 생성자 호출");
		
	}
	
	
}
