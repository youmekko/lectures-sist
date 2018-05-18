package com.test048;

public class AccountExample {

	public static void main(String[] args) {
		
		Account account = new Account();
		
		account.setBalance(10000);
		System.out.printf("현재 잔고:%s%n", account.getBalance()); //10000

		account.setBalance(-100);
		System.out.printf("현재 잔고:%s%n", account.getBalance()); //변동 없음

		account.setBalance(2000000);
		System.out.printf("현재 잔고:%s%n", account.getBalance()); //변동 없음

		account.setBalance(300000);
		System.out.printf("현재 잔고:%s%n", account.getBalance()); //300000

	}

}
