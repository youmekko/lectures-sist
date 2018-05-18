package com.test026;

//생성자 테스트 클래스
public class Sample {
	
	//생성자의 접근제한자
	//생성자는 일반적으로 객체 생성시 자동 호출되기 때문에 public 권장.
	//생성자를 명시적 선언하지 않은 경우 컴파일러에 의해 자동으로 기본 생성자 생성.
	//->접근제한자는 클래스의 접근제한자와 동일
	
	//public이 아닌 접근제한자 지정시 객체 생성(생성자 호출)시 제한을 받는다.
	//->대표적으로 private 생성자 지정
	
	//private 생성자
	//->현재 클래스의 객체 생성 불가
	private Sample() {
	}
	
	//현재 클래스에 instance 메소드가 존재해도 외부에서 접근 불가
	public void method() {
		
	}

}
