<%@page import="opinion.model.vo.Opinion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../common/error.jsp"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page import="free.model.vo.Free, java.util.*,comment.model.vo.*"%>
<%
	Opinion f = (Opinion)request.getAttribute("declaration");
	String title="";
%>
<link
	href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardView.css" />
<article id="article">
	<h2 style="text-align: center; margin-top: 25px;">건의게시판</h2>
	<div id="div1">

		<span id="boardTilte" name="boardTilte"><%=f.getBoardTitle()%></span>
		<span id="k_span">신고게시판</span>
	</div>
	<div class="ed_box">
		<span class="id"><%=f.getBoardWriter()%></span> <span
			class="ed text-xsmall text-muted"><%=f.getBoardDate()%></span> <span
			class="ed text-xsmall text-muted">조회수 <%=f.getBoardReadCount()%></span>
		<%if(userLoggedIn!=null){ %>
		<input type="button" value="☏쪽지보내기" id="message_href"
			onclick="return reply('<%=userLoggedIn.getUserId() %>','<%=f.getBoardWriter()%>');" />
		<%} %>
	</div>

	<div id="boardContent"
		style="width: 590px; height:400px; border: 0.2px solid lightgrayv; margin: auto;">
        <div style="width: 100%; border: 1px solid; margin-top: 5px; margin-left: -16px;" >파일내려받기 or 거래방식 넣을곳임</div>
        <div style="width: 100%; margin-left: -16px; min-height: 360px; margin-top: 10px;">
			<%=f.getBoardContent() %>
		</div>
		
	</div>
	

	<div id="buttons">
	<% if(userLoggedIn!=null&&( userLoggedIn.getUserId().equals(f.getBoardWriter())||userLoggedIn.getUserId().equals("admin"))){ %>
		<button type="button" onclick="updateFreeBoard('<%=f.getBoardNo()%>');">수정</button>
		<button type="button" onclick="checkDelete();">삭제</button>
	<% } %>
		<button type="button" disabled>목록</button>
	</div>

	<!-- <div id="min_div" style="margin-left: 15%;">
		<table id="min_index">

			<tr>
				<td><a href>이전글 제목 ~~~~~~~~~~~~~~~~~</a></td>
			</tr>
			<tr>
				<td><a href>이전글 제목 ~~~~~~~~~~~~~~~~~</a></td>
			</tr>
			<td><a href>다음글 제목 ~~~~~~~~~~~~~~~~~</a></td>
			</tr>
		</table>
	</div> -->
	
</article>
<script>
function checkDelete() {
	var chk = confirm("게시글을 삭제하시겠습니까?"); 
	if(chk) {
		location.href="<%=request.getContextPath()%>/free/freeDelete?"
			 + "boardNo=<%=f.getBoardNo()%>";
	}
}
function reply(receiver,sender){
	var url="<%=request.getContextPath()%>/views/message/messageReply?senderId="+ sender + "&recipient=" + receiver;
	var title = "쪽지 보내기";
	var specs = "width=400px, height=450px, left=500px, top=200px";
	var popup = open(url, title, specs);
	return false;
}
function updateFreeBoard(boardNo){
	location.href="<%=request.getContextPath()%>/freeBoard/freeBoardUpdate?boardNo="+boardNo;
}


</script>
</article>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>