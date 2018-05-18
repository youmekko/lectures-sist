package com.test002;

public class Main {

	public static void main(String[] args) {

		//객체 생성시 필드가 자동 초기화된다.
		FieldInitValue f = new FieldInitValue();
		
		//필드에 대한 자동 초기화 결과 확인
		System.out.println(f.intField); //0
		System.out.println(f.doubleField); //0.0
		System.out.println(f.stringField); //null
		System.out.println(f.arr); //null
		
	}

}
