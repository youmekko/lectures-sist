package com.test001;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		//임의의 Member 객체 생성
		Member m1 = new Member("hong", "010-1234-1234", "hong@test.com", "2017-12-14", "B02");
		Member m2 = new Member("park", "010-4567-7890", "park@naver.com", "2017-12-15", "B01");
		
		//임의의 Member 객체를 컬렉션 저장소에 추가
		List<Member> list = new ArrayList<Member>();
		list.add(m1);
		list.add(m2);
		
		//컬렉션 저장소에 저장된 Member 객체들을 전체 출력
		System.out.printf("총: %d건%n", list.size());
		System.out.println("--------------------------------------------");
		for (Member m : list) {
			System.out.println(m);
		}
		
		
	}

}
