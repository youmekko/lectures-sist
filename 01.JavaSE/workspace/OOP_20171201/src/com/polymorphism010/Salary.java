package com.polymorphism010;

//자식 역할 클래스
public class Salary extends Employee {
	
	//Employee 클래스의 멤버( public, protected 접근제한자를 가진 모든 메소드 )를 상속 받은 상태

	//필드 구성
	private double salary; // Annual salary

	//기본 생성자 추가
	public Salary() {
	}
	
	//매개변수 목록이 있는 생성자
	public Salary(String name, String address, int number, double salary) {
		
		//부모 클래스의 생성자 호출
		//name, address, number는 부모만 가진 전용 필드 -> 자식 입장에서 초기화 불가
		super(name, address, number);
		
		//생성자 내부에서 instance 메소드 호출 가능
		//salary 변수에 대한 초기화
		this.setSalary(salary);
		//this.salary = salary; //검사 과정 진행하지 않는다.
		
	}

	//오버라이딩 메소드
	//Employee 클래스의 mailCheck() 메소드를 자식 클래스에서 오버라이딩
	@Override
	public void mailCheck() {
		System.out.println("Within mailCheck of Salary class ");
		//getName()은 부모 클래스로부터 상속받은 메소드
		System.out.println("Mailing check to " + getName() + " with salary " + salary);
	}

	//getter
	public double getSalary() {
		return salary;
	}

	//setter
	public void setSalary(double newSalary) {
		//외부에서 전달된 값에 대한 검사 과정
		if (newSalary >= 0.0) {
			salary = newSalary;
		}
	}

	//Salary 클래스의 전용 메소드
	public double computePay() {
		//getName()은 부모 클래스로부터 상속받은 메소드
		System.out.println("Computing salary pay for " + getName());
		return salary / 52.0;
	}
	
}