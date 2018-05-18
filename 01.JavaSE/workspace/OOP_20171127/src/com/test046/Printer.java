package com.test046;

public class Printer {
	
	//chapter6. 확인문제17.
	
	//메소드 오버로딩(Overloading)
	//이름은 같고, 매개변수 구성은 다른 메소드 여러개 선언된 상태.
	//->static 메소드로 구성
	
	public static void println(int x) {
		System.out.println(x);
	}
	public static void println(boolean x) {
		System.out.println(x);
	}
	public static void println(double x) {
		System.out.println(x);
	}
	public static void println(String x) {
		System.out.println(x);
	}
	

}
