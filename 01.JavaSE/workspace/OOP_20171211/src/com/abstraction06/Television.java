package com.abstraction06;

//자식 클래스(인터페이스 구현)
public class Television implements RemoteControl {
	
	//전용 필드 추가
	private int volume;
	private int turnOnOff;

	@Override
	public void turnOn() {
		this.turnOnOff = 1;
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		this.turnOnOff = 0;
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		
		//TV 볼륨 조절 액션 추가
		//주의) 최대(MAX_VOLUME), 최소(MIN_VOLUME) 볼륨 범위를 벗어날 수 없도록 설정
		if (this.turnOnOff == 1) {
			if (volume > RemoteControl.MAX_VOLUME) {
				this.volume = RemoteControl.MAX_VOLUME;
			} else if (volume < RemoteControl.MIN_VOLUME) {
				this.volume = RemoteControl.MAX_VOLUME;
			} else {
				this.volume = volume;
			}
			System.out.printf("현재 TV 볼륨 : %d%n", this.volume);
		}

	}

}
