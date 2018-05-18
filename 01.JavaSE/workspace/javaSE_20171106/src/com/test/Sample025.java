package com.test;

public class Sample025 {

	public static void main(String[] args) {
		
		//논리 연산자
		//&&(and), ||(or), !(not)
		//참 AND 참 => 참
		//참 AND 거짓 => 거짓
		//참 OR 참 => 참
		//참 OR 거짓 => 참
		
		boolean a = true;
		boolean b = false;
		boolean c = true;
		
		System.out.println(a && b);
		System.out.println(a || b);
		System.out.println(!(a && b));
		System.out.println(!(a || b));
		System.out.println(!a && b);
		System.out.println(!a || b);
		
		int d = 10;
		int e = 20;
		System.out.println( (d == e) && (d < e) );
		System.out.println( (d == e) || (d < e) );
		
		int f = 14;
		//2의 배수(짝수)
		System.out.println( (f % 2) == 0 );
		//2의 배수가 아닌 수(홀수)
		System.out.println( (f % 2) == 1 );
		//3의 배수
		System.out.println( (f % 3) == 0 );
		//5의 배수
		System.out.println( (f % 5) == 0 );
		//2의 3의 공배수
		System.out.println( (f % 2) == 0 && (f % 3) == 0 );
		

	}

}
