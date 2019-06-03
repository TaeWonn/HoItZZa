<%@page import="message.model.vo.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	String pageBar=(String)request.getAttribute("pageBar");
	String searchKeyword=(String)request.getAttribute("searchKeyword");
	String searchType=(String)request.getAttribute("searchType");
	List<Message> list=(List<Message>)request.getAttribute("msgList");
	

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
		<%if(list!=null){for(int i=0;i<list.size();i++){ %>
			<tr>
				<th scope="row"><nobr><%=list.get(i).getSender() %></nobr></th>
				<td><nobr><%= list.get(i).getContent()%></nobr></td>
				<td><nobr><%=list.get(i).getNoteDate() %></nobr></td>
				<td>
					<button type="button" class="btn btn-secondary"  onclick="reply('<%=userLoggedIn.getUserId() %>','<%=list.get(i).getSender()%>');">답장</button>
					<button type="button" class="btn btn-secondary"  onclick="deletemsg('<%=list.get(i).getMessageNo()%>','<%=list.get(i).getRecipient()%>');">삭제</button>
				</td>
			</tr>
		<%}}%>
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
function deletemsg(msgNo,userId){
	//사용자가 recipient, 보낸사람이 sender
	var bool=confirm('정말 삭제하시겠습니까?');
	if(bool){
	location.href="<%=request.getContextPath()%>/views/message/messageDelete?msgNo="+msgNo+"&userId="+userId;		
	}
}
function reply(sender,recipient){
	//사용자가 sender, 받는사람이 recipient
	location.href="<%=request.getContextPath()%>/views/message/messageReply?senderId="+sender+"&recipient="+receiver;	
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