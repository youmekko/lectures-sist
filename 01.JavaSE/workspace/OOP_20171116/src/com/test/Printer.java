package com.test;

//프린터에 대한 객체 분석 및 클래스 표현
public class Printer {
	
	//프린터에 대한 객체 분석
	//state - power(전원), paper(종이), toner(토너)
	//behavior - print(인쇄), copy(복사), scan(스캔)
	//-> fields, methods로 표현

	//field 선언
	//객체의 상태 정보 저장
	//power 자동 초기화 지원 -> 0(off)
	//paper, toner 자동 초기화 지원 -> 0
	private int power;
	private int paper;
	private int toner;
	
	//getter, setter 메소드
	//field에 대한 상태값 확인, 변경하는 역할
	public int getPower() {
		return this.power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getPaper() {
		return this.paper;
	}
	public void setPaper(int paper) {
		this.paper = paper;
	}
	
	public int getToner() {
		return this.toner;
	}
	public void setToner(int toner) {
		this.toner = toner;
	}
	
	//scan 특성에 대한 메소드 선언
	public String scan(String target) {
		String result = null;
		
		//스캔 특성을 실행할 수 있는 조건 추가
		//->전원 on 상태 확인
		if (this.power == 1) {
			System.out.println("target에 대한 스캔 작업.");
			result = String.format("target(\'%s\')에 대한 사본 이미지%n", target);
		}
		
		//메소드 액션에 대한 결과 반환
		return result;
		
	}
	
	
	//문제) print(), copy() 메소드 선언 및 액션 구현
	
	//print 특성에 대한 메소드 선언
	public String print(String target, int count) {
		String result = null;
		
		//인쇄 특성을 실행할 수 있는 조건 추가
		//->전원 on 상태, 종이 상태, 토너 상태 확인
		if (this.power == 1) {
			if (this.paper > 0 && this.toner > 0) {
				System.out.println("target에 대한 인쇄 작업.");
				
				//요청한 출력 매수만큼의 반복작업
				result = "";
				for (int a=1; a <= count; ++a) {
					result += String.format("target(\'%s\')에 대한 인쇄 결과(%d)%n", target, a);

					//종이, 토너 상태에 대한 변경
					--this.paper;
					--this.toner;
					if(this.paper <= 0 && this.toner <= 0) {
						result += "종이 또는 토너 부족.\n";
						break;
					}
					
				}
				
			} else {
				result = "종이 또는 토너 부족.\n";
			}
		}
		
		//메소드 액션에 대한 결과 반환
		return result;
		
	}
	
	//copy 특성에 대한 메소드 선언
	public String copy(String target, int count) {
		String result = null;
		
		//복사 특성을 실행할 수 있는 조건 추가
		//->전원 on 상태, 종이 상태, 토너 상태 확인
		if (this.power == 1) {
			if (this.paper > 0 && this.toner > 0) {
				System.out.println("target에 대한 복사 작업.");
				
				//요청한 복사 매수만큼의 반복작업
				result = "";
				for (int a=1; a <= count; ++a) {
					result += String.format("target(\'%s\')에 대한 복사 결과(%d)%n", target, a);

					//종이, 토너 상태에 대한 변경
					--this.paper;
					--this.toner;
					if(this.paper <= 0 && this.toner <= 0) {
						result += "종이 또는 토너 부족.";
						break;
					}
					
				}
				
			} else {
				result = "종이 또는 토너 부족.";
			}
		}
		
		//메소드 액션에 대한 결과 반환
		return result;
		
	}
	
}
