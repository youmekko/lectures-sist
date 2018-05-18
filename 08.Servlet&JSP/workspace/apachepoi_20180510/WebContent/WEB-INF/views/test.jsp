<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- jstl-1.2.jar 파일 필요 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SIST_쌍용교육센터</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style>
div#input:hover, div#output:hover {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
        
        //Excel
        $("button.btnExcel").on("click", function() {
			if (confirm("자료를 Excel 형식으로 저장할까요?")) {
				location.assign("${pageContext.request.contextPath}/test/excel")
			}
        });
        
	});


</script>
</head>
<body>
	<div class="container">

		<div class="panel page-header" style="text-align:center;">
			<h1 style="font-size:xx-large;">
				<a href="${pageContext.request.contextPath}/test/test"><img src="${pageContext.request.contextPath}/img/sist_logo.png" alt="sist_logo.png"> </a>
				Excel Download <small>v1.0</small>
			</h1>
		</div>


		<div class="panel panel-default" id="output">
			<div class="panel-heading">다운로드 테스트</div>
			<div class="panel-body">

				<form class="form-inline" method="post">
					<div class="form-group">
						<button	type="button" class="btn btn-default btnExcel" >Excel<span class="glyphicon glyphicon-download-alt"></span></button>
					</div>
				</form>
								
			</div>
		</div>

	</div>

</body>
</html>