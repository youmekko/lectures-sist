package com.test035;

public class Sample {
	
	//final 필드 초기화
	/*
	
	- final 필드는 final 키워드가 붙은 필드. 멤버(필드, 메소드)의 상태를 변경 불가 상태로 만든다.
	- 초기화 이후 변경 불가능한 필드가 된다. 일반 필드는 초기화 이후에도 setter를 이용해서 변경 가능.
	- 외부에서 필드 접근시 read-only 상태이므로 getter만 필요하다.
	- 초기화는 명시적 초기화, 생성자에 의한 초기화만 가능.
	- 형식
	private final 자료형 변수명 = 값; 
	
	*/
	
	//일반 필드
	//->자동 초기화 지원 가능
	private int a;
	
	//final 필드
	//->자동 초기화 지원 불가
	private final int b = 10;
	private final int c;
	
	public Sample() {
		this(20);
	}
	
	public Sample(int c) {
		this.c = c;
	}
	
	//일반 필드 -> getter(O), setter(O)
	public int getA() {
		return this.a;
	}
	public void setA(int a) {
		this.a = a;
	}
	
	//final 필드 -> getter(O), setter(X) -> read-only
	public int getB() {
		return this.b;
	}
	/*
	public void setB(int b) {
		//The final field Sample.b cannot be assigned
		this.b = b;
	}
	*/
	
	
}
