package com.test004;

public class Main {

	public static void main(String[] args) {
		
		//제네릭 메소드 테스트

		//타입 파라미터 자료형을 명시적으로 지정한 상태로 호출
		Box<Integer> box1 = Util.<Integer>boxing(100);
		System.out.println(box1.getT());

		//타입 파라미터 자료형을 암시적으로 지정한 상태로 호출
		//->암시적인 경우 매개변수에 전달될 값을 보고 자료형 판단
		Box<Integer> box2 = Util.boxing(200);
		System.out.println(box2.getT());
		
		
		//멀티 타입 파라미터 제네릭 메소드 테스트
		Pair<String, String> pair1 = new Pair<String, String>("A001", "hong"); 
		Pair<String, String> pair2 = new Pair<String, String>("A002", "park");
		//자바7 이후부터는 객체 생성시 타입 파라미터 표기 생략 가능
		Pair<String, String> pair3 = new Pair<>("A001", "hong");

		//타입 파라미터 자료형을 명시적으로 지정한 상태로 호출
		System.out.println(Util.<String, String>compare(pair1, pair2)); //false
		//타입 파라미터 자료형을 암시적으로 지정한 상태로 호출
		System.out.println(Util.compare(pair1, pair3)); //true
				
	}

}
