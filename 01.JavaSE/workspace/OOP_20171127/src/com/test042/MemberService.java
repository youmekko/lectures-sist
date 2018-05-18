package com.test042;

public class MemberService {
	
	//chapter6. 확인문제15.

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
		System.out.println("로그아웃 되었습니다.");
	}

}
