package com.test011;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//자바 소스 파일(.java)을 메모리로 읽어오는 과정에서 라인 번호 표시 추가
		//-> FileReader 클래스 이용
		//-> Enter키에 대한 처리 필요
		
		FileReader fr = new FileReader("D:\\Member.java");
		
		int readCharNo;
		int lineNum = 0;
		System.out.printf("%d: ", lineNum);
		++lineNum;
		while((readCharNo = fr.read()) != -1) {

			if (readCharNo == 13) {
				fr.read();
				System.out.println();
				System.out.printf("%d: ", lineNum);
				++lineNum;
			} else {
				System.out.printf("%c", readCharNo);
			}
			
		}
		fr.close();

	}

}
