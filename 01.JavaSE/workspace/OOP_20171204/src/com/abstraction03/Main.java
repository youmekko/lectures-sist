package com.abstraction03;

public class Main {

	public static void main(String[] args) {
		
		//자바에서 제공하는 대표적인 추상 클래스인 Number 클래스에 대한 객체 생성 테스트
		//Cannot instantiate the type Number
		//Number num = new Number();
		
		Number num01 = new Integer("127");
		byte result01 = num01.byteValue();
		System.out.println(result01);
		
		Integer num02 = new Integer("127");
		byte result02 = num02.byteValue();
		System.out.println(result02);
		

	}

}
