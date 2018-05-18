package com.test;

public class Sample049 {

	public static void main(String[] args) {
		//제어문 for
		
		//반복 횟수 분석 -> 10회
		for (int x = 0; x < 10; ++x) {
			System.out.println(x); //0, 1, 2, ..., 9
		}
		
		//반복 횟수 분석 -> 11회
		for (int x = 0; x <= 10; ++x) {
			System.out.println(x); //0, 1, 2, ..., 10
		}

		//반복 횟수 분석 -> 10회
		for (int x = 1; x <= 10; ++x) {
			System.out.println(x); //1, 2, ..., 10
		}

		//반복 횟수 분석 -> 9회
		for (int x = 1; x < 10; ++x) {
			System.out.println(x); //1, 2, ..., 9
		}

		//-----------------------------
		//주의)
		//반복 횟수 분석 -> 0회
		for (int x = 1; x > 10; ++x) {
			System.out.println(x); //출력 X
		}
		
		//-----------------------------
		//주의)
		//반복 횟수 분석 -> 21억회
		for (int x = 1; x < 10; --x) {
			System.out.println(x); //1, 0, -1, -2, ..., ?? 
		}
		
	}

}
