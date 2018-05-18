package com.abstraction02;

public class Main {

	public static void main(String[] args) {
		
		//자식 클래스의 객체를 부모 클래스 자료형 변수에 저장->다형성
		//동물1 -> Cat
		Animal ani01 = new Cat();
		ani01.move();
		ani01.bark(); //야옹!
		
		//동물2 -> Dog
		Animal ani02 = new Dog();
		ani02.move();
		ani02.bark(); //멍멍!

	}

}
