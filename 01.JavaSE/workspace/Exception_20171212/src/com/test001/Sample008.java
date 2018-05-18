package com.test001;

import java.util.*;

public class Sample008 {

	public static void main(String[] args) {

		//try~catch~finally 구문 형식
		/*
		try {
			//예외발생 가능한 구문
		}catch(예외종류 변수) {
			//예외처리 구문
		}finally{
			//예외 발생 유무와 관계없이 마무리 액션 처리하는 부분
			//외부 자원 이용시 close() 메소드 호출시 사용 
		}
		*/
		//주의) catch 액션만 잘 처리한다면 finally 구문은 없어도 close() 메소드 호출 가능.
		//주의) try-with-resources 기능(자바7 이후에서만 사용 가능. AutoCloseable 인터페이스 구현 클래스)을 이용하면 close() 메소드에 대한 자동 호출 가능.
		
		
		Scanner sc = new Scanner(System.in);
		
		//예외 발생 가능 구문
		//->try~catch~finally 구문 추가
		try {
			System.out.print("숫자?");
			int a = sc.nextInt();
			System.out.println(a);
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			//주의) 이 부분은 예외 발생 유무와 관계없이 실행되어야 한다.
			sc.close();
			System.out.println("프로그램 정상 종료.");
		}
		
	}

}
