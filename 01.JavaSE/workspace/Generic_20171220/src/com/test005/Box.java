package com.test005;

//제한된 타입 파라미터 <T extends 최상위타입>
//-타입 파라미터 지정시 범위 지정 가능. 단, 범위는 IS-A 관계인 경우만 가능.
//-<T extends 최상위타입> 표현은 최상위타입 하위 자료형만 가능하다는 의미가 된다. 예를 들어, <T extends Number>인 경우 Number 자료형의 하위 자료형만 가능하다는 의미이다.
public class Box<T extends Number> {

	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}
