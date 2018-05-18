package com.test001;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//List 인터페이스
		//-값만 저장된다. 
		//-인덱스 제공. 
		//-저장 순서를 유지한다. 
		//-중복 저장 가능. 
		//-정렬 기능이 지원된다. 
		//-대표적인 구현 클래스는 ArrayList 클래스이다.
		
		//Vector 클래스
		//-Vector 클래스는 ArrayList 클래스와 동일한 내부 구조를 가지고 있다. ArrayList 클래스 사용을 권장한다.
		//-Vector 클래스는 멀티 쓰레드 환경에서 Thread Safe 기능을 제공한다.
		
		List<String> list = new Vector<String>();

		//add() 메소드를 이용해서 자료 저장. 끝 위치에 저장.
		//저장 순서를 유지한다.
		list.add("hong");
		list.add("park");
		list.add("choi");
		
		//get() 메소드를 이용해서 특정 자료를 꺼낼 수 있다.
		//특정 자료를 꺼내는 경우 인덱스 사용.
		System.out.println(list.get(0)); //hong
		System.out.println(list.get(1)); //park
		System.out.println(list.get(2)); //choi
		
		//자료 전체를 꺼내는 경우 향상된 for문 사용
		//null 자료는 자동 제외된다.
		System.out.println("-------------");
		for (String s : list) {
			System.out.println(s);
		}
		
		//인덱스를 이용해서 일반 for문으로 전체 출력 가능
		//->자료 갯수 파악(null 자료는 자동 제외)을 위해서 size() 메소드 필요
		System.out.println("-------------");
		for (int i=0; i<list.size(); ++i) {
			System.out.printf("%d : %s%n", i, list.get(i));
		}
		
		//특정 위치에 자료 추가 가능
		list.add(1, "kim");
		System.out.println("-------------");
		for (String s : list) {
			System.out.println(s);
		}
		
		//특정 위치의 자료를 새로운 자료로 덮어쓰기 가능. 수정 액션.
		list.set(1, "lee");
		System.out.println("-------------");
		for (String s : list) {
			System.out.println(s);
		}
		
		//자료 검색 기능.
		System.out.println("-------------");
		System.out.println(list.contains("lee"));
		System.out.println(list.contains("kim"));
		System.out.println(list.indexOf("lee"));
		System.out.println(list.indexOf("kim"));
		
		//자료 존재 여부 확인.
		System.out.println("-------------");
		System.out.println(list.isEmpty());

		//자료 개수 확인.
		System.out.println("-------------");
		System.out.println(list.size());
		

		//특정 자료 삭제
		System.out.println("-------------");
		list.remove(1);
		list.remove("hong");
		for (String s : list) {
			System.out.println(s);
		}
		
		//전체 자료 삭제
		System.out.println("-------------");
		list.clear();
		System.out.println(list.isEmpty());
		
		
		//다량의 자료 추가. 배열 자료형을 List 자료형으로 형변환.
		String[] arr = {"Test", "Sample", "Java", "Collection"};
		List<String> list2 = Arrays.asList(arr);
		System.out.println("-------------");
		for (String s : list2) {
			System.out.println(s);
		}
		
		//List 자료형을 배열 자료형으로 형변환.
		List<String> list3 = new ArrayList();
		list3.add("1");
		list3.add("2");
		list3.add("3");
		list3.add("4");
		Object[] arr2 = list3.toArray();
		System.out.println("-------------");
		System.out.println(Arrays.toString(arr2));
		
		
	}

}
