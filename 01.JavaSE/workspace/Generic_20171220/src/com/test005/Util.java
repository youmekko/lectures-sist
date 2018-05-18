package com.test005;

public class Util {

	//제한된 타입 파라미터 <T extends 최상위타입>
	//-타입 파라미터 지정시 범위 지정 가능. 단, 범위는 IS-A 관계인 경우만 가능.
	//-<T extends 최상위타입> 표현은 최상위타입 하위 자료형만 가능하다는 의미가 된다. 예를 들어, <T extends Number>인 경우 Number 자료형의 하위 자료형만 가능하다는 의미이다.
	
	
	//T는 Number의 하위 자료형만 가능
	public static <T extends Number> int compare(T t1, T t2) {
		
		//모든 숫자 자료형은 doubleValue() 메소드를 지원한다.
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		//숫자 자료 두 개에 대한 비교 액션
		return Double.compare(v1, v2);
		
	}
	
}
