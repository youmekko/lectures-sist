package com.bank003;

//실행 클래스
public class Main {

	public static void main(String[] args) {
		
		//Service 클래스의 특정 instance 메소드 호출을 이용해서 액션 실행.
		//-> 객체 생성
		//-> new 연산자
		Service s = new Service();
			  
		//계좌 객체 생성 -> accountAdd() 호출
		s.accountAdd();
		
		//계좌 정보 출력 -> accountList() 호출
		s.accountList();
		

	}

}
