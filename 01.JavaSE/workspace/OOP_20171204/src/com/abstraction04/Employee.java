package com.abstraction04;

//추상 클래스 -> new 연산자에 의한 객체 직접 생성 불가 -> 부모 역할만 가능
public abstract class Employee {
	
	//필드
	//1. instance 필드
	//2. static 필드 - static 키워드
	//3. final 필드 - final 키워드
	//4. static final 필드 - 상수(Constant). static final 키워드. 대문자로 표기.
	
	//instance 필드 구성 - 자동 초기화, 명시적 초기화, 생성자에 의한 초기화
	private String name;
	private String address;
	private int number;

	//기본생성자 -> 직접 호출 불가. 자식 객체를 통해서 호출 가능. super 키워드.
	public Employee() {
		System.out.println("Constructing an Employee");
	}

	//매개변수 목록 있는 생성자 -> 직접 호출 불가. 자식 객체를 통해서 호출 가능. super 키워드.
	public Employee(String name, String address, int number) {
		System.out.println("Constructing an Employee");
		//외부에서 제공된 자료를 가지고 필드 초기화
		this.name = name;
		this.address = address;
		this.number = number;
	}

	public double computePay() {
		System.out.println("Inside Employee computePay");
		return 0.0;
	}

	public void mailCheck() {
		System.out.println("Mailing a check to " + this.name + " " + this.address);
	}

	//Object 클래스의 toString() 메소드에 대한 오버라이딩
	@Override
	public String toString() {
		return name + " " + address + " " + number;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String newAddress) {
		address = newAddress;
	}

	public int getNumber() {
		return number;
	}
}
