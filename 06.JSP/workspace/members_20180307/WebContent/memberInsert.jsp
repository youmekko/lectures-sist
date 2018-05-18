<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%-- 주의) 현재 페이지는 단독 실행(Ctrl + F11)하지 않는다. --%>
<%@ page import="com.test.*" %> 
<%
	//JSP code
	request.setCharacterEncoding("UTF-8");
	StringBuilder sb = new StringBuilder();
	
	
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
	response.sendRedirect("member.jsp?success="+ result);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SIST_쌍용교육센터</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style>

</style>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script>
$(document).ready(function(){

	// jQuery methods go here...
	/* 
	window.alert("회원 정보가 입력 되었습니다.");
	location.assign("member.jsp");
	*/
	
});
</script>
</head>
<body>

<div class="container">
	
</div>

</body>
</html>