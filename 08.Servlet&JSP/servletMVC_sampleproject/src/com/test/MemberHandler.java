package com.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberHandler {

	private MemberDAO dao;
	public MemberHandler() {
		this.dao = new MemberDAO();
	}
	
	///member/list
	//주의) 요청 주소와 메소드 이름을 서로 같은 이름 사용
	public String list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		return "/WEB-INF/views/member.jsp";
	}
	
	///member/insert
	public String insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		return String.format("redirect:%s/member/list?success=%s", request.getContextPath(), result);
	}
	
	

}
