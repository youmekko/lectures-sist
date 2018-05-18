package com.test004;

public class Main {

	public static void main(String[] args) {
		
		
		//Calculator 클래스에 대한 객체 생성
		Calculator c = new Calculator();
		
		//Calculator 객체의 plus() 메소드 호출 테스트
		//객체 외부에서의 메소드 호출 -> 객체 생성 후 참조변수를 이용해서 접근해야 한다.
		//메소드 분석 -> int plus(int x, int y) -> 메소드 시그니처 -> 매개변수 목록과 리턴타입 확인
		int x = 10;
		int y = 20;
		int result = c.plus(x, y);
		System.out.println(result); //30
		

	}

}
