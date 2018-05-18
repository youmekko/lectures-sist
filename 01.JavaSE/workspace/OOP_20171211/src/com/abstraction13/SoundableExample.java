package com.abstraction13;

public class SoundableExample {
	
	//매개변수에 의한 다형성 구현
	//주의) Cat, Dog 클래스는 반드시 Soundable 인터페이스를 상속 지정해야 한다.
	private static void printSound(Soundable soundable) {
		//특정 객체(Cat or Dog 객체)의 오버라이딩 메소드 호출
		System.out.println(soundable.sound());
	}

	public static void main(String[] args) {
		
		printSound(new Cat()); //야옹
		
		printSound(new Dog()); //멍멍
		
	}

}
