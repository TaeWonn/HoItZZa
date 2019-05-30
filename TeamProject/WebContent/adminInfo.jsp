<%@page import="board.model.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%

List<Board> suggestionBoardList=(List<Board>)request.getAttribute("");
List<Board> reportBoardList=(List<Board>)request.getAttribute("");


%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin/adminInfo.css" />
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<article>

<div id="viewMain">
	<span id="h1"><%=userIdd %>님의 개인 페이지</span>
</div>

<div id="infoList">
<form action="<%=request.getContextPath()%>/views/user/updateInfo" method="post">
	<table id="userInfoTable">
		<tr>
			<th>이름</th>
			<td><input type="text" value="유저이름" readonly /></td>
		</tr>
		<tr>
			<th>포인트</th>
			<td><input type="text" value="소지포인트" readonly /></td>
		</tr>
		<tr>
			<th>비밀번호</th>			
			<td><input type="password" value="현재비밀번호" readonly />
			<button class="btn" onclick="searchAddr(); " onclick="changeUserPwd(<%=userIdd%>);" >변경하기</button>
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" value=""  name="addr1" readonly/>
				<input type="text" value=""  name="addr2" placeholder="상세주소"/>
				<button class="btn" onclick="searchAddr();">주소찾기</button>
			</td>
				
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" value="user이메일주소" name="email"/></td>
		</tr>
		<tr id="pad">
			<th></th>
			<td >
			<input type="submit" value="정보 수정" class="btnGroup"/> 
			<input type="button" value="회원관리" class="btnGroup" onclick="viewUser();" />
			</td>
		</tr>
	</table>
</form>
</div>

<div id="Board">
	<div id="suggestionBoard" class="boardTitle">
	<p>건의게시판</p>
	<table>
	<tr>
	<th>작성자</th>
	<th>제목</th>
	<th>작성일</th>
	</tr>
	<%-- <%for(Board b1 :suggestionBoardList){ %> --%>
	<tr>
		<td>나는 유저</td>
		<td>이것좀 고쳐주시면...</td>
		<td>2019/03/04</td>
	</tr>
	<%--  <%}  --%>
	</table>
	
	</div>
	
	<div id="reportBoard" class="boardTitle">
	<p>신고게시판</p>
	</div>
</div>


</article>

<script>

function searchAddr(){
	 new daum.Postcode({
		  oncomplete: function(data) {
		      console.log('주소 : '+data.address);
		      
		      var address1=data.address;
		      $('input[name=addr1]').val(address1);
		      //지번주소 표기는 폐기처리.$('#address2').val('(지번주소)'+jibun+' ');
		  }
		}).open();
}

function viewUser(){
	
	location.href="<%=request.getContextPath()%>/views/admin/viewUsers";
}

</script>





<%@ include file="/WEB-INF/views/common/footer.jsp" %>