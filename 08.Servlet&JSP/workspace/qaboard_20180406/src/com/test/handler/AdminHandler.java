package com.test.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminHandler {

	///admin/main
	//->메소드 추가
	public String main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		return "/WEB-INF/views/admin/adminmain.jsp";
	}

	
}
