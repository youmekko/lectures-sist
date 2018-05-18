package com.polymorphism009;

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

//자식 역할 클래스
class Cat extends Animal {
	
	//부모 메소드에 대한 오버라이딩(Overriding)
	@Override
	public void move() {
		System.out.println("Cats can walk and run");
	}
	
}

//실행 테스트 클래스
public class TestDog {

	public static void main(String args[]) {

		//다형성 구현 및 멤버 확인
		//->여러개의 Dog, Cat 객체 준비
		//->Animal 자료형의 배열에 저장
		
		Animal[] ani = new Animal[5];
		ani[0] = new Dog();
		ani[1] = new Dog();
		ani[2] = new Dog();
		ani[3] = new Cat();
		ani[4] = new Cat();
		
		for (Animal a : ani) {

			//move() 메소드는 오버라이딩(Overriding) 상태이므로 Dog, Cat 전용 move()가 호출된다.
			a.move();

			//Animal 변수 a에 저장된 객체(Dog 객체, Cat 객체)를 Dog 자료형으로 변환.
			//->Cat 객체를 Dog 자료형으로 변환하는 경우 오류. ClassCastException
			//->Dog 객체인지 검사하는 과정 필요
			//->instanceof 연산자 사용
			if (a instanceof Dog) {
				//Dog 객체인 경우만 형변환 시도
				Dog d = (Dog)a;
				//Dog 클래스의 bark() 메소드 호출
				d.bark();
			}
			
		}
		
	}
}