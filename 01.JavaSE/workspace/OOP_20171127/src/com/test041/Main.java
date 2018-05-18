package com.test041;

public class Main {

	public static void main(String[] args) {
		
		//Member 클래스의 객체 생성 및 자료 저장 -> 초기화 전용
		Member m = new Member("홍길동", "hong", "1234", 20);
		
		//객체에 저장된 자료 출력
		System.out.printf("[%s, %s, %s, %d]%n"
				, m.getName(), m.getId(), m.getPassword(), m.getAge());
		
		//객체에 저장된 자료 출력
		System.out.println(m.memberInfo());

	}

}
