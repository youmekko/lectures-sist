package com.test;

import java.util.*;

//콘솔 액션 클래스
public class EmployeesService {
	
	private EmployeesDAO dao = new EmployeesDAO();
	
	/*
	//주메뉴 구성을 위한 번호 구성
	public void menu_2() {
	}

	//서브메뉴 구성을 위한 번호 구성
	private void menu_21() {
	}

	//서브메뉴의 서브메뉴 구성을 위한 번호 구성
	private void menu_211() {
	}
	*/

	//직원관리v2.0 MySQL > 2.기초정보관리
	public void menu_2(Scanner sc) {
		//메뉴 액션
		boolean run = true;
		while (run) {
			System.out.println("-----------------------------------");
			System.out.println("직원관리v2.0 MySQL > 2.기초정보관리");
			System.out.println("-----------------------------------");
			System.out.println("1.지역관리 2.부서관리 3.직위관리");
			System.out.print("선택(1~3, 0 quit)?");

			int m = sc.nextInt();
			sc.nextLine();

			switch (m) {
			case 0:	run = false; break;
			case 1: this.menu_21(sc); break;
			}

		}
	}
	
	//직원관리v2.0 MySQL > 2.기초정보관리 > 1.지역관리
	private void menu_21(Scanner sc) {
		//메뉴 액션
		boolean run = true;
		while (run) {
			System.out.println("------------------------------------------------");
			System.out.println("직원관리v2.0 MySQL > 2.기초정보관리 > 1.지역관리");
			System.out.println("------------------------------------------------");
			System.out.println("1.지역입력 2.지역출력 3.지역삭제");
			System.out.print("선택(1~3, 0 quit)?");

			int m = sc.nextInt();
			sc.nextLine();

			switch (m) {
			case 0:	run = false; break;
			case 1: this.menu_211(sc); break;
			case 2: this.menu_212(sc); break;
			case 3: this.menu_213(sc); break;
			}

		}		
	}
	
	//직원관리v2.0 MySQL > 2.기초정보관리 > 1.지역관리 > 1.지역입력
	private void menu_211(Scanner sc) {
		System.out.println("지역번호/ 지역이름");
		for (Employees e : dao.regionList()) {
			System.out.printf("%s/ %s%n", e.getReg_id(), e.getReg_name());
		}
		System.out.print("신규 등록 지역이름:");
		String reg_name = sc.nextLine();
		
		int result = dao.regionInsert(reg_name);
		System.out.printf("%d개의 행이 추가되었습니다.%n", result);
		
	}
	
	//직원관리v2.0 MySQL > 2.기초정보관리 > 1.지역관리 > 2.지역출력
	private void menu_212(Scanner sc) {
		System.out.println("지역번호/ 지역이름");
		for (Employees e : dao.regionList()) {
			System.out.printf("%s/ %s%n", e.getReg_id(), e.getReg_name());
		}		
	}

	//직원관리v2.0 MySQL > 2.기초정보관리 > 1.지역관리 > 3.지역삭제
	private void menu_213(Scanner sc) {
		
		//지역 정보 출력 -> 삭제 가능 여부 출력
		//삭제하고자 하는 지역번호 입력
		//삭제 요청
		//삭제 결과 분석 및 메시지 출력
		System.out.println("지역번호/ 지역이름/ 삭제가능여부");
		for (Employees e : dao.regionList()) {
			System.out.printf("%s/ %s/ %s%n", e.getReg_id(), e.getReg_name(), (e.getDeleteCheck()==0)?"Y":"N");
		}
		System.out.print("삭제할 지역의 지역번호:");
		String reg_id = sc.nextLine();
		
		int result = dao.regionDelete(reg_id);
		System.out.printf("%d개의 행이 삭제되었습니다.%n", result);
		
	}
	
	
	
	
}
