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
	<span id="h1">관리자</span>
</div>

<div id="infoList">
<form action="<%=request.getContextPath()%>/user/updateInfo" method="post">
	<table id="userInfoTable">
		<tr>
			<th>이름</th>
			<td><input type="text" value="관리자 아이디" name="userId" readonly  /></td>
		</tr>
		<tr>
			<th>비밀번호</th>			
			<td><input type="password" value="현재비밀번호" readonly />
			<button class="btn" onclick="searchAddr(); " onclick="changeUserPwd(<%--<%=userIdd%>--%>);" >변경하기</button>
			</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" value="전화번호" name="phone" /></td>
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
	 <%for(int i=1;i<=5;i++){ %>
	<tr>
		<td><nobr>나는 <%=i %>번째 유저</nobr></td>
		<td><nobr>이것좀 고쳐주시면 감사하겠습니다 오버플로우를 왜 안먹을까요<%=i %></nobr></td>
		<td><nobr>2019/03/0<%=i %></nobr></td>
	</tr>
	 <%}%>
	</table>
	 <button type="button" id="move1" class="btn btn-secondary" onclick="moveSBoard(<%--<%=userIdd%>--%>)">건의게시판 바로가기</button>
	<%-- <button type="button" id="move1"onclick="moveSBoard('<%=userIdd%>')">건의게시판 바로가기</button> --%>
	</div>
	
	<div id="reportBoard"  class="boardTitle">
	<p>신고게시판</p>
	<table>
	<tr>
	<th>작성자</th>
	<th>제목</th>
	<th>작성일</th>
	</tr>
	 <%for(int i=1;i<=5;i++){ %>
	<tr>
		<td><nobr>나는 <%=i %>번째 유저</nobr></td>
		<td><nobr><%=i %>그놈새끼 나쁜새끼 사기꾼새끼 신고합니다.</nobr></td>
		<td><nobr>2019/03/0<%=i %></nobr></td>
	</tr>
	 <%}%>
	</table>
	 <button type="button" id="move2" class="btn btn-secondary" onclick="moveRBoard(<%--<%=userIdd%>)--%>">신고게시판 바로가기</button>
	<%-- <button type="button" id="move2"onclick="moveRBoard('<%=userIdd%>')">건의게시판 바로가기</button> --%>
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

//관리자가 유저 목록 확인을 위한 함수
function viewUser(){
	//admin 외의 접근을 막기 위해 아이디값 보냄
	location.href="<%=request.getContextPath()%>/admin/adminList";
}

//비밀번호 변경페이지로 이동
function changeUserPwd(userId){
	location.href="<%=request.getContextPath()%>/user/updatePwd?userId="<%--<%=userIdd%>--%>;
}

function moveSBoard(userId){
	location.href="<%=request.getContextPath()%>/opinion/suggestionBoard?userId="+userId;
}
function moveRBoard(userId){
	location.href="<%=request.getContextPath()%>/views/opinion/reportBoard?userId="+userId;
}



</script>





<%@ include file="/WEB-INF/views/common/footer.jsp" %>