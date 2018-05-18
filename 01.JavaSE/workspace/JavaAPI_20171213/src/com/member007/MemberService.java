package com.member007;

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
		
		
		//문제) 전화번호와 이메일에 대해서 정규표현식 검사를 진행하고, 
		//형식이 잘못된 경우 사용자 정의 예외 발생 처리.
		//전화번호는 "010-XXXX-XXXX" 형식을 갖춰야 한다.
		//이메일은 "문자열@도메인" 형식을 갖춰야 한다.
		//->private 메소드
		System.out.print("전화번호:");
		String phone = sc.next();
		System.out.print("이메일:");
		String email = sc.next();
		
		
		
		//문제) 등록일 입력시 올바른 날짜인지 검증하고, 잘못된 경우 사용자 정의 예외 발생 처리.
		//->private 메소드
		System.out.print("등록일(yyyy-MM-dd):");
		String regDate = sc.next();
		

		//문제) 회원 정보 입력 과정에서 동일 객체 발견시 예외가 발생되면 예외 처리 필요.
		
		//회원 정보 입력 메소드 호출
		this.dao.memberAdd(name, phone, email, regDate);
		//메시지 출력
		System.out.println("회원 정보 입력이 성공했습니다.");
		
	}
	
	// 회원 정보 출력 메소드
	public void memberList(Scanner sc) {

		//정렬 출력을 위한 서브메뉴 운영
		
		
	}

	// 회원 정보 검색 메소드
	// 메소드 오버로딩(Overloading)
	public void memberSearch(Scanner sc) {

		//검색을 위한 서브메뉴 운영
		boolean run = true;
		while (run) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("3. 회원 정보 검색 > ");
			System.out.println("1. 이름 기준  2. 전화번호 기준  3. 이메일 기준  4. 등록일 기준");
			System.out.println("--------------------------------------------------------------");
			System.out.print("선택(1~4, 0 quit)?");

			int selectNo = sc.nextInt();

			switch (selectNo) {
			case 0: run = false; break;
			case 1: this.memberSearch(sc, "이름");	break;
			case 2:	this.memberSearch(sc, "전화번호"); break;
			case 3: this.memberSearch(sc, "이메일"); break;
			case 4: this.memberSearch(sc, "등록일"); break;
			}

		}
		
	}
	
	// 회원 정보 검색 서브메뉴 메소드
	// key : 검색 기준. 예를 들어 '이름' 기준
	// value : 검색 대상. 예를 들어, '홍길동'
	// 메소드 오버로딩(Overloading)
	private void memberSearch(Scanner sc, String key) {
		System.out.println("---------------------------");
		System.out.printf("회원 정보 검색(%s 기준)%n", key);
		System.out.println("---------------------------");
		
		System.out.printf("%s:", key);
		String value = sc.next();
		
		//검색 진행 
		//-> 매개변수 목록에 key, value를 같이 보낸다.
		System.out.println(this.dao.memberSearch(key, value));
		
	}

}
