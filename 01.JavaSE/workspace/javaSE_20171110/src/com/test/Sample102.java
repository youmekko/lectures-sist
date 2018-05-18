package com.test;

public class Sample102 {

	public static void main(String[] args) {
		
		
		//강제(명시적) 형변환은 기본자료형끼리 변환시 사용.
		//기본자료형1 변수 = (기본자료형1)기본자료형2;
		
		//기본자료형->문자열형(참조자료형)
		//String 변수 = String.valueOf(기본자료형);
		
		
		//문자열형(참조자료형)->기본자료형
		//int 변수 = Integer.parseInt(문자열형);
		//double 변수 = Double.parseDouble(문자열형);
		//주의) 문자열은 숫자로 변환 가능한 문자열만 변환. 예를 들어, "1234"은 1234가 되지만, "TEST"는 변환시 오류.
		
		//문자열형 배열 생성 및 초기화
		String[] arr = {"10", "20", "30"};
		
		//합산 연산 수행 후 결과 출력
		int sum = 0;
		for (int a=0; a<arr.length; ++a) {
			
			//틀린 예
			//문자열과 기본자료형의 + 연산은 문자열 결과
			//문자열 결과를 int 자료형 변수에 대입 불가
			//sum = sum + arr[a];
			
			//올바른 예
			//문자열을 int 자료형으로 형변환 필요
			int b = Integer.parseInt(arr[a]);
			sum += b;

		}
		System.out.println(sum);
		

	}

}
