package com.polymorphism007;

//부모 역할 클래스
class Animal {
	public void move() {
		System.out.println("Animals can move");
	}
}

//자식 역할 클래스
class Dog extends Animal {
	
	//부모 메소드에 대한 오버라이딩(Overriding)
	@Override
	public void move() {
		System.out.println("Dogs can walk and run");
	}
	
}

//실행 테스트 클래스
public class TestDog {

	public static void main(String args[]) {

		Animal a = new Animal(); // Animal reference and object
		a.move(); // runs the method in Animal class
		
		//다형성 구현 및 멤버 확인
		//->부모 클래스의 메소드만 접근 가능
		//->단, 오버라이딩 상태인 경우 자식 클래스의 메소드가 호출된다.
		Animal b = new Dog(); // Animal reference but Dog object
		b.move(); // runs the method in Dog class
		
	}
}