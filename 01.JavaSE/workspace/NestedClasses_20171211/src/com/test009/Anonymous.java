package com.test009;

public class Anonymous {
	
	//익명 구현 객체 -> 필드인 경우
	Vehicle field = new Vehicle() {
		//오버라이딩 의무사항
		@Override
		public void run() {
			System.out.println("필드로 구성한 익명 구현 객체의 메소드");
		}
	};
	
	void method1() {
		//익명 구현 객체 -> 로컬 변수인 경우
		Vehicle localVar = new Vehicle() {
			//오버라이딩 의무사항
			@Override
			public void run() {
				System.out.println("로컬 변수로 구현한 익명 구현 객체의 메소드");
			}
		};
		localVar.run();
	}
	
	//익명 구현 객체 -> 매개 변수인 경우
	void method2(Vehicle v) {
		v.run();
	}

}
