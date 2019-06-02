<%@page import="java.util.Date"%>
<%@page import="board.model.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%
	String pageBar = (String) request.getAttribute("pageBar");
	List<Board> interestBBoardList=(List<Board>)request.getAttribute("Binterest");
	List<Board> interestSBoardList=(List<Board>)request.getAttribute("Sinterest");
	List<Board> interest1BoardList=(List<Board>)request.getAttribute("1BoardList");
	List<Board> interest2BoardList=(List<Board>)request.getAttribute("2BoardList");
	List<Board> interest3BoardList=(List<Board>)request.getAttribute("3BoardList");
%>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user/userInfo.css" />

<article>

<div id="viewMain">
	<span id="h1"><%=userIdd %>님의 개인 페이지</span>
</div>

<div id="infoList">
<form action="<%=request.getContextPath() %>/views/user/updateInfo" method="post">
	<table id="userInfoTable">
		<tr>
			<th>이름</th>
			<td><input type="text" value="유저이름" name="userId" readonly /></td>
		</tr>
		<tr>
			<th>포인트</th>
			<td><input type="text" value="소지포인트" readonly /></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" value="전화번호" name="phone" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" value="현재비밀번호" readonly />
			<button class="btn" onclick="searchAddr(); " onclick="changeUserPwd('<%=userIdd%>');" >변경하기</button>
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
		<tr>
			<th>관심품목</th>
			<td>
			<%for(int i=0;i<interestArr.length;i++){
				String arr=""; %>
			<select name="interest<%=i+1%>" class="interestBo">
				<option selected >
				<%if(interestArr[i].equals("A")){
		 		arr="패션의류/잡화";
				}else if(interestArr[i].equals("B")){
					arr="뷰티";
				}else if(interestArr[i].equals("C")){
					arr="출산/유아동";
				}else if(interestArr[i].equals("D")){
					arr="식품";
				}else if(interestArr[i].equals("E")){
					arr="주방용품";
				}else if(interestArr[i].equals("F")){
					arr="생활용품";
				}else if(interestArr[i].equals("G")){
					arr="홈인테리어";
				}else if(interestArr[i].equals("H")){
					arr="가전디지털";
				}else if(interestArr[i].equals("I")){
					arr="스포츠/레저";
				}else if(interestArr[i].equals("J")){
					arr="자동차 용품";
				}else if(interestArr[i].equals("K")){
					arr="도서/음반/DVD";
				}else if(interestArr[i].equals("L")){
					arr="완구/취미";
				}else if(interestArr[i].equals("M")){
					arr="문구/오피스";
				}else if(interestArr[i].equals("N")){
					arr="반려동물용품";
				}else{
					arr="헬스/건강식품";
				}%>
				<%=arr %>
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
			<input type="button" value="탈퇴" class="btnGroup" />
			</td>
		</tr>
	</table>
</form>
</div>

<div id="interestBoard">
	<h3>관심글</h3>	
	<p id="p1">판매글</p>
	<table id="interestSellBoard">
	<tr>
		<th><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th><nobr>작성자</nobr></th>
		<th><nobr>조회수</nobr></th>
	</tr>
	 <%/* if(interestSBoardList!=null){  */
		for(int i=1;i<=5;i++){%>
		<tr>
		<td><nobr><%-- <%=b.getBoardNo() %> --%> <%=i %></nobr></td>
		<td><nobr><%-- <%=b.getBoardTitle() %> --%><%=i %>번 가방 팝니다</nobr></td>
		<td><nobr><%-- <%=b.getBoardWriter() %> --%><%=i %>번째작성</nobr></td>
		<td><nobr><%-- <%=b.getBoardReadCounter()%> --%><%=i %></nobr></td>
		</tr>
	<% /* } */ } %>
	</table>
	<p id="p2">구매글</p>
	<!-- sellboard -->
	<table id="interestBuyBoard">
	<tr>
		<th><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th><nobr>작성자</nobr></th>
		<th><nobr>조회수</nobr></th>
	</tr>
	 <%/* if(interestSBoardList!=null){  */
		for(int i=1;i<=5;i++){%>
		<tr>
		<td><nobr><%-- <%=b.getBoardNo() %> --%> <%=i %></nobr></td>
		<td><nobr><%-- <%=b.getBoardTitle() %> --%><%=i %>번 가방 삽니다</nobr></td>
		<td><nobr><%-- <%=b.getBoardWriter() %> --%><%=i %>번째작성</nobr></td>
		<td><nobr><%-- <%=b.getBoardReadCounter()%> --%><%=i %></nobr></td>
		</tr>
	<% /* } */ } %>
	</table>
	
</div>

<div id="interestBoardAll">
	관심사  연관 글
	<div id="first" class="list3">
	첫번째 관심품목명
		<table>
		<tr>

		</tr>
		</table>
	</div>
	<div id="second" class="list3">
		두번째 관심품목
	</div>
	<div id="third" class="list3">
		세번쨰 관심품목
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
	location.href="<%=request.getContextPath()%>/views/user/updatePwd?userId="+userId;
}
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>