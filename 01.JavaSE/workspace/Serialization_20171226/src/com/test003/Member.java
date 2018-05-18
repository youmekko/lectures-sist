package com.test003;

import java.io.Serializable;

//자료형 클래스 -> 직렬화 가능 클래스
public class Member implements Serializable {

	// 화면 설계를 토대로 항목 결정.
	// 회원번호(M001 형식), 이름, 전화번호, 이메일, 등록일(yyyy-MM-dd), 부서번호
	// 주의) 부서 정보는 개발부(B01), 마케팅부(B02), 총무부(B03)만 존재한다고 가정.

	private String mid, name, phone, email, regDate, deptId;

	// 기본 생성자 추가
	public Member() {
	}

	// 매개변수 목록이 있는 생성자 추가
	public Member(String mid, String name, String phone, String email, String regDate, String deptId) {
		this.mid = mid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.regDate = regDate;
		this.deptId = deptId;
	}

	public String getMid() {
		return mid;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getRegDate() {
		return regDate;
	}

	public String getDeptId() {
		return deptId;
	}

	// 회원 정보 출력용 메소드 추가
	@Override
	public String toString() {
		return String.format("%-5s %-10s %-15s %-20s %-12s %s", this.mid, this.name, this.phone, this.email, this.regDate,
				Dept.getValue(this.deptId));
	}
	
}
