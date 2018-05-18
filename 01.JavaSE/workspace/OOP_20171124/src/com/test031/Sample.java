package com.test031;

public class Sample {
	/*
	
	- 클래스(객체) 내부에서 멤버들끼리의 접근
	instance 멤버 > instance 멤버 가능. this 키워드 사용 가능.
	static 멤버 > static 멤버 가능. this 키워드 사용 불가. 클래스명 사용.
	instance 멤버 > static 멤버 가능. this 키워드 사용 불가. 클래스명 사용.

	static 멤버 > instance 멤버는 불가
	
	*/	
	
	//instance 필드
	private int a;
	
	//static 필드
	private static int b;
	
	//instance 메소드
	public void method1() {
		//instance 멤버 > instance 멤버 가능. this 키워드 사용 가능.
		System.out.println(this.a);
		
		//instance 멤버 > static 멤버 가능. this 키워드 사용 불가. 클래스명 사용.
		System.out.println(Sample.b);
	}
	
	//static 메소드
	public static void method2() {
		//static 멤버 > static 멤버 가능. this 키워드 사용 불가. 클래스명 사용.
		System.out.println(Sample.b);
		
		//static 멤버 > instance 멤버는 불가
		//->메모리 적재 순서가 다르기 때문이다.
		//System.out.println(this.a);
		//System.out.println(Sample.a);
		
	}

}
