package com.test007;

//부모 역할 클래스
public class OuterClass {

	//인스턴스 메소드
	public void method1() {
		System.out.println("OuterClass의 method1()");
	}
	
	//정적 메소드
	public static void method2() {
		System.out.println("OuterClass의 method2()");
	}
	
	
	//인스턴스 멤버 클래스
	//- static 키워드 없다.
	//- 멤버 구성시 정적 멤버 구성 불가
	class IntanceInnerClass {
		
		//OuterClass의 멤버 접근 테스트
		//->OuterClass의 모든 멤버 접근 가능
		void innerMethod() {
			//OuterClass의 인스턴스 메소드
			method1();
			//OuterClass의 정적 메소드
			method2();
			
			
			//OuterClass의 인스턴스 메소드 -> this 키워드 사용 불가
			//this.method1();
			
		}
		
	}
	
	
	//정적 멤버 클래스
	//- static 키워드 있다.
	//- 멤버 구성시 정적 멤버 구성 가능
	static class StaticInnerClass {

		//OuterClass의 멤버 접근 테스트
		//->OuterClass의 정적 멤버만 접근 가능
		void innerMethod() {
			//OuterClass의 인스턴스 메소드 -> 접근 불가
			//method1();
			//OuterClass의 정적 메소드
			method2();
		}
		
	}
	
}
