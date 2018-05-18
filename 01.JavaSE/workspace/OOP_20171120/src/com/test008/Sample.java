package com.test008;

//매개변수 테스트용 클래스
public class Sample {
	
	//매개변수 개수가 불확실한 경우
	//->단, 자료형은 확정된 상태.
	//->매개변수 목록에서 "..." 표현.
	//->전달 받은 매개값 목록이 배열로 표현된다.
	//->가변매개변수
	void method1(int ... args) {
		
		for (int temp : args) {
			System.out.println(temp);
		}
		
		for (int b = 0; b<args.length; ++b) {
			System.out.printf("a[%d]: %d%n", b, args[b]);
		}
		
	}

}
