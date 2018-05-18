package com.test.ex002;

import java.time.LocalDate;

//자료형 클래스 선언
//->클래스명 지정시 테이블명과 동일하게 작성
public class Member {

	//회원번호, 이름, 전화번호, 이메일, 등록일, 부서번호, 부서명
	//mid_, name_, phone, email, regDate, deptId, deptName
	
	//필드 구성
	private String mid_, name_, phone, email, deptId, deptName;
	private LocalDate regDate;
	
	//getter, setter 구성
	public String getMid_() {
		return mid_;
	}

	public void setMid_(String mid_) {
		this.mid_ = mid_;
	}

	public String getName_() {
		return name_;
	}

	public void setName_(String name_) {
		this.name_ = name_;
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

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	//toString() 메소드 오버라이딩
	@Override
	public String toString() {
		return String.format("%s %s %s %s %s %s", mid_, name_, phone, email, regDate, deptName);
	}
	
}
