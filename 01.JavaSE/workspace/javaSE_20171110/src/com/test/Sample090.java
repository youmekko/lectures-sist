package com.test;

public class Sample090 {

	public static void main(String[] args) {
		
		//배열(Array)
		/*
		
		참조형
		동일한 자료형을 가진 저장소가 여러개 준비된 상태.
		생성할 때 크기 지정 필요.
		배열 자신의 자료형은 기본형, 참조형 모두 지원 가능.
		
		자료형[] 변수;
		or
		자료형 변수[];
		
		변수 = new 자료형[크기];
		변수[인덱스] = 값;
		or
		자료형[] 변수 = {값0, 값1, 값2, ...};
		or
		변수 = new 자료형[크기]{값0, 값1, 값2, ...};
		
		배열 요소 접근시 인덱스 사용. 변수명[인덱스]. 인덱스 0부터 시작. 반복문을 이용한 인덱스 접근.
		
		배열 요소의 갯수는 length 필드로 확인 가능. 읽기 전용 필드.
		
		주의) 배열은 생성시 자동 초기화를 지원한다. int 자료형인 0으로 초기화. double 자료형은 0.0으로 초기화. 참조자료형은 null로 초기화.
		주의) ArrayIndexOutOfBoundsException : 인덱스 허용 범위를 벗어나는 인덱스 접근.
		*/
		
		//배열 선언
		int[] arr1;

		//배열 생성(자동 초기화)
		arr1 = new int[5];
		
		//배열 요소 접근(인덱스, 0~크기-1)
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		System.out.println(arr1[3]);
		System.out.println(arr1[4]);
		
		//반복문을 이용한 배열 요소 접근
		for(int a=0; a<arr1.length; ++a) {
			System.out.println(arr1[a]);
		}


	}

}
