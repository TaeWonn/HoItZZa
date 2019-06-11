<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%--isErrorpage=true 설정을 통해 exeption 내장객체에 접근할 수 있다. --%>
<%
	int status = response.getStatus(); //에러번호 404,500
	String errorMessage = exception!=null?exception.getMessage():status+"";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<style>
#container{
	text-align: center;
	width: 500px;
	margin: 0 auto;
	border : 3px solid red;
	border-radius : 30px;
}
.e-msg{
	color: red;
	font-size: 2em;
}
</style>
</head>
<body>
	<div id="container">
		<h2>오류</h2>
		<p class="e-msg"><%=errorMessage%></p>
		<p>관리자에게 문의하세요</p>
		<a href="<%=request.getContextPath()%>">메인페이지로 돌아가기</a>
	</div>
</body>
</html>

