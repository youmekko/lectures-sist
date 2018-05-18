package com.inheritance006;

//실행 테스트
public class Main {

	public static void main(String[] args) {
		
		//자식 클래스의 객체 생성 및 멤버 확인
		//->상속 관계 분석
		SubClass sub = new SubClass();
		
		//SubClass의 method()
		//super 키워드 사용 전 : SubClass의 method() 호출
		//super 키워드 사용 후 : SuperClass의 method() 호출
		sub.method(); 
		

	}

}
