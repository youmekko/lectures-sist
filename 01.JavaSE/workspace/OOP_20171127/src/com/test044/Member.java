package com.test044;

public class Member {
	
	//아이디, 패스워드 항목을 가진 사용자 정의 자료형(클래스) 선언
	private String id, password;
	
	public Member() {
		
	}
	public Member(String id, String password) {
		this.id = id;
		this.password = password;
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

}
