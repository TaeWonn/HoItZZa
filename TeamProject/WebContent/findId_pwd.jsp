<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<section>

</section>
	<h1>회원 정보 찾기</h1>
	<div id="findId">
	<form action="" method="post" >
		<h2>아이디 찾기</h2>
		<table>
		<tr>
			<th>이름</th>
			<td><input type="text" name="findUserId_name" id="fId" /></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="number" name="findUserId_phone" id="fId2" placeholder="하이픈(-)없이 번호 입력해주세요."/></td>
		</tr>
		<tr>
		<th></th>
		<td><button type="submit" class="btn btn-info">아이디 찾기</button></td></tr>
		</table>
	</form>
	</div>

	<div id="fintPwd">
	<form action="">
		<h2>비밀번호 찾기</h2>
		<input type="text" name="findUserId" id="fId" />
		<button type="submit" class="btn btn-info">Info</button>
	</form>
	</div>
	
	

<%@ include file="/WEB-INF/views/common/footer.jsp" %>