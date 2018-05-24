package com.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.test.domain.Login;
import com.test.service.EmployeeMain;
import com.test.service.InstructorMain;
import com.test.service.LoginService;
import com.test.service.StudentMain;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/com/test/beans.xml");
		
		Scanner sc = new Scanner(System.in);
		LoginService service = new LoginService(context);
		
		//로그인 메뉴 구성
		boolean run = true;
		while (run) {
			System.out.println("-------------------");
			System.out.println("직원관리v3.0 MySQL");
			System.out.println("-------------------");
			System.out.println("1.로그인");
			System.out.print("선택(1, 0 quit)?");

			int m = sc.nextInt();
			sc.nextLine();

			if (m == 0) {
				break;
			} else if (m == 1) {
				//로그인 메뉴 호출 및 로그인 결과 분석
				try {
					Login result = service.login(sc);
					
					//로그인 성공 및 등급 분석
					String id_ = result.getId_();
					int grade = result.getGrade();
					if (grade == 0) {
						//관리자 전용 메인 메뉴로 이동
						new EmployeeMain().main(sc, id_, context);
					} else if (grade == 1) {
						//강사 전용 메인 메뉴로 이동
						new InstructorMain().main(sc, id_, context);
					} else if (grade == 2) {
						//수강생 전용 메인 메뉴로 이동
						new StudentMain().main(sc, id_, context);
					} else {
						System.out.println("잘못된 등급 정보입니다.");
					}
				}catch(DataAccessException ex) {
					System.out.println("로그인에 실패 했습니다.");
				}
			}

		}
		sc.close();
		((ClassPathXmlApplicationContext)context).close();

		System.out.println("프로그램 종료.");
		
	}

}
