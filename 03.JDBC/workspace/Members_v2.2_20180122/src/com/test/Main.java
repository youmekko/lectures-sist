package com.test;

import java.util.Scanner;

public class Main {

	//메인 메뉴 액션 메소드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MemberService service = new MemberService();

		// 메인 메뉴 액션
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("1.회원정보입력 2.회원정보출력 3.회원정보검색 4.회원별회비관리");
			System.out.println("-------------------------------------------------------------");
			System.out.print("선택(1~4, 0 quit)?");

			int m = sc.nextInt();
			sc.nextLine();

			switch (m) {
			case 0:	run = false; break;
			case 1:	service.memberAdd(sc); break;
			case 2:	service.memberList(); break;
			case 3:	service.memberList(sc); break;
			case 4: service.memberFee(sc); break;
			}

		}

		sc.close();
		System.out.println("프로그램 종료");
		
	}

}
