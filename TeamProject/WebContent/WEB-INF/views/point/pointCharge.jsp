<%@page import="point.model.vo.Point"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../common/error.jsp"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
    List<Point> pointList=(List<Point>)request.getAttribute("list");
    String pageBar=(String)request.getAttribute("pageBar");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/point/pointCharge.css" />
<script src="<%=request.getContextPath()%>/js/jquery-3.4.0.js"></script>
<style>
/*페이지바*/
div#pageBar {
	margin-top: 10px;
	text-align: center;
}
div#pageBar a, span {
	margin: 5px;
}
div#pageBar .cPage {
	color: blue;
}
</style>
<article id="chargePoint">
	<h2>포인트 충전하기</h2>
	<div id="wantPoint">
	<table id="PointList">
	<colgroup>
	        <col width="460px">
	        <col width="40px">  <!-- 너비를 지정해주어야한다 -->
   	</colgroup>
	<thead>
		<tr>
			<th>포인트</th>
			<th>선택</th>
		</tr>
	</thead>
	<tbody>
	
		<tr>
			<td>5000 Point</td>
			<td><input type="radio" name="point" id="" value="5000" onchange="setVal(this)"  /></td>
		</tr>
		<tr>
			<td>10000 Point</td>
			<td><input type="radio" name="point" id="" value="10000" onchange="setVal(this)"/></td>
		</tr>
		<tr>
			<td>15000 Point</td>
			<td><input type="radio" name="point" id="" value="15000" onchange="setVal(this)" /></td>
		</tr>
		<tr>
			<td>20000 Point</td>
			<td><input type="radio" name="point" id="" value="20000" onchange="setVal(this)" /></td>
		</tr>
		<tr>
			<td>30000 Point</td>
			<td><input type="radio" name="point" id="" value="30000" onchange="setVal(this)" /></td>
		</tr>
		<tr>
			<td>35000 Point</td>
			<td><input type="radio" name="point" id="" value="35000" onchange="setVal(this)" /></td>
		</tr>
		<tr>
			<td>40000 Point</td>
			<td><input type="radio" name="point" id="" value="40000" onchange="setVal(this)" /></td>
		</tr>
		<tr>
			<td>50000 Point</td>
			<td><input type="radio" name="point" id="" value="50000" onchange="setVal(this)" /></td>
		</tr>
		<form action="<%=request.getContextPath() %>/views/point/pointChargeEnd" method="post">
		<tr>
			<td colspan="2">
			<input type="hidden" name="userId" value="<%=userLoggedIn.getUserId()%>" />
			<input type="hidden" name="chargeMoney" />
			<input type="submit" value="충전하기" />
			</td>
		</tr>
		</form>
	</tbody>
	</table>
	</div>
	
	<!-- 포인트 충전내역 확인 -->
	<div id="viewPointList">
	<table id="userPointList">
	<colgroup>
	        <col width="300px">
	        <col width="200px">  <!-- 너비를 지정해주어야한다 -->
   	</colgroup>
	<thead>
		<tr>
			<th>충전일</th>
			<th>충전포인트</th>
		</tr>
	</thead>
	<tbody>
		 <% if(pointList!=null){ for(int i=0;i<pointList.size();i++){ %>
		<tr>
			<td><%=pointList.get(i).getChargeDate() %></td>
			<td><%=pointList.get(i).getChargeMoney() %>포인트</td>
		</tr>
 		<%}}else{ %>
		<tr>
			<td colspan="2">충전내역이 존재하지 않습니다.</td>
		</tr>
		<%} %> 
	</tbody>
	</table>
	</div>
	<div id="pageBar">
		<%=pageBar!=null?pageBar:"" %>
	</div>
</article>
<script>
function setVal(obj){
    console.log(obj.value);
    $('input[name=chargeMoney]').val(obj.value);
}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>