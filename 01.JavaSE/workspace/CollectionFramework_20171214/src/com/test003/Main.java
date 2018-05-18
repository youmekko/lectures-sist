package com.test003;

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
		
		//컬렉션 자료 정렬. 이름 기준
		/*
		Collections.sort(list, new Comparator<Member>() {
			@Override
			public int compare(Member m1, Member m2) {
				return m1.getName().compareTo(m2.getName());
			}
		});
		*/
		
		//컬렉션 저장소에 저장된 객체들에 대한 정보 전체 출력
		//null 자료는 자동 제외
		System.out.println("--------------");
		System.out.printf("총인원:%s명%n", list.size());
		for (Member m : list) {
			//toString() 메소드 생략
			System.out.println(m);
		}
		
		//특정 자료 삭제. 번호 기준 삭제.
		Member temp = new Member();
		temp.setMid(4);
		list.remove(temp);
		System.out.println("--------------");
		System.out.printf("총인원:%s명%n", list.size());
		for (Member m : list) {
			System.out.println(m);
		}
		
		
	}

}
