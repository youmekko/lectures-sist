package com.test043;

public class MemberService {
	
	//login 메소드
	public boolean login(String id, String password) {
		boolean result = false;
		
		if (id.equals("hong") && password.equals("12345") ) {
			result = true;
		}
		
		return result;
	}
	
	//logout 메소드
	public void logout(String id) {
		System.out.printf("아이디 '%s'인 사용자가 로그아웃 되었습니다.%n", id);
	}

}
