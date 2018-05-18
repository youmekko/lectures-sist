package com.test025;

public class Main {

	public static void main(String[] args) {
		
		//생성자 오버로딩 테스트
		
		//매개변수 목록 있는 생성자 호출
		//->시그니처 분석
		Sample s1 = new Sample(10);
		System.out.println(s1.getA()); //10
		System.out.println(s1.getB()); //0
		
		
		//매개변수에 값 전달이 없어도 가능
		//->시그니처 분석
		Sample s2 = new Sample();
		System.out.println(s2.getA()); //0
		System.out.println(s2.getB()); //0
		

		//매개변수에 전달되는 값이 많아도 가능
		//->시그니처 분석
		Sample s3 = new Sample(10, 20);
		System.out.println(s3.getA()); //10
		System.out.println(s3.getB()); //20

		
	}

}
