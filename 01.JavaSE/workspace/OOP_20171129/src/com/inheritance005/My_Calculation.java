package com.inheritance005;

class Calculation {
	int z;

	public void addition(int x, int y) {
		z = x + y;
		System.out.println("The sum of the given numbers:" + z);
	}

	public void subtraction(int x, int y) {
		z = x - y;
		System.out.println("The difference between the given numbers:" + z);
	}
}

public class My_Calculation extends Calculation {
	
	public void multiplication(int x, int y) {
		z = x * y;
		System.out.println("The product of the given numbers:" + z);
	}

	public static void main(String args[]) {
		int a = 20, b = 10;
		
		//new My_Calculation()
		//객체 생성 과정은 자식 클래스만 있지만
		//상속 관계에 있는 부모 클래스의 객체도 자동 생성된다.
		
		My_Calculation demo = new My_Calculation();
		demo.addition(a, b);
		demo.subtraction(a, b);
		demo.multiplication(a, b);
	}
}