package com.inheritance015;

public class SuperClass {

	//필드 초기화
	//1. 자동 초기화 -> instance, static 필드. 단, final 제외.
	//2. 명시적 초기화 -> instance, static 필드
	//3. 생성자에 의한 초기화 -> instance 필드
	//4. static 초기화 블럭 -> static 필드
	
	private int a;
	
	public SuperClass() {
		//다른 생성자 호출
		this(0);
	}
	public SuperClass(int a) {
		this.a = a;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

}
