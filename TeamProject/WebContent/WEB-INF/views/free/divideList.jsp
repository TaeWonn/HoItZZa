<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board, java.util.*"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<style>
.table {
	width: 600px;
	border: none;
	border-top: 2px solid rgb(196, 192, 192);
	border-bottom: 2px solid rgb(196, 192, 192);
	padding: 15px;
	margin: 20px auto;
	text-align: center;
	font-size: 15px;
}

.table #title {
	width: 200px;
}

.table td, .table tr th {
	border: none;
	border-bottom: 0.5px solid lightgray;
}

.thead-light {
	font-size: 17px;
}

h2 {
	text-align: center;
}
</style>
<article>
	<h2>나눔게시판</h2>

	<table class="table">
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
			<%
				for (int i = 0; i < 7; i++) {
			%>

			<tr>
				<th scope="row">작성자명</th>
				<td>Mark</td>
				<td>Otto</td>
				<td>2019-06-24</td>
				<td>5</td>
			</tr>
			<%
				}
			%>
		</tbody>

	</table>

	<%-- <%if(memberLoggedIn != null){ %>
		<input type="button" value="글쓰기" 
			   id="btn-add"
			   onclick="location.href='<%=request.getContextPath()%>/board/boardForm'"/>
	<% } %> --%>
</article>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>