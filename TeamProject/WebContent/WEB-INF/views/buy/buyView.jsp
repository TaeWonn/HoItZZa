<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="buy.model.vo.Buy, java.util.*,comment.model.vo.*" %>
<%
Buy b = (Buy)request.getAttribute("buy");

List<Comment> commentList = (List<Comment>)request.getAttribute("cList");
%>
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrap cdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardView.css" />
<article id="article">

    <h2 style="text-align: center;">구매 게시판</h2>
    <div id="div1" style="text-align: center;">
       
        <span id="boardTitle" name="boardTilte" ><%=b.getBoardTitle() %></span>
        <span id="k_span"><%=b.getBoardCodeNo() %></span>
    </div>
    <div class="ed_box">
        <span class="id"><%=b.getBoardWriter()%></span>
        <span class="ed text-xsmall text-muted"><%=b.getBoardDate() %></span>
        <span class="ed text-xsmall text-muted">조회수 <%=b.getBoardReadCounter() %></span>
       <%if(userLoggedIn != null){ %> 
        <a onclick="reply('<%=userLoggedIn.getUserId() %>','<%=b.getBoardWriter() %>');"
         id="message_href" >☏ 쪽지보내기</a>
              <% } %> 
	</div>

        <div id="boardContent" style="width: 590px; height:400px; border: 0.2px solid lightgrayv; margin: auto;">
			<div style="width: 100%; border: 1px solid; margin-top: 28px; margin-left: -16px;" >파일내려받기 or 거래방식 넣을곳임</div>
			<div style="width: 100%; margin-left: -16px; min-height: 360px;">
				<%=b.getBoardContent() %>
			</div>
        </div>

        <div id="min_div" style="margin-left: 15%;">
        <table id="min_index">
			<tr>
			<td><a href>이전글 제목 ~~~~~~~~~~~~~~~~~</a></td>  
			</tr>
			<tr>
			<td><a href>다음글 제목 ~~~~~~~~~~~~~~~~~</a></td>  
			</tr>
			</table>
		</div>
			<Br>
	<div id="buttons">
        <% if(userLoggedIn!=null && 
        (b.getBoardWriter().equals(userLoggedIn.getUserId())
        || "admin".equals(userLoggedIn.getUserId())) ){ %>
            <input type="button" value="수정" 
            	   onclick="location.href='<%=request.getContextPath()%>/buy/buyModified?boardNo=<%=b.getBoardNo()%>'"/>
            <input type="button" value="삭제" onclick="deleteBoard();"/>
     
   		 <%} %>	
           <button type="button" onclick="location.href='<%=request.getContextPath()%>/buy/buyList'">목록</button>
	</div>
	<div id="comment-container" style="text-align: center;">
		<div class="comment-editor">
			<form action="<%=request.getContextPath()%>/buy/buyComment"
				  name="boardCommentFrm"
				  method="post">
				<textarea name="commentContent" 
						  cols="70" rows="2" maxlength="65" placeholder="65자까지만 작성 할 수 있습니다."></textarea>
				<button type="submit" id="btn-insert" style="position: relative; top: -9px;">등록</button>	  
				<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>" />  
				<input type="hidden" name="commentWriter" value="<%=userLoggedIn!=null?userLoggedIn.getUserId():""%>" />
				<input type="hidden" name="commentLevel" value="1" />
				<input type="hidden" name="commentNoRef" value="0" />
			
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
						<td id="CommentContents">
							<sub class="comment-writer"><%=bc.getCommentWriter() %></sub>
							<sub class="comment-date"><%=bc.getCommentDate() %></sub>
							<br />
							<%=bc.getCommentContent() %>
						</td>
						<td style="text-align: center; width: 110px;">
							<button class="btn-reply" value="<%=bc.getCommentNo() %>" >답글</button>
							<%-- 삭제버튼 추가 --%>
							<%if(userLoggedIn!=null 
								&& ("admin".equals(userLoggedIn.getUserId()) 
										|| bc.getCommentWriter().equals(userLoggedIn.getUserId()) )){%>
							<button class="btn-delete" value="<%=bc.getCommentNo()%>">삭제</button>
							<%} %>
						</td>
					</tr>
			
			<%			
					}
					else{
			%>			
					<!-- 대댓글인경우 -->	
					<tr class="level2">
						<td id="CommentContentsReply">
							<sub class="comment-writer">↳<%=bc.getCommentWriter()%></sub>
							<sub class="comment-date"><%=bc.getCommentDate() %></sub>
							<br />
							<%=bc.getCommentContent() %>
						</td>
						<td>
						<%-- 삭제버튼 추가 --%>
						<%if(userLoggedIn!=null 
							&& ("admin".equals(userLoggedIn.getUserId()) 
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



          


<script>

function reply(sender,recipient){
	//사용자가 sender, 받는사람이 recipient
	var url ="<%=request.getContextPath()%>/views/message/messageReply?senderId="+sender+"&recipient="+recipient;
	var title="쪽지 보내기";
	var specs="width=460px, height=500px, left=500px, top=200px";
	var popup=open(url, title,specs);

}

function deleteBoard(){
	if(!confirm("정말 삭제하시겠습니까?")) return;
	//삭제처리후 돌아올 현재게시판번호도 함께 전송함.
	location.href="<%=request.getContextPath()%>/buy/buyDelete?boardNo=<%=b.getBoardNo()%>";
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
           var html = '<td style="display:none; text-align:left; " colspan="2">';
           html += '<form action="<%=request.getContextPath()%>/buy/buyComment" method="post">';
           html += '<textarea name="commentContent" cols="60" rows="3"></textarea>';
           html += '<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>" />';
           html += '<input type="hidden" name="commentWriter" value="<%=userLoggedIn!=null?userLoggedIn.getUserId():""%>" />';
           html += '<input type="hidden" name="commentLevel" value="2" />';
           html += '<input type="hidden" name="commentNoRef" value="'+$(this).val()+'" />';
           html += '<br><button style="margin-left: 396px;" type="submit" class="btn-insert2">등록</button>';      
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
			 location.href="<%=request.getContextPath()%>/buy/buyCommentDelete?commentNo="+$(this).val()+"&boardNo=<%=b.getBoardNo()%>";
	 });
});



</script>


</article>
</html>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>