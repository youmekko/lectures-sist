package com.bank002;

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

	private String accountNumber;
	private String accountName;
	private int balance;

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		// balance는 0 이상 ~ 100만 이하 자료만 저장 가능
		if (balance >= 0 && balance <= 1000000) {
			this.balance = balance;
		}
	}

	// 계좌 정보 출력용 전용 메소드 추가
	public String accountInfo() {
		return String.format("%-10s %-6s %7s", this.accountNumber, this.accountName, this.balance);
	}

}
