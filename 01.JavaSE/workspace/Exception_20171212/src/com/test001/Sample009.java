package com.test001;

import java.util.*;

public class Sample009 {

	public static void main(String[] args) {

		//try-with-resources 기능
		/*
		try(객체 생성 구문) {
			//예외발생 가능한 구문
		}catch(예외종류 변수) {
			//예외처리 구문
		}
		*/
		//주의) try-with-resources 기능(자바7 이후에서만 사용 가능. AutoCloseable 인터페이스 구현 클래스)을 이용하면 close() 메소드에 대한 자동 호출 가능.
		
		//객체 생성 구문을 try() 구문에 지정. close() 메소드 자동 호출.
		try(Scanner sc = new Scanner(System.in)) {
			//예외 발생 가능 구문
			//->try~catch 구문 추가
			System.out.print("숫자?");
			int a = sc.nextInt();
			System.out.println(a);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("프로그램 정상 종료.");
		
	}

}
