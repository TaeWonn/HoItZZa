<%@page import="board.model.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%
<<<<<<< HEAD
	String pageBar = (String) request.getAttribute("pageBar");
	User u=(User)request.getAttribute("user");
 	List<Board> interestBBoardList=(List<Board>)request.getAttribute("interestList");
	List<Board> interest1BoardList=(List<Board>)request.getAttribute("interestCategoryList1");
	List<Board> interest2BoardList=(List<Board>)request.getAttribute("interestCategoryList2");
	List<Board> interest3BoardList=(List<Board>)request.getAttribute("interestCategoryList3"); 

	/* String[] interestArr=new String[3];
	for(int i=0;i<u.getInterest().length;i++){
		interestArr[i]=u.getInterest()[i];
	} */
	String [] interestArr = u.getInterest();

	

=======
List<Board> suggestionBoardList=(List<Board>)request.getAttribute("");
List<Board> reportBoardList=(List<Board>)request.getAttribute("");
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git
%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin/adminInfo.css" />
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<article>

<div id="viewMain">
<<<<<<< HEAD
	<span id="h1"><%=userLoggedIn.getUserId() %>님의 개인 페이지</span>
=======
	<span id="h1">관리자</span>
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git
</div>

<div id="infoList">
<form action="<%=request.getContextPath()%>/views/user/updateInfo" method="post">
	<table id="userInfoTable">
		<tr>
			<th>이름</th>
<<<<<<< HEAD
			<td><input type="text" value="<%=userLoggedIn.getName() %>" name="userId" readonly /></td>
=======
			<td><input type="text" value="관리자 아이디" name="userId" readonly  /></td>
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git
		</tr>
		<tr>
<<<<<<< HEAD
			<th>포인트</th>
			<td><input type="text" value="0" readonly /></td>
=======
			<th>비밀번호</th>			
			<td><input type="password" value="현재비밀번호" readonly />
			<button class="btn" onclick="searchAddr(); " onclick="changeUserPwd(<%=userIdd%>);" >변경하기</button>
			</td>
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" value="<%=userLoggedIn.getPhone() %>" name="phone" /></td>
		</tr>
		<tr>
<<<<<<< HEAD
			<th>비밀번호</th>
			<td><input type="password" value="현재비밀번호" readonly />
			<button class="btn" onclick="changeUserPwd('<%=userLoggedIn.getUserId()%>');" >변경하기</button>
			</td>
		</tr>
		<tr>
=======
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git
			<th>주소</th>
			<td>
				<input type="text" value="<%=request.getParameter("addr1")%>"  name="addr1" readonly/>
				<input type="text" value="<%=request.getParameter("addr2")%>"  name="addr2" placeholder="상세주소"/>
				<button class="btn" onclick="searchAddr();">주소찾기</button>
			</td>
				
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" value="<%=userLoggedIn.getEmail() %>" name="email"/></td>
		</tr>
<<<<<<< HEAD
		<tr>
			<th>관심품목</th>
			<td>
			<%for(int i=0;i<interestArr.length;i++){
				String arr=""; %>
			<select name="interest<%=i+1%>" class="interestBo">
				<option selected >
				<%=interestArr[i] %>
				</option>
				  <option value="A">패션의류/잡화</option>
				  <option value="B">뷰티</option>
				  <option value="C">출산/유아동</option>
				  <option value="D">식품</option>
				  <option value="E">주방용품</option>
				  <option value="F">생활용품</option>
				  <option value="G">홈인테리어</option>
				  <option value="H">가전디지털</option>
				  <option value="I">스포츠/레저</option>
				  <option value="J">자동차용품</option>
				  <option value="K">도서/음반/DVD</option>
				  <option value="L">완구/취미</option>
				  <option value="M">문구/오피스</option>
				  <option value="N">반려동물용품</option>
				  <option value="O">헬스/건강식품</option>
				 </select>
				 <%} %>
			</td>
			
		</tr>
=======
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git
		<tr id="pad">
			<th></th>
			<td >
			<input type="submit" value="정보 수정" class="btnGroup"/> 
<<<<<<< HEAD
			<input type="button" value="탈퇴" class="btnGroup" onclick="deleteUser('<%=userLoggedIn.getUserId() %>');" />
=======
			<input type="button" value="회원관리" class="btnGroup" onclick="viewUser();" />
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git
			</td>
		</tr>
	</table>
</form>
</div>

<<<<<<< HEAD
<div id="interestBoard">
	<h3>관심글</h3>	
	<table id="interestSellBoard">
=======
<div id="Board">
	<div id="suggestionBoard" class="boardTitle">
	<p>건의게시판</p>
	<table>
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git
	<tr>
	<th>작성자</th>
	<th>제목</th>
	<th>작성일</th>
	</tr>
