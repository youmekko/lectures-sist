package com.test022;

//생성자 테스트 클래스
public class Sample {

	//기본 생성자(매개변수 목록이 없는 생성자)에 대한 명시적 선언
	//->사용자가 명시적 선언한 생성자가 있다면 컴파일러에 의한 기본 생성자 자동 생성이 진행되지 않는다.
	public Sample() {
		//사용자 정의 초기화 액션 코드 작성
		System.out.println("Sample 클래스의 기본 생성자 호출.");
	}
	
}
