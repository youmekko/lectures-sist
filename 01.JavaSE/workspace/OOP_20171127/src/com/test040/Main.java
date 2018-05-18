package com.test040;

public class Main {

	public static void main(String[] args) {
		
		//Member 클래스의 객체 생성
		Member m = new Member();
		
		//객체에 자료 저장 -> 초기화 및 변경 가능
		m.setName("홍길동");
		m.setId("hong");
		m.setPassword("1234");
		m.setAge(20);
		
		//객체에 저장된 자료 출력
		System.out.printf("[%s, %s, %s, %d]%n"
				, m.getName(), m.getId(), m.getPassword(), m.getAge());
		
		//객체에 저장된 자료 출력
		System.out.println(m.memberInfo());

	}

}
