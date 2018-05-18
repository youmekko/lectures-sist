package com.test045;

public class Printer {
	
	//chapter6. 확인문제16.
	
	//메소드 오버로딩(Overloading)
	//이름은 같고, 매개변수 구성은 다른 메소드 여러개 선언된 상태.
	public void println(int x) {
		System.out.println(x);
	}
	public void println(boolean x) {
		System.out.println(x);
	}
	public void println(double x) {
		System.out.println(x);
	}
	public void println(String x) {
		System.out.println(x);
	}
	

}
