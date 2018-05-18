<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.test.*" %>	
<%
	//JSP code
	request.setCharacterEncoding("UTF-8");
	StringBuilder sb = new StringBuilder();
	int count = 0;
	
	//데이터베이스 정보 읽어온 결과(List<Member>)를 동적 테이블 태그(<table> ~ </table>)로 생성하는 과정 추가
	MemberDAO dao = new MemberDAO();
	
	List<Member> list = dao.list();
	
	//인원수 확인
	count = list.size();
	
	//동적 테이블 생성
	//-> <tr> ~ <tr> 태그 부분만 작성한다.
	for(Member m : list){
		sb.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",m.getMid_(),m.getName_(),m.getPhone(),m.getEmail(),m.getRegDate()));  
	}
	
	//성공, 실패 메시지 출력용 변수
	String success = request.getParameter("success");
	String msg = "";
	if (success == null) {
		//최초 실행시 메시지
	} else {
		if (success.equals("1")) {
			//성공 메시지
			msg = "<span class=\"text-success\"><strong>Success!</strong> 회원 정보가 입력되었습니다.</span>";
		} else if (success.equals("0")) {
			//실패 메시지
			msg = "<span class=\"text-danger\"><strong>Fail!</strong> 회원 정보 입력이 실패했습니다.</span>";
		}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SIST_쌍용교육센터</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style>

</style>

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script>
	$(document).ready(function() {

		// jQuery methods go here...

	});
</script>
</head>
<body>

	<div class="container">

		<div class="panel page-header" style="text-align:center;">
			<h1 style="font-size:xx-large;">
				<a href="member.jsp"><img src="img/sist_logo.png" alt="sist_logo.png"> </a>
				회원관리 <small>v3.0</small> <span style="font-size:small; color: #777777;">A website that manages personal information for members</span>
			</h1>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">회원관리 입력</div>
			<div class="panel-body">

				<form action="memberInsert.jsp" method="post">
					<div class="form-group">
						<!-- 주의) name="식별자" 에서 식별자는 
						동일 자료, 동일 식별자 기준으로 작성한다. -->
						<label for="name_">Name:</label> <input type="text"
							class="form-control" id="name_" name="name_" placeholder="max:20" required>
					</div>
					<div class="form-group">
						<label for="phone">Phone:</label> <input type="text"
							class="form-control" id="phone" name="phone" placeholder="max:20" required>
					</div>
					<div class="form-group">
						<!-- 주의) type="email" 속성 지정된 입력폼 사용시 
						  입력된 자료가 email 형식이 틀린 경우 서브밋 진행 불가 -->
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="email" name="email" placeholder="max:50">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
					<!-- 입력 성공, 실패 메시지 출력 -->
    				<%=msg%>
  
				</form>


			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">회원관리 출력</div>
			<div class="panel-body">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Mid</th>
							<th>Name</th>
							<th>Phone</th>
							<th>Email</th>
							<th>RegDate</th>
						</tr>
					</thead>
					<tbody>
						<!-- 
						<tr>
							<td>M01</td>
							<td>John</td>
							<td>010-1234-1234</td>
							<td>john@example.com</td>
							<td>2017-01-01</td>
						</tr>
						<tr>
							<td>M02</td>
							<td>Mary</td>
							<td>010-4567-7654</td>
							<td>mary@example.com</td>
							<td>2017-05-10</td>
						</tr>
						 -->
						<%=sb.toString()%>
					</tbody>
				</table>

				<div>
					<button type="button" class="btn btn-default">Count <span class="badge"><%=count%></span></button>
					<button	type="button" class="btn btn-default" >Previous</button>
					<button	type="button" class="btn btn-default" >Next</button>
				</div>
								
			</div>
		</div>

	</div>

</body>
</html>