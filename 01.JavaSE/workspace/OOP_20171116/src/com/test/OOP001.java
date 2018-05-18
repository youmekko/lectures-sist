package com.test;

public class OOP001 {

	public static void main(String[] args) {
		
		//준비된 클래스에 대한 메모리 적재
		//->객체 생성
		//->생성된 객체는 instance가 된다.
		//->사용 가능한 상태
		//->new 키워드
		//클래스이름  변수 = new 클래스이름();
		//->Marker 객체 생성시 색상 정보 제공
		Marker m1 = new Marker("black");
		
		//가상의 칠판(콘솔)에 보드마카 객체를 이용해서 글쓰기 행위를 한다.
		//->메소드 호출
		//->변수.메소드명();
		m1.writing("Hello, World!");
		

		//하나의 클래스(blueprint)를 가지고 여러개의 객체(instance) 생성 가능
		//->행동 특성, 상태 특성은 동일하다.
		Marker m2 = new Marker("red");
		m2.writing("TEST");
		
	}

}
