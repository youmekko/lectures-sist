package com.test001;

//실행 클래스는 main() 메소드를 제공하는 역할
public class Main {

	public static void main(String[] args) {
		
		//Car 클래스에 대한 객체 생성 -> new 연산자
		//클래스명 변수 = new 클래스명();
		Car myCar = new Car();
		
		//Car 객체의 멤버(필드) 접근 및 값 출력 -> dot(.) 연산자
		//변수명.멤버변수
		System.out.println(myCar.company);
		System.out.println(myCar.model);
		
		//필드는 변수이므로, 새로운 값 저장 가능.
		//-> Car 객체의 상태를 외부에서 변경할 수 있다.
		//주의) 필드는 local 변수가 아니다. instance(객체) 변수이다.
		//변수명.멤버변수 = 값;
		//필드는 객체 생성시 준비되며, 객체 소멸시까지 활동 가능.
		System.out.println(myCar.currentSpeed); //0
		myCar.currentSpeed = 100;
		System.out.println(myCar.currentSpeed); //100
		
	}

}
