<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%-- 주의) 현재 페이지는 단독 실행(Ctrl + F11)하지 않는다. --%>
<%@ page import="java.time.*, com.test.*" %> 
<%
	//JSP code
	request.setCharacterEncoding("UTF-8");
	StringBuilder sb = new StringBuilder();
	
	//데이터 수신(request 내장 객체) 
	String mid_ = request.getParameter("mid_");
	 
	//-> DAO 클래스로 정보 전달
	//-> memberAdd() 메소드 호출
 	MemberDAO dao = new MemberDAO();
	int result = dao.memberRemove(mid_);

	//강제 페이지 전환
	//-> response 내장 객체 이용
	//-> 주의) 현재 문장 이후에 작성된 코드는 실행되지 않는다.
	//-> 주의) 현재 페이지에 있는 HTML 코드는 클라이언트에게 전달되지 않는다.
	//-> 성공, 실패 여부를 GET 방식으로 전달 가능
	response.sendRedirect("member.jsp?del="+ result);
%>