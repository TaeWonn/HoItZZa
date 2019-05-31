<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
List<User>userList=(List<User>)request.getAttribute("userList");
String searchType=(String)request.getAttribute("searchType");
String searchKeyword=(String)request.getAttribute("searchKeyword");
int numPerPage=10;
String pageBar=(String)request.getAttribute("pageBar");


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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/viewUserList.css" />
<article>
<div id="dUserList">
	<p>회원 목록</p>
	<table id="userList">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>주민등록번호</th>
			<th>이메일</th>
			<th>연락처</th>
		</tr>
	</thead>
	<tbody>
	<%/* for(int i=0;i<userList.size();i++){ */for(int i=1;i<16;i++){ %>
		<tr>
			<td><nobr><%-- <%=userList.get(i).getUserId() %> --%>user<%=i %></nobr></td>
			<td><nobr> <%-- <%=userList.get(i).getName() %> --%>유저</nobr></td>
			<td><nobr> <%-- <%=userList.get(i).getGender().equals("M")?"남":"여" %> --%>여성</nobr></td>
			<td><nobr> <%-- <%=userList.get(i).getSsn() %> --%>999999-1111111</nobr></td>
			<td><nobr> <%-- <%=userList.get(i).getEmail() %> --%>female<%=i %>@naver.com</nobr></td>
			<td><nobr> <%-- <%=userList.get(i).getPhone() %> --%>010-1234-1234</nobr></td>		
		</tr>
	<% }%>	
	
	</tbody>
	</table>
</div>

	<div id="search-container">

		<select name="" id="searchType" >
			<option value="memberId"
				<%="memberId".equals(searchType) ? "selected" : ""%>>아이디로
				조회</option>
			<option value="memberName"
				<%="memberName".equals(searchType) ? "selected" : ""%>>회원명으로
				조회</option>
			<option value="gender"
			<%="gender".equals(searchType) ? "selected" : ""%>>성별로 조회</option>
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
		 console.log($('input[name=searchKeyword]').val());

	}
	function submit(){

		 $('input[name=searchType]').val($('#searchType').val());	
		
		  $('#submit').submit();  
	}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>