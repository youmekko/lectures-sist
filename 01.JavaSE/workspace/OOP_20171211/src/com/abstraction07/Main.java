package com.abstraction07;

public class Main {

	public static void main(String[] args) {
		
		//익명 구현 객체
		//인터페이스는 추상이므로 자기 자신을 가지고 객체 생성 할 수 없다.
		//하지만, 인터페이스를 명시적으로 구현한 클래스 없이 바로 객체 생성 가능.
		//인터페이스를 상속 받아서 일시적으로 추상메소드를 오버라이딩할 목적으로 사용하는 임시 객체.
		
		//다형성 구현
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("TV를 켭니다.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("TV를 끕니다.");
			}
			
			@Override
			public void setVolume(int volume) {
				System.out.println("볼륨 조절!");
			}
		};
		
		rc.turnOn();
		rc.setVolume(10);
		rc.turnOff();
		

	}

}
