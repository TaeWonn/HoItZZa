<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
	String loc = request.getContextPath() + (String)request.getAttribute("loc");
	String close = (String)request.getAttribute("close");
	if(close==null) close ="";
	
	
%>
<script>
	<%if(msg!=null){%>
	alert("<%=msg%>");
	<%}%>
	
	<%=close%>
	location.href = "<%=loc%>";
	
	//주소창에 파라미터 값 숨기기
	history.replaceState({}, null, location.pathname);
</script>