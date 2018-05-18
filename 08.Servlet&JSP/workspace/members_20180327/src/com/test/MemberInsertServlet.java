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
		//����� ���� �޼ҵ�
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����� ���� �޼ҵ�
		process(req, resp);
	}

	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//������ ����(request ���� ��ü) 
		String name_ = request.getParameter("name_");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		//-> DAO Ŭ������ ���� ���� -> Member ��ü
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
		 
		//-> memberAdd() �޼ҵ� ȣ��
	 	MemberDAO dao = new MemberDAO();
		int result = dao.memberAdd(m);

		//���� ������ ��ȯ
		//-> response ���� ��ü �̿�
		//-> ����) ���� ���� ���Ŀ� �ۼ��� �ڵ�� ������� �ʴ´�.
		//-> ����) ���� �������� �ִ� HTML �ڵ�� Ŭ���̾�Ʈ���� ���޵��� �ʴ´�.
		//-> ����, ���� ���θ� GET ������� ���� ����
		response.sendRedirect("member?success="+ result);
	}

	
}
