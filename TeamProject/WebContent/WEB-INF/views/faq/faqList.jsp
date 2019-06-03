<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user/userJoin.css" />
<!-- 회원가입 view단 -->
<article>

	<div id="faq-container">
		<h2>FAQ페이지</h2>
		<table>
			<tr>
				<td>경고를 받아서 계정이 삭제되었습니다. 재가입 할수 있나요?</td>
			</tr>	
			<tr>
				<td>악의적인 허위 신고때문에 경고를 먹었습니다. 조사해서 허위 신고자를 처벌할 수 없을까요?</td>
			</tr>	
			<tr>
				<td>포인트 결제도중에 문제가 발생했습니다. 포인트가 날라갔는데 구해주시면 안될까요?</td>
			</tr>	
			<tr>
				<td>사기를 당했는데 사기친 사람 바로 계정차단되게 해주실 수 없을까요?</td>
			</tr>	
			<tr>
				<td>사기당한 피해자인데 고소를 할려고 합니다. 사기친 사람 정보를 알려주시면 안될까요?</td>
			</tr>	
			<tr>
				<td>삭제한 게시글을 다시 복구해서 게시할수 있나요?</td>
			</tr>	
			<tr>
				<td>포인트 충전이 되지 않습니다. 계좌 문제인지 아니면 다른 문제인지 확인좀해주세요.</td>
			</tr>	
			<!-- 일단 채우기만함 -->
		</table>
	</div>

</article>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>