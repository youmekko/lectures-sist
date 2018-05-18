package com.test025;

//생성자 테스트 클래스
public class Sample {

	//다른 생성자 호출
	/*
	
	- 생성자 오버로딩 상태인 경우 현재 객체 내부에서 다른 생성자 호출 가능.
	- 생성자 내부에서 다른 생성자 호출 명령 진행.
	- this(), this(값, ...)
	- 생성자 내부 액션을 다른 생성자에게 위임.
	- 주의) 다른 생성자 호출 구문은 생성자 내부에서 가장 처음 위치에만 허용.
	
	*/
	
	private int a;
	private int b;
	
	public Sample() {
		
		//생성자 내부 액션 코드
		//->다른 생성자에게 위임 처리
		//필드 a, b를 0으로 초기화하는 액션을 다른 생성자 호출 구문으로 작성.
		this(0, 0);
		
	}
	
	public Sample(int a) {
		
		//생성자 내부 액션 코드
		//->다른 생성자에게 위임 처리
		//this.a = a;
		this(a, 0);
		
	}
	
	public Sample(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	//필드의 저장된 값을 외부에서 확인할 수 있도록 메소드 추가
	//->getter
	//instance 메소드
	//객체 생성 이후 여러번 호출 가능
	public int getA() {
		return this.a;
	}
	
	public int getB() {
		return this.b;
	}
	
	
}
