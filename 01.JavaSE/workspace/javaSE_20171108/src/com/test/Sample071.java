package com.test;

import java.io.IOException;

public class Sample071 {

	public static void main(String[] args) throws IOException {
		
		//키보드 입력 
		//키보드를 이용해서 문자 또는 문자열을 프로그램 내부로 읽어들일 수 있다.
		//System.in.read()는 문자(2byte) 단위 입력.
		//예외 처리 필요
		//주의) 실행시 문자 입력 대기 상태가 된다. 특정 문자 입력 후 Enter키. 
		
		System.out.println("메뉴선택?");
		int a = System.in.read();
		char b = (char)a;
		switch (b) {
		case '1':
			System.out.println("예금 조회를 선택하셨습니다.");
			break;
		case '2':
			System.out.println("예금 출금을 선택하셨습니다.");
			break;
		case '3':
			System.out.println("예금 입금을 선택하셨습니다.");
			break;
		case '4':
			System.out.println("프로그램 종료를 선택하셨습니다.");
			break;
		default:
			break;
		}

	}

}
