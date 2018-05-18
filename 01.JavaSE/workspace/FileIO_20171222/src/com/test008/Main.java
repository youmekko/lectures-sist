package com.test008;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//Console IO
		//- 콘솔은 시스템을 사용하기 위해 키보드로 입력 받고, 화면에 출력하는 소프트웨어이다.
		//- System.in, System.out 정적 필드 사용
		
		//System.out
		//-프로그램에서 콘솔로 데이터를 출력 할 수 있도록 System 클래스에서 제공하는 정적 필드.
		//-PrintStream 자료형. OutputStream 클래스의 하위 클래스.
		//-write() 메소드 지원
		
		OutputStream os = System.out;
		int[] array = {65, 66, 67, 68, 69, 13, 10};
		for (int i=0; i<array.length; ++i) {
			os.write(array[i]);
		}
		System.out.println("줄바꿈 문자 확인.");
		os.close();
		
	}

}
