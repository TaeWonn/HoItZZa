<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	String pageBar=(String)request.getAttribute("pageBar");
	String searchKeyword=(String)request.getAttribute("searchKeyword");
	String searchType=(String)request.getAttribute("searchType");
	

%>
<style>
div#search-userId{
display: <%=searchType == null || "userId_find".equals(searchType) ? "inline-block" : "none"%>
}
div#search-content{
<%if(searchType!=null){%>
	display:inline-block;
	<%}else{%>
	display:none;
	<%}%>
}
display:none;
}
</style>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user/message.css" />

<article>
	<h2 id="title2" >쪽지함</h2>
	<table class="table">
		<thead class="thead-light">
			<tr id="tHeader">
				<th scope="col" style="max-width:80px;">발신인</th>
				<th scope="col">내용</th>
				<th scope="col" style="max-width: 90px;">작성일자</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
		<%for(int i=1;i<=11;i++){ %>
			<tr>
				<th scope="row">festa<%=i %></th>
				<td>Sparta!<%=i %></td>
				<td>2019/02/<%= i<10?("0"+i):i %></td>
				<td>
					<button type="button" class="btn btn-secondary"  onclick="deletemsg(<%=userLoggedIn.getUserId() %>);">삭제</button>
					<button type="button" class="btn btn-secondary"  onclick="reply(<%=userLoggedIn.getUserId() %>);">답장</button>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<br>
	<div id="pageBar">
		<%=pageBar %>페이지바
	</div>
	
	<div id="search-container">
		<select name="" id="searchType" >
			<option value="userId"
				<%="userId".equals(searchType) ? "selected" : ""%>>아이디로
				조회</option>
			<option value="content"
				<%="content".equals(searchType) ? "selected" : ""%>>내용으로
				조회</option>
		</select>

		<div id="search-userId">

			<input type="search" onchange="insertKeyword(this);" 
				 size="25" placeholder="검색할 아이디를 입력하세요" 
				value='<%="memberId".equals(searchType)?searchKeyword:"" %>' /> 
				<input type="button" value="검색" onclick="submit();"/>
		</div>
		<div id="search-content">

			<input type="search" onchange="insertKeyword(this);" 
				value='<%="memberName".equals(searchType)?searchKeyword:"" %>'
				size="25" placeholder="검색할 내용을 입력하세요" />
			<input type="button" value="검색" onclick="submit();"/>

		</div>
		
		<div id="sub">
		<form action="<%=request.getContextPath()%>/admin/userFinder">
			<input type="hidden" name="searchType" />
			<input type="hidden" name="searchKeyword" />
		</form>
		</div>
		
	</div>
</article>

<script>
function deletemsg(sender,recipient){
	//사용자가 recipient, 보낸사람이 sender
	location.href="<%=request.getContextPath()%>/views/user/messageDelete?senderId="+sender+"&recipient="+receiver;
}
function reply(sender,recipient){
	//사용자가 sender, 받는사람이 recipient
	location.href="<%=request.getContextPath()%>/views/user/messageReply?senderId="+sender+"&recipient="+receiver;	
}

$('#searchType').change(function() {
	var value = $('#searchType option:selected').val();
	$('#search-container div').css('display', 'none');
	$('#search-' + value).css('display', 'inline-block');
	
	$('input[name=searchType]').val(value);
	
	
});
function insertKeyword(obj){
	 $('input[name=searchKeyword]').val(obj.value);
}
function submit(){
	$('input[name=searchType]').val($('#searchType').val());	
	$('#submit').submit();  
}


</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
