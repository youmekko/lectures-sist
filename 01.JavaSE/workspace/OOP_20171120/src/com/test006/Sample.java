package com.test006;

//매개변수 테스트용 클래스
public class Sample {
	
	
	//매개변수 
	//- 메소드 진행에 필요한 외부 데이터를 수신하는 역할
	//- 메소드 호출시 매개변수에 대응하는 데이터를 전송해야 한다.
	
	//매개변수 없는 경우
	void method1() {
		System.out.println("매개변수가 없는 메소드 호출.");
	}
	
	//매개변수가 있는 경우
	//->메소드이름(자료형 변수명, ...)
	//->외부자료(이름, 전화번호)가 서로 연관성 있는 경우는 하나의 자료(개인의 정보)로 통합한 형태로 사용
	void method2(int x, int y) {
		//내부 액션 진행을 위한 외부 자료
		//->x, y
		System.out.printf("x:%s%n", x);
		System.out.printf("y:%s%n", y);
		
	}
	
	
	//매개변수와 반환값이 있는 경우
	//->메소드이름(자료형 변수명, ...)
	//->외부자료(이름, 전화번호)가 서로 연관성 있는 경우는 하나의 자료(개인의 정보)로 통합한 형태로 사용
	//->매개변수는 local 변수이므로 메소드별로 선언된다.
	int method3(int x, int y) {
		
		int result = 0;
		
		result = x + y;
		
		//return 구문은 메소드 액션 마지막에 실행되도록 한다.
		//return 반환값;
		return result;
	}
	

}
