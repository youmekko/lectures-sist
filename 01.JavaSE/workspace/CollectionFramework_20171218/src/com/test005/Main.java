package com.test005;

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
		
		//정렬 기준 제시 필요
		//익명 구현 객체 내부에서 사용될 변수인 경우 final 특성을 가지는 변수여야 한다.
		//자바8이후부터는 final 키워드 생략 가능
		String key = "phone";
		
		//정렬 액션의 결과를 반환받지 않아도 외부에서 알 수 있다.
		//->참조형 변수의 특성
		Collections.sort(list, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				int result = 0;
				if (key.equals("name")) {
					// 이름 기준 (오름차순)정렬
					// 내림차순 정렬인 경우 o2, o1순으로 비교 액션
					result = o1.getName().compareTo(o2.getName());
				} else if (key.equals("phone")) {
					//전화번호 기준 (오름차순)정렬
					result = o1.getPhone().compareTo(o2.getPhone());
				}
				return result;
			}
		});
		
		//전체 출력
		for (Member m : list) {
			System.out.println(m);
		}
		

	}

}
