<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
List<User> userList=(List<User>)request.getAttribute("userList");
String searchType=(String)request.getAttribute("searchType");
String searchKeyword=(String)request.getAttribute("searchKeyword");
int numPerPage=10;
String pageBar=(String)request.getAttribute("pageBar");
Map<String,Integer>warningCount=(Map<String,Integer>)request.getAttribute("warningCount");


%>
<style>
div#search-userId_find {
    display: <%=searchType == null || "userId_find".equals(searchType) ? "inline-block" : "none"%>
}
div#search-userName_find {
	<%if(searchType!=null){%>
	display:inline-block;
	<%}else{%>
	display:none;
	<%}%>
    display:none;
}
div#search-gender_find {
	<%if(searchType!=null){%>
	display:inline-block;
	<%}else{%>
	display:none;
	<%}%>
    display:none;
}
</style>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/viewUserList.css" />
<article>
<div id="dUserList">
	<p>회원 목록</p>
	<table id="userList">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th><nobr>경고 횟수</nobr></th>
			<th>경고처리</th>
			<th>이메일</th>
			<th>연락처</th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<userList.size();i++){if(!userList.get(i).getUserId().equals("admin")){ %>
		<tr >
			<td onclick="location.href='<%=request.getContextPath()%>/views/user/userInfo?userId=<%=userList.get(i).getUserId()%>'" ><nobr><%=userList.get(i).getUserId() %></nobr></td>
			<td onclick="location.href='<%=request.getContextPath()%>/views/user/userInfo?userId=<%=userList.get(i).getUserId()%>'"><nobr>  <%=userList.get(i).getName() %></nobr></td>
			<td onclick="location.href='<%=request.getContextPath()%>/views/user/userInfo?userId=<%=userList.get(i).getUserId()%>'"><nobr><label for=""><%=warningCount.get(userList.get(i).getUserId()) %>회</label></nobr></td>
			<td><nobr> <input type="button" style="width:90px;" id="warningBtn"value="경고처리" onclick="warningUser('<%=userList.get(i).getUserId() %>');" /></nobr></td>
			<td id="userId"><nobr>  <%=userList.get(i).getEmail() %></nobr></td>
			<td><nobr>  <%=userList.get(i).getPhone() %></nobr></td>		
		</tr>
	<% }}%>	
	
	</tbody>
	</table>
</div>

	<div id="search-container">

		<select name="" id="searchType" >
			<option value="userId_find"
				<%="userId_find".equals(searchType) ? "selected" : ""%>>아이디로
				조회</option>
			<option value="userName_find"
				<%="userName_find".equals(searchType) ? "selected" : ""%>>회원명으로
				조회</option>
			<option value="gender_find"
			<%="gender_find".equals(searchType) ? "selected" : ""%>>성별로 조회</option>
		</select>

		<div id="search-userId_find">

			<input type="search" onchange="insertKeyword(this);" 
				 size="25" placeholder="검색할 아이디를 입력하세요" 
				value='<%="userId".equals(searchType)?searchKeyword:"" %>' /> 
				<input type="button" value="검색" onclick="submit();"/>
		</div>
		<div id="search-userName_find">

			<input type="search" onchange="insertKeyword(this);" 
				value='<%="userName_find".equals(searchType)?searchKeyword:"" %>'
				size="25" placeholder="검색할 회원명을 입력하세요" />
			<input type="button" value="검색" onclick="submit();"/>

		</div>
		<div id="search-gender_find">

			 <input type="radio" onchange="insertKeyword(this);"  
				value="M" id="gender0" <%="gender_find".equals(searchType) && "M".equals(searchKeyword) ? "checked" : ""%> />
			<label for="gender0">남성</label> 
			<input type="radio" value="F" id="gender1" onchange="insertKeyword(this);"
				<%="gender_find".equals(searchType) && "F".equals(searchKeyword) ? "checked" : ""%> />
			<label for="gender1">여성</label> <input type="button" value="검색"
				onclick="submit();" />
		</div>
		
		<div id="sub">
		<form action="<%=request.getContextPath()%>/admin/userFinder" id="submit">
			<input type="hidden" name="searchType" />
			<input type="hidden" name="searchKeyword" />
		</form>
		</div>
	</div>
	<div id="pageBar">
		<%=pageBar %>
	</div>





</article>
<script>

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
function warningUser(userId){
	var bool=prompt(userId+"유저에게 경고 1회를 주시겠습니까?\n경고 코드를 입력해주십시오.\n D_A : 욕설 / D_S : 사기 / D_M : 비매너 / D_P : 음란물 관련 게시 / D_R : 허위신고\n게시글번호 입력(필수) 시 경고 코드 뒤에 콤마(,)를 입력해주세요.");
	if(bool===null){
		location.href="<%=request.getContextPath()%>/admin/adminList";
		return;
	}else{
		location.href="<%=request.getContextPath()%>/admin/warningUser?userId="+userId+"&reason="+bool;
	}

}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>