package com.test;

import java.util.Scanner;

public class Sample123 {

	public static void main(String[] args) {
		
		//Scanner 클래스의 next() 메소드, nextLine() 메소드, nextInt() 메소드 사용.
		
		//next() : 공백으로 구분된 문자열(단어 기준) 입력시 사용. 문자열 자료 반환.
		//nextLine() : 공백 포함 한 줄 전체 문자열(문장 기준) 입력시 사용. 문자열 자료 반환.
		//nextInt() : 공백으로 구분된 정수 형태의 문자열 입력시 사용. 정수 자료 반환.
		
		//주의) next(), nextInt()와 nextLine() 메소드 혼용시 줄바꿈 문자 처리 필요.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("name?");
		String name = sc.next();
		
		System.out.print("score(0~100)?");
		int score = sc.nextInt();
		
		System.out.printf("%s - %d %n", name, score);
		
		sc.close();
		System.out.println("프로그램 종료.");

	}

}
