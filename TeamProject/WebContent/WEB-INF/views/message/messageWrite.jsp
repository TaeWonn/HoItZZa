<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.0.js"></script>
<%
	String senderId=(String)request.getAttribute("senderId");
	String receiverId=(String)request.getAttribute("receiver");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/message/messageWriter.css" />
	<article id="messageWritePage">
		<h2 id="title2" >쪽지 보내기</h2>
		
		<form action="<%=request.getContextPath()%>/views/message/messageWrite" method="post" onsubmit="return check();">
			<table id="messageWriteTable">
				<tr>
				<td><span>수신인</span><br />
					<h3><%=receiverId%></h3>
					<input type="hidden" name="recipient" value="<%=receiverId %>" />
						<input type="hidden" name="sender" value="<%=senderId %>" />
				</td>
				</tr>
				<tr >
					<td><textarea onchange="gogo();" id="contentArea"name="content" id="" cols="30" rows="10"></textarea></td>
				</tr>
				<tr>
					<td>
						<input type="button" value="취소" onclick="window.close();" />
						<input type="submit" value="전송하기" />
					</td>
				</tr>
			</table>
		</form>
	
	</article>
<script>

function check(){
	console.log('검사');
	var content=$('#contentArea').val();
	if(content.length==0){
		alert('내용을 입력해주세요.');
		return false;
	}else return true;
}
//주소창에 파라미터 값 숨기기
history.replaceState({}, null, location.pathname);


</script>