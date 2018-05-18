package com.test;

import java.util.*;

//콘솔 액션 클래스
public class Main {

	//메인메뉴(로그인 화면) 구성
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		LoginService service = new LoginService();
		
		//로그인 메뉴 구성
		boolean run = true;
		while (run) {
			System.out.println("-------------------");
			System.out.println("직원관리v2.0 MySQL");
			System.out.println("-------------------");
			System.out.println("1.로그인");
			System.out.print("선택(1, 0 quit)?");

			int m = sc.nextInt();
			sc.nextLine();

			if (m == 0) {
				break;
			} else if (m == 1) {
				//로그인 메뉴 호출 및 로그인 결과 분석
				Login result = service.login(sc);
				if (result == null) {
					//로그인 실패
					System.out.println("로그인에 실패했습니다.");
				} else {
					//로그인 성공 및 등급 분석
					String id_ = result.getId_();
					int grade = result.getGrade();
					if (grade == 0) {
						//관리자 전용 메인 메뉴로 이동
						new EmployeesMain().main(sc, id_);
					} else if (grade == 1) {
						//강사 전용 메인 메뉴로 이동
						new InstructorMain().main(sc, id_);
					} else if (grade == 2) {
						//수강생 전용 메인 메뉴로 이동
						new StudentMain().main(sc, id_);
					} else {
						System.out.println("잘못된 등급 정보입니다.");
					}
				}
			}

		}
		sc.close();
		System.out.println("프로그램 종료.");
		
	}

}
