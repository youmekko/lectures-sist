package com.test;

public class Sample035 {

	public static void main(String[] args) {
		
		//난수 : 무작위로 발생하는 일정 범위 수
		//0.0 <= Math.random() < 1.0
		//-> 정수화 시켜서 사용하는 경우가 많다. 예를 들어 0 ~ 100 사이의 정수 난수.
		
		//실수 난수(0.0 <= 난수 < 1.0)
		System.out.println(Math.random());
		
		//정수 난수(0 <=  난수 < 100)
		System.out.println( (int)(Math.random()*100) );
		
		//정수 난수(1 <=  난수 <= 100)
		//System.out.println( ?? );

		//정수 난수(0 <=  난수 <= 100)
		//System.out.println( ?? );

	}

}
