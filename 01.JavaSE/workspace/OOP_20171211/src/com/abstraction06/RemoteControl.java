package com.abstraction06;

//부모 역할 클래스(인터페이스)
public interface RemoteControl {
	
	//상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);

}
