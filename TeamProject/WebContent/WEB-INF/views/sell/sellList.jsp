<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../common/error.jsp"%>
    <%@ page import="sell.model.vo.Sell, java.util.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<Sell> sell = (List<Sell>)request.getAttribute("sellList");
	String pageBar = (String)request.getAttribute("pageBar");
	//header.jsp에 memberLoggedIn변수를 선언했으므로, 이 페이지에서는 선언할 필요 없음.
    //Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
%>
<<<<<<< HEAD
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/boardForm2.css" />    
	<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
 <style>
 .input-group{
 margin-top : 3%;
 margin-left: 30%;
 width: 400px;
 font-size: 12px;
 }
 .input-group *{
  width: 40px;
 height: 25px;
 }
 .input-group select{
 width: 70px;
  margin-top : -3px;
 }
 
 body{
	margin: auto;
}
 
#btn-add{
 margin-right : 25px;
 width : 80px;
 float: right;}

#pageBar{
text-align: center;
width: 300px;
  margin: auto;
  padding: 0px 9px;
  
    border-radius: 5px;
    
    background-color white;
    box-shadow: inset 0px 1px 0px rgba(255,255,255, .8), 0px 1px 3px rgba(0,0,0, .1);
    font-size: .875em;
    font-weight: bold;
    text-decoration: none;
    color: #717171;
    text-shadow: 0px 1px 0px rgba(255,255,255, 1);
}

#pageBar >*{
border-radius: 3px;
 padding: 4px 10px;
	margin: 5px;
  background-color: skyblue;
    color: white;
    font-size : 15px;
    border: solid 1px lightgray;
}

#pageBar >a{
border-radius: 3px;
 padding: 1.5px 7px;
	margin: 5px;
  background-color: #f5f5f5;
    color: #969696;
    border: solid 1px skyblue;
}
 
    .table{
        width: 610px; 
        border: none;
        border-top: 2px solid rgb(196, 192, 192);
        border-bottom: 2px solid rgb(196, 192, 192);
        padding: 15px;
        margin: 20px auto;
        text-align: center;
        font-size: 15px;
    }
    .table #title{
      width: 200px;
    }
    
    .table td, .table tr th{
    border: none;
    border-bottom: 0.5px solid lightgray;
    }
    .thead-light{
    font-size : 14px;}
    </style>
=======
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">    
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />    
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardList.css" />
>>>>>>> refs/remotes/origin/SeUh

<article id="article">

	<br>
	<H3 style="text-align: center; margin-bottom: 10px;">판매게시판</H3>
	<%if(userLoggedIn != null){ %> 
			<input type="button" value="글쓰기" 
				   id="btn-add"
				   onclick="location.href='<%=request.getContextPath()%>/sell/sellWrite'"/>
	<% } %> 

    <table class="table">
        <thead class="thead-light">
          <tr>
            <th scope="col">글번호</th>
            <th scope="col">작성자</th>
            <th scope="col" id="title">제목</th>
            <th scope="col">작성일</th>
            <th scope="col">카테고리</th>
          </tr>
        </thead>
        <tbody>
        <% for(Sell b : sell){ %>
         
          <tr>
            <td><%= b.getBoardNo() %></td>
            <td><%=b.getBoardWriter() %></td>
            <td><a href="<%=request.getContextPath()%>/sell/sellView?boardNo=<%= b.getBoardNo() %>" style="text-decoration:none; color: black;">
            <%=b.getBoardTitle() %> </a></td>
            <td><%=b.getBoardDate() %></td>
            <td><%=b.getBoardCodeNo() %></td>
    	 </tr>
        <% } %>
        </tbody>
        
      </table>
	<div id="pageBar">
		<%=pageBar %>
	</div>
	
<<<<<<< HEAD
	<div class="input-group">
	<select id="search_category">
	<option value="board_Title" selected>제목</option>
	<option value="board_Writer">작성자</option>
	<option value="board_Content">내용</option>
	<option value="board_CodeName">카테고리</option>
	</select>
  <input class="form-control" placeholder="검색어를 입력하세요" id="search_key"/>
  <input type="button" value="검색" onclick="search_category();">
</div>
=======
	 
	<div class="input-group">
		<select>
			<option value="boardTitle" selected>제목</option>
			<option value="boardWriter">작성자</option>
			<option value="boardContant">내용</option>
			<option value="boardCodeName">카테고리</option>
		</select>
		<input class="form-control" placeholder="검색어를 입력하세요" />
		<input type="submit" value="검색">
	</div>
>>>>>>> refs/remotes/origin/SeUh
</article>

<script>



//카테고리를 보내준다
	function search_category() {
	
		//내용
		var boardContent = $("#search_key").val();
		if(boardContent.trim().length == 0){
			alert("검색어 입력하세요.");
			return false;
		}
	
		var search_category = $("#search_category option:selected").val();
		var search_key = $("#search_key").val();
		location.href = "<%=request.getContextPath()%>/sell/sellList?search_category="+search_category+"&search_key="+search_key;
	}

</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
