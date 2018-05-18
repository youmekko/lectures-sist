package com.test002;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//ArrayList 클래스를 이용한 컬렉션 저장소 관리
		
		Member m1 = new Member("hong", "010-1234-1234");
		Member m2 = new Member("park", "010-5678-5678");
		Member m3 = new Member("choi", "010-4321-0987");
		Member m4 = new Member("hong", "010-9876-5432");
		
		//Member 객체만 저장할 수 있는 컬렉션 저장소 준비
		List<Member> list = new ArrayList<Member>();
		//저장소 크기 관리, 인덱스 관리가 자동으로 진행된다.
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		
		//컬렉션 저장소에 저장된 객체들에 대한 정보 전체 출력
		//null 자료는 자동 제외
		System.out.println("--------------");
		System.out.printf("총인원:%s명%n", list.size());
		for (Member m : list) {
			//toString() 메소드 생략
			System.out.println(m);
		}
		
		//특정 조건(이름 검색)을 만족하는 자료만 출력
		System.out.println("--------------");
		int count = 0;
		for (Member m : list) {
			if (m.getName().contains("hong")) {
				++count;
				System.out.println(m);
			}
		}
		System.out.printf("총인원:%s명%n", count);
		
		
		//특정 자료 삭제 가능. 이름 기준 삭제.
		Member temp = new Member("hong", "");
		//Member 클래스 내부에 equals() 메소드에 대한 오버라이딩 구현 필요
		list.remove(temp);
		System.out.println("--------------");
		System.out.printf("총인원:%s명%n", list.size());
		for (Member m : list) {
			//toString() 메소드 생략
			System.out.println(m);
		}
		//주의) 중복된 이름이 있는 경우 원하는 자료 삭제가 안되는 경우가 발생한다. 유니크한 성격을 가진 키가 필요.
		

	}

}
