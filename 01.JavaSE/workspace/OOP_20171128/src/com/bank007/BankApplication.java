package com.bank007;

import java.util.*;

//메인메뉴 액션 클래스
public class BankApplication {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		//화면(메뉴) 액션
		boolean run = true;
		while(run) {
			
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 2.계좌목록 3.예금 4.출금 5.종료.");
			System.out.println("-------------------------------------------");
			System.out.print("선택>");
			
			int selectNo = sc.nextInt();
			
			//메뉴 액션
			if (selectNo == 1) {
				//AccountService 클래스의 createAccount() 메소드 호출
				//->시그니처 분석
				//->public static void createAccount(Scanner sc)
				AccountService.createAccount(sc);
			} else if (selectNo == 2) {
				
			} else if (selectNo == 3) {
				
			} else if (selectNo == 4) {
				
			} else if (selectNo == 5) {
				run = false;
			}
			
		}
		
		sc.close();
		System.out.println("프로그램 종료.");
		
	}
	


}
