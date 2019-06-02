<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	String pageBar=(String)request.getAttribute("pageBar");
	String searchKeyword=(String)request.getAttribute("searchKeyword");
	String searchType=(String)request.getAttribute("searchType");

%>
<style>
div#search-memberId {
	display: <%=searchType == null || "memberId".equals(searchType) ? "inline-block" : "none"%>
}
div#search-memberName {
	<%-- display: <%=searchType == null || "memberName".equals(searchType) ? "inline-block" : "none"%> --%>
	display:none;
}
div#search-gender {
	<%-- display: <%=searchType == null || "gender".equals(searchType) ? "inline-block" : "none"%> --%>
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
				<th scope="col">Handle</th>
			</tr>
		</thead>
		<tbody>
		<%for(int i=1;i<=11;i++){ %>
			<tr>
				<th scope="row">festa<%=i %></th>
				<td>Sparta!<%=i %></td>
				<td>2019/02/<%= i<10?("0"+i):i %></td>
				<td>
					<button type="button" class="btn btn-secondary"
						onclick="deletemsg(보낸아이디,받는 아이디);">삭제</button>

					<button type="button" class="btn btn-secondary" onclick="reply(아이디);"
						value="">답장</button>
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

		<div id="search-memberId">

			<input type="search" onchange="insertKeyword(this);" 
				 size="25" placeholder="검색할 아이디를 입력하세요" 
				value='<%="memberId".equals(searchType)?searchKeyword:"" %>' /> 
				<input type="button" value="검색" onclick="submit();"/>
		</div>
		<div id="search-memberName">

			<input type="search" onchange="insertKeyword(this);" 
				value='<%="memberName".equals(searchType)?searchKeyword:"" %>'
				size="25" placeholder="검색할 회원명을 입력하세요" />
			<input type="button" value="검색" onclick="submit();"/>

		</div>
		<div id="search-gender">

			 <input type="radio" onchange="insertKeyword(this);"  
				value="M" id="gender0" <%="gender".equals(searchType) && "M".equals(searchKeyword) ? "checked" : ""%> />
			<label for="gender0">남성</label> 
			<input type="radio" value="F" id="gender1" onchange="insertKeyword(this);"
				<%="gender".equals(searchType) && "F".equals(searchKeyword) ? "checked" : ""%> />
			<label for="gender1">여성</label> <input type="button" value="검색"
				onclick="submit();" />
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
function deletemsg(sender,receiver){
	location.href="<%=request.getContextPath()%>/views/user/messageDelete?senderId="+sender+"&receiverId="+receiver;
}
function reply(sender,receiver){
	location.href="<%=request.getContextPath()%>/views/user/messageReply?senderId="+sender+"&receiverId="+receiver;	
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
