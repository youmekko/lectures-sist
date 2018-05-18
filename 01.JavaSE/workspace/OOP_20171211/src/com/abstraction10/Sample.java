package com.abstraction10;

public class Sample {
	
	//SubClass01 또는 SubClass02 객체를 사용하는 입장 -> 포함 관계
	//포함 관계 적용시 해당 객체를 명시적 지정하지 않고, 추상 객체를 이용해서 연결하는 것을 권장 -> 약한 결합
	
	//해당 객체를 명시적 지정 -> 강한 결합
	private SubClass01 sub;

	public Sample() {
	}
	public Sample(SubClass01 sub) {
		this.sub = sub;
	}
	
	public SubClass01 getSub() {
		return sub;
	}
	
	public void method() {
		//SubClass01의 전용 메소드 호출
		this.sub.method();
	}

}
