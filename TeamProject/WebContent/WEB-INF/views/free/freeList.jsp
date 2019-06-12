<%@page import="free.model.vo.Free"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../common/error.jsp"%>
<%@ page import="board.model.vo.Board, java.util.*"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
    List<Free> free = (List<Free>)request.getAttribute("free");
    String pageBar = (String)request.getAttribute("pageBar");
    //header.jsp에 memberLoggedIn변수를 선언했으므로, 이 페이지에서는 선언할 필요 없음.
    //Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
   
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardList.css" />

<article id="article">
	<h3 style="text-align: center; margin: 30px 0 20px 5px;">잡담게시판</h3>
	<%if(userLoggedIn != null){ %>
	<input type="button" value="글쓰기" id="btn-add"
		onclick="location.href='<%=request.getContextPath()%>/views/free/freeWrite'" />
	<% } %>
	<table class="table">
		<thead class="thead-light">
			<tr>
				<th scope="col" >글번호</th>
				<th scope="col" >작성자</th>
				<th scope="col" id="title">제목</th>
				<th scope="col">작성일</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<%if(free!=null){ for(Free f : free){ %>
			<tr>
				<th scope="row"><%=f.getBoardNo() %></th>
				<td><nobr><%=f.getBoardWriter() %></nobr></td>
				<td>
					<a
					href="<%=request.getContextPath()%>/free/freeView?boardNo=<%=f.getBoardNo()%>&list="
					style="text-decoration: none; color: black;"> 
						<nobr><%=f.getBoardTitle()%></nobr>
					</a>
				</td>
				<td><%=f.getBoardDate() %></td>
				<td><%=f.getBoardReadCounter() %></td>
			</tr>
			<% }} %>
		</tbody>
	</table>
	<div id="pageBar">
		<%=pageBar %>
	</div>
		<form action="<%=request.getContextPath()%>/free/search">
		<div class="input-group">
		<select name="searchType">
			<option value="boardTitle" selected>제목</option>
			<option value="boardWriter">작성자</option>
			<option value="boardContant">내용</option>
		</select>
		<input class="form-control" placeholder="검색어를 입력하세요" name="keyword"/>
		<input type="hidden" name="code" value="<%if(free!=null){ %><%=free.get(0).getBoardNo().substring(0,2)%><%}%>"/>
		<input type="submit" value="검색">
	</div>
		</form>
</article>
	
<%@ include file="/WEB-INF/views/common/footer.jsp"%>