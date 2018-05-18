package com.test006;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//Set 저장소에 Member 객체 저장시 정렬 액션 지원
		//->Set 저장소를 List 저장소로 변환한 다음 정렬 액션 진행
		
		Member m1 = new Member("hong", "010-1234-1234");
		Member m2 = new Member("park", "010-4567-5678");
		Member m3 = new Member("choi", "010-4321-4321");
		
		Set<Member> set = new HashSet<Member>();
		
		set.add(m1);
		set.add(m2);
		set.add(m3);
		
		//정렬 액션 추가
		List<Member> list = new ArrayList<Member>(set);
		Collections.sort(list, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		for (Member m : list) {
			System.out.println(m);
		}

		
	}

}
