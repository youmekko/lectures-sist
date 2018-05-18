package com.polymorphism006;

public class SubClass {
	
	//다형성 구현 필드 구성
	//Number 클래스는 다양한 숫자 자료형(정수, 실수)의 부모 클래스
	private Number[] arr = new Number[5];
	//인덱스 관리용 변수
	private int idx;
	
	//다형성 구현 매개변수 구성
	public void add(Number n) {
		arr[idx] = n;
		++idx;
	}

	public String list() {
		StringBuilder sb = new StringBuilder();

		//[값1, 값2, ...]
		sb.append("[");
		for (int a=0; a<arr.length; ++a) {
			sb.append(String.format("%s", arr[a]));
			if (a < arr.length-1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}

}
