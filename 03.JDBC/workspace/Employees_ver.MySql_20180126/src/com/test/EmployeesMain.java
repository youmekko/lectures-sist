package com.test;

import java.util.*;

//콘솔 액션 클래스(관리자 전용)
public class EmployeesMain {
	
	//(관리자용) 메인 메뉴 구성
	public void main(Scanner sc, String id_) {
		
		EmployeesService service = new EmployeesService();
		
		// 메인 메뉴 액션
		boolean run = true;
		while (run) {
			System.out.println("------------------------------------");
			System.out.printf("직원관리v2.0 MySQL (관리자:%s)%n", id_);
			System.out.println("------------------------------------");
			System.out.println("1.직원관리 2.기초정보관리");
			System.out.print("선택(1~2, 0 quit)?");

			int m = sc.nextInt();
			sc.nextLine();

			switch (m) {
			case 0:	run = false; break;
			case 2: service.menu_2(sc); break;
			}

		}
		System.out.println("로그아웃되었습니다.");
		
	}

}
