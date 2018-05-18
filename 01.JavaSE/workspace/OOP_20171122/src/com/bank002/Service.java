package com.bank002;

//액션 전용 클래스
public class Service {
	
	//액션 단위로 메소드 구성
	//->입력, 출력, 처리 등을 독립적인 메소드로 구성
	//->공통 자료 -> 필드로 구성
	
	//계좌 객체 저장용 저장소(배열) 준비. 기본 크기는 5.
	private Account[] accountArray = new Account[5];

	//계좌 정보 생성
	//instance 메소드
	public void accountAdd() {
		//계좌 객체 생성 -> 홍길동 계좌 객체, 박길동 계좌 객체
		Account a1 = new Account();
		a1.setAccountNumber("111-111");
		a1.setAccountName("홍길동");
		a1.setBalance(10000);

		Account a2 = new Account();
		a2.setAccountNumber("111-112");
		a2.setAccountName("박길동");
		a2.setBalance(20000);
		  
		//계좌 객체를 저장소에 저장
		this.accountArray[0] = a1;
		this.accountArray[1] = a2;		
	}
	
	//계좌 정보 출력
	//instance 메소드
	public void accountList() {
		
		//전체 계좌 명단 출력
		//->계좌번호, 계좌주, 잔고
		//->출력시 NullPointerException 주의
		/*
		
		-----------
		계좌 목록
		-----------
		111-111 홍길동   10000
		111-222 박최길동 20000
		
		*/
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		for (Account temp : this.accountArray) {
			if (temp == null) continue;
			System.out.println(temp.accountInfo());
		}
		
	}

}
