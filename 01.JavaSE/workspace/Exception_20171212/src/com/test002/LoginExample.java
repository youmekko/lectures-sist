package com.test002;

public class LoginExample {

	public static void main(String[] args) {
		
		//Chapter10 확인문제7
		
		try {
			login("white", "12345");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	//예외 발생시 예외 객체를 메소드 호출 지점으로 내보내기 -> throws 키워드 사용
	public static void login(String id, String password) throws NotExistIDException, WrongPasswordException  {
		
		//id가 "blue"가 아니라면 NotExistIDException 발생시킴
		if (!id.equals("blue")) {
			//예외 발생 구문 추가 -> throw 키워드 사용
			throw new NotExistIDException("아이디가 존재하지 않습니다.");
		}
		
		//password가 "12345"가 아니라면 WrongPasswordException 발생시킴
		if (!password.equals("12345")) {
			//예외 발생 구문 추가 -> throw 키워드 사용
			throw new WrongPasswordException("패스워드가 틀립니다.");
		}

	}

}
