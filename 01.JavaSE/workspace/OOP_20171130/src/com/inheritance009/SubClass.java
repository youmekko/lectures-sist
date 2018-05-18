package com.inheritance009;

public class SubClass extends SuperClass {


	//SuperClass 클래스의 toString() 메소드에 대한 오버라이딩 구현
	//이클립스 - Source>Override/Implement Methods...
	//-> 부모 메소드의 시그니처를 잘 모를때 유용.
	@Override
	public String toString() {
		
		return "SubClass의 toString()";
		
	}

	
}
