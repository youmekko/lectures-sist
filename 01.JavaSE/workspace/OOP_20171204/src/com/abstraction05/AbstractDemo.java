package com.abstraction05;

/* File name : AbstractDemo.java */
public class AbstractDemo {

	public static void main(String[] args) {

		Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
		System.out.println("Call mailCheck using Salary reference --");
		s.mailCheck();

		//추상 클래스인 Employee 클래스의 생성자를 직접 호출하지는 못하고,
		//자식 객체를 통해서 간접 접근할 수 있다.
		//자식 객체를 부모 클래스 자료형에 저장 가능->다형성
		Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
		System.out.println("Call mailCheck using Employee reference--");
		e.mailCheck();

	}
}