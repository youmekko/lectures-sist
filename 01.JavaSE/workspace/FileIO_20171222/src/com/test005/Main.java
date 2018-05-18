package com.test005;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//Console IO
		//- 콘솔은 시스템을 사용하기 위해 키보드로 입력 받고, 화면에 출력하는 소프트웨어이다.
		//- System.in, System.out 정적 필드 사용
		
		//System.in
		//-프로그램이 콘솔로부터 데이터를 입력받을 수 있도록 System 클래스에서 제공하는 정적 필드.
		//-InputStream 자료형
		//-read() 메소드 지원
		//-예를 들어, a키를 입력하고, Enter키를 치는 경우, a의 97과, Enter의 13, 10 숫자가 전달된다.
		
		InputStream is = System.in;

		for (int i=0; i<6; ++i) {
			System.out.printf("문자(%d):", (i+1));
			int temp = is.read();
			System.out.println(temp); //출력시 입력한 문자 외에 Enter키 값(13, 10)도 출력된다.
		}
		
		is.close();
		
	}

}
