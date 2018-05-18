package com.test001;

import java.io.*;

public class Main {

	public static void main(String[] args) {

		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			
			//주의) input.txt 파일(프로젝트 이름 위치)이 물리적으로 미리 존재해야 한다.
			//주의) 물리적 경로명(상대적, 절대적) 확인 필요
			in = new FileInputStream("input.txt");
			out = new FileOutputStream("output.txt"); //물리적 파일이 생성된다.

			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
