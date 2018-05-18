package com.test009;

//부모 역할 클래스
public class Super {
	
	private int a;
	private int b;
	
	public Super() {
	}

	public Super(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	
	public void setA(int a) {
		this.a = a;
	}

	public void setB(int b) {
		this.b = b;
	}

}
