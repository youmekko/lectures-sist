package com.polymorphism010;

/* File name : VirtualDemo.java */
public class VirtualDemo {

	public static void main(String[] args) {
		
		Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
		System.out.println("Call mailCheck using Salary reference --");
		s.mailCheck();

		System.out.println("----------------------------");
		//Salary 클래스의 객체를 Employee 클래스 자료형 변수에 저장
		//->다형성 구현
		Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
		System.out.println("Call mailCheck using Employee reference--");
		//mailCheck() 메소드는 
		//원래 Employee 클래스의 메소드가 호출되어야 하지만
		//오버라이딩 상태이므로 Salary 클래스의 메소드가 호출된다.
		e.mailCheck();
		
	}
	
}