<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/findId_pwd.css" />
<section>

</section>
	<div id="findUserService">
		<h1>회원 정보 찾기</h1>
		<br />
		<div id="findId">
		<form action="<%=request.getContextPath() %>/views/user/findId" method="post" >
			<h3 class="formTitle">아이디 찾기</h3>
			<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="findUserId_name"  /></td>
			</tr> 
			<tr>
				<th>전화번호</th>
				<td><input type="number" name="findUserId_phone"  placeholder="하이픈(-)없이 입력"/></td>
			</tr>
			<tr>
			<th></th>
			<td><button type="submit" class="btn btn-info">아이디 찾기</button></td></tr>
			</table>
		</form>
		</div>
		
		<div id="findPwd">
		<form action="<%=request.getContextPath() %>/views/user/findPwd" method="post" >
			<h3 class="formTitle">비밀번호 찾기</h3>
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="findUserPwd_Id"  /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="findUserPwd_name"  /></td>
				</tr>
				<tr>
					<th>주민등록번호</th>
					<td>
						<input type="text" class="ssn" name="findUserPwd_ssn_1" id="ssn_1" maxlength='6'/>&nbsp;ㅡ&nbsp;
						<input type="password" class="ssn" name="findUserPwd_ssn_2" id="ssn_2" maxlength='7' />
					</td>
				</tr>
				<tr>
					<th></th>
					<td><button type="submit" class="btn btn-info">비밀번호 찾기</button></td>
				</tr>
				
			</table>
		</form>
		</div>
	</div>
	

<%@ include file="/WEB-INF/views/common/footer.jsp" %>