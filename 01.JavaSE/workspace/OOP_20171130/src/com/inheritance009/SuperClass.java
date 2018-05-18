package com.inheritance009;

public class SuperClass {

	//java.lang.Object 클래스의 toString() 메소드에 대한 오버라이딩 구현
	//이클립스 - Source>Override/Implement Methods...
	//-> 부모 메소드의 시그니처를 잘 모를때 유용.
	@Override
	public String toString() {

		//메소드 오버라이딩
		//메소드 시그니처는 원본 그대로 사용
		//메소드 내용은 사용자가 임의로 수정 가능
		return "SuperClass의 toString()";
	
	}

}
