package com.test003;

//리플렉션 대상 클래스
public class Sample {
	
	private int a;
	private String b;
	
	public Sample() {
		
	}
	public Sample(int a, String b) {
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	
	@Override
	public String toString() {
		return String.format("a: %s, b: %s%n ", this.a, this.b);
	}

}
