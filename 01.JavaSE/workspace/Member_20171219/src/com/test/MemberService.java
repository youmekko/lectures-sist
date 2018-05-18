package com.test;

import java.util.*;

public class MemberService {

	// (컬렉션) 저장소 객체 확보
	private MemberDAO dao = new MemberDAO();

	// 회원 정보 입력 메소드
	public void memberAdd(Scanner sc) {
		System.out.println("--------------");
		System.out.println("회원정보입력");
		System.out.println("--------------");

		// 콘솔 입력
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("전화번호: ");
		String phone = sc.nextLine();
		System.out.print("이메일: ");
		String email = sc.nextLine();
		System.out.print("등록일(yyyy-MM-dd): ");
		String regDate = sc.nextLine();

		// 부서번호 입력
		System.out.println(Dept.getList());
		System.out.print("부서번호: ");
		String deptId = sc.nextLine();

		// 회원 정보 입력 메소드 호출
		this.dao.memberAdd(name, phone, email, regDate, deptId);
		System.out.println("회원 정보 입력이 성공했습니다");
	}

	// 회원 정보 출력 메소드
	public void memberList() {
		System.out.println("--------------");
		System.out.println("회원정보출력");
		System.out.println("--------------");
		System.out.println(this.dao.memberList());
	}

	// 회원 정보 출력 메소드 -> 정렬 기능 지원
	public void memberList(Scanner sc) {
		// 정렬을 위한 서브메뉴 운영
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("3. 회원정보(정렬)출력>");
			System.out.println("1. 회원번호기준  2. 이름기준  3. 전화번호기준  4. 이메일기준  5. 등록일기준  6. 부서번호기준");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("선택(1~6, 0 quit)?");
			int selectNo = sc.nextInt();
			sc.nextLine();

			switch (selectNo) {
			case 0: run = false; break;
			case 1:	this.memberList(sc, "회원번호"); break;
			case 2:	this.memberList(sc, "이름"); break;
			case 3:	this.memberList(sc, "전화번호"); break;
			case 4:	this.memberList(sc, "이메일"); break;
			case 5:	this.memberList(sc, "등록일"); break;
			case 6:	this.memberList(sc, "부서번호"); break;
			}
		}
	}
	
	private void memberList(Scanner sc, String key) {
		System.out.println("--------------------");
		System.out.printf("회원정보출력(%s)%n", key);
		System.out.println("--------------------");

		// 정렬 진행
		// -> 매개변수 목록에 key, value를 같이 보낸다.
		System.out.println(this.dao.memberList(key));
	}

	// 회원 정보 검색 메소드
	public void memberSearch(Scanner sc) {

		// 검색을 위한 서브메뉴 운영
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("3. 회원정보검색>");
			System.out.println("1. 회원번호기준  2. 이름기준  3. 전화번호기준  4. 이메일기준  5. 등록일기준  6. 부서번호기준");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("선택(1~6, 0 quit)?");
			int selectNo = sc.nextInt();
			sc.nextLine();

			switch (selectNo) {
			case 0: run = false; break;
			case 1:	this.memberSearch(sc, "회원번호"); break;
			case 2:	this.memberSearch(sc, "이름"); break;
			case 3:	this.memberSearch(sc, "전화번호"); break;
			case 4:	this.memberSearch(sc, "이메일"); break;
			case 5:	this.memberSearch(sc, "등록일"); break;
			case 6:	this.memberSearch(sc, "부서번호"); break;
			}
		}
	}

	private void memberSearch(Scanner sc, String key) {
		System.out.println("--------------------");
		System.out.printf("회원정보검색(%s)%n", key);
		System.out.println("--------------------");
		if (key.equals("부서번호")) {
			System.out.println(Dept.getList());
		}
		System.out.printf("%s: ", key);
		String value = sc.nextLine();

		// 검색 진행
		// -> 매개변수 목록에 key, value를 같이 보낸다.
		System.out.println(this.dao.memberSearch(key, value));
	}

	public void memberRemove(Scanner sc) {
		System.out.println("--------------------");
		System.out.printf("회원정보삭제%n");
		System.out.println("--------------------");
		System.out.printf("회원번호: ");
		String value = sc.nextLine();
		// 검색 진행
		// -> 매개변수 목록에 key, value를 같이 보낸다.
		String key = "회원번호";
		String result = this.dao.memberSearch(key, value);
		System.out.println(result);
		
		if (result.contains("검색 결과가 없습니다.")) {
			
		} else {
			System.out.printf("삭제할까요(y/n)?");
			String yn = sc.nextLine();
			if (yn.equalsIgnoreCase("y")) {
				Member m = new Member(value, "", "", "", "", "");
				this.dao.memberRemove(m);
				System.out.println("삭제되었습니다.");
			}
		}
		
	}

}
