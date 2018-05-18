package com.abstraction02;

public class Dog extends Animal {
	
	//Animal클래스의 move() 메소드 상속

	@Override
	public void bark() {
		System.out.println("멍멍!");
	}

}
