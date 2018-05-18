package com.test;

//보드마카에 대한 객체 분석 및 클래스 표현
public class Marker {
	
	//보드마카에 대한 객체 분석
	//state - color(색상)
	//behavior - writing(쓰기)
	//-> fields, methods로 표현
	
	//field 선언
	//객체의 상태 정보 저장
	//자동 초기화 지원 -> null
	private String color;
	
	//constructor 선언
	//객체 생성시 field에 대한 초기화 역할
	public Marker(String color) {
		this.color = color;
	}
	
	//method 선언
	//객체의 행위 특성에 대한 코드 표현
	//매개변수 추가
	//->외부에서 제공되는 자료 수신
	public void writing(String msg) {
		//글쓰기 행위에 대한 코드
		//가상의 칠판(콘솔)
		System.out.printf("(%s)%s%n", this.color, msg);
	}

}
