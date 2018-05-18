package com.test002;

import java.util.*;

public class MemberService {

	// (컬렉션) 저장소 객체 확보
	private MemberDAO dao = new MemberDAO();

	// 회원 정보 입력 메소드
	public void memberAdd(Scanner sc) {
		System.out.println("--------------");
		System.out.println("회원 정보 입력");
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
		System.out.println("회원 정보 출력");
		System.out.println("--------------");
		System.out.println(this.dao.memberList());
	}
	
	// 회원 정보 검색 메소드
	public void memberList(Scanner sc) {

		// 검색을 위한 서브메뉴 운영
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("3. 회원 정보 검색>");
			System.out.println("1. 이름 기준  2. 전화번호 기준  3. 이메일 기준  4. 등록일 기준  5. 부서번호 기준");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("선택(1~5, 0 quit)?");
			int selectNo = sc.nextInt();
			sc.nextLine();

			switch (selectNo) {
			case 0: run = false; break;
			case 1: this.memberList(sc, "이름"); break;
			case 2: this.memberList(sc, "전화번호"); break;
			case 3: this.memberList(sc, "이메일"); break;
			case 4: this.memberList(sc, "등록일"); break;
			case 5: this.memberList(sc, "부서번호"); break;
			}
		}
	}
	
	private void memberList(Scanner sc, String key) {
		System.out.println("--------------------");
		System.out.printf("회원 정보 검색(%s)%n", key);
		System.out.println("--------------------");
		if (key.equals("부서번호")) {
			System.out.println(Dept.getList());
		}
		System.out.printf("%s: ", key);
		String value = sc.nextLine();

		// 검색 진행
		// -> 매개변수 목록에 key, value를 같이 보낸다.
		System.out.println(this.dao.memberList(key, value));
	}

}
