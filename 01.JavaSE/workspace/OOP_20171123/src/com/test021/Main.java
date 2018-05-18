package com.test021;

public class Main {

	public static void main(String[] args) {
		
		//기본 생성자 호출 테스트
		//객체(instance)가 생성되어야 instance 메소드 접근 가능.
		//->new 연산자를 이용해서 객체 생성
		//->생성자 호출은 객체 생성시에만 호출 가능
		//->클래스이름 변수 = new 클래스이름();
		
		//생성자 호출은 객체 생성시에만 호출 가능
		Sample s = new Sample();
		
		//일반 메소드처럼 추가(반복) 호출 불가
		//s.Sample();
		

	}

}
