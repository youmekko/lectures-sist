package com.test026;

public class Main {

	public static void main(String[] args) {
		
		//private 생성자를 가진 클래스의 객체 생성 테스트
		//The constructor Sample() is not visible
		//->객체 생성 불가
		//->instance 메소드 접근 불가
		
		Sample s = new Sample();
		s.method();
		
		//java.lang.Math 클래스는 생성자에 의한 객체 생성 불가
		//The constructor Math() is not visible
		//->private 생성자
		//->객체 생성 불필요
		//->instance 메소드가 전혀 없는 상태이다.
		Math m = new Math();
		

	}

}
