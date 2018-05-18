package com.test006;

public class Util {
	
	//와일드 카드(?) 타입 매개변수
	
	//매개변수 목록에 Box<T> 자료형을 가지는 변수 선언
	//->Box<?> 형태로 자료형 선언 필요
	//->?는 모든 자료형이 가능하다는 의미
	public static String getString1(Box<?> t) {
		return t.toString();
	}

	//매개변수 목록에 Box<T> 자료형을 가지는 변수 선언
	//->Box<? extends Number> 형태로 자료형 선언 필요
	//->? extends Number는 제한된 범위의 자료형만 가능하다는 의미
	public static String getString2(Box<? extends Number> t) {
		return t.toString();
	}

	//매개변수 목록에 Box<T> 자료형을 가지는 변수 선언
	//->Box<? super Integer> 형태로 자료형 선언 필요
	//->? super Integer는 제한된 범위의 자료형만 가능하다는 의미
	public static String getString3(Box<? super Integer> t) {
		return t.toString();
	}

}
