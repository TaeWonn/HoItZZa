<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ page import="sell.model.vo.Sell, java.util.*,comment.model.vo.*" %>
<%
Sell b = (Sell)request.getAttribute("sell");

List<Comment> commentList = (List<Comment>)request.getAttribute("cList");
System.out.print(b.getBoardNo());
%>
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/boardForm.css" /> 
  <style>

 .ed_box{
 			color: rgb(122, 122, 122);
            font-size: 9px;
            width: 630px;
            margin : auto;
        }
        .ed_box span{
        float : left;
            margin: 5px;
         }
         .ed_box a{
        float : right;
            margin-top: 5px;
         }
       
        #buttons{
            width: 58%;
            float: right;
        }
        #buttons button{
        position : relative;
        left : 20%;
            width: 80px;
            height: 35px;
         	

            font-size: 16px;
        }
        #buttons :first-child{
            
            color: rgb(0, 0, 0);
            margin-top: 5px;
            
        }
        #buttons :last-child{
            color: rgb(102, 61, 179);
            margin: 5px;
        }
    #min_index{
        border-spacing: 2px;
        border-collapse: separate;
        margin-top : 5px;
        margin-left : 5%;
        border-top: 1px solid #7a82f1; 
        border-bottom: 1px solid #7a82f1; 
        width: 58%;
        font-size: 10px;
    } 
    #min_index tr{
        height: 10px;
    }
    #min_index tr td{
    width: 590px;
  
    }
    #div1{
width: 58%; 
margin-left: 19.5%;
border-top: 1px solid rgb(28, 4, 117); 
background-color: rgb(230, 234, 236)}
    #min_index td{
    	float: left;
 
        font-size: 8px;
        color: rgb(153, 153, 153);
        font-weight: bold; 
    }
    #min_index tr:not(:last-child) td {
        border-bottom: 0.1px solid lightgray;
        padding-bottom: 5px;
       width: 600px;
    }
  	
  	#k_span{
  	float: right; margin: 5px; 
  	font-size: 11px; color: red; 
  	font-weight: bold;
  	}
  	#message_href{
  	font-size: 9px; color: cadetblue; 
  	text-decoration: none; position: 
  	relative; left : 4%
  	}
  	
    </style>

<article id="article">

    <h2 style="text-align: center;">판매 게시판</h2>
    <div id="div1">
        <form action="">
        <span id="boardTilte" name="boardTilte" ><%=b.getBoardTitle() %></span>
        <span id="k_span"><%=b.getBoardCodeNo() %></span>
    </div>
    <div class="ed_box">
        <span class="id"><%=b.getBoardWriter()%></span>
        <span class="ed text-xsmall text-muted"><%=b.getBoardDate() %></span>
        <span class="ed text-xsmall text-muted">조회수 <%=b.getBoardReadCounter() %></span>
        <a onclick="reply('<%=userLoggedIn.getUserId() %>','<%=b.getBoardWriter() %>');"
         id="message_href" >☏ 쪽지보내기</a>
            </span>     
        </div>

        <div id="boardContent" style="width: 590px; height:400px; border: 0.2px solid lightgrayv; margin: auto;">
<div style="width: 100%; border: 1px solid;" >파일내려받기 or 거래방식 넣을곳임</div>
        </div>
        
        
        
        
        
        <div id="min_div" style="margin-left: 15%;">
        <table id="min_index">

<tr>
<td><a href>이전글 제목 ~~~~~~~~~~~~~~~~~</a></td>  
</tr>
<td><a href>다음글 제목 ~~~~~~~~~~~~~~~~~</a></td>  
</tr>
</div>
</table>
<Br>

<div id="comment-container" style="text-align: center;">
	<div class="comment-editor">
		<form action="<%=request.getContextPath()%>/sell/sellComment"
			  name="boardCommentFrm"
			  method="post">
			<textarea name="boardCommentContent" 
					  cols="60" rows="3"></textarea>
			<button type="submit" id="btn-insert">등록</button>	  
			<input type="hidden" name="boardRef" value="<%=b.getBoardNo() %>" />  
			<input type="hidden" name="boardCommentWriter" value="<%=userLoggedIn!=null?userLoggedIn.getUserId():""%>" />
			<input type="hidden" name="boardCommentLevel" value="1" />
			<input type="hidden" name="boardCommentRef" value="0" />
		
		</form>
	</div>
	
	<!-- 댓글목록 테이블 -->
	<table id="tbl-comment">
	<%if(!commentList.isEmpty()) {
		for(Comment bc: commentList){
			if(bc.getCommentLevel()==1){
	%>
			<!-- 댓글인경우 -->
			<tr class="level1">
				<td>
					<sub class="comment-writer"><%=bc.getCommentWriter() %></sub>
					<sub class="comment-date"><%=bc.getCommentDate() %></sub>
					<br />
					<%=bc.getCommentContent() %>
					
				</td>
				<td>
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
				<td>
					<sub class="comment-writer"><%=bc.getCommentWriter()%></sub>
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



       <div id="buttons">
      <%--  <% if(userLoggedIn!=null && 
        (b.getBoardWriter().equals(userLoggedIn.getUserId())
        || "admin".equals(userLoggedIn.getUserId())) ){ %> --%>
   
       
            <input type="button" value="수정" 
            	   onclick="location.href='<%=request.getContextPath()%>/board/boardUpdate?boardNo=<%=b.getBoardNo()%>'"/>
            <input type="button" value="삭제" onclick="deleteBoard();"/>
     
    
    
 <%--    <%} %>	 --%>
           <button type="button" onclick="location.href='<%=request.getContextPath()%>/sell/sellList'">목록</button>
        </div>              



<script>

function reply(sender,recipient){
	//사용자가 sender, 받는사람이 recipient
	var url="<%=request.getContextPath()%>/views/message/messageReply?senderId="+sender+"&recipient="+recipient;
	var title="쪽지 보내기";
	var specs="width=460px, height=500px, left=500px, top=200px";
	var popup=open(url, title,specs);

}

function deleteBoard(){
	if(!confirm("정말 삭제하시겠습니까?")) return;
	//삭제처리후 돌아올 현재게시판번호도 함께 전송함.
	location.href="<%=request.getContextPath()%>/sell/sellDelete?boardNo=<%=b.getBoardNo()%>";
}

</script>


</article>
</html>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>
