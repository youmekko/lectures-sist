package com.score001;

import java.util.Scanner;

//(콘솔)서비스 관련 클래스
public class ScoreService {
	
	//(배열)저장소 관련 클래스 객체 확보
	private ScoreDAO dao = new ScoreDAO();

	//성적 정보 입력 메소드
	public void scoreAdd(Scanner sc) {

		System.out.println("--------------");
		System.out.println("성적 정보 입력");
		System.out.println("--------------");
		System.out.print("번호:");
		String sid = sc.next();
		System.out.print("이름:");
		String name = sc.next();
		System.out.print("과목1:");
		int sub1 = sc.nextInt();
		System.out.print("과목2:");
		int sub2 = sc.nextInt();
		System.out.print("과목3:");
		int sub3 = sc.nextInt();

		this.dao.scoreAdd(sid, name, sub1, sub2, sub3);

		System.out.println("성적 정보 입력이 성공했습니다.");

	}

	//성적 정보 출력 메소드
	public void scoreList(Scanner sc) {

		System.out.println("--------------");
		System.out.println("성적 정보 출력");
		System.out.println("--------------");
		
		System.out.println(this.dao.scoreList());
		
	}
}
