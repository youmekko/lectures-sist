package com.test002;

//사용자 정의 예외 클래스
//->Exception 클래스 상속 지정 필수
//->checked exception 상태가 된다.
public class WrongPasswordException extends Exception {

	public WrongPasswordException() {
		super();
	}

	public WrongPasswordException(String message) {
		super(message);
	}

}
