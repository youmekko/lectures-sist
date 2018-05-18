package com.polymorphism008;

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
	
	//자식 클래스의 전용 메소드
	public void bark() {
		System.out.println("Dogs can bark");
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

		//다형성 구현 상태에서 자식 클래스 전용 메소드 호출 불가
		//->부모 클래스의 메소드만 접근 가능
		//b.bark();
		
		
		//Animal 자료형 변수에 저장된 객체를 원래의 자료형으로 변환하면 가능
		//->강제(명시적) 형변환 필요
		Dog c = (Dog)b;
		c.bark();
		
		
	}
}