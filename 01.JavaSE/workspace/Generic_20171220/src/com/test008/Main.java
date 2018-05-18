package com.test008;

public class Main {

	public static void main(String[] args) {
		
		//타입 파라미터 자료형을 가지는 배열 객체 테스트
		Util<String> util = new Util<String>(5);
		
		util.add("TEST", 0);
		util.add("SAMPLE", 1);
		
		System.out.println("----------------");
		System.out.println(util.get(0));
		System.out.println(util.get(1));
		
		System.out.println("----------------");
		for (Object s : util.getArray()) {
			System.out.println(s);
		}

	}

}
