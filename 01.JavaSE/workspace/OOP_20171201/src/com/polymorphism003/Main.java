package com.polymorphism003;

public class Main {

	public static void main(String[] args) {

		//자식 객체를 부모(조상) 자료형 변수에 저장
		//->자동 형변환
		D d1 = new D();
		B d2 = new D();
		A d3 = new D();
		Object d4 = new D();
		
		//IS-A 관계가 아닌 자료형 변수에 저장 불가
		C d5 = new D();

	}

}
