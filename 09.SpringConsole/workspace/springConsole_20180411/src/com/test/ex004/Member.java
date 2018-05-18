package com.test.ex004;

public class Member {
	
	private String name;
	private String id;
	private String password;
	private int age;
	
	public String getName() {
		return this.name;
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
	
	public String memberInfo() {
		return String.format("[%s, %s, %s, %s]", this.name, this.id, this.password, this.age);
	}
	

}