<<<<<<< HEAD
	 <%/* if(interestSBoardList!=null){  */
		for(int i=1;i<=14;i++){%>
		<tr>
		<td><nobr><%-- <%=b.getBoardNo() %> --%> <%=i %></nobr></td>
		<td><nobr><%-- <%=b.getBoardTitle() %> --%><%= i<7? (i+"번가방 팝니다!"):(i+"번가방 삽니다!") %></nobr></td>
		<td><nobr><%-- <%=b.getBoardWriter() %> --%><%=i %>번째작성</nobr></td>
		<td><nobr><%-- <%=b.getBoardReadCounter()%> --%><%=i %></nobr></td>
		</tr>
	<% /* } */ } %>
	</table>
	<div id="pageBar">
		페이지바
=======
	 <%for(int i=1;i<=5;i++){ %>
	<tr>
		<td><nobr>나는 <%=i %>번째 유저</nobr></td>
		<td><nobr>이것좀 고쳐주시면 감사하겠습니다 오버플로우를 왜 안먹을까요<%=i %></nobr></td>
		<td><nobr>2019/03/0<%=i %></nobr></td>
	</tr>
	 <%}%>
	</table>
	 <button type="button" id="move1" class="btn btn-secondary" onclick="moveSBoard(<%=userIdd%>)">건의게시판 바로가기</button>
	<%-- <button type="button" id="move1"onclick="moveSBoard('<%=userIdd%>')">건의게시판 바로가기</button> --%>
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git
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
	 <button type="button" id="move2" class="btn btn-secondary" onclick="moveRBoard(<%=userIdd%>)">신고게시판 바로가기</button>
	<%-- <button type="button" id="move2"onclick="moveRBoard('<%=userIdd%>')">건의게시판 바로가기</button> --%>
	</div>
</div>

<<<<<<< HEAD
<%-- <div id="interestBoardAll">
	<p>관심사 추천 글</p>
		<table id="recommendBoard">
		
		<tr>
		<!-- 판매게시판 글만 가져오므로 링크걸때 판매게시판쪽 DB만 보도록 해야함. 주의할것. -->
			<th><nobr><%=interestArr[0] %></nobr></th>
			<% for(int i=0;i<5;i++){%>
			<td><a href="<%=request.getContextPath()%>/"><img src="<%=request.getContextPath() %>/images/leo.jpg" alt="" /><br />
			<span><nobr><%=i %>번제품 팝니다!!!!!!!!!!!!!!!!1</nobr></span></a></td>
			<%} %>
		</tr>
		<tr>
		<!-- 판매게시판 글만 가져오므로 링크걸때 판매게시판쪽 DB만 보도록 해야함. 주의할것. -->
			<th><nobr><%=interestArr[1] %></nobr></th>
			<% for(int i=0;i<5;i++){%>
			<td><a href="<%=request.getContextPath()%>/"><img src="<%=request.getContextPath() %>/images/냥챗 아이콘.jpg" alt="" /><br />
			<span><nobr><%=i %>번제품 팝니다!!!!!!!!!!!!!!!!1</nobr></span></a></td>
			<%} %>
		</tr>
		<tr>
		<!-- 판매게시판 글만 가져오므로 링크걸때 판매게시판쪽 DB만 보도록 해야함. 주의할것. -->
			<th><nobr><%=interestArr[2] %></nobr></th>
			<% for(int i=0;i<5;i++){%>
			<td><a href="<%=request.getContextPath()%>/"><img src="<%=request.getContextPath() %>/images/강사님.PNG" alt="" /><br />
			<span><nobr><%=i %>번제품 팝니다!!!!!!!!!!!!!!!!1</nobr></span></a></td>
			<%} %>
		</tr>
		
		
		</table>
	</div>

</div> --%>









=======
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git

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
	location.href="<%=request.getContextPath()%>/views/admin/viewUserList?userId=<%=userIdd%>";
}
//비밀번호 변경페이지로 이동
function changeUserPwd(userId){
<<<<<<< HEAD
	location.href="<%=request.getContextPath()%>/views/user/updatePwd?userId="+userId;

=======
	location.href="<%=request.getContextPath()%>/views/user/updatePwd?userId="+<%=userIdd%>;
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git
}
<<<<<<< HEAD

function deleteUser(userId){
	location.href="<%=request.getContextPath()%>/views/user/deleteUser?userId="+userId;
}


=======
function moveSBoard(userId){
	location.href="<%=request.getContextPath()%>/views/opinion/suggestionBoard?userId="+userId;
}
function moveRBoard(userId){
	location.href="<%=request.getContextPath()%>/views/opinion/reportBoard?userId="+userId;
}
>>>>>>> branch 'DaHee' of https://github.com/TaeWonn/HoItZZa.git
</script>





<%@ include file="/WEB-INF/views/common/footer.jsp" %>