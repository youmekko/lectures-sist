package com.test007;

public class Main {

	public static void main(String[] args) {
		
		//부모 클래스에 대한 객체 생성
		Box<String> parent = new Box<>();

		//자식 클래스에 대한 객체 생성
		ChildBox<String, String> child = new ChildBox<>();

	}

}
