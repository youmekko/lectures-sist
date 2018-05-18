package com.inheritance011;

class Animal {
	public void move() {
		System.out.println("Animals can move");
	}
}

class Dog extends Animal {
	
	//내부적으로 모든 클래스는 super, this 변수가 자동 생성된다. 객체의 참조주소가 자동 지정된다.
	
	public void move() {
		
		//super 키워드
		/*
		
		- 상속 관계인 경우 부모 객체의 멤버(메소드) 접근시 사용하는 키워드
		- 오버라이딩 메소드의 경우 부모 메소드 접근이 안된다. super 키워드를 이용하면 접근 가능.
		- 자식 클래스의 메소드 내부에서만 사용 가능
		- 형식
		super.메소드()
		
		*/
		
		super.move(); // invokes the super class method
		System.out.println("Dogs can walk and run");
	}
}

public class TestDog {

	public static void main(String args[]) {
		Dog b = new Dog();
		b.move(); // runs the method in Dog class
	}
}