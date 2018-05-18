package com.test017;

//캡슐화(Encapsulation) 테스트 클래스
public class Sample {
	
	//캡슐화(Encapsulation)
	/*
	1. 데이터 은닉(data hiding)한다는 의미. private 접근제한자 필요.
	
	2. 구현 내용을 감춘다는 의미. 메소드 필요.
	복잡한 액션을 감추고 외부에서 간단하게 메소드 호출만으로 액션 수행 가능한 상태를 만든다.
	*/
	
	//필드 선언시 private 접근제한자 사용. 외부에서 직접 접근 불가.
	//getter, setter  public 메소드 선언. 외부에서 필드에 대한 간접 접근 메소드.
	
	//필드(멤버변수) 선언
	//객체의 상태 정보 저장용 변수 선언
	//접근제한자 자료형 변수명;
	//접근제한자 자료형 변수명 = 초기값;
	//자동 초기화 지원
	
	//private 접근 제한자 생략한 경우
	//외부에서 객체의 상태에 대한 변경/사용 가능
	//instance 필드
	int currentSpeed;
	
}
