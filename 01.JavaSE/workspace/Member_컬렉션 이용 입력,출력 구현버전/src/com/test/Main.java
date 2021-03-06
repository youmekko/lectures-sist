package com.test;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MemberService service = new MemberService();

		// 메인 메뉴 액션
		boolean run = true;
		while (run) {
			System.out.println("-----------------------------");
			System.out.println("1.회원정보입력 2.회원정보출력");
			System.out.println("-----------------------------");
			System.out.print("선택(1~2, 0 quit)?");

			int answer = sc.nextInt();
			sc.nextLine();

			switch (answer) {
			case 0:	run = false; break;
			case 1:	service.memberAdd(sc); break;
			case 2:	service.memberList(); break;
			}

		}

		sc.close();
		System.out.println("프로그램 종료");

	}

}
