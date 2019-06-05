<%@page import="free.model.vo.Free"%>
<%@page import="buy.model.vo.Buy"%>
<%@page import="sell.model.vo.Sell"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css" />
<% 
List<Sell> sellList=(List<Sell>)request.getAttribute("sellList");
List<Buy> buyList=(List<Buy>)request.getAttribute("buyList");
List<Free> sudaList=(List<Free>)request.getAttribute("sudaList");
List<Free> mediaList=(List<Free>)request.getAttribute("mediaList");
List<Free> senseList=(List<Free>)request.getAttribute("senseList");
List<Free> nanumList=(List<Free>)request.getAttribute("nanumList");
String stop=(String)request.getAttribute("stop");

%>
  
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
		<th style="font-size: 20px;"colspan="3" id="firstTitle">판매 게시판</th>
		</tr>
		<tr>
		<th class="board_no"><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th class="viewer"><nobr>조회수</nobr></th>
		</tr>
		</thead>
		<tbody>
		 <%if(sellList!=null){for(int i=0;i<sellList.size();i++){%>
		<tr onclick="boardView('<%=sellList.get(i).getBoardNo()%>','/sell/sellView?boardNo=');">
			<td class="board_no"><nobr><%= sellList.get(i).getBoardNo()%></nobr></td>
			<td><nobr><%= sellList.get(i).getBoardTitle()%></nobr></td>
			<td class="viewer"><nobr><%= sellList.get(i).getBoardReadCounter()%></nobr></td>
		</tr>
		<%}} %>
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
		<th style="font-size: 20px;"colspan="3" id="firstTitle"><nobr>구매 게시판</nobr></th>
		</tr>
		<tr>
		<th class="board_no"><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th class="viewer"><nobr>조회수</nobr></th>
		</tr>
		</thead>
		<tbody>
		 <%if(buyList!=null){for(int i=0;i<buyList.size();i++){%>
		<tr onclick="boardView('<%=buyList.get(i).getBoardNo()%>','/buy/buyView?boardNo=');">
			<td class="board_no"><nobr><%= buyList.get(i).getBoardNo()%></nobr></td>
			<td><nobr><%= buyList.get(i).getBoardTitle()%></nobr></td>
			<td class="viewer"><nobr><%= buyList.get(i).getBoardReadCounter()%></nobr></td>
		</tr>
		<%}} %> 
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
		<th colspan="3" style="font-size: 20px;" id="firstTitle"><nobr>나눔 게시판</nobr></th>
		</tr>
		<tr>
		<th class="board_no"><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th class="viewer"><nobr>조회수</nobr></th>
		</tr>
		</thead>
		<tbody>
		 <%if(nanumList!=null){for(int i=0;i<nanumList.size();i++){%>
		<tr onclick="boardView('<%=nanumList.get(i).getBoardNo()%>');">
			<td class="board_no"><nobr><%= nanumList.get(i).getBoardNo()%></nobr></td>
			<td><nobr><%= nanumList.get(i).getBoardTitle()%></nobr></td>
			<td class="viewer"><nobr><%= nanumList.get(i).getBoardReadCounter()%></nobr></td>
		</tr>
		<%}} %> 
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
		<th colspan="3" style="font-size: 20px;" id="firstTitle"><nobr>잡담 게시판</nobr></th>
		</tr>
		<tr>
		<th class="board_no"><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th class="viewer"><nobr>조회수</nobr></th>
		</tr>
		</thead>
		<tbody>
		 <%if(sudaList!=null){for(int i=0;i<sudaList.size();i++){%>
		<tr onclick="boardView('<%=sudaList.get(i).getBoardNo()%>',);">
			<td class="board_no"><nobr><%= sudaList.get(i).getBoardNo()%></nobr></td>
			<td><nobr><%= sudaList.get(i).getBoardTitle()%></nobr></td>
			<td class="viewer"><nobr><%= sudaList.get(i).getBoardReadCounter()%></nobr></td>
		</tr>
		<%}} %> 
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
		<th  colspan="3" style="font-size: 20px;" id="firstTitle">유용한 생활지식 게시판</th>
		</tr>
		<tr>
		<th class="board_no"><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th class="viewer"><nobr>조회수</nobr></th>
		</tr>
		</thead>
		<tbody>
		 <%if(senseList!=null){for(int i=0;i<senseList.size();i++){%>
		<tr onclick="boardView('<%=senseList.get(i).getBoardNo()%>');">
			<td class="board_no"><nobr><%= senseList.get(i).getBoardNo()%></nobr></td>
			<td><nobr><%= senseList.get(i).getBoardTitle()%></nobr></td>
			<td class="viewer"><nobr><%= senseList.get(i).getBoardReadCounter()%></nobr></td>
		</tr>
		<%}} %> 
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
		<th  colspan="3" style="font-size: 20px;" id="firstTitle">연예/미디어 게시판</th>
		</tr>
		<tr>
		<th class="board_no">번호</th>
		<th>제목 </th>
		<th class="viewer">조회수</th>
		</tr>
		</thead>
		<tbody>
	 	<%if(mediaList!=null){for(int i=0;i<mediaList.size();i++){%>
		<tr onclick="boardView('<%=mediaList.get(i).getBoardNo()%>');">
			<td class="board_no"><nobr><%= mediaList.get(i).getBoardNo()%></nobr></td>
			<td><nobr><%= mediaList.get(i).getBoardTitle()%></nobr></td>
			<td class="viewer"><nobr><%= mediaList.get(i).getBoardReadCounter()%></nobr></td>
		</tr>
		<%}} %> 
		</tbody>
		</table>
		
		</div>
 
	</div>
 
</section>
</article>
<script>
<% if(stop==null){%>
$(document).ready(function() {
    // 로딩되기 시작할때
location.href="<%=request.getContextPath()%>/views/index";
});
<%}%> 
 
function boardView(boardNo,link){
	location.href="<%=request.getContextPath()%>"+link+boardNo;
}


</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>

