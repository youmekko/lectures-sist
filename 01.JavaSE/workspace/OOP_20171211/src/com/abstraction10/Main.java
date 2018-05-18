package com.abstraction10;

public class Main {

	public static void main(String[] args) {
		
		//강한 결합 설정 테스트
		
		//Sample 객체에서 사용할 SubClass01 객체 생성 -> 한국 타이어 객체라고 가정
		SubClass01 sub = new SubClass01();
		//Sample 객체에서 사용할 SubClass02 객체 생성 -> 금호 타이어 객체라고 가정 -> 현재는 사용 불가
		//SubClass02 sub = new SubClass02();
		
		//생성자를 이용한 SubClass01 객체 전달
		Sample obj = new Sample(sub); //->자동차 객체라고 가정
		
		//SubClass01 객체 확인
		System.out.println(obj.getSub());
		
		//SubClass01 메소드 호출 -> Sample 클래스의 메소드를 이용한 간접 호출
		obj.method();
		
		
	}

}
