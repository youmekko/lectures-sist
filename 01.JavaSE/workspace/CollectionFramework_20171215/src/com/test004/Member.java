package com.test004;

public class Member {
	
	private String name;
	private String phone;
	
	public Member() {
	}
	public Member(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s", this.name, this.phone);
	}
	


}
