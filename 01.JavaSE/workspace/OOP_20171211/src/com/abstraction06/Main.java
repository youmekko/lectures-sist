package com.abstraction06;

public class Main {

	public static void main(String[] args) {
		
		//다형성 구현
		RemoteControl tv = new Television();

		tv.turnOn();
		tv.setVolume(5);
		tv.turnOff();
		
		tv.setVolume(3);

	}

}
