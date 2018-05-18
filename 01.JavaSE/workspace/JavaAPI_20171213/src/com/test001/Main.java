package com.test001;

public class Main {

	public static void main(String[] args) {
		
		//Member 클래스의 오버라이딩 메소드 테스트
		Member m1 = new Member("hong");
		Member m2 = new Member("park");
		Member m3 = new Member("hong");
		
		//오버라이딩 전에는 참조주소 비교가 진행된다.
		//오버라이딩 후에는 값(id) 비교가 진행된다.
		System.out.println(m1.equals(m2)); //???
		System.out.println(m1.equals(m3)); //???
		
	}

}
