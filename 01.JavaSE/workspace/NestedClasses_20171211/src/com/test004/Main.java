package com.test004;

public class Main {

	public static void main(String[] args) {

		//중첩 클래스 객체 생성 및 멤버 접근 테스트
		OuterClass inner = new OuterClass() {
			
			//익명 객체
			//- 중첩 클래스이지만 명시적 이름을 가지지 않는 상태
			//- 부모 클래스를 이용해서 자식 클래스의 객체 생성
			
			//자기만의 고유한 필드, 메소드 구성 가능 -> 객체 생성시 외부에서 접근 불가 -> 다형성 구현
			//주의) 정적 멤버를 가질 수 없다.
			//-> 부모 클래스의 멤버를 오버라이딩하는 경우 많이 사용
			
			//인스턴스 멤버 메소드 -> 객체 생성시 외부에서 접근 불가 -> 다형성 구현
			public void innerMethod() {
				System.out.println("AnonymouseInnerClass의 innerMethod()");
			}

			//부모의 멤버를 오버라이딩
			@Override
			public void outerMethod() {
				System.out.println("AnonymouseInnerClass에서 오버라이딩한 outerMethod()");
			}
			
		};
		
		inner.outerMethod(); //AnonymouseInnerClass에서 오버라이딩한 outerMethod()

		//부모 클래스 범위 내의 멤버만 접근 가능 -> 다형성 구현
		//->강제 형변환을 이용한 자식 클래스 변환 불가
		//inner.innerMethod();
		
	}

}
