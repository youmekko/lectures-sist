package com.test008;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//Map 인터페이스
		//- 키와 값의 쌍으로 자료 저장. 
		//- 인덱스 제공되지 않는다. 
		//- 키(Set)는 중복 저장 불가. 
		//- 값(List)은 중복 저장 가능. 
		//- 키를 이용해서 값 접근. 
		//- 대표적인 구현 클래스는 HashMap 클래스이다.
		
		//제네릭 표현시 <키, 값> 자료형 표기 필요
		//키는 주로 Integer, String 자료형을 사용한다.
		Map<String, String> map = new HashMap<String, String>();
		
		//put(키, 값) 형태로 자료 입력
		//키는 중복 불가, 값은 중복 가능
		map.put("A001", "TEST");
		map.put("A002", "SAMPLE");
		map.put("A003", "JAVA");
		map.put("A004", "ORACLE");
		
		//get() 메소드를 이용해서 특정 자료를 꺼낼 수 있다.
		//특정 자료를 꺼내는 경우 키 사용.
		System.out.println("----------------");
		System.out.println(map.get("A001"));
		System.out.println(map.get("A002"));
		System.out.println(map.get("A003"));
		System.out.println(map.get("A004"));
		
		//주의) 자료 전체를 꺼내는 경우 향상된 for문 사용 불가.
		
		//자료 전체를 꺼내는 경우 Iterator(반복자) 사용
		//->키들의 집합(set)을 가지고 반복문 진행하고, 각각의 키별로 값 접근.
		//주의) 키들의 집합체는 Set 컬렉션이므로 순서대로 출력되지 않는다.
		System.out.println("----------------");
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.printf("%s, %s%n", key, map.get(key));
		}
		
		
		//문제) 키들을 정렬시켜서 출력하도록 코드 작성.
		/*
		실행예)
		A001, TEST
		A002, SAMPLE
		A003, JAVA
		A004, ORACLE
		*/
		System.out.println("----------------");
		List<String> list = new ArrayList<String>(keySet);
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (String key : list) {
			System.out.printf("%s, %s%n", key, map.get(key));
		}
		
		//자료 검색
		System.out.println("---------------");
		System.out.println(map.containsKey("A001"));
		System.out.println(map.containsKey("A000"));
		System.out.println(map.containsValue("TEST"));
		System.out.println(map.containsValue("JSP"));
		
		//자료 존재 여부 확인.
		System.out.println("-------------");
		System.out.println(map.isEmpty());

		//자료 개수 확인.
		System.out.println("-------------");
		System.out.println(map.size());
		
		//Map 컬렉션에서 자료(값)들의 집합체를 반환 받을 수 있다.
		System.out.println("-------------");
		Collection<String> collections = map.values();
		for (String c : collections) {
			System.out.println(c);
		}
		
		//특정 자료 삭제
		//주의) 특정 키를 이용한 자료 삭제 액션
		System.out.println("-------------");
		map.remove("A001");
		Set<String> keySet2 = map.keySet();
		Iterator<String> iterator2 = keySet2.iterator();
		while(iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.printf("%s, %s%n", key, map.get(key));
		}
		
		//전체 자료 삭제
		System.out.println("-------------");
		map.clear();
		System.out.println(map.isEmpty());
		
	}

}
