package com.test;

//변수 선언 불가 위치

public class Sample040 {
	
	//변수 선언 가능
	//Instance variables, Class/Static variables
	
	public static void main(String[] args) {
		
		//변수의 사용 범위
		//변수는 선언된 위치(코드 블럭 내)에 따라서 사용 범위가 결정된다.
		//Local variables, Instance variables, Class/Static variables
		//Local variables are declared in methods, constructors, or blocks.
		//Local variables are created when the method, constructor or block is entered and the variable will be destroyed once it exits the method, constructor, or block.
		//There is no default value for local variables, so local variables should be declared and an initial value should be assigned before the first use.
		
		//(로컬)변수 선언(초기값 지정) 위치
		//(로컬)변수 사용 위치
		//(로컬) 변수는 선언 범위 안에서 사용해야 한다.
		
		int a = 10;
		System.out.println(a);
		
		//The local variable b may not have been initialized
		int b;
		System.out.println(b);
		
		
	}

}
