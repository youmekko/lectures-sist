package com.polymorphism010;

//부모 역할 클래스
//Object 클래스 상속
public class Employee {

	//필드 구성
	private String name;
	private String address;
	private int number;

	//기본 생성자 추가
	//->객체 생성시 한 번만 호출 가능
	public Employee() {
		//instance 필드 초기화
	}
	
	//매개변수 목록이 있는 생성자
	//->외부에서 전달된 자료를 가지고 instance 필드 초기화
	//->객체 생성시 한 번만 호출 가능
	public Employee(String name, String address, int number) {
		System.out.println("Constructing an Employee");
		//this 키워드는 instance 멤버에만 사용 가능
		this.name = name;
		this.address = address;
		this.number = number;
	}

	//메소드
	public void mailCheck() {
		System.out.println("Mailing a check to " + this.name + " " + this.address);
	}

	//오버라이딩 메소드
	//->부모 메소드의 기능을 재정의
	@Override
	public String toString() {
		return name + " " + address + " " + number;
	}

	//getter -> read-only
	public String getName() {
		return name;
	}

	//getter
	public String getAddress() {
		return address;
	}

	//setter -> 초기화 이후 수정 가능
	public void setAddress(String newAddress) {
		address = newAddress;
	}

	//getter -> read-only
	public int getNumber() {
		return number;
	}
}
