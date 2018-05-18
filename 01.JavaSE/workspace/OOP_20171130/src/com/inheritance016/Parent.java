package com.inheritance016;

//부모 역할 클래스
public class Parent {
	
	//default 접근제한자
	String name;

	//기본 생성자 부족
	/*
	public Parent() {
	}
	*/
	
	//매개변수 목록이 있는 생성자
	public Parent(String name) {
		this.name = name;
	}

}
