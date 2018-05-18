package com.test042;

public class MemberServiceExample {
	
	public static void main(String[] args) {
		
		MemberService memberService = new MemberService();
		
		//login 메소드 호출
		boolean result = memberService.login("hong", "12345");
		
		if (result) {
			System.out.println("로그인 되었습니다.");
			
			//logout 메소드 호출
			memberService.logout("hong");
			
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
		
	}

}
