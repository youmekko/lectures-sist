package com.test001;

public class Sample006 {

	public static void main(String[] args) {
		
		//throws 구문
		//예외 처리 방법 두 가지. try~catch  또는 throws
		//throws 구문은 예외 발생시 자체 처리하지 않고 내보내기 한다.
		
		//정상적인 경우
		//int a = 10;
		//int b = 5;
		
		//비정상적인 경우
		int a = 10;
		int b = 0;

		//예외 발생 가능 구문
		//호출하는 메소드에 throws 구문이 있다면 메소드 시그니처에 나타난다.
		//->try~catch 구문 추가
		try {
			System.out.printf("몫 연산 결과:%d%n", Calc.mod(a, b));
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		//위에서 예외처리를 적용했기 때문에 이 부분은 정상 실행된다.
		System.out.println("프로그램 정상 종료.");


	}

}
