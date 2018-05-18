package com.test008;

public class Main {

	public static void main(String[] args) {
		
		//가변매개변수에 대한 값 전달
		//메소드 시그니처-> void method1(int ... args)
		Sample s = new Sample();
		
		//전달해야 하는 값의 개수에 제약이 없다.
		s.method1();
		s.method1(10);
		s.method1(10, 20);
		s.method1(10, 20, 30);

		//배열 객체를 전달할 수 있다.
		int[] arr = {10, 20, 30, 40};
		s.method1(arr);

	}

}
