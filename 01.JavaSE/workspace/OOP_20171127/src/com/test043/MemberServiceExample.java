package com.test043;

public class MemberServiceExample {
	
	public static void main(String[] args) {
		
		MemberService memberService = new MemberService();
		
		String id = "hong";
		String password = "12345";
		
		//login 메소드 호출
		boolean result = memberService.login(id, password);
		
		if (result) {
			System.out.printf("아이디 '%s'인 사용자로 로그인 되었습니다.%n", id);
			
			//logout 메소드 호출
			memberService.logout(id);
			
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
		
	}

}
