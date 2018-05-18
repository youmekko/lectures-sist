package com.test004;

import java.io.*;

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

		//Object 클래스 자료형을 가진 변수는 접근할 수 있는 멤버가 제한적이다.
		//객체의 정보 출력 -> toString() 메소드 호출 -> 오버라이딩 메소드 호출 가능
		System.out.println(temp); 
		//ArrayList의 toString() 메소드 호출시 구성 요소가 [요소1, 요소2, ..] 형태로 출력된다.
		//Member의 toString() 메소드 호출시 번호, 이름, 전화번호, ... 형태로 출력된다.
		//[번호, 이름, 전화번호, ..., 번호, 이름, 전화번호, ..., 번호, 이름, 전화번호, ...]
		
		
		os.close();
		fs.close();
		
		System.out.println("역직렬화 완료.");
		
	}

}
