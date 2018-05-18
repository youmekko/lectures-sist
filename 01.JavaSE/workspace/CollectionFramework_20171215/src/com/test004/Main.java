package com.test004;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//Set 저장소에 Member 객체 저장시 중복 자료 검사
		
		Member m1 = new Member("hong", "010-1234-1234");
		Member m2 = new Member("hong", "010-1234-1234"); //중복 자료
		Member m3 = new Member("park", "010-4567-5678");
		
		Set<Member> set = new HashSet<Member>();
		
		set.add(m1);
		set.add(m2); //참조 주소 비교를 하기 때문에 중복 자료로 판단하지 않는다. 항목(이름, 전화번호) 비교로 변경해야 중복 검사 가능. hashCode(), equals() 메소드에 대한 오버라이딩 필요.
		set.add(m3);
		
		for (Member m : set) {
			System.out.println(m);
		}

	}

}
