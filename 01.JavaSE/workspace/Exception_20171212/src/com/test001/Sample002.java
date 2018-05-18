package com.test001;

public class Sample002 {

	public static void main(String[] args) {
		
		//예외(Exception) 및 예외처리
		
		//정상적인 자료 준비한 경우
		//String a = "TEST";

		//NullPointerException
		//->참조 자료형 변수에 정상적인 값이 없는 경우 발생
		String a = null;
		
		//예외 발생 가능 구문
		//->참조 자료형 변수에 null 이 있는 상태에서 하위 멤버 접근(. 연산자) 시도하면 예외 발생
		//->예외 발생시 프로그램 비정상 종료.
		//->try~catch 예외 처리 구문 추가
		try {
			System.out.println(a.toString());
		} catch(Exception e) {
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

		//위에서 예외처리를 적용했기 때문에 이 부분은 정상 실행된다.
		System.out.println("프로그램 정상 종료.");
		

	}

}
