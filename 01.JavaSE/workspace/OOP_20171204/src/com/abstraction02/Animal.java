package com.abstraction02;

//부모 역할 클래스
public abstract class Animal {
	
	//일반 메소드
	public void move() {
		System.out.println("이동한다.");
	}
	
	//추상 메소드 추가
	public abstract void bark();

}
