package com.test005;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//Set 저장소에 Member 객체 저장시 중복 자료 검사
		
		Member m1 = new Member("hong", "010-1234-1234");
		Member m2 = new Member("hong", "010-1234-1234"); //중복 자료
		Member m3 = new Member("park", "010-4567-5678");
		
		Set<Member> set = new HashSet<Member>();
		
		set.add(m1);
		set.add(m2); //이름, 전화번호 항목이 모두 일치하므로 동등 객체로 판단. 저장 불가.
		set.add(m3);
		
		for (Member m : set) {
			System.out.println(m);
		}

		
	}

}
