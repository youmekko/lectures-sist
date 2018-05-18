package com.bank005;

public class Main {

	public static void main(String[] args) {
	
		//계좌 객체 저장용 저장소(배열) 준비. 기본 크기는 5.
		Account[] accountArray = new Account[5];
		
		//계좌 객체 생성 
		//-> 홍길동 계좌 객체, 박길동 계좌 객체
		//-> 매개변수 목록 있는 생성자 호출
		/*
		 
		 --------- 
		 계좌 생성 
		 --------- 
		 계좌번호: 111-111 
		 계좌주: 홍길동 
		 초기입금액: 10000
		  
		*/		
		Account a1 = new Account("111-111", "홍길동", 10000);
		Account a2 = new Account("111-222", "박길동", 20000);

		//balance 항목에 -10 지정
		Account a3 = new Account("111-333", "최길동", -10);
		
		//계좌 객체를 저장소에 저장
		accountArray[0] = a1;
		accountArray[1] = a2;	
		accountArray[2] = a3;	
		
		//-------------------------
		//문제)
		//입금(예금) 액션 추가
		//-> 홍길동 계좌 객체에 대해서 입금(예금) 액션 진행
		//-> setter 메소드 호출
		/*
		 
		 --------- 
		 예금
		 --------- 
		 계좌번호: 111-111 
		 예금액: 10000
		 결과: 예금이 성공되었습니다. 
		  
		*/	
		
		
		//-------------------------
		//문제)
		//출금 액션 추가
		//-> 박길동 계좌 객체에 대해서 출금 액션 진행
		//-> setter 메소드 호출
		/*
		 
		 --------- 
		 출금
		 --------- 
		 계좌번호: 111-222 
		 출금액: 2000
		 결과: 출금이 성공되었습니다. 
		  
		*/	
		
		
		//전체 계좌 명단 출력
		//->계좌번호, 계좌주, 잔고
		//->출력시 NullPointerException 주의
		/*
		
		-----------
		계좌 목록
		-----------
		111-111 홍길동  20000
		111-222 박길동  18000
		111-333 최길동      0
		
		*/
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		for (Account temp : accountArray) {
			if (temp == null) continue;
			System.out.println(temp.accountInfo());
		}	

	}

}
