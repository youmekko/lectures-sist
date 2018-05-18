package com.test010;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		//File 클래스
		//- 시스템의 파일, 디렉토리에 대한 정보 제공 및 생성, 삭제 기능 제공
		
		//시스템의 파일, 디렉토리에 대한 정보 제공
		File f = new File("C:\\");
		File[] contents = f.listFiles();
		for (File temp : contents) {
			System.out.println(temp);
		}
		
		//기존에 존재하는 파일에 대한 물리적 삭제
		File f2 = new File("D:\\temp.txt");
		f2.delete();
		System.out.println("파일 삭제 완료.");

	}

}
