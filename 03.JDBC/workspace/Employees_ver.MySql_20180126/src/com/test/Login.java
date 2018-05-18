package com.test;

//자료형 클래스
public class Login {
	
	//로그인 액션 진행에 필요한 필드 구성
	//-> id_, pw_, grade
	private String id_, pw_;
	private int grade;
	
	//매개변수 있는 생성자 구성
	public Login(String id_, String pw_) {
		this.id_ = id_;
		this.pw_ = pw_;
	}
	public Login(String id_, int grade) {
		this.id_ = id_;
		this.grade = grade;
	}
	
	//getter, setter 구성
	public String getId_() {
		return id_;
	}
	public void setId_(String id_) {
		this.id_ = id_;
	}
	public String getPw_() {
		return pw_;
	}
	public void setPw_(String pw_) {
		this.pw_ = pw_;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
