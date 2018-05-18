package com.test;

public class Sample010 {

	public static void main(String[] args) {

		//형변환
		/*
		 * A 타입을 B 타입으로 변환
		 * 자동(암시적) 형변환 or 강제(명시적) 형변환
		 * 
		 * 자동(암시적) 형변환은 컴파일러가 자동으로 형변환을 시켜주는 상태
		 * 작은 타입을 자료를 큰 타입의 변수에 저장하는 과정에서 발생
		 * byte -> short(2) -> int(4) -> long(8) -> float(4) -> doule(8)
		 * char(2) -> int(4)
		 * 
		 */
	
		byte a = 100;
		int b = 2100000000;
		
		//byte c = 2100000000;
		
		//byte 자료형의 값을 int 자료형의 변수에 저장
		//->자동(암시적) 형변환
		int d = a;
		
		//char 자료형의 값을 int 자료형의 변수에 저장
		//->자동(암시적) 형변환
		char e = 'A';
		int f = e;
		
		//int 자료형의 값을 double 자료형의 변수에 저장
		//->자동(암시적) 형변환
		int g = 100;
		double h = g;
		
		
	}

}
