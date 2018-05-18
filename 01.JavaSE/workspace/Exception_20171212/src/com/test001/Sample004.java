package com.test001;

public class Sample004 {

	public static void main(String[] args) {
		
		//예외(Exception) 및 예외처리
		
		//NumberFormatException
		//잘못된 숫자 형태의 문자열을 숫자로 형변환 시도하는 경우 발생 

		//정상적인 경우
		//String a = "123";
		
		//비정상인 경우
		String a = "123T";
		
		try {
			//예외 발생 가능 구문
			//숫자 형태의 문자열을 숫자로 형변환 시도
			int b = Integer.parseInt(a);
			System.out.println(b + 100);
			
		} catch(Exception e) {
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

		//위에서 예외처리를 적용했기 때문에 이 부분은 정상 실행된다.
		System.out.println("프로그램 정상 종료.");
		

	}

}
