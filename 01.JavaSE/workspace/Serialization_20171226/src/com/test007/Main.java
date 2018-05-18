package com.test007;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//상속 관계인 경우 자식 클래스에 대한 직렬화 테스트
		//부모가 직렬화 대상 클래스인 경우 자식 클래스는 직렬화 가능
		Sub sub = new Sub(10, 20, 30);
		
		//동적 파일 생성(덮어쓰기)
		FileOutputStream fs = new FileOutputStream("D:\\temp.ser");
		//직렬화를 위한 보조스트림 준비
		ObjectOutputStream os = new ObjectOutputStream(fs);

		//메모리에 존재하는 객체(Instance)를 직렬화 대상으로 등록
		//->물리적 파일로 생성된다.
		os.writeObject(sub);
		
		//마무리
		os.close();
		fs.close();
		
		System.out.println("직렬화 완료.");

		
		

	}

}
