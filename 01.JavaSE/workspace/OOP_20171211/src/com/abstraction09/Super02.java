package com.abstraction09;

//인터페이스 상속
//인터페이스끼리 상속 관계 지정 가능. extends 키워드 사용. 다중 상속 허용.
//부모 역할 클래스(인터페이스)
public interface Super02 extends Super01 {
	
	//주의) 부모의 추상 메소드를 자식 인터페이스에서 오버라이딩 구현하지 않는다.

	//자기 자신의 추상 메소드(public abstract 키워드 생략) 추가
	void method2();
	
}
