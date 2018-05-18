package com.test003;

public class Util {
	
	
	//문제) getValue() 제네릭 메소드 선언
	//첫 번째 매개값으로 Pair 타입과 하위 타입만 받고, 두 번째 매개값으로 키(String 자료형)를 받는다.
	//리턴값은 키값이 일치할 경우 Pair에 저장된 값(Integer 자료형)을 리턴하고, 일치하지 않는 경우 null 반환.
	
	//메소드 시그니처 분석
	//public static 자료형 getValue(매개변수1, 매개변수2)
	public static <T extends Pair<String, Integer>> Integer getValue(T t, String key) {
		
		Integer result = null;
		if (t.getKey().equals(key)) {
			result = (Integer) t.getValue();
		}
		return result;
		
	}
	
	
	
}
