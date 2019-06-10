<%@page import="sell.model.vo.Sell"%>
<%@page import="file.model.vo.FileTable"%>
<%@page import="java.util.Date"%>
<%@page import="board.model.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%
	String pageBar = (String) request.getAttribute("pageBar");
	User u=(User)request.getAttribute("user");
  	List<Sell> interestBoardList=(List<Sell>)request.getAttribute("interestBoardList");
	List<Sell> interest1BoardList=(List<Sell>)request.getAttribute("firstInterestList");
	List<Sell> interest2BoardList=(List<Sell>)request.getAttribute("secondInterestList");
	List<Sell> interest3BoardList=(List<Sell>)request.getAttribute("thirdInterestList"); 
	String[] interestArr=userLoggedIn.getInterest();
	String reason=(String)request.getAttribute("reason");
	List<FileTable> intFile1=(List<FileTable>)request.getAttribute("intFile1");
	List<FileTable> intFile2=(List<FileTable>)request.getAttribute("intFile2");
	List<FileTable> intFile3=(List<FileTable>)request.getAttribute("intFile3");
 
	String[] addrArr = u.getAddr().split(",");

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
	<span id="h1"><%=u.getUserId()%>님의 개인 페이지</span>
</div>

<div id="infoList">
<form action="<%=request.getContextPath() %>/views/user/updateInfo" method="post">
	<table id="userInfoTable">
	
		<tr>
			<th>이름</th>
			<td><input type="text" value="<%=u.getName() %>" name="userName" readonly /></td>
		</tr>
		<tr>
			<th>포인트</th>
			<td><input type="text" value="<%=u.getPoint()%>" readonly /></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" value="<%=u.getPhone() %>" name="phone" /></td>
		</tr>
		<tr>
			<th>비밀번호</th> 
			<td><input type="button" value="변경하기" class="btn" onclick="return changeUserPwd('<%=u.getUserId()%>','<%=u.getName() %>','<%=u.getSsn() %>');"  /></td>
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
			<td><input type="email" value="<%=u.getEmail() %>" name="email"/></td>
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
			<input type="button" value="탈퇴" class="btnGroup" onclick="deleteUser('<%=u.getUserId()%>,<%=u.getSsn()%>,<%=u.getName()%>');" />
			<%if(userLoggedIn.getUserId().equals("admin")){ %>
			<input type="button" value="블랙리스트 " class="btnGroup" onclick="blackUser('<%=u.getUserId()%>','<%=reason %>);" />			
			<%} %>
			</td>
		</tr>
	</table>
</form>
</div>

<div id="interestBoard">
	<h3>관심글</h3>	
 	
 	<table id="interestSellBoard">
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
	 <%  if(interestBoardList!=null){ %>
		<% for(Sell s:interestBoardList){%>
		<tr>
			<td><nobr> <%=s.getBoardNo() %> </nobr></td>
			<td><nobr> <%=s.getBoardTitle() %> </nobr></td>
			<td><nobr><%=s.getBoardWriter() %> </nobr></td>
			<td><nobr> <%=s.getBoardReadCounter()%> </nobr></td>
		</tr>
	<% }}else{ %>
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
			<% if(interest1BoardList!=null){for(int i=0;i<interest1BoardList.size();i++){%>
			<%if(intFile1!=null){ %>
			<td><a href="<%=request.getContextPath()%>/sell/sellView?boardNo=<%=interest1BoardList.get(i).getBoardNo()%>">
			<img src="<%=request.getContextPath() %>/upload/sell/<%=intFile1.get(i).getRenamedFileName() %>" alt="" /><br />
			<span><nobr><%=interest1BoardList.get(i).getBoardTitle()%></nobr></span></a></td>
			<%}else{%>
			<td><a href="<%=request.getContextPath()%>/sell/sellView?boardNo=<%=interest1BoardList.get(i).getBoardNo()%>">
			<br />
			<span><nobr><%=interest1BoardList.get(i).getBoardTitle()%></nobr></span></a></td>
			<%}}} %>
		</tr>
		<tr>
		<!-- 판매게시판 글만 가져오므로 링크걸때 판매게시판쪽 DB만 보도록 해야함. 주의할것. -->
			<th><nobr><%=interestArr[1] %></nobr></th>
			<% if(interest2BoardList!=null){for(int i=0;i<interest2BoardList.size();i++){%>
			<%if(intFile2!=null){ %>
			<td><a href="<%=request.getContextPath()%>/sell/sellView?boardNo=<%=interest2BoardList.get(i).getBoardNo()%>">
			<img src="<%=request.getContextPath() %>/upload/sell/<%=intFile2.get(i).getRenamedFileName() %>" alt="" /><br />
			<span><nobr><%=interest2BoardList.get(i).getBoardTitle()%></nobr></span></a></td>
			<%}else{%>
			<td><a href="<%=request.getContextPath()%>/sell/sellView?boardNo=<%=interest2BoardList.get(i).getBoardNo()%>">
			<br />
			<span><nobr><%=interest2BoardList.get(i).getBoardTitle()%></nobr></span></a></td>
			<%}}} %>
		</tr>
		<tr>
		<!-- 판매게시판 글만 가져오므로 링크걸때 판매게시판쪽 DB만 보도록 해야함. 주의할것. -->
			<th><nobr><%=interestArr[2] %></nobr></th>
			<% if(interest3BoardList!=null){for(int i=0;i<interest3BoardList.size();i++){%>
			<%if(intFile3!=null){ %>
			<td><a href="<%=request.getContextPath()%>/sell/sellView?boardNo=<%=interest3BoardList.get(i).getBoardNo()%>">
			<img src="<%=request.getContextPath() %>/upload/sell/<%=intFile3.get(i).getRenamedFileName() %>" alt="" /><br />
			<span><nobr><%=interest3BoardList.get(i).getBoardTitle()%></nobr></span></a></td>
			<%}else{%>
			<td><a href="<%=request.getContextPath()%>/sell/sellView?boardNo=<%=interest3BoardList.get(i).getBoardNo()%>">
			<br />
			<span><nobr><%=interest3BoardList.get(i).getBoardTitle()%></nobr></span></a></td>
			<%}}} %>
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

function blackUser(userId,reason){
	var bool=confirm('경고횟수가 3회 이상인것을 확인 하셨습니까?');
	if(bool){
	location.href="<%=request.getContextPath()%>/admin/insertBlackList?userId="+userId+"&reason="+reason;
	}else{
		return;
	}
}

</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>