package com.test006;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//회원번호('M001' 형식) 자동 증가 및 관리 액션
		
		List<String> list = new ArrayList<String>();
		
		list.add("M001");
		list.add("M002");
		list.add("M003");
		
		//다음에 만들어야 하는 신규회원번호는 'M004'가 되어야 한다.
		for (int i=0; i<10; ++i) {
			
			//기존 번호 분석 -> 저장 순서가 유지되므로 마지막 값이 가장 큰 값이다.
			String max = list.get(list.size()-1);
			//System.out.println(max);
			
			//신규 번호 생성 -> max 변수의 값을 분석해서 +1 연산 수행
			String newNum = String.format("M%03d", Integer.parseInt(max.substring(1)) + 1);
			
			//신규 번호를 가진 객체를 컬렉션에 저장
			list.add(newNum);
			
		}
		
		for(String s : list) {
			System.out.println(s);
		}

	}

}
