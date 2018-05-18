package com.test010;

public class Main {
	
	//인스턴스 메소드 샘플
	void method1() {
		
	}

	//대표적인 static(정적) 메소드
	public static void main(String[] args) {
		
		//인스턴스 메소드 접근을 위한 this 키워드 사용
		//Cannot use this in a static context
		//this.method1();
		
		//-> Main 클래스에 대한 객체(instance) 생성 필요
		//-> 참조변수를 통한 접근
		Main m = new Main();
		m.method1();
		
		//Sample 클래스의 method1() 메소드 호출 테스트
		//Sample 클래스의 객체 생성 -> 인스턴스 멤버 접근
		//method1() 메소드는 외부에서 직접 접근 불가 -> private
		//method2() 메소드를 이용해서 method1() 접근 시도 -> this.method1()
		Sample s = new Sample();
		
		//The method method1() from the type Sample is not visible
		//s.method1();
		
		s.method2(); //Sample 객체의 method1() 메소드 호출.
		
	}

}
