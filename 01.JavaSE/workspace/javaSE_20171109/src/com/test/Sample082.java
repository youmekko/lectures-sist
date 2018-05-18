package com.test;

public class Sample082 {

	public static void main(String[] args) {
		
		//String 클래스의 charAt() 메소드
		String ssn = "010624-1230123";
		
		char ss = ssn.charAt(7);
		
		switch (ss) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		default:
			break;
		}

	}

}
