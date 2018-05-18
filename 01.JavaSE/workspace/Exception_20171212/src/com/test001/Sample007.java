package com.test001;

import java.util.*;

public class Sample007 {

	public static void main(String[] args) {

		//try~catch~finally 구문 형식
		/*
		try {
			//예외발생 가능한 구문
		}catch(예외종류 변수) {
			//예외처리 구문
		}finally{
			//예외 발생 유무와 관계없이 마무리 액션 처리하는 부분
			//외부 자원 이용시 close() 메소드 호출시 사용 
		}
		*/
		
		Scanner sc = new Scanner(System.in);
		
		//예외 발생 가능 구문
		System.out.print("숫자?");
		int a = sc.nextInt();
		System.out.println(a);
		
		//주의) 이 부분은 예외 발생 유무와 관계없이 실행되어야 한다.
		sc.close();
		System.out.println("프로그램 정상 종료.");
		
	}

}
