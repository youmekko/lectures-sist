package com.test034;

import  java.util.Random;

public class Sample {
	
	//필드 초기화
	/*
	
	- 필드 초기화는 아래 순서대로 진행된다.
	1. 자동 초기화
	2. 명시적 초기화
	3. 생성자에 의한 초기화. 단, instance 필드에 대해서만.
	4. static 초기화 블럭에 의한 초기화. 단, static 필드에 대해서만.
	
	- static 초기화 블럭에 의한 초기화는 static 필드에 대해서 초기화할 때 사용
	- 명시적 초기화로 부족한 경우 초기화 블럭 사용. 예를 들어, 프로그램 실행 결과값으로 초기화하는 경우.
	- 형식
	static {
		static변수 = 값;
	}
	
	*/
	
	//0부터 10까지 범위를 가지는 난수로 초기화.
	//난수 발생 -> java.util.Random 클래스 사용.
	
	//private static int[] arr = {난수1, 난수2, 난수3, ...};
	//-> 반복문 처리
	
	//private static int[] arr = for (초기값; 조건식; 증가식) { 난수발생 액션 };
	//-> for 구문을 = (대입문)과 연결 불가
	//-> 초기화 블럭 사용
	
	//static 필드
	private static int[] arr;
	
	//static 초기화 블럭
	static {
		//문제)
		//배열 객체 생성 및 난수에 의한 초기화 액션. 기본 크기 5.
		//-> java.util.Random 클래스 사용
		Sample.arr = new int[5]; // 배열 생성
		Random random = new Random(); // 랜덤객체 생성
		for (int i = 0; i < Sample.arr.length; ++i) {
			Sample.arr[i] = random.nextInt(11); // 배열에 난수 할당
		}
	}
	
	//static getter
	public static int[] getArr() {
		return Sample.arr;
	}
	
}
