package com.test008;

import java.io.*;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//역직렬화
		
		FileInputStream fs = new FileInputStream("D:\\temp.ser");
		ObjectInputStream os = new ObjectInputStream(fs);
		
		Object temp = os.readObject();
		
		Sub sub = (Sub)temp;
		
		System.out.println(sub.getA()); //부모 필드
		System.out.println(sub.getB()); //부모 필드
		System.out.println(sub.getC()); //자식 필드
		
		os.close();
		fs.close();
		
		System.out.println("역직렬화 완료.");
		
	}

}
