package com.test008;

public class NestedClassExample {

	public static void main(String[] args) {
		
		//중첩 클래스의 객체 생성 테스트
		
		//OuterClass의 객체 생성
		Car myCar = new Car();
		
		//인스턴스 멤버 클래스의 객체 생성
		Car.Tire tire = myCar.new Tire();
		System.out.println(tire);
		
		//정적 멤버 클래스의 객체 생성
		Car.Engine engine = new Car.Engine();
		System.out.println(engine);

	}

}
