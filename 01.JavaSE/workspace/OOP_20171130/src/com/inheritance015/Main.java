package com.inheritance015;

public class Main {

	public static void main(String[] args) {

		//자식 클래스의 객체 생성 및 멤버 확인
		SubClass sub = new SubClass(10);
		
		System.out.println(sub.getA()); //10
		
	}

}
