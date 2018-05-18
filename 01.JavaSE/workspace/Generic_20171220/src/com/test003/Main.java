package com.test003;

public class Main {

	public static void main(String[] args) {
		
		//제네릭 클래스 Box<T>에 대한 객체 생성 테스트
		//->타입 파라미터 T에 대한 자료형 지정 필요
		Box<String> box1 = new Box<String>();
		box1.setT("123");
		System.out.println(box1.getT()); //String
		
		Box<Integer> box2 = new Box<Integer>();
		box2.setT(123);
		System.out.println(box2.getT()); //Integer

	}

}
