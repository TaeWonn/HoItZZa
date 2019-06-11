<%@page import="opinion.model.vo.Opinion"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@page import="java.util.List"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
   List<Opinion> opinion = (List<Opinion>)request.getAttribute("oList");
   String pageBar = (String)request.getAttribute("PageBar");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardList.css" />
<article id="article">
	<br />
	<h3 style="text-align: center; margin-bottom: 10px;">건의 게시판</h3>
	<%if(userLoggedIn != null){ %>
	<input type="button" value="글쓰기" id="btn-add"
		onclick="location.href='<%=request.getContextPath()%>/opinion/opinionWrite'" />
	<% } %>
	
	<table class="table" id="freeTable">
		<thead class="thead-light">
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">작성자</th>
				<th scope="col" id="title">제목</th>
				<th scope="col">작성일</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<% for(Opinion b : opinion){if(userLoggedIn.getUserId().equals("admin")||userLoggedIn.getUserId().equals(b.getBoardWriter())){ %>
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