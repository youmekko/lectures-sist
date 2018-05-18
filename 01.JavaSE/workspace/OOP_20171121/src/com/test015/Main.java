package com.test015;

import java.util.Arrays;

import com.test013.Sample;

public class Main {

	public static void main(String[] args) {
		
		//다른 패키지, 다른 클래스의 멤버 접근 테스트
		//다른 패키지-> import 구문 필요
		//Sample 클래스 객체의 instance 멤버(메소드) 접근 테스트
		//->객체 생성
		//->new 연산자
		//public void method1() -> 접근 가능
		//void method2() -> 접근 불가
		//private void method3() -> 접근 불가
		
		Sample s = new Sample();
		
		s.method1();
		//The method method2() from the type Sample is not visible
		//s.method2();
		//The method method3() from the type Sample is not visible
		//s.method3();
		
		//import 구문 생략한 경우 클래스명에 패키지명 추가 지정 필요
		com.test013.Sample s2 = new com.test013.Sample();
		s2.method1();
		
		//이클립스에서 import 구문 자동 생성 단축키 -> Ctrl + Shift + O
		Arrays.sort(new int[] {3, 1, 2});
		
	}

}
