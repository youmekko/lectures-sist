package com.test001;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//사용자 정의 클래스에 대한 직렬화 테스트
		//->Serializable 인터페이스에 대한 구현 필요
		
		Member m = new Member("M001", "hong", "010-1234-1234", "hong@test.com", "2017-12-26","B01");
		
		System.out.println(m.getName()); //hong
		System.out.println(m.getPhone()); //010-1234-1234

		//직렬화
		
		//동적 파일 생성(덮어쓰기)
		FileOutputStream fs = new FileOutputStream("D:\\temp.ser");
		//직렬화를 위한 보조스트림 준비
		ObjectOutputStream os = new ObjectOutputStream(fs);

		//메모리에 존재하는 객체(Instance)를 직렬화 대상으로 등록
		//->물리적 파일로 생성된다.
		os.writeObject(m);
		
		//마무리
		os.close();
		fs.close();
		
		System.out.println("직렬화 완료.");
		
	}

}
