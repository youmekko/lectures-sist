package com.test001;

public class Sample011 {

	public static void main(String[] args) {
		
		//예외 발생시키기
		/*
		
		- 사용자가 임의로 예외 객체를 생성하고, 외부로 내보내기 하는 상태.
		- throw, throws 키워드 사용
		- 기본 형식
		접근제한자 반환자료형 메소드이름(매개변수 리스트) throws 예외종류 {
		
			//상황에 맞는 예외객체 선택
			throw new 예외객체("메시지");
		
		}
		
		*/
		
		//정상적인 경우
		/*
		int a = 10;
		int b = 5;
		*/
		
		//비정상적인 경우
		int a = 10;
		int b = 0;

		//Calc3 클래스의 mod() 메소드가 checked exception 상태이므로
		//컴파일 단계에서 예외 확인 가능
		//->try~catch 필수
		try {
			//사용자 정의 예외 발생 가능 구문
			System.out.printf("몫 연산 결과:%d%n", Calc3.mod(a, b));
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.toString());
		}
		
		System.out.println("프로그램 정상 종료.");

	}

}
