package com.inheritance004;

//java.lang.Object 클래스에 대한 자동 상속
public class Calculation    {
	
	//필드 -> 자동 초기화 -> 0
	//instance 변수
	//default -> 상속 가능
	int z;
	
	//기본 생성자 자동 생성

	//instance 메소드
	//public -> 상속 가능
	public void addition(int x, int y) {
		//x, y -> local 변수
		this.z = x + y;
		System.out.println("The sum of the given numbers:" + this.z);
	}

	public void subtraction(int x, int y) {
		this.z = x - y;
		System.out.println("The difference between the given numbers:" + this.z);
	}
	
}
