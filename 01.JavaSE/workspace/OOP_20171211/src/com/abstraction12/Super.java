package com.abstraction12;

//부모 역할 클래스(인터페이스)
public interface Super {
	
	//디폴트 메소드
	//주의) 자바8 이후에만 사용 가능
	/*
	- 형식
	public interface 인터페이스명 {
		
		//디폴트 메소드 구현(public 키워드 생략)
		default 반환자료형 메소드이름(매개변수 리스트) {
		}
		
	}
	*/
	//주의) 인터페이스는 객체 생성 할 수 없기 때문에 디폴트 메소드를 자식 객체를 통해서 사용해야 한다.
	//인터페이스를 구현하는 구현 객체가 기본으로 가지는 메소드. 오버라이딩 가능.
	
	default void method() {
		System.out.println("인터페이스의 디폴트 메소드 호출");
	}

}
