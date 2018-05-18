package com.test012;

import java.util.*;

//오버로딩 메소드 테스트 클래스
public class Calculator {
	
	//문제)
	//진법 변환 액션 메소드를 오버로딩 상태로 구성
	
	//10진수 -> 2진수
	//->메소드 시그니처가 String 메소드이름(int dec)로 구성
	String radixTransformation(int dec) {
		StringBuilder result = new StringBuilder();
		
		int a = 0;
		while (true) {
			a = dec % 2;
			dec = dec / 2;
			result.insert(0, a);
			if (dec == 0) break;
		}
		
		return result.toString();
	}
	
	//2진수 -> 10진수
	//->메소드 시그니처가 int 메소드이름(String bin)로 구성
	int radixTransformation(String bin) {
		int result = 0;
		
		//"1010"
		//"1", "0", "1", "0"
		//1, 0, 1, 0
		//1 * 2의3승, 0*2의2승, 1*2의1승, 0*2의0승
		//8, 0, 2, 0
		//10
		/*
		String a = bin.substring(0,1);
		System.out.println(Integer.parseInt(a));
		System.out.println(Integer.parseInt(a) * Math.pow(2, 1));
		*/
		
		for (int a = 0; a<bin.length(); ++a) {
			String b = bin.substring(a, (a+1));
			int c = Integer.parseInt(b);
			if (c == 0) continue;
			result += c * (int)Math.pow(2, (bin.length()-1-a));
		}
		
		return result;
	}
	
	
	//문제
	//16진수 -> 10진수
	//예를 들어, "FF"(16) -> 255(10)
	//->메소드 시그니처가 int 메소드이름(String hex)로 구성
	//->주의) 매개변수 구성에서 변수명만 다른 것은 오버로딩이라고 할 수 없다.
	//->독립적인 메소드명 사용
	int toHex(String hex) {
		int result = 0;
		
		//"FF"
		//"F", "F"
		//15, 15
		//15*16의1승, 15*16의0승
		//240, 15
		//255
		String[] arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
		
		for (int a = 0; a<hex.length(); ++a) {
			String b = hex.substring(a, (a+1));
			int c = Arrays.binarySearch(arr, b);
			if (c == 0) continue;
			result += c * (int)Math.pow(16, (hex.length()-1-a));
		}
		
		return result;
	}
	
	

}
