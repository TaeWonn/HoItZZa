<%@page import="opinion.model.vo.Opinion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../common/error.jsp"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page import="opinion.model.vo.Opinion, java.util.*,comment.model.vo.*"%>
<%
	Opinion f = (Opinion)request.getAttribute("opinion");
	List<Comment> commentList = (List<Comment>)request.getAttribute("cList");
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
		<span id="k_span">건의게시판</span>
	</div>
	<div class="ed_box">
		<span class="id"><%=f.getBoardWriter()%></span> <span
			class="ed text-xsmall text-muted"><%=f.getBoardDate() %></span> <span
			class="ed text-xsmall text-muted">조회수 <%=f.getBoardReadCount() %></span>
		<div id="div-message" style="margin-left: 436px;">
			<%if(userLoggedIn != null){ %>
			<a onclick="reply('<%=userLoggedIn.getUserId() %>','<%=f.getBoardWriter() %>');"
				id="message_href">☏ 쪽지보내기</a> 
			<a onclick="interest_btn('<%=userLoggedIn.getUserId() %>','<%=f.getBoardNo()%>');"
				id="interest_btn">☆ 관심등록</a> 
				<input type="hidden" value="0" id="interest_val">
			<% } %>
		</div>
	</div>

		 <div id="boardContent" style="width: 590px; min-height: 200px; border: 0.2px solid lightgrayv; margin: auto;">
            <div style="width: 100%; border: 1px solid; margin-top: 28px; margin-left: -16px;" >파일내려받기 or 거래방식 넣을곳임</div>
            <div style="width: 100%; margin-left: -16px; min-height: 200px; margin-top: 10px;">
                <%=f.getBoardContent() %>
            </div>
        </div>
	<div id="min_div" style="margin-left: 15%;">
		<table id="min_index">
			<tr>
				<td><a onclick="next_btn();" id="next_btn"> [다음글 : <%-- <%=next.getBoardTitle()!=null?next.getBoardTitle():"다음글 없습니다"%> ] --%></a></td>  
			</tr>
			<tr>
				<td><a onclick="prev_btn();" id="prev_btn"> [이전글 : <%-- <%=prev.getBoardTitle()!=null?prev.getBoardTitle():"이전글 없습니다"%> ] --%></a></td>  
			</tr>
		</table>
	</div>
	<br />
	<div id="buttons">
		<% if(userLoggedIn!=null&&( userLoggedIn.getUserId().equals(f.getBoardWriter())||userLoggedIn.getUserId().equals("admin"))){ %>
			<input type="button" onclick="<%-- updateFreeBoard('<%=f.getBoardNo()%>'); --%>" value="수정">
			<input type="button" onclick="<!-- checkDelete(); -->" value="삭제">
		<% } %>
		<button type="button"  onclick="location.href='<%=request.getContextPath()%>/opinion/opinonList'">목록</button>
	</div>

	<div id="comment-container" style="text-align: center;">
			<div class="comment-editor">
				<form action="<%=request.getContextPath()%>/opinion/opinionComment"
					name="boardCommentFrm" method="post">
					<textarea name="commentContent" cols="70" rows="2" maxlength="65"
						placeholder="65자까지만 작성 할 수 있습니다."></textarea>
					<button type="submit" id="btn-insert"
						style="position: relative; top: -9px;">등록</button>
					<input type="hidden" name="boardNo" value="<%=f.getBoardNo() %>" />
					<input type="hidden" name="commentWriter"
						value="<%=userLoggedIn!=null?userLoggedIn.getUserId():""%>" /> <input
						type="hidden" name="commentLevel" value="1" /> <input
						type="hidden" name="commentNoRef" value="0" />

				</form>
			</div>
			<!-- 댓글목록 테이블 -->
		<div id="div-comment">
			<table id="tbl-comment">
		<%if(!commentList.isEmpty()) {
	
			for(Comment bc: commentList){
				if(bc.getCommentLevel()==1){
			%>
				<!-- 댓글인경우 -->
				<tr class="level1">
					<td id="CommentContents"><sub class="comment-writer"><%=bc.getCommentWriter() %></sub>
						<sub class="comment-date"><%=bc.getCommentDate() %></sub> <br />
						<%=bc.getCommentContent() %></td>
					<td style="text-align: left; width: 120px;">
						<button class="btn-reply" value="<%=bc.getCommentNo() %>">답글</button>
						<!-- 삭제버튼 추가  --><%if(userLoggedIn!=null 

					&& ("admin".equals(userLoggedIn.getUserId()) 
							|| bc.getCommentWriter().equals(userLoggedIn.getUserId()) )){%>
						<button class="btn-delete" value="<%=bc.getCommentNo()%>">삭제</button>
						<%} %>
					</td>
				</tr>

				<%			
		}else{%>
				<!-- 대댓글인경우 -->
				<tr class="level2">
					<td id="CommentContentsReply"><sub class="comment-writer"><%=bc.getCommentWriter()%></sub>
						<sub class="comment-date"><%=bc.getCommentDate() %>
						</sub> <br />↳<%=bc.getCommentContent() %></td>
					<td style="text-align: left; width: 120px;"> 
						<!-- 삭제버튼 추가 --> <%if(userLoggedIn!=null && ("admin".equals(userLoggedIn.getUserId()) 
						|| bc.getCommentWriter().equals(userLoggedIn.getUserId()) )){%>
						<button class="btn-delete" value="<%=bc.getCommentNo()%>">삭제</button>
						<%} %>
					</td>
				</tr>
				<%			
				}//end of if(bc.getBoardCommentLevel()==1)
		
			}//end of for
		
		}//end of if(!commentList.isEmpty())
		%>
			</table>
		</div>
	</div>
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
<%-- function updateFreeBoard(boardNo){
	location.href="<%=request.getContextPath()%>/freeBoard/freeBoardUpdate?boardNo="+boardNo;
} --%>


</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>