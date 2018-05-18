package com.member001;

//자료형 클래스 -> VO, DTO 클래스
public class Member {
	
	//화면 설계를 토대로 분석한 결과를 필드로 구성 -> getter, setter 구성
	//이름, 전화번호, 이메일, 등록일(yyyy-MM-dd)
	
	//필드 구성
	private String name, phone, email, regDate;

	//기본 생성자 추가
	public Member() {
	}
	//매개변수 목록이 있는 생성자 추가
	public Member(String name, String phone, String email, String regDate) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.regDate = regDate;
	}
	
	//getter, setter 구성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	//회원 정보 출력용 메소드 추가
	public String memberInfo() {
		return String.format("%-10s %-15s %-20s %-12s", this.name, this.phone, this.email, this.regDate);
	}
	
}
