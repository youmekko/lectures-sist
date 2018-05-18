package com.test004;

//계산기 클래스 선언
public class Calculator {
	
	//메소드
	//객체(Object)의 행동 특성(behavior)을 선언한 것.
	//예를 들어, 보드마카에서 쓰기 특성을 메소드로 표현.
	/*
	
	modifier returnType nameOfMethod (Parameter List) {
   		// method body
   		return 반환값;
	}
	
	*/
	//접근제한자는 외부에서 멤버 접근할 때 사용. 메소드는 public 접근제한자 권장.
	//접근제한자는 생략 가능.
	//반환자료형 부분은 반환값에 대한 자료형 지정. 반환값이 없는 경우 void 키워드 사용.
	//메소드이름은 식별자 작성 규칙을 따른다. 
	//매개변수는 외부에서 전달되는 자료를 수신하는 역할. 생략 가능. local 변수. 자료의 갯수, 자료형에 맞춰서 작성.
	//반환값이 있는 경우 return 구문 사용. 메소드 액션의 가장 마지막에 실행.

	
	//산술 연산(더하기) 메소드 추가
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}

}
