package com.test013;

//같은 패키지에 속한 클래스 참조시 import 구문 필요 없다.
//java.lang 패키지에 속한 클래스 참조시 import 구문 필요 없다.

public class Main {

	//주의) main() 메소드가 있는 클래스에 다른 멤버를 구성하지 않는다.
	//instance 메소드
	private void test() {
		
	}

	//static 메소드
	public static void main(String[] args) {

		//같은 패키지 다른 클래스
		//Sample 클래스 객체의 instance 멤버(메소드) 접근 테스트
		//->객체 생성
		//->new 연산자
		//public void method1() -> 접근 가능
		//void method2() -> 접근 가능
		//private void method3() -> 접근 불가
		Sample s = new Sample();
		
		s.method1();
		s.method2();
		//The method method3() from the type Sample is not visible
		//s.method3(); //접근 불가
		
		
		
		//같은 패키지, 같은 클래스
		//instance private test() 메소드 접근 테스트
		//this.test();
		Main m = new Main();
		m.test();
		
		
	}

}
