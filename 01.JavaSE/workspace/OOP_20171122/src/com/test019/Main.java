package com.test019;

public class Main {

	public static void main(String[] args) {
		
		
		//홍길동 정보 저장용 Member 클래스 객체(instance) 생성
		Member m1 = new Member();
		//홍길동 개인정보 저장 -> setter 메소드 호출
		m1.setName("홍길동");
		m1.setId("hong");
		m1.setPassword("1234");
		m1.setAge(20);
		
		//박길동 정보 저장용 Member 클래스 객체(instance) 생성
		Member m2 = new Member();
		m2.setName("박길동");
		m2.setId("park");
		m2.setPassword("abcd");
		m2.setAge(30);
		

		//출력시 참조형 변수를 지정하면 toString() 메소드 자동 호출
		//객체(instance)의 정보 ->  클래스이름@해쉬코드
		System.out.println(m1); 
		System.out.println(m2);
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		
		//박길동의 개인정보 항목별 출력 -> getter 메소드 호출
		System.out.println(m2.getName());
		System.out.println(m2.getId());
		System.out.println(m2.getPassword());
		System.out.println(m2.getAge());
		
		//박길동의 개인정보 전체 출력 -> 전용 메소드 or toString() 오버라이딩 메소드 호출
		System.out.println(m2.memberInfo());
		

	}

}
