package com.test013;


//접근제한자 테스트 클래스
public class Sample {
	
	//접근제한자(modifier)
	//클래스(객체)의 특정 멤버(필드, 메소드)를 외부에서 접근할 때 제한하는 역할.
	//클래스 자신도 접근제한자 지정 가능.
	//외부 범위는 (같은 패키지의) 다른 클래스, 다른 패키지 (다른 클래스)
	
	//public - 제한 없는 상태. 적용 대상 클래스, 필드 , 메소드, 생성자
	//protected - 상속 개념 전제 조건.
	//(default) - 접근제한자 생략한 상태. 일부 제한 있는 상태. (같은 패키지의) 다른 클래스에서 접근 가능, 외부(다른 패키지)에서 접근 불가. 적용 대상 클래스, 필드 , 메소드, 생성자
	//private - (같은 패키지의 같은 클래스) 내부 멤버만 접근 가능. 외부에서 접근 불가. 적용 대상 필드 , 메소드, 생성자
	
	//외부(다른 클래스, 다른 패키지)에서 접근 가능. 내부에서도 접근 가능.
	public void method1() {
		
	}
	
	//외부(다른 클래스, 같은 패키지)에서 접근 가능. 내부에서도 접근 가능.
	void method2() {
		
	}
	
	//외부(다른 클래스)에서 접근 불가. 내부에서만 접근 가능.
	//instance 메소드
	private void method3() {
		
	}
	
	//instance 메소드
	private void test() {
		//private 메소드 접근 가능 테스트
		//instance 메소드 -> instance 메소드 접근
		//this => 같은 객체(instance)의 내부 멤버 접근시 사용
		this.method3();
		
		//(default) 메소드 접근 가능 테스트
		this.method2();
		
		//public 메소드 접근 가능 테스트
		this.method1();
	}

}
