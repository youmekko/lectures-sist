package com.abstraction11;

public class Main {

	public static void main(String[] args) {
		
		//약한 결합 설정 테스트
		
		//Sample 객체에서 사용할 SubClass01 객체 생성 -> 한국 타이어 객체라고 가정
		//SubClass01 sub = new SubClass01();
		//Sample 객체에서 사용할 SubClass02 객체 생성 -> 금호 타이어 객체라고 가정 -> 현재는 사용 가능
		SubClass02 sub = new SubClass02();
		
		//생성자를 이용한 SubClass01 또는 SubClass02 객체 전달
		//주의) Super 인터페이스를 구현한 모든 자식 클래스를 객체로 전달 가능
		Sample obj = new Sample(sub); //->자동차 객체라고 가정
		
		//SubClass01 또는 SubClass02 객체 확인
		System.out.println(obj.getSub());
		
		//SubClass01 또는 SubClass02의 오버라이딩 메소드 호출 -> Sample 클래스의 메소드를 이용한 간접 호출
		obj.method();
		
		
	}

}
