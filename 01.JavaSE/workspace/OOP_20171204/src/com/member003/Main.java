package com.member003;

import java.util.*;

//메인 메뉴 액션 클래스
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//메인 메뉴 액션
		MemberService service = new MemberService();

		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1. 회원 정보 입력  2. 회원 정보 출력  3. 회원 정보 검색");
			System.out.println("-------------------------------------------------------");
			System.out.print("선택(1~3, 0 quit)?");

			int selectNo = sc.nextInt();

			switch (selectNo) {
			case 0: run = false; break;
			case 1:	service.memberAdd(sc); break;
			case 2:	service.memberList(sc);	break;
			case 3: service.memberSearch(sc); break;
			}

		}
		
		sc.close();
		System.out.println("프로그램 종료.");
		
	}

}
