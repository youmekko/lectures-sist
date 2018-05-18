package com.test007;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		//Member 객체들의 정렬 진행
		//-> Arrays.sort() 메소드
		//-> Member 클래스가 Comparable 인터페이스 구현 상태여야 한다.
		
		Member m1 = new Member("hong", "010-1234-1234");
		Member m2 = new Member("park", "010-5678-8765");
		Member m3 = new Member("choi", "010-4321-4321");
		
		Member[] members = {m1, m2, m3};
		
		System.out.println("정렬전:");
		for (Member m : members) {
			//toString() 생략된 상태
			System.out.println(m);
		}
		
		//정렬 액션 진행 -> Arrays.sort() 
		Arrays.sort(members);
		
		System.out.println("정렬후:");
		for (Member m : members) {
			//toString() 생략된 상태
			System.out.println(m);
		}
		

	}

}
