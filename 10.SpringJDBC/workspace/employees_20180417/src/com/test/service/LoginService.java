package com.test.service;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.test.dao.LoginJDBCTemplate;
import com.test.domain.Login;

public class LoginService {

	private LoginJDBCTemplate loginJDBCTemplate;
	
	public LoginService(ApplicationContext context) {
		this.loginJDBCTemplate = (LoginJDBCTemplate) context.getBean("loginJDBCTemplate");
	}

	//아이디, 패스워드 입력받고, 로그인 검증하는 메소드
	public Login login(Scanner sc) {
		Login result = null;
		
		//로그인 검증 절차 진행
		//성공하면 Login 객체 반환
		//실패하면 NULL 반환
		System.out.print("아이디:");
		String id_ = sc.nextLine();
		System.out.print("패스워드:");
		String pw_ = sc.nextLine();
		
		Login login = new Login();
		login.setId_(id_);
		login.setPw_(pw_);
		
		result = this.loginJDBCTemplate.login(login);
		
		return result;
	}
	
}
