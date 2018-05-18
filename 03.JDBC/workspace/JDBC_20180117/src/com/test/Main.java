package com.test;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//TestDAO 클래스의 list(), add() 메소드 테스트
		//->TestService 클래스의 list(), add() 메소드 호출로 대체할 수 있다.
		
		Scanner sc = new Scanner(System.in);

		TestService service = new TestService();

		//입력 메소드 테스트
		//service.add(sc);

		//출력 메소드 테스트
		//service.list();
		
		//삭제 메소드 테스트
		service.remove(sc);
		
		sc.close();

	}

}
