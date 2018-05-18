package com.bank006;

import java.util.*;

public class BankApplication {

	//(배열) 저장소 준비
	private static Account[] accountArray = new Account[5];
	//인덱스 관리용 전용 변수 준비
	private static int idx;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		//화면(메뉴) 액션
		boolean run = true;
		while(run) {
			
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 2.계좌목록 3.예금 4.출금 5.종료.");
			System.out.println("-------------------------------------------");
			System.out.print("선택>");
			
			int selectNo = sc.nextInt();
			
			//메뉴 액션
			if (selectNo == 1) {
				createAccount(sc);
			} else if (selectNo == 2) {
				accountList(sc);
			} else if (selectNo == 3) {
				deposit(sc);
			} else if (selectNo == 4) {
				withdraw(sc);
			} else if (selectNo == 5) {
				run = false;
			}
			
		}
		
		sc.close();
		System.out.println("프로그램 종료.");
		
	}
	
	//계좌생성하기 메소드
	private static void createAccount(Scanner sc) {
		
		//외부 입력->계좌번호, 계좌주, 초기입금액
		//계좌 생성(Account 객체 생성) 및 (배열)저장소에 저장
		//메시지 출력
		
		//next() - 한 단어 단위 입력. 공백 기준으로 단어 구분. nextLine() 메소드와 혼용시 줄바꿈 문자 처리 필요.
		//nextLine() - 한 문장 단위 입력. 
		
		System.out.println("------------");
		System.out.println("계좌 생성");
		System.out.println("------------");
		System.out.print("계좌번호:");
		String ano = sc.next();
		System.out.print("계좌주:");
		String owner = sc.next();
		System.out.print("초기입금액:");
		int balance = sc.nextInt();

		//계좌 객체 생성 및 (배열)저장소 저장
		Account ac = new Account(ano, owner, balance);
		accountArray[idx] = ac;
		++idx;
		
		System.out.println("결과:계좌가 생성되었습니다.");
	}
	
	//문제)
	//계좌목록보기 메소드
	private static void accountList(Scanner sc) {
		System.out.println("-----------");
		System.out.println("계좌목록");
		System.out.println("-----------");
		//(배열)저장소의 전체 계좌 객체 정보 탐색
		for (Account temp : accountArray) {
			//NullPointerException 주의
			if (temp == null) continue;
			System.out.printf("%5s %5s %5d %n", temp.getAno(), temp.getOwner(), temp.getBalance());
		}
	}
	 
	//문제)
	//예금하기 메소드
	private static void deposit(Scanner sc) {
		System.out.println("-----------");
		System.out.println("예금");
		System.out.println("-----------");
		System.out.print("계좌번호 : ");
		String ano = sc.next();
		System.out.print("예금액 : ");
		int balance = sc.nextInt();

		//특정 계좌 객체 탐색 및 참조주소 반환
		Account temp = findAccount(ano);
		
		//특정 계좌 객체의 잔고 변경
		temp.setBalance(temp.getBalance() + balance);

		System.out.println("결과:예금이 성공되었습니다.");

	}

	//문제)
	//출금하기 메소드
	private static void withdraw(Scanner sc) {
		System.out.println("-----------");
		System.out.println("출금");
		System.out.println("-----------");
		System.out.print("계좌번호 : ");
		String ano = sc.next();
		System.out.print("출금액 : ");
		int balance = sc.nextInt();

		//특정 계좌 객체 탐색 및 참조주소 반환
		Account temp = findAccount(ano);

		//특정 계좌 객체의 잔고 변경
		temp.setBalance(temp.getBalance() - balance);

		System.out.println("결과:출금이 성공되었습니다.");
	}
	
	
	//문제)
	//Account 배열에서 ano와 동일한 Account 객체 찾기 메소드
	private static Account findAccount(String ano) {
		Account account = null;
		
		//특정 계좌 객체를 탐색하는 반복문 
		for (Account temp : accountArray) {
			//NullPointerException 주의
			if (temp == null) continue;
			//계좌번호가 일치하는 계좌 객체 탐색한 경우 계좌객체의 참조주소 반환 준비
			if (temp.getAno().equals(ano)) {
				account = temp;
			}
		}
		//계좌번호가 일치하는 계좌객체의 참조주소 반환
		return account;
	}

}
