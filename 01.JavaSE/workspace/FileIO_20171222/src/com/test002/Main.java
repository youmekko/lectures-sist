package com.test002;

import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException  {
		
		//File IO
		/*
		
		- File을 대상으로 입출력하는 액션
		- java.io 패키지 필요
		- 데이터가 연속된 상태로 존재하는 것을 스트림(Stream)이라고 한다. 스트림 상태의 데이터를 물리적으로 파일에 기록하거나, 파일의 정보를 읽어내서 스트림 상태로 만들 수 있다.
		- 스트림은 진행 방향에 따른 구분으로 InputStream, OutputStream이 존재한다.
		- 스트림을 처리하는 단위에 따른 구분으로 ByteStream(바이너리 파일 처리용), CharacterStream(텍스트 파일 처리용)이 존재한다.
		
		- 파일 + InputStream + Byte 단위 => FileInputStream 클래스 이용
		- 파일 + OutputStream + Byte 단위 => FileOutputStream 클래스 이용
		- 파일 + InputStream + Character 단위 => FileReader 클래스 이용
		- 파일 + OutputStream + Character 단위 => FileWriter 클래스 이용
		
		*/
		
		//Reader 클래스
		//-Reader 클래스는 문자 기반 입력 스트림의 최상위 클래스이다.
		//-하위 클래스로서 FileReader, InputStreamReader, BufferedReader 클래스가 존재한다.
		//-주요 메소드로 read(), close() 메소드가 있다.
	
		//read(char[] cbuf) 메소드
		//- 입력 스트림으로부터 주어진 문자 배열의 길이 만큼 읽고 배열을 반환.
		//- 배열에 채워지고 나면 읽은 문자수를 반환.
		
		//물리적인 파일을 메모리로 읽어 들이는 과정
		Reader reader = new FileReader("D:\\test.txt");
		
		//텍스트 파일을 문자 단위로 2byte씩 읽는 과정
		//->미리 준비한 문자 자료형 배열에 저장된다.
		int readData;
		char[] cbuf = new char[5];
		while((readData=reader.read(cbuf)) != -1) {
			
			//읽어낸 내용을 화면에 출력
			System.out.printf("읽은 문자수:%d%n", readData);
			System.out.printf("읽은 내용:%s%n",Arrays.toString(cbuf));
			
		}
		reader.close();

		
	}

}
