package com.test004;


public class Util {
	
	//제네릭 메소드
	/*
	- 기본 형식(메소드인 경우)
	- 반환자료형, 매개변수 목록에 타입 파라미터 표현이 있는 경우
	public <T> 반환자료형<T> 메소드명(T 변수명) {
	}
	*/
	
	public static <T> Box<T> boxing(T t) {
		
		Box<T> box = new Box<T>();
		box.setT(t);
		return box;
		
	}
	
	
	public static <K, V> boolean compare(Pair<K,V> p1, Pair<K,V> p2) {
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		//키와 값이 모두 같은 경우만 같은 객체로 인정
		return keyCompare && valueCompare;
		
	}

}
