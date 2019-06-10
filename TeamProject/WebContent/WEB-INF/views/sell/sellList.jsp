<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="sell.model.vo.Sell, java.util.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<Sell> sell = (List<Sell>)request.getAttribute("sellList");
	String pageBar = (String)request.getAttribute("pageBar");
	//header.jsp에 memberLoggedIn변수를 선언했으므로, 이 페이지에서는 선언할 필요 없음.
    //Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
%>
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">    
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />    
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardList.css" />

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
</article>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>
