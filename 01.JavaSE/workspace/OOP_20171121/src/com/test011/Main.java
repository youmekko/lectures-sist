package com.test011;

public class Main {

	public static void main(String[] args) {

		//메소드 오버로딩 테스트
		
		//객체 생성-> instance 메소드 호출 전제 조건 
		Sample s = new Sample();
		
		//오버로딩 메소드 호출 
		//->JVM이 메소드에 전달되는 매개값의 자료형을 기준으로 적절한 메소드를 선택 호출한다.
		System.out.println(s.add(10, 20));
		System.out.println(s.add(1.23, 2.34));
		System.out.println(s.add("TEST", "HELLO"));
		
	}

}
