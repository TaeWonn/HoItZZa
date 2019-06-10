<%@page import="message.model.vo.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../common/error.jsp"%>

<%
	Message m=(Message)request.getAttribute("message");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/message/messageView.css" />


	<article id="messageWritePage">
		<h2 id="title2" >쪽지</h2>
		
		<form action="<%=request.getContextPath()%>/views/message/messageWrite" method="post" onsubmit="return check();">
			<table id="messageWriteTable">
				<tr>
				<td><span>발신인</span><br />
					<h3><%=m.getSender()%></h3>
				</td>
				</tr>
				<tr >
					<td><textarea readonly id="contentArea"name="content" id="" cols="30" rows="10" ><%=m.getContent()%></textarea></td>
				</tr>
				<tr>
					<td>
						<button onclick="window.close();" id="btn1">닫기</button>
						<button id="btn2" onclick="msgWrite('<%=m.getRecipient() %>','<%=m.getSender() %>');">답장</button>
					</td>
				</tr>
			</table>
		</form>
	
	</article>
	
<script>

function msgWrite(sender,recipient){
	var url="<%=request.getContextPath()%>/views/message/messageReply?senderId="+sender+"&recipient="+recipient;
	var title="쪽지 보내기";
	var specs="width=460px, height=500px, left=500px, top=200px";
	var popup=open(url, title,specs);
	window.close();
}
//주소창에 파라미터 값 숨기기
history.replaceState({}, null, location.pathname);
</script>
