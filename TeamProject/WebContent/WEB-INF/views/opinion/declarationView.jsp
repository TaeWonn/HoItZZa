<%@page import="opinion.model.vo.Opinion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page import="free.model.vo.Free, java.util.*,comment.model.vo.*"%>
<%
	Opinion f = (Opinion)request.getAttribute("declaration");
	String title="";
%>
<link
	href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/boardForm.css" />
<article style="text-align: center;">
<style>
.ed_box {
	color: rgb(122, 122, 122);
	font-size: 9px;
	width: 630px;
	margin: auto;
}

.ed_box span {
	float: left;
	margin: 5px;
}

.ed_box a {
	float: right;
	margin-top: 5px;
}

#buttons {
	width: 58%;
}

#buttons button {
	position: relative;
	/* left: 20%; */
	float: right;
	width: 50px;
	height: 28px;
	font-size: 16px;
	margin: 5px;
}

#buttons :first-child {
	color: rgb(102, 61, 179);
	margin:0 15px 0 0;
}

/* #buttons :first-child {
	color: rgb(0, 0, 0);
	margin-top: 5px;
}

#buttons :last-child {
	color: rgb(102, 61, 179);
	margin: 5px;
} */
#min_index {
	border-spacing: 2px;
	border-collapse: separate;
	margin-top: 5px;
	margin-left: 5%;
	border-top: 1px solid #7a82f1;
	border-bottom: 1px solid #7a82f1;
	width: 58%;
	font-size: 10px;
}

#min_index tr {
	height: 10px;
}

#min_index tr td {
	width: 590px;
}

#div1 {
	width: 58%;
	margin-left: 19.5%;
	border-top: 1px solid rgb(28, 4, 117);
	background-color: rgb(230, 234, 236)
}

#min_index td {
	float: left;
	font-size: 8px;
	color: rgb(153, 153, 153);
	font-weight: bold;
}

#min_index tr:not (:last-child ) td {
	border-bottom: 0.1px solid lightgray;
	padding-bottom: 5px;
	width: 600px;
}

#k_span {
	float: right;
	margin: 5px;
	font-size: 11px;
	color: red;
	font-weight: bold;
}

#message_href {
	font-size: 9px;
	color: cadetblue;
	text-decoration: none;
	position: relative;
	left: 33%;
	border: none;
	background: white;
	margin-top: 6px;
}
#boardContent{
text-align: left;
}
div#div-comment{position:relative;height: 100px;top:6px;}

table#tbl-comment #CommentContents{border-bottom: 1px solid gray;} 
table#tbl-comment #CommentContentsReply{border-bottom: 1px solid gray;} 
table#tbl-comment button{border-radius: 20%;}
table#tbl-comment tr.level2 td:first-of-type{padding-left: 40px;} 

div.comment-editor{position:relative;top:25px;}
div#div-comment{height: 140px;}

</style>
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
		style="width: 590px; height: 400px; border: 0.2px solid lightgrayv; margin: auto;">
		<div style="width: 100%; border: 1px solid;">파일내려받기 or 거래방식 넣을곳임</div>
		<%=f.getBoardContent() %>
		
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