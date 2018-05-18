package com.inheritance010;

//부모 역할 클래스
class Animal {
	public void move() {
		System.out.println("Animals can move");
	}
}

//자식 역할 클래스
class Dog extends Animal {
	
	//부모 메소드에 대한 오버라이딩 구현
	@Override
	public void move() {
		System.out.println("Dogs can walk and run");
	}
	
	//Dog 클래스의 전용 메소드 추가
	public void bark() {
		System.out.println("Dogs can bark");
	}
	   
}

//실행 테스트 클래스
public class TestDog {

	public static void main(String args[]) {
		Animal a = new Animal(); // Animal reference and object
		
		//자식 클래스의 객체(Dog 객체)를 부모 클래스(Animal) 자료형의 변수(b)에 저장 가능
		//->다형성(polymophism)
		Animal b = new Dog(); // Animal reference but Dog object

		a.move(); // runs the method in Animal class
		b.move(); // runs the method in Dog class
		
		Dog c = new Dog();
		c.move(); // runs the method in Dog class
		
		//Dog 클래스의 전용 메소드인 bark() 메소드 호출 테스트
		//b.bark(); //변수 b가 Animal 자료형이기 때문에 bark() 메소드 접근 불가
		c.bark();
		
	}
}
