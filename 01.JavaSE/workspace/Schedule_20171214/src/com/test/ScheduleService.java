package com.test;

import java.util.*;
import java.time.*;
import java.time.format.*;

//메뉴 액션 진행을 위한 서비스 클래스
public class ScheduleService {

	//(컬렉션) 저장소 접근을 위한 공용 변수 -> 현재 클래스 내부에서 사용될 예정
	private ScheduleDAO dao = new ScheduleDAO();

	//스케줄 자료 등록 -> 콘솔 외부 입력 액션 필요 -> Scanner 객체 필요
	public void scheduleAdd(Scanner sc) {
		
		System.out.print("날짜(YYYY-MM-DD)?");
		String date = sc.nextLine();
		System.out.print("내용(200자 이내)?");
		//nextLine() 메소드는 공백 포함 문장 전체를 하나의 문자열로 입력받을 수 있다.
		String content = sc.nextLine();
		
		this.dao.scheduleAdd(date, content);
		System.out.println("일정이 추가되었습니다.");
		
	}
	
	//스케줄 자료 전체 출력 및 검색
	public void scheduleList(Scanner sc) {

		// 검색을 위한 서브메뉴 운영
		boolean run = true;
		while (run) {
			System.out.println("--- 일정 출력(서브메뉴) ---");
			System.out.println("1. 오늘 일정");
			System.out.println("2. 특정 일 일정");
			System.out.println("3. 특정 월 일정");
			System.out.println("4. 특정 단어 포함 일정");
			System.out.println("5. 전체 일정");
			System.out.print("선택(1~5, 0 quit)?");
			int selectNo = sc.nextInt();
			sc.nextLine();

			switch (selectNo) {
			case 1:	this.scheduleList_sub01(); break;
			case 2:	this.scheduleList_sub02(sc); break;
			case 3:	this.scheduleList_sub03(sc); break;
			case 4:	this.scheduleList_sub04(sc); break;
			case 5:	this.scheduleList_sub05(); break;
			case 0: run = false; break;
			}
		}
		
	}
	
	
	private void scheduleList_sub01() {
		//오늘 날짜(YYYY-MM-DD) 기준 검색
		String key = "날짜";
		LocalDate now = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String value = now.format(dateTimeFormatter);
		System.out.print(this.dao.scheduleList(key, value));		
	}
	
	private void scheduleList_sub02(Scanner sc) {
		//특정 일(YYYY-MM-DD) 기준 검색
		String key = "날짜";
		System.out.print("특정 일(YYYY-MM-DD)?");
		String value = sc.nextLine();
		System.out.print(this.dao.scheduleList(key, value));		
	}
	
	private void scheduleList_sub03(Scanner sc) {
		//특정 월(YYYY-MM) 기준 검색
		String key = "날짜";
		System.out.print("특정 월(YYYY-MM)?");
		String value = sc.nextLine();
		System.out.print(this.dao.scheduleList(key, value));		
	}
	
	private void scheduleList_sub04(Scanner sc) {
		//특정 단어 기준 검색
		String key = "내용";
		System.out.print("특정 단어?");
		String value = sc.nextLine();
		System.out.print(this.dao.scheduleList(key, value));		
	}
	
	private void scheduleList_sub05() {
		//전체 일정
		System.out.print(this.dao.scheduleList());		
	}
	
	
}
