package com.bank005;

public class Account {
	
	// 데이터 모델링을 위한 분석은 화면설계를 토대로 항목 분석을 한다.
	// ->private 필드로 구성
	// ->getter, setter 메소드 추가
	/*
 
	 --------- 
	 계좌 생성 
	 --------- 
	 계좌번호: 111-1111 
	 계좌주: 홍길동 
	 초기입금액: 10000
	  
	*/
	// 기본 자료형은 String으로 지정하고, 산술 연산 필요한 자료만 int형으로 선언.
	// 실수, 날짜 자료형은 선택적으로 사용.

	// 초기입금액은 계좌 생성시 한 번만 실행할 수 있는 액션이다.
	//-> (매개변수 목록이 있는) 생성자 호출
	//-> 기본 생성자(필수) + 매개변수 목록 있는 생성자 등으로 구성

	private String accountNumber;
	private String accountName;
	private int balance;
	
	
	//기본 생성자
	public Account() {
		
	}
	
	//매개변수 목록이 있는 생성자(생성자 오버로딩)
	public Account(String accountNumber, String accountName, int balance) {
		
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		// balance는 0 이상 ~ 100만 이하 자료만 저장 가능
		if (balance >= 0 && balance <= 1000000) {
			this.balance = balance;
		}
		
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	public String getAccountName() {
		return this.accountName;
	}
	public int getBalance() {
		return this.balance;
	}
	
	// 계좌 정보 출력용 전용 메소드 추가
	public String accountInfo() {
		return String.format("%-10s %-6s %7s", this.accountNumber, this.accountName, this.balance);
	}

}
