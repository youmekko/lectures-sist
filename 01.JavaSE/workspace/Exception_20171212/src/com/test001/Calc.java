package com.test001;

public class Calc {
	
	public static int mod(int a, int b) throws ArithmeticException {
		int result = 0;
		
		//몫 연산 과정 추가
		//주의) ArithmeticException 발생 가능 -> throws 예외 처리 구문 사용
		
		result = a / b;
		
		return result;
	}

}
