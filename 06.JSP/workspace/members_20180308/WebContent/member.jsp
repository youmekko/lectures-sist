<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.test.*" %>	
<%
		//JSP code
		request.setCharacterEncoding("UTF-8");
		StringBuilder sb = new StringBuilder();
		StringBuilder dept = new StringBuilder();
		int count = 0;
		int totalCount = 0;
		String key = "ALL";
		String value = "";
		
		//검색 기능 구현
		//->key, value 전달 받는다. 주의) 최초 실행시 key, value는 null값이 채워진다.
		//->데이터베이스 자료 검색 기능
		//->결과를 동적 테이블 태그로 구성하고 화면에 출력
		key = request.getParameter("key");
    	value = request.getParameter("value");
        if(key == null){
            key = "ALL";
            value = "";
        }
		
		
		//데이터베이스 정보 읽어온 결과(List<Member>)를 동적 테이블 태그(<table> ~ </table>)로 생성하는 과정 추가
		MemberDAO dao = new MemberDAO();
		
		//전체 인원수 확인 기능
		totalCount = dao.totalCount();
		
		//전체 출력 및 검색 기능
		List<Member> list = dao.list(key, value);
		count = list.size();
		if (count == 0) {
			//출력 자료가 존재하지 않는 경우
			sb.append(String.format("<tr><td colspan=\"7\" style=\"text-align:center;\"> <strong>출력 대상이 없습니다.</strong> </td></tr>"));
		} else {
			//출력 자료가 존재하는 경우
			for(Member m : list){
				/* 삭제 버튼에 이벤트 등록 및 삭제 기능 진행 */
				sb.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td><div class=\"btn-group\"><button type=\"button\" class=\"btn btn-default btn-xs\">Update</button><button type=\"button\" class=\"btn btn-default btn-xs\" onclick=\"location.assign('memberDelete.jsp?mid_=%s')\">Delete</button></div></td></tr>",m.getMid_(),m.getName_(),m.getPhone(),m.getEmail(),m.getRegDate(), m.getDeptName(), m.getMid_()));  
			}
		}

		//부서 정보 읽기용 메소드 호출
		//->동적 <option> 태그 생성
		List<Member> deptList = dao.deptList();
		for (Member m : deptList) {
			dept.append(String.format("<option value =\"%s\">%s</option>", m.getDeptId(), m.getDeptName()));
		}

		//입력 성공, 실패 메시지 출력용 변수
		String ins = request.getParameter("ins");
		String insMsg = "";
		if (ins == null) {
			//최초 실행시 메시지
		} else {
			if (ins.equals("1")) {
				//성공 메시지
				insMsg = "<span class=\"text-success\"><strong>Success!</strong> 회원 정보가 입력되었습니다.</span>";
			} else if (ins.equals("0")) {
				//실패 메시지
				insMsg = "<span class=\"text-danger\"><strong>Fail!</strong> 회원 정보 입력이 실패했습니다.</span>";
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

/* 회원정보 입력, 회원정보 출력 DIV 영역에 CSS Shadow Effects 지정 */
div#input:hover, div#output:hover {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}

</style>

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script>
	$(document).ready(function() {

		//검색 진행하는 경우 key, value를 가지고 현재 컨트롤의 상태를 이전값으로 설정 필요.
		var key = "<%=key%>";
		var value = "<%=value%>";
        $("select#key > option[value="+key+"]").attr("selected","selected");
        $("input#value").val(value);

	});
</script>
</head>
<body>

	<div class="container">

		<div class="panel page-header" style="text-align:center;">
			<h1 style="font-size:xx-large;">
				<a href=""><img src="img/sist_logo.png" alt="sist_logo.png"> </a>
				회원관리 <small>v3.1</small> <span style="font-size:small; color: #777777;">A website that manages personal information for members</span>
			</h1>
		</div>

		<div class="panel panel-default" id="input">
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
					
					<div class="form-group">
						<!-- 주의) type="date" 속성 지정된 입력폼 사용시 
						  입력된 자료가 date 형식이 틀린 경우 서브밋 진행 불가 -->
						<label for="regDate">RegDate:</label> <input type="date"
							class="form-control" id="regDate" name="regDate">
					</div>
										
					<div class="form-group">
					  <label for="deptId">DeptName:</label>
					  <select class="form-control" id="deptId" name="deptId">
					  	<!-- 주의) option 태그의 value="" 속성에는 데이터베이스에 저장될 정보인 부서코드를 지정한다. -->
					  	<!-- 
					    <option value="B01">개발부</option>
					    <option value="B02">마케팅부</option>
					     -->
					    <%=dept.toString()%>
					  </select>
					</div>					
					
					
					<button type="submit" class="btn btn-default">Submit</button>
					<!-- 입력 성공, 실패 메시지 출력 -->
    				<%=insMsg%>
  
				</form>


			</div>
		</div>

		<div class="panel panel-default" id="output">
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
							<th>DeptName</th>
							<th>Update/Delete</th>
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
							<td>개발부</td>
							<td><div class="btn-group"><button type="button" class="btn btn-default btn-xs">Update</button><button type="button" class="btn btn-default btn-xs">Delete</button></div></td>
						</tr>
						<tr>
							<td>M02</td>
							<td>Mary</td>
							<td>010-4567-7654</td>
							<td>mary@example.com</td>
							<td>2017-05-10</td>
							<td>총무부</td>
							<td><div class="btn-group"><button type="button" class="btn btn-default btn-xs">Update</button><button type="button" class="btn btn-default btn-xs">Delete</button></div></td>
						</tr>
						 -->
						<%=sb.toString()%>
						
					</tbody>
				</table>

				<!-- 검색 구현 -->
				<!-- 주의) action="" 속성 생략시 자기 자신에게 전송된다 -->
				<!-- 주의) 검색 결과 출력 후 전체 출력으로 돌아갈 수 있어야 한다. -->
				<form class="form-inline" method="post">
					<div class="form-group">
						<button type="button" class="btn btn-default">TotalCount <span class="badge"><%=totalCount%></span></button>
						<button type="button" class="btn btn-default">Count <span class="badge"><%=count%></span></button>
						<button	type="button" class="btn btn-default" ><span class="glyphicon glyphicon-step-backward"></span> Previous</button>
						<button	type="button" class="btn btn-default" >Next <span class="glyphicon glyphicon-step-forward"></span></button>
						
						<!-- 검색 기준 선택 항목 추가 -->
						<select class="form-control" id="key" name="key">
							<option value="mid_">Mid</option>
							<option value="name_">Name</option>
							<option value="phone">Phone</option>
							<option value="email">Email</option>
							<option value="regDate">RegDate</option>
							<option value="deptName">DeptName</option>
						</select>
					</div>
					<div class="input-group">
						<input type="text" class="form-control" id="value" name="value"
							placeholder="Search" >

						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>

								
			</div>
		</div>

	</div>

</body>
</html>