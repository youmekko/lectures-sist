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

}
