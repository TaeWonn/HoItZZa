<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user/findPwd.css" />
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	String userA=(String)request.getAttribute("userId");
%>
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
						onkeyup="check();" placeholder="특수,영문,숫자 4~15자리"/> <input type="hidden" name="findUserPwd_Id"
						value="<%=userA%>" /></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" id="changePwd2" placeholder="비밀번호 재입력"/></td>
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
	function regTest(reg,info,msg){
		console.log(info);
	  if(reg.test(info)){
	      return true;
	  }else{
	      alert(msg);
	      return false;
	  }
	}
	function checkChangePwd() {
		var pwd1 = $('input[name=changePwd]').val();
		var pwd2 = $("#changePwd2").val();
		var result=true;
		
		var reg=/^.*(?=^.*\S{4,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).*$/g;
		
		console.log(pwd2+"/2");
		console.log(pwd1+"/1");
		var bool=regTest(reg,pwd1,'비밀번호를 다시 입력해주세요.');
		
		console.log(bool);
		if(!bool){
			$('input[name=changePwd]').val('');
			$('#changePwd2').val('');
			$('input[name=changePwd]').focus();
			result=false;
		}
		else{
			if (pwd1 !== pwd2){
				alert('비밀번호가 동일하지 않습니다. 다시 입력해주세요');
				$('input[name=changePwd]').val('');
				$('#changePwd2').val('');
				$('input[name=changePwd]').focus();
				result=false;
			} else {
				result=true;
			}	
		}
		return result;

	}

	function check() {
		console.log($('#changePwd').val());

	}
	
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>