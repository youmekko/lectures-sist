package com.test007;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//Console IO
		//- 콘솔은 시스템을 사용하기 위해 키보드로 입력 받고, 화면에 출력하는 소프트웨어이다.
		//- System.in, System.out 정적 필드 사용
		
		//Scanner 클래스
		//- 자바5 이후
		//- System.in 필드의 정보를 가지고 콘솔에서 문자, 기본 자료형 등의 값을 직접 입력 처리할 수 있는 클래스.
		//- next(), nextInt(), nextLine() 메소드
		//- nextLine() 메소드 외에 나머지 메소드는 줄바꿈 문자 처리 필요.
		
		Scanner sc = new Scanner(System.in);

		for (int i=0; i<6; ++i) {
			System.out.printf("문자열(%d):", (i+1));
			//공백을 포함한 문자열 입력시 문자열 전체가 하나의 문자열(문장 단위)로 입력된다.
			String temp = sc.nextLine(); 
			System.out.println(temp);
		}
		
		sc.close();
		
	}

}
