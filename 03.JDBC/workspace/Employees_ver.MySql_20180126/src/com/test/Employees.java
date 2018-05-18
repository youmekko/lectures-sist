package com.test;

//자료형 클래스 선언
public class Employees {

	//지역 정보를 위한 필드 구성
	private String reg_id, reg_name;
	
	//삭제 가능 여부 확인용 필드 구성
	private int deleteCheck;

	
	//매개변수 있는 생성자 구성


	//getter, setter 구성
	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public String getReg_name() {
		return reg_name;
	}

	public void setReg_name(String reg_name) {
		this.reg_name = reg_name;
	}
	
	public int getDeleteCheck() {
		return deleteCheck;
	}

	public void setDeleteCheck(int deleteCheck) {
		this.deleteCheck = deleteCheck;
	}
	
	
}
