package com.test;

public class Sample022 {

	public static void main(String[] args) {
		
		//비교 연산자 주의사항
		//double과 float 자료형의 비교
		
		float a = 0.1F;
		double b = 0.1D;
		
		System.out.println(a);
		System.out.println(b);
		
		//0.1을 float와 double로 저장시 저장된 값이 약간 다름.
		System.out.println(a == b);
		System.out.println(a != b);
		
		//float 와 double 자료 비교시 float로 강제 형변환 후 비교
		System.out.println((float)a == (float)b);

	}

}
