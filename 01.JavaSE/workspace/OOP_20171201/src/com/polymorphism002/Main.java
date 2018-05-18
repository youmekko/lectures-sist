package com.polymorphism002;

public class Main {
	
	public static void main(String[] args) {
		
		//Tire와 HankookTire는 IS-A 관계이다.
		//->다형성 지원
		Tire t1 = new HankookTire();
		System.out.println(t1.toString());
		
		Tire t2 = new KumhoTire();
		System.out.println(t2.toString());
		
	}

}
