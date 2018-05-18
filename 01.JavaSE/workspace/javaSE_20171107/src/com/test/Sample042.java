package com.test;

public class Sample042 {

	public static void main(String[] args) {
		
		//int -> byte 자료형으로 형변환
		
		int a = 128;
		
		//byte 자료형은 허용 범위가 -128 ~ 127
		if (a >= Byte.MIN_VALUE && a <= Byte.MAX_VALUE) {
			byte b = (byte)a;
			System.out.println("int -> byte 형변환 성공");
			System.out.println("a : " + a);
			System.out.println("b : " + b);
		} else {
			System.out.println("byte 범위를 벗어나는 수입니다.");
		}
		

	}

}
