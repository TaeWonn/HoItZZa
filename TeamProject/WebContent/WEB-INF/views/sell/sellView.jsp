<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>


<%@ page import="sell.model.vo.Sell, java.util.*,comment.model.vo.*,file.model.vo.*" %>
<%
Sell b = (Sell)request.getAttribute("sell");

Sell prev = (Sell)request.getAttribute("prev");
Sell next = (Sell)request.getAttribute("next");
List<Comment> commentList = (List<Comment>)request.getAttribute("cList");
List<FileTable> file = (List<FileTable>)request.getAttribute("files");
int warningCnt=(int)request.getAttribute("warningCnt");
String reason=(String)request.getAttribute("reason");
%>
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrap cdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" /> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardView.css" /> 
<style>
#warning{color:red;font-size: 14px;}
</style>

<article id="article">

	<h2 style="text-align: center;">판매 게시판</h2>
	<div id="div1" style="text-align: center;">

		<span id="boardTitle" name="boardTilte"><%=b.getBoardTitle() %></span>
		<span id="k_span"><%=b.getBoardCodeNo() %></span>
	</div>
	<div class="ed_box">
		<span class="id"><%=b.getBoardWriter()%></span> 
		<%if(warningCnt!=0){ %>
			<span id="warning">&nbsp; 경고 횟수 : <%=warningCnt %>회 &nbsp; 경고 사유 : <%=reason %></span>
			<%} %>
			<span class="ed text-xsmall text-muted"><%=b.getBoardDate() %></span> <span
			class="ed text-xsmall text-muted">조회수 <%=b.getBoardReadCounter() %></span>
		<div id="div-message">
			<%if(userLoggedIn != null){ %>
			<a onclick="reply('<%=userLoggedIn.getUserId() %>','<%=b.getBoardWriter() %>');"
				id="message_href">☏ 쪽지보내기</a> 
			<a onclick="interest_btn('<%=userLoggedIn.getUserId() %>','<%=b.getBoardNo()%>');"
				id="interest_btn">☆ 관심등록</a> 
				<input type="hidden" value="0" id="interest_val">
			<% } %>
		</div>
	</div>

	  <div id="boardContent" style="width: 590px; height:400px; border: 0.2px solid lightgrayv; margin: auto;">
            <div style="width: 100%; border: 1px solid; margin-top: 28px; margin-left: -16px;" >
            
            <%if(file!=null){for(int i=0;i<file.size();i++){ %>
		<a href="<%=request.getContextPath()%>/sell/fileDownload?oName=<%=file.get(i).getOriginalFileName() %>&rName=<%=file.get(i).getRenamedFileName()%>">
		<img src="<%=request.getContextPath() %>/images/file.png" alt="" />
		<%=file.get(i).getOriginalFileName() %>
		</a>
		<%}}else{ %>
		<%="" %>
		<%} %>
            
            
           	</div>
		<div style="width: 100%; margin-left: -16px; min-height: 200px; margin-top: 10px;overflow: auto;max-height: 350px;;">
		<%for(int i=0;i<file.size();i++){ %>
			<img src="<%=request.getContextPath() %>/upload/sell/<%=file.get(i).getRenamedFileName() %>" alt="" id="imgView" />
		<%} %>
		<%=b.getBoardContent() %>
		</div>
	</div>

	<div id="min_div" style="margin-left: 15%;">
		<table id="min_index">
		<tr>
			<td><a onclick="next_btn();" id="next_btn"> [다음글 : <%=next.getBoardTitle()!=null?next.getBoardTitle():"다음글 없습니다"%> ]</a></td>  
		</tr>
		<tr>
			<td><a onclick="prev_btn();" id="prev_btn"> [이전글 : <%=prev.getBoardTitle()!=null?prev.getBoardTitle():"이전글 없습니다"%> ]</a></td>  
		</tr>

	
		</table>
	</div>
		
		<div id="buttons">
			<% if(userLoggedIn!=null){if(b.getBoardWriter().equals(userLoggedIn.getUserId())
        || "admin".equals(userLoggedIn.getUserId())){ %>

			<input type="button" value="수정"
				onclick="location.href='<%=request.getContextPath()%>/sell/sellModified?boardNo=<%=b.getBoardNo()%>'" />
			<input type="button" value="삭제" onclick="deleteBoard();" />

			<%}} %>
			<button type="button"
				onclick="location.href='<%=request.getContextPath()%>/sell/sellList'">목록</button>
		</div>
		<Br>
		<div id="comment-container" style="text-align: center;">
			<div class="comment-editor">
				<form action="<%=request.getContextPath()%>/sell/sellComment" onsubmit="return checkLogin();"
					name="boardCommentFrm" method="post">
					<textarea name="commentContent" cols="70" rows="2" maxlength="65"
						placeholder="65자까지만 작성 할 수 있습니다."></textarea>
					<button type="submit" id="btn-insert"
						style="position: relative; top: -9px;">등록</button>
					<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>" />
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
							<sub class="comment-date"><%=bc.getCommentDate() %>
							</sub> <br /><%=bc.getCommentContent() %></td>
						<td style="text-align: left; width: 120px;">
							<button class="btn-reply" value="<%=bc.getCommentNo() %>">답글</button>
							<%-- 삭제버튼 추가 --%> 
							<%if(userLoggedIn!=null 
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
						<td id="CommentContentsReply">
						<sub class="comment-writer">↳<%=bc.getCommentWriter()%></sub>
							<sub class="comment-date"><%=bc.getCommentDate() %></sub> <br />
							<%=bc.getCommentContent() %></td>
						<td style="text-align: left; width: 120px;"> 
							<%-- 삭제버튼 추가 --%> <%if(userLoggedIn!=null && ("admin".equals(userLoggedIn.getUserId()) 
							|| bc.getCommentWriter().equals(userLoggedIn.getUserId()) )){%>
							<button class="btn-delete" value="<%=bc.getCommentNo()%>" >삭제</button>
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


function prev_btn() {
	
	if('<%=prev.getBoardTitle()%>'=='null'){
		alert('이전글이 없습니다');
		return;
	} 
	
	var boardNo = '<%=b.getBoardNo()%>';
    var b1 = boardNo.substr(0,2);
    var b2 = Number(boardNo.substr(2))-1;
	boardNo = b1+b2
	console.log(boardNo)
	
 location.href="<%=request.getContextPath()%>/sell/sellView?boardNo=<%=prev.getBoardNo()%>";
}


function next_btn() {
	
	if('<%=next.getBoardTitle()%>'=='null'){
		alert('다음글이 없습니다');
		return;
	} 
	
	var boardNo = '<%=b.getBoardNo()%>';
	 var b1 = boardNo.substr(0,2);
	    var b2 =Number(boardNo.substr(2))+1;
		boardNo = b1+b2
		console.log(boardNo)
		
	 location.href="<%=request.getContextPath()%>/sell/sellView?boardNo=<%=next.getBoardNo()%>";
}


(function on_interest(userId,boardNo) {
	
	$.ajax({
		url: "<%=request.getContextPath()%>/board/boardinterestcheck",
		data: {userId : '<%=userLoggedIn!=null?userLoggedIn.getUserId():""%>', boardNo : '<%=b.getBoardNo()%>'},
		success: function(data){
			console.log(data);
			
			//넘어온 csv데이터가, 공백인경우
			if(data.trim().length == '0'){
				console.log("관심글 x");
				$("#interest_val").val(0);
				$("#interest_btn").text('☆관심등록');
			}
			else{
				console.log("관심글 o");
				$("#interest_val").val(1);
				$("#interest_btn").text('★관심등록');
				}	
			}
	});
})();

//관심글 등록 함수
function interest_btn(userId,boardNo) {
	
 if('<%=b.getBoardWriter()%>'==userId){
		alert('본인글 입니다');
		return;
	} 
	
	if($("#interest_val").val()==0){
		console.log("추가 실행")
	$.ajax({
		
		url: "<%=request.getContextPath()%>/board/boardinterest",
		data: {userId : userId, boardNo : boardNo},
		success: function(data){
			console.log(data);
			
			//넘어온 csv데이터가, 공백인경우
			if(data.trim().length == 0){
				console.log("공백넘어옴");
			}
			else{
					alert("관심글 등록완료");
					$("#interest_val").val(1);
					$("#interest_btn").text('★관심등록');
				}	
			}
	});
	
	} //end if
	else {
		console.log("삭제 실행");
		$.ajax({
			
			url: "<%=request.getContextPath()%>/board/boardinterestdelete",
			data: {userId : userId, boardNo : boardNo},
			success: function(data){
				console.log(data);
				
				//넘어온 csv데이터가, 공백인경우
				if(data.trim().length == 0){
					console.log("공백넘어옴");
				}
				else{
						alert("관심글 제거완료");
						$("#interest_val").val(0);
						$("#interest_btn").text('☆관심등록');
					}	
				}
		});
		
	}//end else
	
}



function reply(sender,recipient){
	//사용자가 sender, 받는사람이 recipient
	var url="<%=request.getContextPath()%>/views/message/messageReply?senderId="+sender+"&recipient="+recipient;
	var title="쪽지 보내기";
	var specs="width=460px, height=500px, left=500px, top=200px";
	var popup=open(url, title,specs);

	
}
function loginAlert(){
	alert('로그인이 필요한 기능입니다.');
}

function checkLogin(){
	if(<%=userLoggedIn==null%>){
		loginAlert();
		return false;
	}else{
		return true;
	}
}

function deleteBoard(){
	if(!confirm("정말 삭제하시겠습니까?")) return;
	//삭제처리후 돌아올 현재게시판번호도 함께 전송함.
	location.href="<%=request.getContextPath()%>/sell/sellDelete?boardNo=<%=b.getBoardNo()%>";
}
function deleteComment(obj){
	console.log(obj.value);
}

$(function() {
	 //대댓글입력
   $(".btn-reply").click(function(){
       /* 로그인여부확인 */
       <% if(userLoggedIn == null){ %>
           loginAlert();
       <% } else {%>
           var tr = $("<tr></tr>");
           var html = '<td style="display:none; text-align:left;" colspan="2">';
           html += '<form action="<%=request.getContextPath()%>/sell/sellComment" onsubmit="return checkLogin();" method="post">';
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
	 

   $('.btn-delete').click(function(){
		 var bool=confirm('댓글을 삭제하시겠습니까??');
		 if(bool){
			 location.href="<%=request.getContextPath()%>/sell/sellCommentDelete?commentNo="+$(this).val()+"&boardNo=<%=b.getBoardNo()%>";
		 }else{
			 return;
		 }
		 
	});
});

</script>
</article>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>