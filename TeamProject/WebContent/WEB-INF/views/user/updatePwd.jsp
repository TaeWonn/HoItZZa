<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user/findPwd.css" />
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<article id="article">
	<h1>비밀번호 변경</h1>
	<div id="changePwd">
		<%-- <%=request.getContextPath()%>/views/user/updatePwd --%>
		<form action="<%=request.getContextPath()%>/views/user/updatePwdEnd"
			method="post" onsubmit="return checkChangePwd();">
			<table id="changePwdTable">
				<tr>
					<th>변경 할 비밀번호</th>
					<td><input type="password" id="changePwd" name="changePwd"
						onkeyup="check();" /> <input type="hidden" name="findUserPwd_Id"
						value="<%=request.getAttribute("userId")%>" /></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" id="changePwd2" /></td>
				</tr>
				<tr>
					<th></th>
					<td>
						<button type="submit" class="btn btn-info" id="bt_1">변경완료</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</article>


<script>
	function checkChangePwd() {
		var pwd1 = $('input[name=changePwd]').val();
		var pwd2 = $('#changePwd2').val();

		if (pwd1 !== pwd2) {
			alert('비밀번호가 동일하지 않습니다. 다시 입력해주세요');
			$('input[name=changePwd]').val('');
			$('#changePwd2').val('');
			$('input[name=changePwd]').focus();
			return false;
		} else {
			return true;
		}

	}

	function check() {
		console.log($('#changePwd').val());

	}
	
	//주소창에 파라미터 값 숨기기
	history.replaceState({}, null, location.pathname);
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>