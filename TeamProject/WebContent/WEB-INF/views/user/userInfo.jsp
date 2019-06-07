<%@page import="java.util.Date"%>
<%@page import="board.model.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%
	String pageBar = (String) request.getAttribute("pageBar");
	User u=(User)request.getAttribute("user");
	System.out.println(u);
  	List<Board> interestBBoardList=(List<Board>)request.getAttribute("interestList");
	List<Board> interest1BoardList=(List<Board>)request.getAttribute("interestCategoryList1");
	List<Board> interest2BoardList=(List<Board>)request.getAttribute("interestCategoryList2");
	List<Board> interest3BoardList=(List<Board>)request.getAttribute("interestCategoryList3"); 
	String[] interestArr=userLoggedIn.getInterest();
 
	String[] addrArr = userLoggedIn.getAddr().split(",");
%>
<style>
table#interestSellBoard2{position:absolute;width:308px;padding:0px;border:1px solid; border-collapse: collapse;
				top:40px; table-layout:fixed;}
table#interestSellBoard2 th{max-width:76px;border:1px solid;text-align: center;background: lightgray;text-overflow:ellipsis;}
table#interestSellBoard2 td{max-width:120px;border:1px solid;text-align: center;max-height: 10px;text-overflow:ellipsis;}
table#interestSellBoard2 th,td{overflow:hidden;}
table#interestSellBoard2 tr{max-height: 10px; overflow: hidden;}
</style>

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
			<td><input type="text" value="<%=userLoggedIn.getName() %>" name="userName" readonly /></td>
		</tr>
		<tr>
			<th>포인트</th>
			<td><input type="text" value="<%=userLoggedIn.getPoint()%>" readonly /></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" value="<%=userLoggedIn.getPhone() %>" name="phone" /></td>
		</tr>
		<tr>
			<th>비밀번호</th> 
			<td><input type="button" value="변경하기" class="btn" onclick="return changeUserPwd('<%=userLoggedIn.getUserId()%>','<%=userLoggedIn.getName() %>','<%=userLoggedIn.getSsn() %>');"  /></td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" value="<%=addrArr[0] %>"  name="addr1" readonly/>
				<input type="text" value="<%=addrArr[1] %>"  name="addr2" placeholder="상세주소"/>
				<input type="button" value="주소찾기" class="btn" onclick="searchAddr();"/>
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
			<select name="interest<%=i+1%>" class="interestBo" >
			<option value="" selected><%=interestArr[i] %></option>
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
			<input type="button" value="탈퇴" class="btnGroup" onclick="deleteUser('<%=userLoggedIn.getUserId()%>,<%=userLoggedIn.getSsn()%>,<%=userLoggedIn.getName()%>');" />
			</td>
		</tr>
	</table>
</form>
</div>

<div id="interestBoard">
	<h3>관심글</h3>	
 	 <%  if(interest1BoardList!=null){ %>
	<table id="interestSellBoard">
	<tr>
		<th><nobr>번호</nobr></th>
		<th><nobr>제목</nobr></th>
		<th><nobr>작성자</nobr></th>
		<th><nobr>조회수</nobr></th>
	</tr>
		<% for(int i=1;i<=14;i++){%>
		<tr>
			<td><nobr><%-- <%=b.getBoardNo() %> --%> <%=i %></nobr></td>
			<td><nobr><%-- <%=b.getBoardTitle() %> --%><%= i<7? (i+"번가방 팝니다!"):(i+"번가방 삽니다!") %></nobr></td>
			<td><nobr><%-- <%=b.getBoardWriter() %> --%><%=i %>번째작성</nobr></td>
			<td><nobr><%-- <%=b.getBoardReadCounter()%> --%><%=i %></nobr></td>
		</tr>
	<%  } }else{ %>
	<table id="interestSellBoard2">
	<colgroup>
	    <col width="55px">
        <col width="55px">  <!-- 너비를 지정해주어야한다 -->
        <col width="55px">  <!-- 너비를 지정해주어야한다 -->
        <col width="55px">
	</colgroup>
			<tr>
				<th><nobr>번호</nobr></th>
				<th><nobr>제목</nobr></th>
				<th><nobr>작성자</nobr></th>
				<th><nobr>조회수</nobr></th>
			</tr>
			<tr>
				<td colspan="4">관심글이 존재하지 않습니다.</td>
			</tr>
	
	<%} %> 
	</table>
	<div id="pageBar" style="top:460px;">
		<%=pageBar %>
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
function changeUserPwd(userId,name,ssn){
	console.log(userId);
	console.log(typeof ssn);
	var ssn1=ssn.substring(0,6);
	console.log(ssn1);
	var ssn2=ssn.substring(6);
	console.log(ssn2);
	location.href="<%=request.getContextPath()%>/views/user/updatePwd?findUserPwd_Id="+userId+"&findUserPwd_name="+name+"&findUserPwd_ssn_1="+ssn1+"&findUserPwd_ssn_2="+ssn2;
	return false;
}
function deleteUser(userId){
	var bool=confirm('정말 탈퇴하시겠습니까??');
	if(bool){
	location.href="<%=request.getContextPath()%>/views/user/deleteUser?userId="+userId;
	}
}
//주소창에 파라미터 값 숨기기
history.replaceState({}, null, location.pathname);
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>