
<%@page import="java.util.Date"%>
<%@page import="board.model.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%
	//String pageBar = (String) request.getAttribute("pageBar");
	User user=(User)request.getAttribute("user");
  	List<Board> interestBBoardList=(List<Board>)request.getAttribute("interestList");
	List<Board> interest1BoardList=(List<Board>)request.getAttribute("interestCategoryList1");
	List<Board> interest2BoardList=(List<Board>)request.getAttribute("interestCategoryList2");
	List<Board> interest3BoardList=(List<Board>)request.getAttribute("interestCategoryList3"); 
 
	String[] interestArr=userLoggedIn.getInterest();
	

%>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user/userInfo.css" />

<article>

<div id="viewMain">
	<span id="h1"><%=userLoggedIn.getUserId()%>님의 개인 페이지</span>
</div>

<div id="infoList">
<form action="<%=request.getContextPath() %>/views/user/updateInfo" method="post">
	<table id="userInfoTable">
		<tr>
			<th>이름</th>
			<td><input type="text" value="<%=userLoggedIn.getName() %>" name="userId" readonly /></td>
		</tr>
		<tr>
		
			<th>포인트</th>
			<td><input type="text" value="0" readonly /></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" value="<%=userLoggedIn.getPhone() %>" name="phone" /></td>
		</tr>
		<tr>
			<th>비밀번호</th> 
			<td><input type="password" value="현재비밀번호" readonly />
			<button class="btn" onclick="changeUserPwd('<%=userLoggedIn.getUserId()%>');" >변경하기</button>
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
			<td><input type="email" value="<%=userLoggedIn.getEmail() %>" name="email"/></td>
		</tr>
		<tr>
			<th>관심품목</th>
			<td>
			<%for(int i=0;i<interestArr.length;i++){%>
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
		<tr id="pad">
			<th></th>
			<td >
			<input type="submit" value="정보 수정" class="btnGroup"/> 
			<input type="button" value="탈퇴" class="btnGroup" onclick="deleteUser('<%=userLoggedIn.getUserId() %>');" />
			</td>
		</tr>
	</table>
</form>
</div>

<div id="interestBoard">
	<h3>관심글</h3>	
	<table id="interestSellBoard">
	<tr>
		<th><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th><nobr>작성자</nobr></th>
		<th><nobr>조회수</nobr></th>
	</tr>
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
	</div>
	
</div>

<div id="interestBoardAll">
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
	location.href="<%=request.getContextPath()%>/views/user/updatePwd?userId="+userId;

}

function deleteUser(userId){
	location.href="<%=request.getContextPath()%>/views/user/deleteUser?userId="+userId;
}


</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>