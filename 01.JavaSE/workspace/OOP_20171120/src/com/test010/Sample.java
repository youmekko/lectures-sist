package com.test010;

//객체 내부에서의 메소드 호출 
//->this 키워드
public class Sample {
	
	//this 키워드
	//객체(instance) 내부에서 인스턴스 멤버(필드, 메소드) 접근시 사용하는 키워드. this.메소드();
	//-> 자기 자신이 객체(instance) 상태인 경우만 사용 가능.
	//-> 내부적으로 자동 준비되는 변수.
	//객체(instance) 외부에서 인스턴스 멤버(필드, 메소드) 접근시에는 객체의 참조주소가 저장된 변수를 통해서 접근. 클래스 변수 = new 클래스();  변수.메소드();


	//객체 외부에서 접근 불가
	//인스턴스 메소드
	private void method1() {
		System.out.println("Sample 객체의 method1() 메소드 호출.");
	}

	//객체 외부에서 접근 가능
	//주의) this 키워드를 사용하려면 메소드 자신도 인스턴스 메소드여야 한다.
	//인스턴스 메소드
	void method2() {
		
		//객체 내부에서만 접근하는 상황에서 사용.
		this.method1();
		
	}

}
