package com.test001;

public class ContainerExample {

	public static void main(String[] args) {
		
		//제네릭 클래스 Container에 대한 객체 생성 테스트
		//<String>, <Integer> 자료형 지원
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		System.out.println(container1.get()); //홍길동
		
		Container<Integer> container2 = new Container<Integer>();
		container2.set(100);
		System.out.println(container2.get()); //100

	}

}
