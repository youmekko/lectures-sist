package com.test005;

public class Main {

	public static void main(String[] args) {
		
		//제한된 타입 파라미터 <T extends 최상위타입> 제네릭 메소드 테스트
		
		//Number의 하위 자료형(Byte, Short, Integer, Long, Float, Double)만 가능
		Util.<Integer>compare(10, 20); //O
		
		//Number의 하위 자료형만 가능
		//Util.<String>compare("10", "20"); //X
		
		//Number의 하위 자료형(Byte, Short, Integer, Long, Float, Double)만 가능
		Box<Integer> box1 = new Box<Integer>(); //O
		box1.setT(10);
		System.out.println(box1.getT());
		
		//Number의 하위 자료형만 가능
		/*
		Box<String> box2 = new Box<String>(); //X
		box2.setT("10");
		System.out.println(box2.getT());
		*/
		

	}

}
