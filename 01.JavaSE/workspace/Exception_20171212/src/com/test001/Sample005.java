package com.test001;

import java.util.*;

public class Sample005 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//메인 메뉴 액션
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1. 회원 정보 입력  2. 회원 정보 출력  3. 회원 정보 검색");
			System.out.println("-------------------------------------------------------");
			System.out.print("선택(1~3, 0 quit)?");

			//예외 발생 가능 구문
			//InputMismatchException
			//->try~catch 예외 처리 구문 추가
			//->예외 발생하더라도 프로그램은 정상 실행된다.
			try {
				int selectNo = sc.nextInt();
				sc.nextLine();
	
				switch (selectNo) {
				case 0: run = false; break;
				case 1: System.out.println("메뉴1 선택."); break;
				case 2:	System.out.println("메뉴2 선택."); break;
				case 3: System.out.println("메뉴3 선택."); break;
				}
			}catch(Exception e) {
				System.out.println("잘못된 메뉴 선택입니다.");
				sc.nextLine();
			}

		}
		
		sc.close();
		System.out.println("프로그램 종료.");
		
	}

}
