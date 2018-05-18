package com.member001;

import java.util.Scanner;

//(콘솔)서비스 관련 클래스
public class MemberService {
	
	//(배열)저장소 관련 클래스 객체 확보
	private MemberDAO dao = new MemberDAO();
	
	//회원 정보 입력 메소드
	public void memberAdd(Scanner sc) {
		
		//콘솔 입력
		System.out.println("--------------");
		System.out.println("회원 정보 입력");
		System.out.println("--------------");
		System.out.print("이름:");
		String name = sc.next();
		System.out.print("전화번호:");
		String phone = sc.next();
		System.out.print("이메일:");
		String email = sc.next();
		System.out.print("등록일(yyyy-MM-dd):");
		String regDate = sc.next();
		
		//회원 정보 입력 메소드 호출
		this.dao.memberAdd(name, phone, email, regDate);
		
		//메시지 출력
		System.out.println("회원 정보 입력이 성공했습니다.");
		
	}
	
	// 회원 정보 출력 메소드
	public void memberList(Scanner sc) {

		System.out.println("--------------");
		System.out.println("회원 정보 출력");
		System.out.println("--------------");

		System.out.println(this.dao.memberList());

	}

}
