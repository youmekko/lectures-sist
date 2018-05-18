package com.inheritance016;

public class Child extends Parent {
	
	private int studentNo;
	
	//기본 생성자
	public Child() {
		//부모 생성자 호출
		//super();
	}
	
	//Implicit super constructor Parent() is undefined. 
	//Must explicitly invoke another constructor
	public Child(String name, int studentNo) {
		
		//부모 생성자 호출
		//super();
		
		this.name = name;
		this.studentNo = studentNo;
	}

}
