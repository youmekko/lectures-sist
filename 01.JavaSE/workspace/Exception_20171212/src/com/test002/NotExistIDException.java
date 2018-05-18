package com.test002;

//사용자 정의 예외 클래스
//->Exception 클래스 상속 지정 필수
//->checked exception 상태가 된다.
public class NotExistIDException extends Exception {

	public NotExistIDException() {
		super();
	}

	public NotExistIDException(String message) {
		super(message);
	}

}
