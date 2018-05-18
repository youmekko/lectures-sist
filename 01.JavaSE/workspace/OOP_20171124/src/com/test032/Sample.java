package com.test032;

public class Sample {
	
	//필드 초기화
	/*
	
	- 필드 초기화는 아래 순서대로 진행된다.
	1. 자동 초기화
	2. 명시적 초기화
	3. 생성자에 의한 초기화. 단, instance 필드에 대해서만.
	4. static 초기화 블럭에 의한 초기화. 단, static 필드에 대해서만.
	
	- 자동 초기화는 (객체 생성시) 기본값으로 초기화되는 상태. int 자료형은 0, double 자료형은 0.0, 참조형(클래스, 열거형, 배열, 인터페이스)은 null로 초기화 된다.
	- 명시적 초기화는 사용자가 값을 임의로 지정해서 초기화하는 상태. 대입(할당) 연산자 사용.
	
	*/	
	
	//자동 초기화
	private int a;
	
	//명시적 초기화
	private int b = 10;

	//같은 자료형을 가진 필드를 같이 선언
	private static int c, d = 10;
	
	//instance getter 
	public int getA() {
		return this.a;
	}
	
	//static getter
	public static int getC() {
		return Sample.c;
	}
	
}
