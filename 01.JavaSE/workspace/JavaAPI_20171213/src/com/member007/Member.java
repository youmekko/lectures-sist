package com.member007;

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
	//->객체의 정보 출력용 메소드는 toString() 오버라이딩
	//->toString() 메소드는 명시적 호출이 없어도 호출 가능
	@Override
	public String toString() {
		return String.format("%-10s %-15s %-20s %-12s", this.name, this.phone, this.email, this.regDate);
	}
	
	
	
	//문제) equals() 메소드에 대한 오버라이딩 구현
	//Member 객체에 대한 참조주소 비교가 아니라 값 비교 액션 구현
	//이름, 전화번호, 이메일이 전부 일치하면 true, 일치하지 않는 항목이 있다면 false 반환
	
	
	
	
}
