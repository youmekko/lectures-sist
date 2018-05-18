package com.abstraction05;

//자식 역할 클래스
//주의) 부모가 추상 클래스인 경우 추상 메소드에 대한 오버라이딩을 반드시 해야 한다.
public class Salary extends Employee {
	
	private double salary; // Annual salary

	public Salary(String name, String address, int number, double salary) {
		
		//추상 클래스인 Employee 클래스의 생성자를 간접 호출하는 과정
		super(name, address, number);
		
		setSalary(salary);
	}

	@Override
	public void mailCheck() {
		System.out.println("Within mailCheck of Salary class ");
		System.out.println("Mailing check to " + getName() + " with salary " + salary);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double newSalary) {
		if (newSalary >= 0.0) {
			salary = newSalary;
		}
	}

	public double computePay() {
		System.out.println("Computing salary pay for " + getName());
		return salary / 52;
	}
}