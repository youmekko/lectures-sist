package com.test007;

public class Main {

	public static void main(String[] args) {
		
		//Sample 클래스의 객체 생성
		Sample s = new Sample();
		
		//진법 변환 메소드 호출 테스트
		//메소드 시그니처 분석->String toBin(int dec)
		//String 변수 = toBin(값);
		int a = 10;
		String result = s.toBin(a);
		System.out.printf("%d(10) -> %s(2)%n", a, result);
		
		//자바에서 제공하는 진법 변환 메소드
		//10진수->2진수
		String result2 = Integer.toString(a, 2);
		System.out.printf("%d(10) -> %s(2)%n", a, result2);
		
		//자바에서 제공하는 진법 변환 메소드
		//10진수->16진수
		String result3 = Integer.toString(a, 16).toUpperCase();
		System.out.printf("%d(10) -> %s(16)%n", a, result3);

		//진법 변환 메소드 호출 테스트
		//메소드 시그니처 분석->String toBinHex(int dec, int radix)
		//String 변수 = toBinHex(값1, 값2);
		int radix1 = 2;
		String result4 = s.toBinHex(a, radix1);
		System.out.printf("%d(10) -> %s(%d)%n", a, result4, radix1);
		
		int radix2 = 16;
		String result5 = s.toBinHex(a, radix2);
		System.out.printf("%d(10) -> %s(%d)%n", a, result5, radix2);
		

	}

}
