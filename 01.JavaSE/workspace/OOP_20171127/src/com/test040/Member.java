package com.test040;

public class Member {
	
	//chapter6. 확인문제13.
	
	//이름, 아이디, 패스워드, 나이
	private String name, id, password;
	private int age;
	
	//getter, setter
	//이클립스에서 getter, setter 자동 생성 기능 제공.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//자료 통합 출력 메소드
	public String memberInfo() {
		return String.format("[%s, %s, %s, %d]"
				, this.name, this.id, this.password, this.age);
	}
	
}
