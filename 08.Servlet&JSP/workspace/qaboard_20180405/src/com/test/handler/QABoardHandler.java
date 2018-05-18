package com.test.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.QABoardDAO;
import com.test.domain.QABoard;

public class QABoardHandler {
	
	private QABoardDAO dao;
	
	public QABoardHandler() {
		this.dao = new QABoardDAO();
	}

	///qaboard/list
	//->메소드 추가
	public String list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<QABoard> list = this.dao.list();
		int size = list.size();
		
		request.setAttribute("list", list);
		request.setAttribute("size", size);
	
		return "/WEB-INF/views/qaboard/qaboardlist.jsp";
	}

	
	///qaboard/insert
	//->메소드 추가
	public String insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pw = request.getParameter("pw");
		String clientIP = request.getRemoteAddr();
		
		QABoard qa = new QABoard();
		qa.setTitle(title);
		qa.setContent(content);
		qa.setPw(pw);
		qa.setClientIP(clientIP);
		
		result = this.dao.add(qa);
		
		return String.format("redirect:%s/qaboard/list?success=%s", request.getContextPath(), result);
	}
	
}
