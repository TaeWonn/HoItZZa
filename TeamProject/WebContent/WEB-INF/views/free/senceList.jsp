<%@page import="free.model.vo.Free"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../common/error.jsp"%>
<%@ page import="board.model.vo.Board, java.util.*"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
   List<Free> free = (List<Free>)request.getAttribute("sense");
   String pageBar = (String)request.getAttribute("pageBar");
   //header.jsp에 memberLoggedIn변수를 선언했으므로, 이 페이지에서는 선언할 필요 없음.
   //Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardList.css" />
	<h3 style="text-align: center; margin: 30px 0 0 5px;">유용한 생활지식 게시판</h3>
	<%if(userLoggedIn != null){ %>
	<input type="button" value="글쓰기" id="btn-add"
		onclick="location.href='<%=request.getContextPath()%>/views/free/freeWrite'" />
	<% } %>
	<table class="table" id="freeTable">
		<thead class="thead-light">
			<tr>
				<th scope="col" style="width: 95px;">글번호</th>
				<th scope="col" style="width: 100px;">작성자</th>
				<th scope="col" id="title">제목</th>
				<th scope="col">작성일</th>
				<th scope="col" style="width: 80px;">조회수</th>
			</tr>
		</thead>
		<tbody>
			<% for(Free f : free){ %>
			<tr>
				<th scope="row"><%=f.getBoardNo() %></th>
				<td><nobr><%=f.getBoardWriter() %></nobr></td>
				<td>
					<a
					href="<%=request.getContextPath()%>/free/freeView?boardNo=<%=f.getBoardNo()%>"
					style="text-decoration: none; color: black;"> 
						<nobr><%=f.getBoardTitle()%></nobr>
					</a>
				</td>
				<td><%=f.getBoardDate() %></td>
				<td><%=f.getBoardReadCounter() %></td>
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
	
<%@ include file="/WEB-INF/views/common/footer.jsp"%>