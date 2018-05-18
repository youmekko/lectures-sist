package com.test002;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//제네릭 표현을 사용하지 않는 컬렉션 테스트
		//List is a raw type. References to generic type List<E> should be parameterized
		List list2 = new ArrayList();
		
		//일반 컬렉션 클래스에서는 모든 자료형 범위의 자료 저장 가능
		//->다양한 자료형의 자료 저장 가능
		list2.add("123"); //O
		list2.add(123); //O
		
		//일반 컬렉션 클래스에 저장된 자료는 타입 검사 및 형변환 필요
		//->모든 자료가 Object 자료형으로 취급된다.
		Object o1 = list2.get(0);
		if (o1 instanceof String) {
			String temp0 = (String)o1;
			System.out.println(temp0);
		}
		
		Object o2 = list2.get(1);
		if (o2 instanceof String) {
			String temp1 = (String)o2;
			System.out.println(temp1);
		}

	}

}
