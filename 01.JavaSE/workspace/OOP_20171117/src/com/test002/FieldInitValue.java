package com.test002;

public class FieldInitValue {

	//필드 자동 초기화 테스트
	//int형은 0, double형은 0.0, 참조형은 null로 초기화.

	//정수형
	byte byteField;
	short shortField;
	int intField; //기본자료형. 4byte, -21억~21억(2147483647)
	long longField; //접미사 L
	
	//실수형
	float floatField; //접미사 F
	double doubleField; //기본자료형.
	
	//논리형
	boolean booleanField; //true or false
	
	//문자열형
	String stringField; //java.lang.String
	
	//참조형
	//클래스, 배열, 열거형(enum), 인터페이스 
	int[] arr;

}
