package com.test004;

//제네릭 클래스 선언
/*
- 기본 형식(클래스인 경우)
- 클래스명 뒤에 타입 파라미터를 표현한 경우
public class 클래스명<T> {
}
-선언된 타입 파라미터를 클래스 내부에서 필드, 메소드, 매개변수 등에서 자료형으로 사용할 수 있다.
-선언된 타입 파라미터에 실제 적용할 자료형은 클래스의 객체 생성시 결정된다.
*/

public class Box<T> {

	//필드 선언시 변수의 자료형에 타입 파라미터에 사용된 자료형을 사용한 예
	private T t;

	//메소드 선언시 반환자료형에 타입 파라미터에 사용된 자료형을 사용한 예
	public T getT() {
		return t;
	}

	//메소드 선언시 매개변수에 타입 파라미터에 사용된 자료형을 사용한 예
	public void setT(T t) {
		this.t = t;
	}

}