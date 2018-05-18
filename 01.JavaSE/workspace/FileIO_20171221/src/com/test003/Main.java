package com.test003;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
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
		
		//InputStream 클래스
		//-InputStream 클래스는 바이트 기반 입력 스트림의 최상위 클래스이다.
		//-하위 클래스로서 FileInputStream, BufferedInputStream, DataInputStream 클래스가 존재한다.
		//-주요 메소드로 read(), close() 메소드가 있다.
		
		
		//read(byte[] b) 메소드
		//- 입력 스트림으로부터 주어진 바이트 배열의 길이 만큼 읽고 배열을 반환.
		//- 입력 스트림으로부터 더 이상 읽을 바이트가 없는 경우 -1 반환.

		//InputStream 자료형의 변수 준비
		InputStream is = null;
		try {
			
			//물리적인 파일을 메모리로 읽어 들이는 과정
			is = new FileInputStream("C:\\test.jpg");
			
			//바이너리 파일을 배열의 길이 만큼씩 읽는 과정
			//물리적인 파일에서 특정 바이트만큼 읽어서 배열에 임시 저장
			byte[] readBytes = new byte[4];
			//읽은 바이트 수가 대신 저장된다.
			int readByte;
			while((readByte = is.read(readBytes)) != -1) {

				//읽어낸 내용을 화면에 출력
				//System.out.println(readByte); //읽은 바이트 수
				System.out.println(Arrays.toString(readBytes)); //배열에 저장된 내용
				
			}
		} catch (IOException  e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
