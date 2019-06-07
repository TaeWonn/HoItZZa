<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user/findId_pwd.css" />
<article id="article">
	<div id="findUserService">
		<h1>회원 정보 찾기</h1>
		<br />
		<div id="findId">
		<form action="<%=request.getContextPath() %>/views/user/findId" method="post" onsubmit="checkFindId();">
			<h3 class="formTitle">아이디 찾기</h3>
			<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="findUserId_name" required="required" /></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="number" name="findUserId_phone"  placeholder="하이픈(-)없이 입력" required /></td>
			</tr>
			<tr>
			<th></th>
			<td><button type="submit" class="btn btn-info">아이디 찾기</button></td></tr>
			</table>
		</form>
		</div>
		
		<div id="findPwd">
		<form action="<%=request.getContextPath() %>/views/user/findPwd" method="post" onsubmit="return checkPwdInfo();" >
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
</article>
<script>
function checkFindId(){
	var name=$('input[name=findUserId_name]').val().trim();
	var phone=$('input[name=findUserId_phone]').val().trim();
	if(name.length==0){
		alert('이름을 입력해주세요');
		return;
	}else{
		if(phone.length==0){
			alert('휴대폰 번호를 입력해주세요');
			return;	
		}else{
			var checkcontains=phone.indexOf('-');
			if(checkcontains!=-1){
				alert('하이픈을 제외하고 입력해주세요');
				return;	
			}
		}
	}
	
	return true;
}

function checkPwdInfo(){
	var $id=$('input[name=findUserPwd_Id]').val().trim();
	var $name=$('input[name=findUserPwd_name]').val().trim();
	var ssn1=$('#ssn_1').val().trim();
	var ssn2=$('#ssn_2').val().trim();
	//주민등록번호 유효성 검사
	var reg1=/^[0-9]{6}$/;
	var regSsn1=reg1.test(ssn1);
	var reg2=/^[0-9]{7}$/;
	var regSsn2=reg2.test(ssn2);
	
	if($id.length==0){
		alert('아이디가 입력되지 않았습니다.');
		return false;
	}else if($name.length==0){
		alert('이름이 입력되지 않았습니다.');
		return false;
	}else if(ssn1.length==0||ssn2.length==0){
		alert('주민등록번호가 입력되지 않았습니다.');
		return false;
	}else if(!regSsn1 || !regSsn2){
		alert('올바른 주민등록 번호를 입력해주세요.');
		return false;
	}
	
	else return true;
	
	
}
//주소창에 파라미터 값 숨기기
history.replaceState({}, null, location.pathname);

</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>