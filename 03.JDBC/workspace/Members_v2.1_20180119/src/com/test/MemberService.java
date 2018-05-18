package com.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//콘솔 액션 전용 클래스
public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	//회원 정보 출력 메소드
	public void memberList() {
		
		List<Member> list = dao.memberList();
		System.out.println("--------------");
		System.out.println("회원 정보 출력");
		System.out.println("--------------");
		System.out.printf("총: %d명%n", list.size());
		System.out.println("---------------------------------");
		for (Member m : list) {
			//콘솔 출력시 서식 지정 추가
			System.out.println(m);
		}
		
	}
	
	//부서 정보 출력 메소드
	private String deptList() {
		String result = "";
		
		Map<String, String> map = dao.deptList();
		result = map.toString();
		
		return result;
	}

	//회원 정보 입력 메소드
	public void memberAdd(Scanner sc) {

		System.out.println("--------------");
		System.out.println("회원 정보 입력");
		System.out.println("--------------");
		System.out.print("이름:");
		String name_ = sc.nextLine();
		System.out.print("전화번호:");
		String phone = sc.nextLine();
		System.out.print("이메일:");
		String email = sc.nextLine();
		System.out.print("등록일(YYYY-MM-DD):");
		String regDate = sc.nextLine();
		
		//부서 정보 출력
		System.out.println(deptList());
		
		System.out.print("부서번호:");
		String deptId = sc.nextLine();
		
		Member m = new Member(name_, phone, email, LocalDate.parse(regDate), deptId);
		dao.memberAdd(m);
		System.out.println("회원 정보 입력이 성공했습니다.");
		
	}
	
	
	//회원 정보 검색 메소드
	public void memberList(Scanner sc) {
		
		//검색 기준(서브메뉴)과 검색값을 콘솔에서 입력.
		
		boolean run = true;
		while (run) {
			System.out.println("------------------------");
			System.out.println("3.회원정보검색 서브메뉴");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("1.회원번호기준 2.이름기준 3.전화번호기준 4.이메일기준 5.등록일기준 6.부서명기준");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("선택(1~6, 0 quit)?");

			int m = sc.nextInt();
			sc.nextLine();

			switch (m) {
			case 0:	run = false; break;
			case 1:	this.memberList(sc, "mid"); break;
			case 2:	this.memberList(sc, "name_"); break;
			case 3:	this.memberList(sc, "phone"); break;
			case 4:	this.memberList(sc, "email"); break;
			case 5:	this.memberList(sc, "regDate"); break;
			case 6:	this.memberList(sc, "deptName"); break;
			}

		}

		
	}
	
	//회원 정보 검색 메소드
	private void memberList(Scanner sc, String key) {
		
		System.out.printf("%s:", key);
		String value = sc.nextLine();
		
		List<Member> list = dao.memberList(key, value);
		
		System.out.println("--------------");
		System.out.println("회원 정보 검색");
		System.out.println("--------------");
		System.out.printf("총: %d명%n", list.size());

		if (list.size() > 0) {
			//검색 결과가 존재하는 경우
			System.out.println("---------------------------------");
			for (Member m : list) {
				System.out.println(m);
			}
		} else {
			//검색 결과가 존재하지 않는 경우
			System.out.println("검색 결과가 없습니다.");
		}
	}

}
