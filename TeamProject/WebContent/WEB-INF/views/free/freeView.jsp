<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page import="free.model.vo.Free, java.util.*,comment.model.vo.*"%>
<%
	Free f = (Free) request.getAttribute("free");
	List<Comment> commentList = (List<Comment>) request.getAttribute("clist");
	
	String title="";
	String link="";
	if(f.getBoardNo().contains("FC_")){
		title="잡담게시판";	
		link="/jabdamComment";	
		}else if(f.getBoardNo().contains("FU_")){
			title="유용한 생활지식 게시판";
			link="/senseComment";
		}else if(f.getBoardNo().contains("FE_")){
				title="연예/미디어";
				link="/mediaComment";
		}else{
			title="나눔게시판";
			link="/nanumComment";
		}
%>
<link
	href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap"
	rel="stylesheet">
	
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardView.css" />
<style>

#boardContent div{
	text-align: left;	
}
div#min_div{
	text-align: left;
	margin: 10px;
}
</style>
<article style="text-align: center;">
	<h2 style="text-align: center;"><%=title%></h2>
	<div id="div1">

		<span id="boardTilte" name="boardTilte"><%=f.getBoardTitle()%></span>
		<span id="k_span">free</span>
	</div>
	<div class="ed_box">
		<span class="id"><%=f.getBoardWriter()%></span> <span
			class="ed text-xsmall text-muted"><%=f.getBoardDate() %></span> <span
			class="ed text-xsmall text-muted">조회수 <%=f.getBoardReadCounter() %></span>
		<%if(userLoggedIn != null){ %>
		<a onclick="reply('<%=userLoggedIn.getUserId() %>','<%=f.getBoardWriter() %>');"
			id="message_href">☏ 쪽지보내기</a>
		<% } %>
	</div>

	<div id="boardContent"
		style="width: 590px; border: 0.2px solid lightgrayv; margin: auto;">
		<div style="width: 100%; border: 1px solid; margin-top: 28px; margin-left: -16px;" >파일내려받기 or 거래방식 넣을곳임</div>
		<div style="width: 100%; margin-left: -16px; min-height: 200px; margin-top: 10px;">
		<%=f.getBoardContent() %>
		</div>
		
	</div>
	<div id="min_div" style="margin-left: 15%;">
			<table id="min_index">
				<tr>
					<td><a href="<%=request.getContextPath()%>/free/freeView?<%=f.getBoardNo()+1%>">이전글
							제목 </a></td>
				</tr>
				<tr>
					<td><a href="">다음글 제목 ~~~~~~~~~~~~~~~~~</a></td>
				</tr>
			</table>
		</div>
	<div id="buttons">
	<% if(userLoggedIn!=null&&( userLoggedIn.getUserId().equals(f.getBoardWriter())||userLoggedIn.getUserId().equals("admin"))){ %>
		<input type="button" onclick="updateFreeBoard('<%=f.getBoardNo()%>');" value="수정">
		<input type="button" onclick="checkDelete();" value="삭제">
	<% } %>
		<button type="button" disabled>목록</button>
	</div>
	<div id="comment-container" style="text-align: center;">
			<div class="comment-editor">
				<form action="<%=request.getContextPath()%>/free<%=link %>"
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
					<colgroup>
						<col width="130px" />
						<col width="50px" />
					</colgroup>
					<%if(!commentList.isEmpty()) {
						for(Comment bc: commentList){
							if(bc.getCommentLevel()==1){%>
					<!-- 댓글인경우 -->
					<tr class="level1">
						<td id="CommentContents"><sub class="comment-writer"><%=bc.getCommentWriter() %></sub>
							<sub class="comment-date"><%=bc.getCommentDate() %></sub> <br />
							<%=bc.getCommentContent() %></td>
						<td style="text-align: center; width: 110px;">
							<button class="btn-reply" value="<%=bc.getCommentNo() %>">답글</button>
							<%-- 삭제버튼 추가 --%> <%if(userLoggedIn!=null 
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
							<sub class="comment-date"><%=bc.getCommentDate() %></sub> <br />
							↳<%=bc.getCommentContent() %></td>
						<td >
							<%-- 삭제버튼 추가 --%> <%if(userLoggedIn!=null && ("admin".equals(userLoggedIn.getUserId()) 
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

//대댓글 달기
$(function() {
	 //대댓글입력
   $(".btn-reply").click(function(){
       /* 로그인여부확인 */
       <% if(userLoggedIn == null){ %>
           loginAlert();
       <% } else {%>
           var tr = $("<tr></tr>");
           var html = '<td style="display:none; text-align:left;" colspan="2">';
           html += '<form action="<%=request.getContextPath()%>/free/<%=link%>" method="post">';
           html += '<textarea name="commentContent" cols="60" rows="3"></textarea>';
           html += '<input type="hidden" name="boardNo" value="<%=f.getBoardNo() %>" />';
           html += '<input type="hidden" name="commentWriter" value="<%=userLoggedIn!=null?userLoggedIn.getUserId():""%>" />';
           html += '<input type="hidden" name="commentLevel" value="2" />';
           html += '<input type="hidden" name="commentNoRef" value="'+$(this).val()+'" />';
           html += '<button type="submit" class="btn-insert2">등록</button>';      
           html += '</form></td>';
     
           tr.html(html);
           tr.insertAfter($(this).parent().parent()).children("td").slideDown(800);
       
           //답글버튼을 연속적으로 누르지 않도록 핸들러제거
           $(this).off('click');
           
           //새로생성한 요소에 대해 submit이벤트 핸들러 작성
           tr.find("form").submit(function(e){
               //댓글 textarea 유효성검사
               var content = $(this).children("textarea").val().trim();
               if(content.length == 0){
                   e.preventDefault();
               }
           });
       <% } %>
   });
	 
   //댓글 삭제 기능
   $('.btn-delete').click(function(){
		 var bool=confirm('댓글을 삭제하시겠습니까??');
		 if(bool){}
		 location.href="<%=request.getContextPath()%>/free/freeCommentDelete?commentNo="+$(this).val()+"&boardNo=<%=f.getBoardNo()%>";
	 });
	
});


</script>
</article>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>