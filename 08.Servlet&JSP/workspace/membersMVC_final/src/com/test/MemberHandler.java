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

	/// member/list
	public String list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String key = "ALL";
		String value = "";
		key = request.getParameter("key");
		value = request.getParameter("value");
		if (key == null) {
			key = "ALL";
			value = "";
		}

		int totalCount = this.dao.totalCount();

		List<Member> list = this.dao.list(key, value);
		int count = list.size();

		List<Member> deptList = this.dao.deptList();

		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("deptList", deptList);
		request.setAttribute("key", key);
		request.setAttribute("value", value);

		return "/WEB-INF/views/member.jsp";
	}

	/// member/insert
	public String insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name_ = request.getParameter("name_");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String deptId = request.getParameter("deptId");
		String regDate = request.getParameter("regDate");

		Member m = new Member();
		m.setName_(name_);
		m.setPhone(phone);
		m.setEmail(email);
		m.setDeptId(deptId);
		m.setRegDate(java.time.LocalDate.parse(regDate));

		int result = this.dao.memberAdd(m);

		return String.format("redirect:%s/member/list?success=%s", request.getContextPath(), result);
	}

	/// member/delete
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mid_ = request.getParameter("mid_");
		int result = dao.memberRemove(mid_);

		return String.format("redirect:%s/member/list?success=%s", request.getContextPath(), result);
	}

	/// member/update
	public String update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mid_ = request.getParameter("mid_");
		String name_ = request.getParameter("name_");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String regDate = request.getParameter("regDate");
		String deptId = request.getParameter("deptId");

		Member m = new Member();
		m.setName_(name_);
		m.setPhone(phone);
		m.setEmail(email);
		m.setDeptId(deptId);
		m.setRegDate(java.time.LocalDate.parse(regDate));
		m.setMid_(mid_);

		int result = dao.memberModify(m);

		return String.format("redirect:%s/member/list?success=%s", request.getContextPath(), result);
	}

}
