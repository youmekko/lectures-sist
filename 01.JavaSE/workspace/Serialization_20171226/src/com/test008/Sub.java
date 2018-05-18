package com.test008;

import java.io.Serializable;

//자식 역할 클래스 -> 직렬화 가능 클래스
//부모는 직렬화 대상이 아니고, 자식만 직렬화 가능 클래스인 경우 부모의 필드는 직렬화 대상에서 제외된다.
public class Sub extends Super implements Serializable {
	
	private int c;
	
	public Sub() {
	}

	public Sub(int a, int b) {
		super(a, b);
	}

	public Sub(int a, int b, int c) {
		super(a, b);
		this.c = c;
	}

	public int getC() {
		return c;
	}
	

}
