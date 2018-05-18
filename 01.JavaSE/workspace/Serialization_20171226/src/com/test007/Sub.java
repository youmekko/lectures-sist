package com.test007;

//자식 역할 클래스 -> 직렬화 지원 여부 표시하지 않는 상태
//부모가 직렬화 대상 클래스인 경우 자식 클래스는 직렬화 가능
public class Sub extends Super {
	
	private int c;
	
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
