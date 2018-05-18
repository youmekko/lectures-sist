package com.test001;

public class Calc3 {

	//throws 키워드에 의해서 발생한 사용자 정의 예외 객체를 밖으로 내보내기 한다.
	public static int mod(int a, int b) throws DivideByZeroException {
		int result = 0;
		
		//예외 발생시키기
		//주의) 변수 b에 0이 전달된다면 사용자 정의 예외 객체 발생 -> throw 키워드 사용
		if (b == 0) {
			//throw 키워드에 의해서 준비된 사용자 정의 예외 객체가 발생된다.
			throw new DivideByZeroException();
		}
		
		result = a / b;
		
		return result;
	}

}
