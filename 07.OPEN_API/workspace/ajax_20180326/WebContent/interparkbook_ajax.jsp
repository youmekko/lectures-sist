<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	//JSP code
	request.setCharacterEncoding("UTF-8");
	String contextRoot = request.getContextPath();
	StringBuilder sb = new StringBuilder();
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
div#input:hover, div#output:hover {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
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

	});
</script>
</head>
<body>

	<div class="container">

		<div class="panel page-header" style="text-align: center;">
			<h1 style="font-size: xx-large;">
				<a href="interparkbook_ajax.jsp"><img src="<%=contextRoot%>/resources/img/sist_logo.png"
					alt="sist_logo.png"></a> 인터파크 도서 검색 <small>v2.0</small> <span
					style="font-size: small; color: #777777;"></span>
			</h1>
		</div>

		<div class="panel panel-default" id="input">
			<div class="panel-heading">도서 검색</div>
			<div class="panel-body">

				<!-- 스크립트에서 객체 접근을 위한 식별자 추가 -->
				<form class="form-inline" id="myForm" onsubmit="return false;">
					<select class="form-control" id="key" name="key">
						<option value="title">Title</option>
						<option value="author">Author</option>
						<option value="publisher">Publisher</option>
						<option value="isbn">ISBN</option>
					</select> <input type="text" class="form-control" id="value" name="value"
						placeholder="Search" style="width: 30%" required="required">

					<!-- Ajax 요청을 위한 일반 버튼 설정 -->
					<button class="btn btn-default" type="button"
						onclick="clickButton(this)">
						<i class="glyphicon glyphicon-search"></i><span>Search</span>
					</button>

				</form>
			</div>
		</div>


		<div class="panel panel-default" id="output">
			<div class="panel-heading">도서 검색 결과</div>

			<!-- 도서 검색 결과를 Ajax 응답 결과를 가지고 출력 -->
			<div class="panel-body">
				<button type="button" class="btn btn-default totalResults">
					TotalRows <span class="badge">0</span>
				</button>
				<!-- <span style="font-size: small; color: #777777;">결과는 최대
					100건까지만 출력됩니다.</span> -->

				<div id="book-list-box">				
				</div>

			</div>
			
			<div class="panel-footer">
			
				<!-- 더보기 버튼 추가 -->
				<button type="button" class="btn btn-default btn-block btnMore" onclick="moreButton(this)" disabled="disabled">더보기...</button>
			
			</div>
		</div>

	</div>

	<script>
	
		//일련번호 관리를 위한 전역 변수 선언
		var count = 0;
		
		function clickButton(obj) {
			
			//검색 버튼 비활성 -> 추가 검색 진행 차단
			obj.setAttribute("disabled", "disabled");
			
			//더보기 버튼 활성 -> 초기 비활성 상태 제거
			document.querySelector("button.btnMore").removeAttribute("disabled");

			//사용자가 입력(선택)한 key, value 확인
			var key = document.querySelector("select#key").value;
			var value = document.querySelector("input[type='text']#value").value;
			
			//검색 요청시 최초 페이지(start)는 1부터 시작
			var start = "1";

			//Ajax를 이용한 검색 요쳥
			myFunction(key, value, start);
			
		}
		
		function myFunction(key, value, start) {
			
			//서버로 전송하기 위한 값 설정
			var obj = { "key":key, "value":value, "start":start };
		    var param = JSON.stringify(obj);
		    
		    //Ajax 요청 및 응답 처리
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					
					//서버로부터 Ajax 응답받은 XML 문서에 대한 파싱 및 동적 태그 생성
					var xmlDoc = this.responseXML;
					console.log(xmlDoc);
					
					var totalResults = xmlDoc.querySelector("totalResults").textContent;
					document.querySelector("button.totalResults span").innerHTML = totalResults;

					var txt = "";
					
					if (totalResults == "0") {
						txt += "<div class=\"row\" style=\"margin-top:30px; border-top:1px dashed #e5e5e5; padding-top:20px;\">";
						txt += "<div class=\"col-sm-12\" style=\"text-align:center;\">검색 결과가 없습니다.</div>";
						txt += "</div>";
					} else {
					
						x = xmlDoc.querySelectorAll("item");
						for (i = 0; i < x.length; i++) {
							
							++count;
							
							txt += "<div class=\"row\" style=\"margin-top:30px; border-top:1px dashed #e5e5e5; padding-top:20px;\">";
							txt += "<div class=\"col-sm-1\">"+count+"</div>";
							txt += "<div class=\"col-sm-2\"><img src=\""+x[i].querySelector("coverSmallUrl").textContent+"\" alt=\""+x[i].querySelector("coverLargeUrl").textContent+"\"></div>";
							txt += "<div class=\"col-sm-7\">";
							txt += "<ul>";
							txt += "<li><strong>title</strong> "+x[i].querySelector("title").textContent+"</li>";
							txt += "<li><strong>description</strong> "+x[i].querySelector("description").textContent+"</li>";
							txt += "<li><strong>publisher</strong> "+x[i].querySelector("publisher").textContent+"</li>";
						 	txt += "<li><strong>author</strong> "+x[i].querySelector("author").textContent+"</li>";
							txt += "<li><strong>priceStandard</strong> "+x[i].querySelector("priceStandard").textContent+"</li>";
							txt += "<li><strong>isbn</strong> "+x[i].querySelector("isbn").textContent+"</li>";
							txt += "<li><strong>pubDate</strong> "+x[i].querySelector("pubDate").textContent+"</li>";
							txt += "</ul>";
							txt += "</div>";
							txt += "<div class=\"col-sm-2\">";
							txt += "<button type=\"button\" class=\"btn btn-default btn-xs\" onclick=\"window.open('"+x[i].querySelector("link").textContent+"')\">인터파크 상세보기</button>";
							txt += "</div>";
							txt += "</div>";
						}
						
					}
					
					//서버로부터 받은 응답을 누적 출력한다.
					document.querySelector("div#book-list-box").innerHTML += txt;

					//더보기버튼에 대한 페이지 번호 설정
					document.querySelector("button.btnMore").value = start;
					
					//더보기버튼에 대한 활성/비활성 결정
					if (count == parseInt(totalResults)) {
						document.querySelector("button.btnMore").setAttribute("disabled", "disabled");
					}
					
				}
			};
			/* 
			xmlhttp.open("GET", "getBookList.jsp?x=값", true);
			xmlhttp.send();
			 */
		    xmlhttp.open("POST", "getBookList.jsp", true);
		    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		    xmlhttp.send("x=" + param);
		    
		}
		
		
		function moreButton(obj) {
			
			//기존 key, value와 함께 start만 새로운 페이지 요청
			var key = document.querySelector("select#key").value;
			var value = document.querySelector("input[type='text']#value").value;
			
			//더보기버튼의 value값을 이용한 새로운 페이지 연산
			var start = (parseInt(obj.value) + 1).toString();
			
			//Ajax를 이용한 검색 요쳥
			myFunction(key, value, start);
			
		} 
		

	</script>

</body>
</html>