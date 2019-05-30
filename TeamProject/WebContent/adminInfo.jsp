<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

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
			<input type="button" id="viewUser" value="회원관리" class="btnGroup" />
			</td>
		</tr>
	</table>
</form>
</div>

<div id="reportBoard">
	<h3>관심글</h3>
	


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

</script>





<%@ include file="/WEB-INF/views/common/footer.jsp" %>