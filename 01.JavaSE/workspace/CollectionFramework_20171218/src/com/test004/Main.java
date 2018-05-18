package com.test004;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//사용자 정의 객체가 저장된 컬렉션에 대한 정렬 지원
		//- 사용자 정의 객체는 기본적으로 정렬이 되지 않는다. 내부적으로 참조 주소만을 비교하기 때문이다. 객체 내부의 항목을 비교해야만 정렬이 된다.
		//- Comparable 인터페이스(고정된 정렬 기준 제시) 구현 또는 Comparator 인터페이스 구현(정렬 기준을 상황에 맞춰서 제시 가능)
		
		Member m1 = new Member("hong", "010-1234-1234");
		Member m2 = new Member("park", "010-4567-5678");
		Member m3 = new Member("choi", "010-6543-4321");
		
		//컬렉션 저장소 준비 및 자료 저장
		List<Member> list = new ArrayList<Member>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		//이름 기준 정렬
		Collections.sort(list);
		
		//전체 출력
		for (Member m : list) {
			System.out.println(m);
		}
		

	}

}
