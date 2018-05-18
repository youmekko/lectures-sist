package com.test;

public class Sample011 {

	public static void main(String[] args) {

		//형변환
		/*
		 * A 타입을 B 타입으로 변환
		 * 자동(암시적) 형변환 or 강제(명시적) 형변환
		 * 
		 * 강제(명시적) 형변환은 사용자가 직접 형변환을 시켜주는 상태
		 * 큰 타입을 자료를 작은 타입의 변수에 저장하는 과정에서 발생
		 * byte(1) <- short(2) <- int(4) <- long(8) <- float(4) <- doule(8)
		 * char(2) <- int(4)
		 * 
		 * 작은 타입 변수 = (작은 타입)큰 타입 자료;
		 * 
		 * 주의) 자료 손실 발생
		 * 
		 */
	
		byte a = 100;
		int b = 2100000000;
		
		//강제(명시적) 형변환
		//-> 자료 손실 발생
		byte c = (byte)b;
		System.out.println(c);
		
		//강제(명시적) 형변환
		//-> 자료 손실 발생하지 않는 경우도 있다.
		int d = 100;
		byte f = (byte)d;
		System.out.println(f);
		
		
		//int 자료형의 값을 char 자료형의 변수에 저장
		//-> 강제(명시적) 형변환
		int g = 65;
		char h = (char)g;
		System.out.println(h);
		
		
		//double 자료형의 값을 int 자료형의 변수에 저장
		//->강제(명시적) 형변환
		double i = 123.456;
		int j = (int)i;
		System.out.println(j);
		
	}

}
