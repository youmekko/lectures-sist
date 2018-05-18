package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInsertServlet extends HttpServlet {

	private static final long serialVersionUID = -6018658714085621637L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자 정의 메소드
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자 정의 메소드
		process(req, resp);
	}

	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//데이터 수신(request 내장 객체) 
		String name_ = request.getParameter("name_");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		//-> DAO 클래스로 정보 전달 -> Member 객체
		/* 
		Member m = new Member();
		m.setName_(name_);
		m.setPhone(phone);
		m.setEmail(email);
		*/
		Member m = new Member();
		m.setName_(name_);
		m.setPhone(phone);
		m.setEmail(email);
		 
		//-> memberAdd() 메소드 호출
	 	MemberDAO dao = new MemberDAO();
		int result = dao.memberAdd(m);

		//강제 페이지 전환
		//-> response 내장 객체 이용
		//-> 주의) 현재 문장 이후에 작성된 코드는 실행되지 않는다.
		//-> 주의) 현재 페이지에 있는 HTML 코드는 클라이언트에게 전달되지 않는다.
		//-> 성공, 실패 여부를 GET 방식으로 전달 가능
		response.sendRedirect("member?success="+ result);
	}

	
}
