package com.test;

import java.time.*;

//�ڷ��� Ŭ����
public class Member {
	
	//�ʵ� ����
	//->�Է�, ��¿� ������ ��� �׸�
	//->���� �ڷ�, ���� �ĺ���
	private String mid_, name_, phone, email;
	private LocalDate regDate;
	
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
	

}
