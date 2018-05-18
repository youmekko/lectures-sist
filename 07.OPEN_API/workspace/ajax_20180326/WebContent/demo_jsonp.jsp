<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	//JSP code
	request.setCharacterEncoding("UTF-8");
	String contextRoot = request.getContextPath();
	StringBuilder sb = new StringBuilder();
	
	String myJSON = "{ \"name\":\"John\", \"age\":30, \"city\":\"New York\" }";

	out.println(String.format("myFunc(%s)", myJSON));
	
%>