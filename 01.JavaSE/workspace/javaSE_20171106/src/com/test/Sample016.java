package com.test;

public class Sample016 {

	public static void main(String[] args) {
		
		//산술연산자 주의사항
		//오버플로우(overflow)
		
		int a = Integer.MAX_VALUE;
		int b = 1;
		
		//2147483647 + 1 => 2147483648(예상) => -2147483648(실제)
		//-> 안전한 산술연산을 하려면 오버플로우 감지하는 과정 필요
		int c = a + b;
		System.out.println(c);
		

	}

}
