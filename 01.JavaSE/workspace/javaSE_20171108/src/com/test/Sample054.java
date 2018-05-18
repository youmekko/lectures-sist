package com.test;

public class Sample054 {

	public static void main(String[] args) {
		
		//for와 while의 차이
		
		//변수 a의 사용범위 -> Local 변수
		for (int a=0; a<10; ++a) {
			System.out.println(a);
		}
		
		//for 범위 밖에서 변수 a 접근 불가
		//System.out.println(a);
		
		
		//변수 b의 사용범위 -> Local 변수
		int b=0;
		while (b<10) {
			System.out.println(b);
			++b;
		}
		
		//while 범위 밖에서 변수 b 접근 가능
		System.out.println(b);
		

	}

}
