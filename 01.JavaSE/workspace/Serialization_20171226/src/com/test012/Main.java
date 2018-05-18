package com.test012;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//자바 소스 파일(.java)을 메모리로 읽어오는 과정에서 라인 번호 표시 추가
		//-> FileReader, BufferedReader 클래스 이용
		//-> BufferedReader 클래스의 readLine() 메소드 이용시 행 단위 문자열을 한꺼번에 읽을 수 있다.
		
		FileReader fr = new FileReader("D:\\Member.java");
		BufferedReader br = new BufferedReader(fr);

		int lineNum = 0;
		while(true) {
			String str =  br.readLine();
			if (str == null) break;
			System.out.printf("%d: %s%n", lineNum, str);
			++lineNum;
		}
		
		br.close();
		fr.close();

	}

}
