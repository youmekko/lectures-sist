package com.score003;

import java.util.*;

//메인 메뉴 액션 클래스
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		 //메인 메뉴 액션
		ScoreService service = new ScoreService();
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1. 성적 정보 입력  2. 성적 정보 출력");
			System.out.print("선택(1~2, 0 quit)?");
			int selectNo = sc.nextInt();

			switch (selectNo) {
			case 0:	run = false; break;
			case 1:	service.scoreAdd(sc); break;
			case 2:	service.scoreList(sc); break;
			}

		}
		
		sc.close();
		System.out.println("프로그램 종료.");
		
	}

}
