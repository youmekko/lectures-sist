package com.polymorphism006;

//실행 테스트 클래스
public class Main {

	public static void main(String[] args) {
		
		//Number 클래스는 다양한 숫자 자료형(정수, 실수)의 부모 클래스
		/*
		Number[] arr2 = new Number[5];
		arr2[0] = 10;
		arr2[1] = 12.34;
		for (Number a : arr2) {
			System.out.println(a);
		}
		*/
		
		SubClass sub = new SubClass();
		
		sub.add(10); //정수(byte, short, int, long-L)
		sub.add(12.34); //실수(float-F, double)
		sub.add(100L);
		sub.add(34.56F);
		byte a = new Byte("10");
		//sub.add(a);
		
		System.out.println(sub.list()); //[값1, 값2, ...]
		
	}

}

