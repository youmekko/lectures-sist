package com.test018;

//캡슐화(Encapsulation) 테스트 클래스
public class Sample {

	//캡슐화(Encapsulation)
	
	//private 접근 제한자 지정한 경우
	//외부에서 객체의 상태에 대한 직접 변경/사용 불가
	//instance 필드 -> 객체 생성시부터 객체 소멸시까지 활동 가능. 클래스 내부 전체에서 활동 가능.
	//->instance 필드 사용시 this.변수명 형식으로 사용 권장
	private int currentSpeed;
	
	//외부에서 객체의 상태에 대한 간접 변경/사용 가능
	//->getter, setter 메소드 추가
	/*
	
	public 자료형 get변수명() {
		return this.변수명;
	}
	public void set변수명(자료형 변수명) {
		this.변수명 = 변수명;
	}
	
	*/

	//객체의 상태에 대한 간접 사용
	public int getCurrentSpeed() {
		return this.currentSpeed;
	}
	
	//객체의 상태에 대한 간접 변경
	public void setCurrentSpeed(int currentSpeed) {
		//this 키워드는 객체(instance)의 멤버(필드, 메소드)에만 사용 가능
		//주의) 로컬 변수에는 this 키워드 사용 불가
		//외부에서 전달되는 자료에 검증 과정 추가 가능
		if (currentSpeed >= 0) {
			this.currentSpeed = currentSpeed;
		}
	}

	
}
