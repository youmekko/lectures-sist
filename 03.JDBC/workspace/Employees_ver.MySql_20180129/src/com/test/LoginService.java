package com.test;

import java.util.*;

//콘솔 액션 클래스
public class LoginService {
	
	private LoginDAO dao = new LoginDAO();
	
	//아이디, 패스워드 입력받고, 로그인 검증하는 메소드
	public Login login(Scanner sc) {
		Login result = null;
		
		//로그인 검증 절차 진행
		//성공하면 Login 객체 반환
		//실패하면 NULL 반환
		System.out.print("아이디:");
		String id_ = sc.nextLine();
		System.out.print("패스워드:");
		String pw_ = sc.nextLine();
		
		result = dao.login(new Login(id_, pw_));
		
		return result;
	}
	

}
