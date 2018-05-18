package com.inheritance001;

public class Main {

	public static void main(String[] args) {
		
		//자식 클래스의 객체 생성
		//->부모 객체도 같이 생성된다.
		SubClass sub = new SubClass();
		
		//자식 클래스의 객체가 가지는 instance 멤버 확인 -> dot(.) 연산자
		//toString() - 객체의 정보를 반환하는 메소드
		//명시적 선언이 없는 메소드 확인 -> Object 클래스
		System.out.println(sub.toString());
		
		//method() - SuperClass의 전용 멤버
		//명시적 선언이 없는 메소드 확인 -> SuperClass 클래스
		sub.method();

	}

}
