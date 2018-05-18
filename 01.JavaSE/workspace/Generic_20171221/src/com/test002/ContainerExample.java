package com.test002;

public class ContainerExample {

	public static void main(String[] args) {
		
		//제네릭 클래스 Container에 대한 객체 생성 테스트
		//<String, String>, <String, Integer> 자료형 지원
		Container<String, String> container1 = new Container<String, String>();
		container1.set("홍길동", "도적");
		System.out.println(container1.getKey()); //홍길동
		System.out.println(container1.getValue()); //도적
		
		Container<String, Integer> container2 = new Container<String, Integer>();
		container2.set("홍길동",35);
		System.out.println(container2.getKey()); //홍길동
		System.out.println(container2.getValue()); //35

	}

}
