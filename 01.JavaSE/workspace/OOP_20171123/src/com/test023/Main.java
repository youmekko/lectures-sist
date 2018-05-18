package com.test023;

public class Main {

	public static void main(String[] args) {

		//매개변수 목록 있는 생성자 호출 테스트
		//객체(instance)가 생성되어야 instance 메소드 접근 가능.
		//->new 연산자를 이용해서 객체 생성
		//->생성자 호출은 객체 생성시에만 호출 가능
		//->클래스이름 변수 = new 클래스이름(값, ...);
		
		//매개변수 목록 있는 생성자 호출
		//->시그니처 분석
		Sample s1 = new Sample(10);
		
		
		//매개변수에 값 전달이 없으면 오류
		//The constructor Sample() is undefined
		//->기본 생성자 부족
		Sample s2 = new Sample();
		

		//매개변수에 전달되는 값이 많으면 오류
		//The constructor Sample(int, int) is undefined
		//->매개변수 목록 있는 생성자 부족
		Sample s3 = new Sample(10, 20);
		
		
	}

}
