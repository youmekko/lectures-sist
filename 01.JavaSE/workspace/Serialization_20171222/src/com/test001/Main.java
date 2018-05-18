package com.test001;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//직렬화(Serialization)
		/*
		
		- 메모리에 생성된 객체(Instance)를 객체인 상태로 물리적으로 저장할 수 있는 방법.
		- 물리적으로 직렬화된 정보를 역으로 메모리로 읽어올 수 있다. 역직렬화.
		- 파일에 저장하거나, 네트워크를 통해서 전송 가능.
		- ObjectOutputStream, FileOutputStream 클래스 이용.
		- 파일로 저장시 일반적으로 확장자는 *.ser 를 사용한다.
		- 직렬화시 고유 객체임으로 입증할 수 있는 정보 지정 필요. serialVersionUID 필드. 권장사항.
		- 직렬화 가능 클래스로 선언된 경우만 직렬화 가능. Serializable 인터페이스 구현 필요.
		- 객체 직렬화 대상은 필드 및 필드의 값만이다. 메소드 제외. 단, static, transient 키워드가 붙은 필드는 제외.
		- 부모 클래스가 직렬화 가능 클래스인 경우, 자식 클래스는 자동으로 직렬화 대상이 된다. Serializable 인터페이스 구현 불필요.
		
		*/
		
		
		//Serializable 인터페이스 구현 클래스를 대상으로 직렬화 테스트
		//-> Wrapper 클래스 전체는 직렬화 지원
		
		//Integer 클래스 자료형의 객체(Instance) -> 직렬화 대상
		Integer a = new Integer(10);
		
		//동적 파일 생성(덮어쓰기)
		FileOutputStream fs = new FileOutputStream("D:\\temp.ser");
		//직렬화를 위한 보조스트림 준비
		ObjectOutputStream os = new ObjectOutputStream(fs);
		
		//메모리에 존재하는 객체(Instance)를 직렬화 대상으로 등록
		//->물리적 파일로 생성된다.
		os.writeObject(a);
		
		//마무리
		os.close();
		fs.close();
		
		System.out.println("직렬화 완료.");

	}

}
