package com.test;

import java.time.LocalDate;

//자료형 클래스 선언
//->클래스명 지정시 테이블명과 동일하게 작성
public class Member {

	// 자료형 클래스 선언시 멤버 구성은
	// 동일 자료, 동일 식별자 권장
	// ->데이터베이스 입력, 출력 액션에서 사용한 모든 식별자(특히 별칭 사용한 경우)를 멤버로 구성
	// ->테이블의 컬럼 구성시 사용한 컬럼명 및 자료형을 멤버로 구성
	// ->오라클에서 NUMBER 자료형인 경우 Java에서는 int, double 자료형
	// ->오라클에서 VARCHAR2, NVARCHAR2 자료형인 경우 Java에서는 String 자료형
	// ->오라클에서 DATE 자료형인 경우 Java에서는 Date, LocalDate 자료형
	
	
	//회원번호, 이름, 전화번호, 이메일, 등록일, 부서번호, 부서명
	//mid, name_, phone, email, regDate, deptId, deptName
	
	//필드 구성
	private String mid, name_, phone, email, deptId, deptName;
	private LocalDate regDate;
	
	//매개변수 있는 생성자 추가
	//회원 정보 출력시 사용할 전용 생성자
	public Member(String mid, String name_, String phone, String email,
			LocalDate regDate, String deptName) {
		this.mid = mid;
		this.name_ = name_;
		this.phone = phone;
		this.email = email;
		this.regDate = regDate;
		this.deptName = deptName;
	}
	
	//회원 정보 입력시 사용할 전용 생성자
	public Member(String name_, String phone, String email, LocalDate regDate, String deptId) {
		this.name_ = name_;
		this.phone = phone;
		this.email = email;
		this.regDate = regDate;
		this.deptId = deptId;
	}
	
	//getter, setter 구성
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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
		return String.format("%s %s %s %s %s %s", mid, name_, phone, email, regDate, deptName);
	}
	
}
