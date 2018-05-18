package com.test;

public class Sample097 {

	public static void main(String[] args) {
		
		//배열 사용시 주의사항
		
		//배열 생성시 사용한 자료형의 값만 저장 가능.
		
		//올바른 예
		int[] arr1 = new int[5];
		arr1[0] = 10;
		arr1[1] = Integer.MAX_VALUE;
		
		//틀린 예
		arr1[2] = 10.0;
		arr1[3] = "TEST";
		arr1[4] = "10";
		
		//double 자료형 배열에 int 자료형 값 저장
		//->자동(암시적) 형변환
		double[] arr2 = new double[5];
		arr2[0] = 10;
		

	}

}
