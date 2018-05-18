package com.test005;

public class Sample {

	//익명 객체
	//- 중첩 클래스이지만 명시적 이름을 가지지 않는 상태
	//- 부모 클래스를 이용해서 자식 클래스의 객체 생성
	private OuterClass inner = new OuterClass() {
		//부모의 멤버를 오버라이딩
		@Override
		public void outerMethod() {
			System.out.println("AnonymouseInnerClass에서 오버라이딩한 outerMethod()");
		}
	};

	public OuterClass getInner() {
		return inner;
	}

}
