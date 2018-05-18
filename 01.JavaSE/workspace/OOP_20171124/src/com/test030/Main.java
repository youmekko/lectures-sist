package com.test030;

public class Main {

	public static void main(String[] args) {
		
		//대표적인 static 필드인 상수 테스트
		//Math 클래스의 상수인 PI 값 출력
		//클래스명.필드명
		//->new 연산자에 의한 객체 생성 불필요
		System.out.println(Math.PI);
		
		//Math 클래스의 대표적인 static 메소드 테스트
		//클래스명.메소드명()
		//->new 연산자에 의한 객체 생성 불필요
		//0.0 이상 ~ 1.0 미만의 실수 난수
		System.out.println(Math.random());
		//->난수 관련 전용 클래스 java.util.Random 클래스 사용 권장
		
		
		//Sample 클래스의 static 메소드 테스트
		//->시그니처 분석 -> public static void method()
		Sample.method();

		
	}

}
