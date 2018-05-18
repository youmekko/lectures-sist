package com.test005;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//사용자 정의 클래스에 대한 직렬화 테스트
		//->Serializable 인터페이스에 대한 구현 필요
		
		//두 개 이상의 객체(instance)를 직렬화 하려면 하나의 객체(instance)로 포장이 필요하다.
		//-> 배열 또는 컬렉션
		Member m1 = new Member("M001", "hong", "010-1234-1234", "hong@test.com", "2017-12-26","B01");
		Member m2 = new Member("M002", "park", "010-4567-4567", "park@naver.com", "2017-12-26","B02");
		
		//컬렉션 클래스는 직렬화 지원
		//Member 클래스가 직렬화 지원하지 않는 경우
		List<Member> members = new ArrayList<Member>();
		members.add(m1);
		members.add(m2);
		

		//직렬화
		
		//동적 파일 생성(덮어쓰기)
		FileOutputStream fs = new FileOutputStream("D:\\temp.ser");
		//직렬화를 위한 보조스트림 준비
		ObjectOutputStream os = new ObjectOutputStream(fs);

		//메모리에 존재하는 객체(Instance)를 직렬화 대상으로 등록
		//->물리적 파일로 생성된다.
		//->java.io.NotSerializableException
		os.writeObject(members);
		
		//마무리
		os.close();
		fs.close();
		
		System.out.println("직렬화 완료.");
		
	}

}
