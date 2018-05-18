package com.test009;


//매개변수 테스트용 클래스
public class Sample {
	
	//매개변수 자료형에 따른 구분
	//기본형(by value)과 참조형(by reference)의 차이
	
	//by value
	//메소드 호출시 매개변수 값을 보내는쪽과 받는 쪽이 서로 독립 상태.
	//->값 복사
	//->메소드 액션 결과에 대한 return 구문이 필요 하다.
	void method1(int a) {
		++a;
		System.out.printf("inner:%d%n", a);
	}
	
	//메소드 액션 결과를 반환하는 구문이 있어야 메소드 액션 결과를 알 수 있다.
	int method3(int a) {
		++a;
		System.out.printf("inner:%d%n", a);
		return a;
	}

	
	//by reference
	//메소드 호출시 매개변수 값을 보내는쪽과 받는 쪽이 서로 연결 상태.
	//->참조주소 복사
	//->메소드 액션 결과에 대한 return 구문이 필요 없다.
	void method2(int[] arr) {
		++arr[0];
		System.out.printf("inner:%d%n",arr[0]);
	}
	

}
