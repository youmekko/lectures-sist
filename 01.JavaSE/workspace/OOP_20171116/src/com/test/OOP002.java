package com.test;

public class OOP002 {

	public static void main(String[] args) {

		//프린터 객체 생성
		Printer p = new Printer();
		
		//프린터의 전원 상태 확인
		System.out.println(p.getPower()); //0(off)

		//프린터의 전원 상태 설정
		p.setPower(1);
		//프린터의 전원 상태 확인
		System.out.println(p.getPower()); //1(on)
		
		//scan() 메소드 호출
		String result = p.scan("스캔 이미지 원본");
		System.out.println(result);	
		
		//print(), copy() 메소드 호출 테스트
		
		//종이, 토너 준비
		p.setPaper(10);
		p.setToner(10);
		
		//프린트 요청
		String printResult = p.print("프린트 테스트", 5);
		System.out.println(printResult);

		//복사 요청
		String copyResult = p.copy("복사 테스트", 10);
		System.out.println(copyResult);

		//프린터의 전원 상태 설정
		p.setPower(0);
		//프린터의 전원 상태 확인
		System.out.println(p.getPower()); //0(off)
		
		
	}

}
