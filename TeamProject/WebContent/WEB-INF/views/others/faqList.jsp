<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <%@ include file="/WEB-INF/views/common/header.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/others/faqList.css" />

<article>

	<section>
		<div id="faq-container">
			<h2>쎌빠 FAQ</h2>
			<table id="faq-tbl" >
			<colgroup>
				<col width="35px">
				<col width="135px">
				<col width="80px">
				<col width="360px">
			</colgroup>
				<tr>
					<th>순서</th>
					<th>대분류</th>
					<th>중분류</th>
					<th>제목</th>
				</tr>
				<tr id="p-tag">
					<td>1</td>
					<td>서비스/피해/오류문의</td>
					<td>계정문의</td>
					<td>경고를 받아서 계정이 삭제되었습니다. 재가입 할수 있나요?
						<p>&nbsp;&nbsp;┖ 경고 누적3회로 인해 발생한 계정삭제는 허위사실로 인한
						<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;경고가 아닌이상 복구는 불가하며 재가입도 불가합니다.</p>
					</td>
				</tr>
				<tr id="p-tag">
					<td>2</td>
					<td>서비스/피해/오류문의</td>
					<td>피해문의<p></td>
					<td>악의적인 허위 신고때문에 경고를 먹었습니다. 조사해서 허위 신고자를 처벌할 수 없을까요?
						<p>&nbsp;&nbsp;┖ 신고처리된 부분을 조사해서 허위적인 신고라고 판명나
						<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;면 허위 신고자에게 경고처리 하겠습니다.</p>
					</td>
				</tr>
				<tr id="p-tag">
					<td>3</td>
					<td>결제/충전/환불</td>
					<td>결제/환불</td>
					<td>포인트 결제도중에 문제가 발생했습니다. 포인트가 날라갔는데 복구해주시면 안될까요?
						<p>&nbsp;&nbsp;┖ 결제,거래	내역을 확인하고 복구처리 해드리겠습니다.</p>
					</td>
				</tr>
				<tr id="p-tag">
					<td>4</td>
					<td>서비스/피해/오류문의</td>
					<td>피해문의</td>
					<td>사기를 당했는데 사기친 사람에 계정을 차단 해주실 수 없을까요?
						<p>&nbsp;&nbsp;┖ 기본적으로 신고하기를 해주시면 저희가 조사해서 경고 
						<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;처리를 합니다. 사기를 당하신 경우에는 증거물을 보내주 
						<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;시면 계정을 차단하도록 하겠습니다.</p>
					</td>
				</tr>
				<tr id="p-tag">
					<td>5</td>
					<td>서비스/피해/오류문의</td>
					<td>피해문의</td>
					<td>사기당한 피해자인데 고소를 할려고 합니다. 사기친 사람이 게시글을 지워서 증거가 없는데 게시글을 보여주시면 안될까요?
						<p>&nbsp;&nbsp;┖ 개인정보 보호법에 의해 경찰동석없이는 알려드릴수 없 
						<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;습니다. 먼저 경찰에 신고를 하시고 사이트에 문의하시면  
						<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게시글 정보를 내어 드리겠습니다.</p>
					</td>
				</tr>
				<tr id="p-tag">
					<td>6</td>
					<td>서비스/피해/오류문의</td>
					<td>서비스문의</td>
					<td>삭제한 게시글을 다시 복구해서 게시할수 있을까요?
						<p>&nbsp;&nbsp;┖ 삭제한 게시글에경우 복구처리를하지 않습니다.</p>
					</td>
				</tr>
				
				<tr id="p-tag">
					<td>7</td>
					<td>결제/충전/환불</td>
					<td>충전</td>
					<td>포인트 충전이 되지 않습니다. 계좌 계좌에서 돈은 빠져나갔는데 포인트 충전이 안됬어요.
						<p>&nbsp;&nbsp;┖ 저희쪽 계좌를 확인하고 돈이 들어와있는게 확인되면 
						<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포인트를 충전해 드리겠습니다.</p>
					</td>
				</tr>
			</table>
		</div>
	</section>
</article>
<script>
$("tr:first").nextAll().click(function() {
	$(this).children("td:last").children("p").slideToggle(100).css("color","black");
});
</script>
 <%@ include file="/WEB-INF/views/common/footer.jsp"%>
