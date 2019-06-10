<%@page import="opinion.model.vo.Opinion"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../common/error.jsp"%>
<%@page import="java.util.List"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
   List<Opinion> opinion = (List<Opinion>)request.getAttribute("oList");
   String pageBar = (String)request.getAttribute("PageBar");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/freeboard/freeList.css" />

	<h2>건의 게시판</h2>
	<%if(userLoggedIn != null){ %>
	<input type="button" value="글쓰기" id="btn-add"
		onclick="location.href='<%=request.getContextPath()%>/opinion/opinionWrite'" />
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
			<% for(Opinion b : opinion){ %>
			<%if(userLoggedIn.getUserId().equals("admin")||userLoggedIn.getUserId().equals(b.getBoardWriter())){ %>
			<tr>
				<th scope="row"><%=b.getBoardNo() %></th>
				<td><nobr><%=b.getBoardWriter() %></nobr></td>
				<td>
					<a
					href="<%=request.getContextPath()%>/opinion/opinionView?boardNo=<%=b.getBoardNo()%>"
					style="text-decoration: none; color: black;"> 
						<nobr><%=b.getBoardTitle()%></nobr>
					</a>
				</td>
				<td><%=b.getBoardDate() %></td>
				<td><%=b.getBoardReadCount() %></td>
			</tr>
			<% }} %>
		</tbody>
	</table>
	<div id="pageBar">
		<%=pageBar %>
	</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>