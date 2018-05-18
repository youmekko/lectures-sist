package com.test010;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//자바 소스 파일(.java)을 메모리로 읽어오는 과정에서 라인 번호 표시 추가
		//-> FileReader 클래스 이용
		
		FileReader fr = new FileReader("D:\\Member.java");
		
		int readCharNo;
		char[] cbuf = new char[100];
		while((readCharNo = fr.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.println(data);
		}
		fr.close();

	}

}
