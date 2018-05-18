package com.test002;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
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
		
		os.close();
		fs.close();
		
		System.out.println("역직렬화 완료.");

	}

}
