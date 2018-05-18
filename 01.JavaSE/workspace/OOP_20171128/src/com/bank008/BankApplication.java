package com.bank008;

import java.util.*;

//메인메뉴 액션 클래스
public class BankApplication {

	public static void main(String[] args) {

		//local variable
		Scanner sc = new Scanner(System.in);
		AccountService service = new AccountService();

		//화면(메뉴) 액션
		boolean run = true;
		while(run) {
			
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 2.계좌목록 3.예금 4.출금 5.종료.");
			System.out.println("-------------------------------------------");
			System.out.print("선택>");
			
			int selectNo = sc.nextInt();
			
			//메뉴 액션 
			//-> switch 구문으로 대체 
			//-> 주의) case 구문에 실행문을 한 문장 이상 넣는 것은 권장하지 않는다. 실행문이 많은 경우 메소드 호출로 대체.
			switch (selectNo) {
			case 1:
				//AccountService 클래스의 createAccount() 인스턴스 메소드 호출
				//->시그니처 분석
				//->public void createAccount(Scanner sc)
				service.createAccount(sc);
				break;
			case 2: break;
			case 3:	break;
			case 4:	break;
			case 5:	run = false; break;
			}
			
		}
		
		//자바 내부 자원이 아닌 외부 자원(운영체제) 사용시 close() 메소드 호출
		sc.close();
		System.out.println("프로그램 종료.");
		
	}
	


}
