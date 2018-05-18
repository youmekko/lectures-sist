package com.bank006;

public class Account {
	
	//데이터모델링(화면설계)->클래스 표현->항목 분석->필드 구성->getter, setter 구성
	
	//계좌번호 -> ano
	//계좌주 -> owner
	//초기입금액, 출금액, 예금액 -> balance
	
	//필드 구성
	private String ano;
	private String owner;
	private int balance;
	
	//매개변수 목록이 있는 생성자 구성
	//->초기입금액 액션 처리용
	public Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}
	
	//getter, setter 구성
	//->출금액, 예금액 액션 처리용
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	

}
