package com.test030;

//정적(static) 멤버 테스트 클래스
public class Sample {
	
	//정적(static) 멤버(필드, 메소드)
	/*
	
	- 클래스의 멤버 구성시 static 키워드를 붙이면 정적(static) 멤버가 된다. 안 붙이면 instance 멤버가 된다.
	- 정적(static) 멤버는 메모리에 적재되는 순서와 공유되는 범위가 instance 멤버와 다르다.
	- instance 멤버는 객체 생성시에만 메모리에 적재되지만, static 멤버는 프로그램 실행시(객체 생성과 관계없이) 메모리에 적재된다. 예를 들어, 2강의실 메모리인 경우, 수강생들은 instance 멤버(독립적 존재)이다. 컴퓨터, 책상들은 static 멤버(공유되는 존재)이다.
	
	- static 필드 선언
	접근제한자 static 자료형 변수명;
	접근제한자 static 자료형 변수명 = 값; 
	
	- static 메소드 선언
	접근제한자 static 반환자료형 메소드명(매개변수 리스트) {
	}
	
	- 대표적인 static 메소드는 main()이다. JVM이 자동 호출하는 메소드이다.
	- main() 메소드를 포함하는 클래스의 객체 생성 없이 main() 메소드 호출이 가능하도록 하기 위해서 static 키워드 필요.
	public static void main(String[] args) {
	}
	
	- instance 멤버는 외부에서 접근시 해당 객체 생성 후에 접근 가능. 변수명.멤버
	- static 멤버는 외부에서 접근시 해당 객체 생성과 관계없이 접근 가능. 클래스명.멤버
	- 대표적인 static 필드는 상수(constant)이다. 상수시 접근시 클래스명.상수명. 예를 들어. Math 클래스의 상수인 PI는 Math.PI로 접근.
	
	- 클래스 내부에서 멤버들끼리의 접근
	instance 멤버 > instance 멤버 가능. this 키워드 사용 가능.
	static 멤버 > static 멤버 가능. this 키워드 사용 불가. 클래스명 사용.
	instance 멤버 > static 멤버 가능. this 키워드 사용 불가. 클래스명 사용.

	static 멤버 > instance 멤버는 불가
	
	
	- 필드 초기화 과정에서 instance, static 멤버(필드) 초기화 과정이 다르다.
	
	*/
	
	//static 메소드 구성 예
	public static void method() {
		System.out.println("Sample 클래스의 static 메소드 호출.");
	}
	

}
