package com.test;

public class Sample084 {

	public static void main(String[] args) {
		
		//서식 지정 문자열
		//System.out.printf("서식 포함 문자열", 대상, ...)
		//String.format("서식 포함 문자열", 대상,...)
		
		// %[argument_index$][flags][width][.precision]conversion
		// 정수 관련 서식 -> %d
		// 실수 관련 서식 -> %f
		// 범용(문자열) 관련 서식 -> %s
		// 줄바꿈 문자 관련 서식 -> %n
		
		int a = 10;
		System.out.printf("[%d]%n", a);
		System.out.printf("[%10d]%n", a);
		System.out.printf("[%-10d]%n", a);
		System.out.printf("[%10d] [%10d] %n", a, a);
		System.out.printf("[%1$10d] [%1$10d] %n", a);
		
		double b = 1234.567890123456789;
		System.out.printf("[%f]%n", b);
		System.out.printf("[%.1f]%n", b);
		System.out.printf("[%10.1f]%n", b);
		System.out.printf("[%-10.1f]%n", b);
		System.out.printf("[%1$f] [%1$f]%n", b);
		System.out.printf("[%.20f]%n", b);
		
		String c = "TEST";
		System.out.printf("[%s]%n", c);
		System.out.printf("[%10s]%n", c);
		System.out.printf("[%-10s]%n", c);
		System.out.printf("[%s]%n", a);
		System.out.printf("[%s]%n", b);
		
		
		//16진수 서식
		System.out.printf("%1$d -> %1$H(16)%n", 255);
		System.out.printf("%1$s -> %1$H(16)%n", "A");
		
		//Boolean 서식
		System.out.printf("%1$d -> %1$B%n", 255);
		System.out.printf("%1$s -> %1$B%n", "A");
		System.out.printf("%1$s -> %1$B%n", null);
		
		//문자 서식
		System.out.printf("%1$d -> %1$c%n", 97);
		
		//16진수 서식
		System.out.printf("%1$d -> %1$X%n", 255);
		
		//지수 서식
		System.out.printf("%1$f -> %1$E%n", 1234.56);
		System.out.printf("%1$f -> %1$E%n", 0.00001234);

		//grouping separators(,) 서식
		System.out.printf("%1$d -> %1$,d%n", 1234567);
		
		//zero-pad(0) 서식
		System.out.printf("%1$d -> %1$05d%n", 12);
		
	}

}
