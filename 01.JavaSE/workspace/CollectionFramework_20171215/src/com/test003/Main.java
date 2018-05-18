package com.test003;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//Set 인터페이스
		//- 값만 저장된다. 
		//- 저장 순서가 유지되지 않는다. 
		//- 중복 저장 불가. 
		//- 정렬 기능이 지원되지 않는다.
		//- 인덱스를 이용한 접근 불가
		//- 대표적인 구현 클래스는 HashSet 클래스이다.
		
		//HashSet 클래스를 이용한 컬렉션 저장소 준비
		//->메모리 상의 크기는 자동 관리된다.
		//->초기 크기 지정 불필요
		//->컬렉션 저장소 준비할 때 제네릭 표현에 의해 저장 가능한 객체의 종류가 제한된다.
		Set<String> set = new HashSet<String>();
		
		//add() 메소드를 이용해서 자료 저장.
		//저장 순서가 유지되지 않는다. 중복 저장 불가. 
		set.add("hong");
		set.add("park");
		set.add("choi");
		set.add("hong"); //저장 제외. 중복 저장 불가. 내부적으로 equals() 메소드를 이용해서 비교.
		
		//주의) get() 메소드를 이용해서 특정 위치의 자료를 꺼낼 수 없다.
		//System.out.println(set.get(0));
		
		//자료 전체를 꺼내는 경우 Iterator(반복자) 사용
		System.out.println("---------------");
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String temp = iterator.next();
			System.out.println(temp);
		}
		
		//자료 전체를 꺼내는 경우 향상된 for문 사용
		System.out.println("---------------");
		for (String s : set) {
			System.out.println(s);
		}
		
		//주의) 인덱스를 이용한 일반 for문으로 전체 출력 불가
		//주의) 특정 위치를 이용한 자료 추가, 수정 액션 불가
		
		//자료 검색
		System.out.println("---------------");
		System.out.println(set.contains("hong"));
		System.out.println(set.contains("test"));
		
		//자료 존재 여부 확인.
		System.out.println("-------------");
		System.out.println(set.isEmpty());

		//자료 개수 확인.
		System.out.println("-------------");
		System.out.println(set.size());
		
		//특정 자료 삭제
		//주의) 특정 위치를 이용한 자료 삭제 액션 불가
		System.out.println("-------------");
		set.remove("hong");
		for (String s : set) {
			System.out.println(s);
		}
		
		//전체 자료 삭제
		System.out.println("-------------");
		set.clear();
		System.out.println(set.isEmpty());
		
		
	}

}
