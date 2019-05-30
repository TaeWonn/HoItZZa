<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/userInfo.css" />
<article>

<div id="viewMain">
	<span id="h1"><%=userIdd %>님의 개인 페이지</span>
</div>

<div id="infoList">
<form action="">
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
				<input type="button" value="변경하기" onclick="changeUserPwd(<%=userIdd %>);" />
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" value="주소" />
				<input type="button" value="주소 변경" onclick="searchAddr();" />
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" value="user이메일주소" /></td>
		</tr>
		<tr>
			<th>관심품목</th>
			<%for(int i=0;i<interestArr.length;i++){
				String arr="";
			%>
			<td><select name="" id="interestBo">
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
			</td>
			<%} %>
		</tr>
		<tr>
			<th></th>
			<td id="interestBo"><input type="submit" value="정보 수정" /> </td>
		</tr>
	</table>
</form>
</div>

<div id="interestBoardList">



</div>











</article>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>