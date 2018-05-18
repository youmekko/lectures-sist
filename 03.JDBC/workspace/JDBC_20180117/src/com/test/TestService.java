package com.test;

import java.util.*;

//콘솔 액션 전용 클래스
public class TestService {
	
	private TestDAO dao = new TestDAO();
	
	//출력 액션 메소드
	public void list() {
		//콘솔 액션 처리
		//->TestDAO의 특정 메소드로부터 반환받은 컬렉션 객체를
		//원하는 서식에 맞춰서 콘솔 출력
		
		List<Test> list = dao.list();
		for (Test t : list) {
			System.out.println(t.toString());
		}
		
	}
	
	//입력 액션 메소드
	public void add(Scanner sc) {

		//콘솔 액션 처리
		//->특정 항목(age_, first_, last_ 항목)의 자료를 콘솔로부터 입력 받고,
		//TestDAO의 특정 메소드에 전달.
		System.out.print("first_name:");
		String first_ = sc.nextLine();
		System.out.print("last_name:");
		String last_ = sc.nextLine();
		System.out.print("age:");
		int age_ = sc.nextInt();
		sc.nextLine();
		
		Test t = new Test(0, age_, first_, last_);
		dao.add(t);
		System.out.println("Inserted records into the table.");
		
	}
	
	
	//삭제 액션 메소드
	public void remove(Scanner sc) {
		//콘솔 액션 처리
		//->특정 항목(PK 제약이 지정된 id_ 항목)의 자료를 콘솔로부터 입력 받고,
		//->TestDAO의 특정 메소드에 전달.
		//->결과 메시지(n개 행 이(가) 삭제되었습니다.) 출력
		System.out.print("id:");
		int id_ = sc.nextInt();
		sc.nextLine();
		
		int result = dao.remove(id_);
		System.out.printf("%d개 행 이(가) 삭제되었습니다.%n", result);
		
	}

}
