<%@page import="free.model.vo.Free"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../common/error.jsp"%>
<%@ page import="board.model.vo.Board, java.util.*"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
   List<Free> free = (List<Free>)request.getAttribute("divideList");
   String pageBar = (String)request.getAttribute("pageBar");
   //header.jsp에 memberLoggedIn변수를 선언했으므로, 이 페이지에서는 선언할 필요 없음.
   //Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/freeboard/freeList.css" />

	<h2>나눔 게시판</h2>
	<%if(userLoggedIn != null){ %>
	<input type="button" value="글쓰기" id="btn-add"
		onclick="location.href='<%=request.getContextPath()%>/views/free/freeWrite'" />
	<% } %>
	<table class="table" id="freeTable">
	<colgroup>
	<col width="55px;"/>
	<col width="80px;"/>
	<col width="160px;"/>
	<col width="80px;"/>
	<col width="70px;"/>
	</colgroup>
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

<%@ include file="/WEB-INF/views/common/footer.jsp"%>