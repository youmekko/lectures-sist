package com.test003;

public class OuterClass {
	
	//인스턴스 멤버 메소드
	public void outerMethod() {
		System.out.println("OuterClass의 outerMethod()");
		
		//로컬 클래스
		//- 인스턴스 메소드 내부에서 선언된 중첩 클래스
		//- static 키워드 없이 선언된 중첩 클래스
		//- 접근제한자 지정 불가
		//- 메소드 내부에서만 객체 생성 및 멤버 접근 가능
		class MethodLocalInnerClass {
			
			//자기만의 고유한 필드, 메소드 구성 가능
			//주의) 정적 멤버를 가질 수 없다.
			
			//인스턴스 멤버 메소드
			public void innerMethod() {
				System.out.println("MethodLocalInnerClass의 innerMethod()");
			}
			
		}

		//로컬 클래스 선언 위치보다 아래쪽에서 객체 생성 가능
		MethodLocalInnerClass inner = new MethodLocalInnerClass();
		inner.innerMethod();

	}
	
}
