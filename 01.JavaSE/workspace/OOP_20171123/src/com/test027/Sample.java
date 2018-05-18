package com.test027;

//생성자 테스트 클래스
public class Sample {
	
	//싱글톤(singleton) 패턴
	/*
	
	 - Gof 디자인 패턴의 한 종류
	 - 이 분야의 사인방(Gang of Four, 줄여 GoF)으로 불리는 에리히 감마(Erich Gamma), 리처드 헬름(Richard Helm), 랄프 존슨(Ralph Johnson), 존 블리시데스(John Vlissides)
	 - 생성 패턴(Creational Patterns), 구조 패턴(Structural Patterns), 행위 패턴(Behavioral Patterns)
	 - 한 클래스에 한 객체만 생성(존재)하도록 제한한다.
	 - 사용자가 직접 객체 생성 요구하는 상황 제한(private 생성자) + 객체 생성 요구를 처리하는 전용 메소드 추가
	
	*/

	//정적(static) 필드
	//->초기값으로 객체 생성된 결과(참조주소) 저장
	//->메모리에 Sample 객체(instance)는 한 개인 상태를 유지.
	private static Sample singleton = new Sample();
	
	//private 생성자
	//사용자가 직접 객체 생성 요구하는 상황 제한
	private Sample() {
	}
	
	
	//정적(static) 메소드
	//객체 생성 요구를 처리하는 전용 메소드
	public static Sample getInstance() {
		//Sample 객체에 대한 참조주소 반환
		//->new 연산자에 의한 추가 객체 생성은 없다.
		return singleton;
	}
	

}
