package com.test011;

//메소드 오버로딩 테스트 클래스
public class Sample {
	
	//메소드 오버로딩(Overloading)
	/*
	- 클래스 내에 같은 이름을 가진 메소드가 여러개 선언된 상태.
	- 같은 이름을 가진 식별자(클래스, 변수, 기타) 여러개가 존재하는 것은 잘못된 표현.
	- 메소드 중복 정의 -> 메소드 시그니처(매개변수 구성)가 달라야 한다.
	- 액션 구성이 유사한 메소드를 묶어서 하나의 이름으로 표현. 예를 들어, println() 메소드.
	*/
	
	void method() {
		
		//PrintStream 클래스의 println() 메소드의 매개변수 구성이 다양하다.
		//->메소드 오버로딩 상태
		System.out.println();
		System.out.println(10);
		System.out.println(12.345);
		System.out.println("TEST");
		
	}
	
	
	//더하기 연산 메소드에 대한 오버로딩 테스트
	
	//정수 더하기 연산 메소드 -> int a(int x, int y) -> int add(int x, int y)
	int add(int x, int y) {
		return x + y;
	}
	
	//실수 더하기 연산 메소드 -> double b(double x, double y) -> double add(double x, double y)
	double add(double x, double y) {
		return x + y;
	}	
	
	//문자열 더하기(결합) 연산 메소드 -> String c(String x, String y) -> String add(String x, String y)
	String add(String x, String y) {
		return x + y;
	}

}
