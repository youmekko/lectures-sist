package com.test;

public class Sample103 {

	public static void main(String[] args) {
		
		//main 메소드의 매개변수 분석
		//String[] args
		//JVM이 전달하는 문자열형 배열 객체를 전달받을 수 있는 변수
		//자바프로그램이 실행될 때 외부 자료를 전달할 수 있다.
		//예를 들어, 명령 프롬프트에서 실행하는 경우 "java 클래스이름 자료1 자료2 ..." 형태로 실행한다.
		//이클립스에서 실행하는 경우 Run>Run configurations...>Main 탭>Project 항목>Main Class 항목>Arguments 탭>Program arguments 항목>정수1 정수2 ... 입력>Run 버튼

		if (args.length < 2) {
			System.out.println("java 클래스이름 정수1 정수2 ...");
			System.exit(0);
		}

		//합산 연산 수행 후 결과 출력
		int sum = 0;
		for (int a=0; a<args.length; ++a) {
			sum += Integer.parseInt(args[a]);
		}
		System.out.printf("합:%d%n", sum);
		
	}

}
