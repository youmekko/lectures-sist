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
		int result = dao.memberAdd(m);
		if (result > 0) {
			System.out.println("회원 정보 입력이 성공했습니다.");
		} else {
			System.out.println("회원 정보 입력이 실패했습니다.");
		}
		
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

	public void memberFee(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("------------------------");
			System.out.println("4.회원별회비관리 서브메뉴");
			System.out.println("--------------------------------------------------------");
			System.out.println("1.회원별회비납부 2.회원별회비출력 3.전체회원회비총액출력");
			System.out.println("--------------------------------------------------------");
			System.out.print("선택(1~3, 0 quit)?");

			int m = sc.nextInt();
			sc.nextLine();

			switch (m) {
			case 0:	run = false; break;
			case 1:	this.memberFeeSub01(sc); break;
			case 2:	this.memberFeeSub02(sc); break;
			case 3:	this.memberFeeSub03(sc); break;
			}

		}
	}
	
	private void memberFeeSub01(Scanner sc) {
		System.out.print("검색할 전화번호?");
		String phone = sc.nextLine();
		
		List<Member> list = dao.memberList("phone", phone);
		
		if (list.size() > 0) {
			//검색 결과가 존재하는 경우
			System.out.println("---------------------------------");
			for (Member m : list) {
				System.out.println(m);
			}

			this.memberFeeAdd(sc);

		} else {
			//검색 결과가 존재하지 않는 경우
			System.out.println("검색 결과가 없습니다.");
		}

		
	}
	
	private void memberFeeAdd(Scanner sc) {
		
		System.out.println("-----------------------------------");
		System.out.print("회원번호?");
		String mid = sc.nextLine();
		System.out.print("회비금액?");
		int fee = sc.nextInt();
		sc.nextLine();
		System.out.print("회비납부일?");
		String feeDate = sc.nextLine();
		
		Member m = new Member(mid, LocalDate.parse(feeDate), fee);
		int result = dao.memberFeeAdd(m);
		if (result > 0) {
			System.out.println("회비 정보 입력이 성공했습니다.");
		} else {
			System.out.println("회비 정보 입력이 실패했습니다.");
		}
				
	}

	private void memberFeeSub02(Scanner sc) {
		System.out.print("검색할 전화번호?");
		String phone = sc.nextLine();
		
		List<Member> list = dao.memberList("phone", phone);
		
		if (list.size() > 0) {
			//검색 결과가 존재하는 경우
			System.out.println("---------------------------------");
			for (Member m : list) {
				System.out.println(m);
			}

			this.memberFeeList(sc);
			
			
		} else {
			//검색 결과가 존재하지 않는 경우
			System.out.println("검색 결과가 없습니다.");
		}
		
	}
	
	private void memberFeeList(Scanner sc) {
		
		System.out.println("-----------------------------------");
		System.out.print("회원번호?");
		String mid = sc.nextLine();
		
		List<Member> list = dao.memberList("mid", mid);
		
		System.out.println("---------------------------------");
		for (Member m : list) {
			System.out.println(m);
		}
		System.out.println("---------------------------------");
		
		int feeTotal = dao.memberFeeTotal("mid", mid);
		List<Member> feeList = dao.memberFeeList(mid);
		System.out.printf("총: %d건%n", list.size());

		if (feeList.size() > 0) {
			//검색 결과가 존재하는 경우
			System.out.println("---------------------------------");
			for (Member m : feeList) {
				System.out.printf("%s %s%n", m.getFeeDate(), m.getFee());
			}
			System.out.println("--------------------");
			System.out.printf("총액 : %d원%n", feeTotal);
			
		} else {
			//검색 결과가 존재하지 않는 경우
			System.out.println("검색 결과가 없습니다.");
		}

				
	}

	private void memberFeeSub03(Scanner sc) {
		
		int feeTotal = dao.memberFeeTotal("all", "");
		List<Member> list = dao.memberList();
		System.out.println("--------------");
		System.out.printf("총: %d명%n", list.size());
		System.out.println("---------------------------------");
		for (Member m : list) {
			//콘솔 출력시 서식 지정 추가
			System.out.println(m);
		}
		System.out.println("-----------------------");
		System.out.printf("총액 : %d원%n", feeTotal);
		
	}
}
