package com.test001;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//제네릭(Generic)
		/*
		
		- 제네릭 표현은 타입 파라미터(<T> 표현)를 클래스나 메소드에 추가함으로써 사용 가능한 자료형을 제한하는 역할이다. 이때, 자료형 선택은 선언할 때 아니라, 메소드 호출시 또는 객체 생성시 결정된다. 단, 자료형은 참조자료형(클래스)만 가능
		- 불필요한 타입 검사 또는 타입 변환 액션을 필요로 하지 않게 된다.
		- 제네릭 표현은 클래스 또는 메소드에 표시 가능. 일반적으로 대문자 한 글자로 표기. 예를 들어, <A>, <B>, ...
		- 대표적인 제네릭 클래스는 컬렉션 클래스들이다.
		- 자바5 이후부터 사용 가능.

		- 기본 형식(클래스인 경우)
		- 클래스명 뒤에 타입 파라미터를 표현한 경우
		public class 클래스명<T> {
		}
		public interface 인터페이스명<T> {
		}
		public class 클래스명<K, V, ...> {
		}
		public interface 인터페이스명<K, V, ...> {
		}
		
		- 기본 형식(메소드인 경우)
		- 반환자료형, 매개변수 목록에 타입 파라미터 표현이 있는 경우
		public <T> 반환자료형<T> 메소드명(T 변수명) {
		}
		
		- 타입 파라미터 표현시 단일 타입만이 아니라 부모 클래스 범위(extends 키워드), 자식 클래스 범위(super 키워드), 무제한 범위(? 키워드) 등으로 확장할 수 있다.
		- 타입 파라미터를 가진 클래스(<T>)를 상속 받으면 자식 클래스에서 타입 파라미터를 추가해서 확장(<T, M>)할 수 있다.
		- 타입 파라미터를 가진 인터페이스(<T>)를 구현하는 경우 클래스는 반드시 제네릭 클래스(<T>)가 되어야 한다.
		
		*/
		
		
		//public interface List<E> : 제네릭 인터페이스
		//public class ArrayList<E> : 제네릭 클래스
		
		//제네릭 클래스 사용시 <E>에 해당하는 타입 파라미터에 사용자가 사용할 명시적인 자료형(클래스) 지정 필요
		List<String> list1 = new ArrayList<String>();
		
		//제네릭 클래스의 객체 생성시 <> 부분에 자료형 표기 생략 가능
		//->자바7 이후
		List<String> list2 = new ArrayList<>();
		
		//제네릭 클래스에서 지정한 자료형 범위의 자료만 저장 가능
		//예를 들어, String인 경우 문자열만 저장 가능.
		//->컴파일시 강한 타입 체크가 이루어진다.
		list2.add("123"); //O
		//list2.add(123); //X
		
		//제네릭 클래스에 저장된 자료는 형변환 없이 꺼낼 수 있다.
		//->타입 변환 불필요
		String temp = list2.get(0);
		System.out.println(temp);

	}

}