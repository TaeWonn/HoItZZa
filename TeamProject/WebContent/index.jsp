<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css" />
  
<article id="article">
<section>
	<div id="list-container">
	<div id="board1">
		<span class="title">판매 / 구매 게시판</span>
		
		<table id="sellList">
		<colgroup>
	        <col width="20px">
	        <col width="70px">  <!-- 너비를 지정해주어야한다 -->
	        <col width="25px">
   		</colgroup>

		<thead>
		<tr >
		<th style="font-size: 20px;"colspan="3">나눔 게시판</th>
		</tr>
		<tr>
		<th class="board_no"><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th class="viewer"><nobr>조회수</nobr></th>
		</tr>
		</thead>
		<tbody>
		<%for(int i=1;i<=10;i++){%>
		<tr>
			<td class="board_no"><nobr><%= i%></nobr></td>
			<td><nobr><%= i%>번째 글입니다</nobr></td>
			<td class="viewer"><nobr><%= i%></nobr></td>
		</tr>
		<%} %>
		</tbody>
		</table>
		
		
		<table id="buyList">
		<colgroup>
	        <col width="20px">
	        <col width="70px">  <!-- 너비를 지정해주어야한다 -->
	        <col width="25px">
   		</colgroup>
		<thead>
		<tr >
		<th style="font-size: 20px;"colspan="3"><nobr>나눔 게시판</nobr></th>
		</tr>
		<tr>
		<th class="board_no"><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th class="viewer"><nobr>조회수</nobr></th>
		</tr>
		</thead>
		<tbody>
		<%for(int i=1;i<=10;i++){%>
		<tr>
			<td class="board_no"><nobr><%= i%></nobr></td>
			<td><nobr><%= i%>번째 글입니다</nobr></td>
			<td class="viewer"><nobr><%= i%></nobr></td>
		</tr>
		<%} %>
		</tbody>
		</table>
		</div>
		
		<div id="board2">
		<span class="title">자유게시판</span>
		<table id="jayuList1">
		<colgroup>
	        <col width="20px">

	        <col width="70px">  <!-- 너비를 지정해주어야한다 -->
	        <col width="20px">
   		</colgroup>
		<thead>
		<tr >
		<th colspan="3" style="font-size: 20px;"><nobr>나눔 게시판</nobr></th>
		</tr>
		<tr>
		<th class="board_no"><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th class="viewer"><nobr>조회수</nobr></th>
		</tr>
		</thead>
		<tbody>
		<%for(int i=1;i<=3;i++){%>
		<tr>
			<td class="board_no"><nobr><%= i%></nobr></td>
			<td><nobr><%= i%>번째 글입니다</nobr></td>
			<td class="viewer"><nobr><%= i%></nobr></td>
		</tr>
		<%} %>
		</tbody>
		</table>
		
		<table id="jayuList2">
		<colgroup>
	        <col width="20px">

	        <col width="70px">  <!-- 너비를 지정해주어야한다 -->
	        <col width="20px">
   		</colgroup>
		<thead>
		<tr >
		<th colspan="3" style="font-size: 20px;"><nobr>잡담 게시판</nobr></th>
		</tr>
		<tr>
		<th class="board_no"><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th class="viewer"><nobr>조회수</nobr></th>
		</tr>
		</thead>
		<tbody>
		<%for(int i=1;i<=3;i++){%>
		<tr>
			<td class="board_no"><nobr><%= i%></nobr></td>
			<td><nobr><%= i%>번째 글입니다</nobr></td>
			<td class="viewer"><nobr><%= i%></nobr></td>
		</tr>
		<%} %>
		</tbody>
		</table>
		
		
		<table id="jayuList3">
		<colgroup>
	        <col width="20px">

	        <col width="70px">  <!-- 너비를 지정해주어야한다 -->
	        <col width="20px">
   		</colgroup>
		<thead>
		<tr >
		<th  colspan="3" style="font-size: 20px;">유용한 생활지식 게시판</th>
		</tr>
		<tr>
		<th class="board_no"><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th class="viewer"><nobr>조회수</nobr></th>
		</tr>
		</thead>
		<tbody>
		<%for(int i=1;i<=3;i++){%>
		<tr>
			<td class="board_no"><nobr><%= i%></nobr></td>
			<td><nobr><%= i%>번째 글입니다</nobr></td>
			<td class="viewer"><nobr><%= i%></nobr></td>
		</tr>
		<%} %>
		</tbody>
		</table>
		
		
		<table id="jayuList4">
		<colgroup>
	        <col width="20px">

	        <col width="70px">  <!-- 너비를 지정해주어야한다 -->
	        <col width="20px">
   		</colgroup>
		<thead>
		<tr>
		<th  colspan="3" style="font-size: 20px;">연예/미디어 게시판</th>
		</tr>
		<tr>
		<th class="board_no">번호</th>
		<th>제목</th>
		<th class="viewer">조회수</th>
		</tr>
		</thead>
		<tbody>
		<%for(int i=1;i<=3;i++){%>
		<tr>
			<td class="board_no"><nobr><%= i%></nobr></td>
			<td><nobr><%= i%>번째 글입니다</nobr></td>
			<td class="viewer"><nobr><%= i%></nobr></td>
		</tr>
		<%} %>
		</tbody>
		</table>
		
		</div>
 
	</div>
 
</section>
</article>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>

