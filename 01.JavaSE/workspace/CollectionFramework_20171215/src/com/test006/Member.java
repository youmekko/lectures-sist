package com.test006;

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
	
	
	//문제) hashCode() 메소드에 대한 오버라이딩
	@Override
	public int hashCode() {
		return this.name.hashCode() + this.phone.hashCode();
	}	
	
	//문제) equals() 메소드에 대한 오버라이딩
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Member) {
			Member m = (Member) obj;
			result = this.name.equals(m.getName()) && this.phone.equals(m.getPhone());
		}
		return result;
	}

}
