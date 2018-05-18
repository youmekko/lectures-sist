package com.test048;

public class Account {

	//chapter6. 확인문제19.
	
	//상수(constant) 선언
	//->static 특성 + final 특성
	//->상수명은 대문자로 표기.
	//->public 권장.
	
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		//주의) 조건문 작성시 변수 먼저 선언
		//예를 들어, 0 <= balance 가 아니라, balance >= 0 형식 권장.
		if ( balance >= MIN_BALANCE && balance <= MAX_BALANCE ) {
			this.balance = balance;
		}
	}
	
}
