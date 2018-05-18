package com.test044;

public class MemberService {
	
	//MemberDAO 클래스에 대한 객체 생성
	private MemberDAO dao = new MemberDAO();
	
	//login 메소드
	public boolean login(String id, String password) {
		boolean result = false;
		
		//MemberDAO 객체의 탐색 메소드 호출
		result = this.dao.memberSearch(id, password);
		
		return result;
	}
	
	//logout 메소드
	public void logout(String id) {
		System.out.printf("아이디 '%s'인 사용자가 로그아웃 되었습니다.%n", id);
	}

}
