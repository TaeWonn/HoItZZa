<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user/findId.css" />

<%
String userIdResult=(String)request.getAttribute("userId");
/* String userIdResult="abcdefg"; */
String str=userIdResult.substring((userIdResult.length()-3), userIdResult.length());

String result=userIdResult.replaceAll("["+str+"]","*");
System.out.println(result);
userIdResult=result;
%>

<article id="article">
<h1>회원 정보 찾기</h1>
	<div id="findUserIdSucess">
		<table>
		<tr>
			<th>아이디</th>
			<td>
			<input type="text"  id="viewId" readonly />
			</td>
		</tr>
		<tr>
		<th></th>
		<td>
		<button type="button" class="btn btn-info" id="bt_1">비밀번호 찾기</button>
		<button type="button" class="btn btn-info" >홈으로</button>
		</td>
		</tr>
		</table>
	</div>
</article>	

<script>

$(function(){
	<%if(userIdResult!=null){ %>
	
		$('#viewId').val('<%=userIdResult%>');
	<%}%>
});
//주소창에 파라미터 값 숨기기
history.replaceState({}, null, location.pathname);
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>