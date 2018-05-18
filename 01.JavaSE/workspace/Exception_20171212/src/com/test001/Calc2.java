package com.test001;

public class Calc2 {

	//throws 키워드에 의해서 발생한 예외 객체를 밖으로 내보내기 한다.
	public static int mod(int a, int b) throws Exception {
		int result = 0;
		
		//예외 발생시키기
		//주의) 변수 b에 0이 전달된다면 Exception 예외 발생 -> throw 키워드 사용
		if (b == 0) {
			//throw 키워드에 의해서 준비된 예외 객체가 발생된다.
			//메시지가 있는 예외 객체
			throw new Exception("0으로 나누기 시도.");
			//메시지가 없는 예외 객체 -> 상황 분석이 어려울 수도 있다. -> 사용자 정의 예외 객체를 만들면 클래스 이름에 예외 상황을 표현할 수 있다.
			//throw new Exception();
		}
		
		result = a / b;
		
		return result;
	}

}
