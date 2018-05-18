package com.test006;

import java.io.*;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//사용자 정의 클래스에 대한 직렬화 테스트
		//->Serializable 인터페이스에 대한 구현 필요
		
		//역직렬화
		//-물리적으로 직렬화된 정보를 역으로 메모리로 읽어올 수 있다.
		//- ObjectInputStream, FileInputStream 클래스 이용.
		
		FileInputStream fs = new FileInputStream("D:\\temp.ser");
		ObjectInputStream os = new ObjectInputStream(fs);
		
		Object temp = os.readObject();
		//주의) 저장된 객체가 단순한 객체가 아닌 경우 형변환 등이 필요할 수 있다.
		
		//역직렬화한 객체를 원래의 자료형으로 형변환할 때 클래스의 소속인 패키지 확인 필요.
		//->같은 패키지 내에서 역직렬화를 진행하는 경우는 패키지명 생략 가능  
		List<com.test003.Member> members = (List<com.test003.Member>)temp;
		
		for (com.test003.Member m : members) {
			System.out.println(m.toString());
		}
		
		os.close();
		fs.close();
		
		System.out.println("역직렬화 완료.");
		
	}

}
