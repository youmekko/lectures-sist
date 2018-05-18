package com.test;

public class Sample026 {

	public static void main(String[] args) {
		
		//비트 단위 연산자
		//비트 단위로 비교 연산 수행
		//&, |, ^, ~, <<, >>, >>>
		//1 & 1 => 1
		//1 & 0 => 0
		//1 | 1 => 1
		//1 | 0 => 1

		byte a = 45; //00101101
		byte b = 25; //00011001
		
		System.out.println(a & b); //00001001 => 9
		System.out.println(a | b); //00111101 => 61
		System.out.println(a >> 1); //00010110
		System.out.println(a << 1); //01011010

	}

}
