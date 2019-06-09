<%@page import="board.model.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%

List<Board> suggestionBoardList=(List<Board>)request.getAttribute("suggestion");
List<Board> reportBoardList=(List<Board>)request.getAttribute("report");
String[] addrArr = userLoggedIn.getAddr().split(",");
String pageBar = (String) request.getAttribute("pageBar");

%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin/adminInfo.css" />
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<article>

<div id="viewMain">
	<span id="h1">관리자</span>
</div>

<div id="infoList">
<form action="<%=request.getContextPath()%>/views/user/updateInfo" method="post">
	<table id="userInfoTable">
		<tr>
			<th>이름</th>
			<td><input type="text" value="관리자 아이디" name="userId" readonly  /></td>
		</tr>
		<tr>
			<th>비밀번호</th>			
			<td>
			<button class="btn" onclick="searchAddr(); " onclick="changeUserPwd(<%=userLoggedIn.getUserId()%>);" >변경하기</button>
			</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" value="<%=userLoggedIn.getPhone() %>" name="phone" /></td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" value="<%=addrArr[0] %>"  name="addr1" readonly/>
				<input type="text" value="<%=addrArr[1] %>"  name="addr2" placeholder="상세주소"/>
				<button class="btn" onclick="searchAddr();">주소찾기</button>
			</td>
				
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" value="<%=userLoggedIn.getEmail() %>" name="email"/></td>
		</tr>
		<tr id="pad">
			<th></th>
			<td >
			<input type="submit" value="정보 수정" class="btnGroup"/> 
			<input type="button" value="회원관리" class="btnGroup" onclick="location.href='<%=request.getContextPath()%>/admin/adminList'" />
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
	<%for(Board b : suggestionBoardList){ %>
	<tr>
		<td><nobr><%=b.getBoardWriter() %></nobr></td>
		<td><nobr><%=b.getBoardTitle() %></nobr></td>
		<td><nobr><%=b.getBoardDate() %></nobr></td>
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
	 <%for(Board b : reportBoardList){ %>
	<tr>
		<td><nobr><%=b.getBoardWriter() %></nobr></td>
		<td><nobr><%=b.getBoardTitle() %></nobr></td>
		<td><nobr><%=b.getBoardDate() %></nobr></td>
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


//비밀번호 변경페이지로 이동
function changeUserPwd(userId){
	location.href="<%=request.getContextPath()%>/user/updatePwd?userId="+userId;
}

function moveSBoard(userId){
	location.href="<%=request.getContextPath()%>/opinion/opinionList";
}
function moveRBoard(userId){
	location.href="<%=request.getContextPath()%>/views/opinion/reportBoard";
}



</script>





<%@ include file="/WEB-INF/views/common/footer.jsp" %>