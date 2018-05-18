package com.test001;

//사용자 정의 예외 클래스 선언
//->Exception 클래스에 대한 상속 지정 필수
//->checked exception 상태가 된다.
//주의) 클래스명 작성시 예외 상황을 표현할 수 있는 이름 사용할 것.
public class DivideByZeroException extends Exception {
	
	//메시지가 없는 예외 객체 생성시 사용
	public DivideByZeroException() {
		
	}
	
	//메시지가 있는 예외 객체 생성시 사용
	public DivideByZeroException(String message) {
		//부모 클래스(Exception)의 매개변수 있는 생성자 호출
		super(message);
	}

}
