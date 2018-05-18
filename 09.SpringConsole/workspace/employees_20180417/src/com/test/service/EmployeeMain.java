package com.test.service;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;

public class EmployeeMain {

	//(관리자용) 메인 메뉴 구성
	public void main(Scanner sc, String id_, ApplicationContext context) {
		
		EmployeeService service = new EmployeeService(context);
		
		// 메인 메뉴 액션
		boolean run = true;
		while (run) {
			System.out.println("------------------------------------");
			System.out.printf("직원관리v3.0 MySQL (관리자:%s)%n", id_);
			System.out.println("------------------------------------");
			System.out.println("1.직원관리 2.기초정보관리");
			System.out.print("선택(1~2, 0 quit)?");

			int m = sc.nextInt();
			sc.nextLine();

			switch (m) {
			case 0:	run = false; break;
			case 1: service.menu_1(sc); break;
			case 2: service.menu_2(sc); break;
			}

		}
		System.out.println("로그아웃되었습니다.");
		
	}
	
}
