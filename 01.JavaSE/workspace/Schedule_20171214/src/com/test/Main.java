package com.test;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ScheduleService service = new ScheduleService();
		
		while(true) {
			System.out.println("--- 일정 관리 ---");
			System.out.println("1.일정입력");
			System.out.println("2.일정출력 및 검색");
			System.out.print("선택(1~3, 0 exit)?");
			int m = sc.nextInt();
			sc.nextLine();
			if (m == 0) break;
			switch (m) {
			case 1: service.scheduleAdd(sc); break;
			case 2: service.scheduleList(sc); break;
			}
		}
		
		sc.close();
		System.out.println("프로그램 종료.");
		
	}

}
