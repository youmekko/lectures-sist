package com.test007;

import java.io.Serializable;

//부모 역할 클래스 -> 직렬화 가능 클래스
public class Super implements Serializable {
	
	private int a;
	private int b;
	
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
	

}
