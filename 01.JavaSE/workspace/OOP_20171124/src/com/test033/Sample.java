package com.test033;

public class Sample {
	
	//필드 초기화
	/*
	
	- 필드 초기화는 아래 순서대로 진행된다.
	1. 자동 초기화
	2. 명시적 초기화
	3. 생성자에 의한 초기화. 단, instance 필드에 대해서만.
	4. static 초기화 블럭에 의한 초기화. 단, static 필드에 대해서만.
	
	- 생성자에 의한 초기화는 내부 자료만이 아니라, 외부 자료를 이용해서 초기화 가능.
	- 매개변수 목록이 있는 생성자 준비 필요. 단, 기본 생성자와 같이 준비한다. 생성자 오버로딩(Overloading).

	*/
	
	//instance 필드
	private int a;
	
	//기본 생성자
	public Sample() {
		//명시적 초기화 ->10 -> 다른 생성자 호출
		this(10);
	}
	
	//매개변수 목록이 있는 생성자
	//생성자에 의한 초기화 -> 외부 자료를 이용해서 초기화 가능
	public Sample(int a) {
		this.a = a;
	}
	
	//getter
	public int getA() {
		return this.a;
	}
	
	
}
