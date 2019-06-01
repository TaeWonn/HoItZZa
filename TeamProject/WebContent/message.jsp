<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user/message.css" />
<link
	href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user/message.css" />
<article>

	<h2 id="title2" >쪽지함</h2>
	<table class="table">
		<thead class="thead-light">
			<tr id="tHeader">
				<th scope="col" style="max-width:80px;">발신인</th>
				<th scope="col">내용</th>
				<th scope="col" style="max-width: 90px;">작성일자</th>
				<th scope="col">Handle</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">Mark</th>
				<td>Sparta!</td>
				<td>1993/23/34</td>
				<td>
					<button type="button" class="btn btn-secondary"
						onclick="deletemsg();">삭제</button>

					<button type="button" class="btn btn-secondary" onclick="reply();"
						value="gg">답장</button>
				</td>
			</tr>
			<tr>
				<th scope="row">Jacob</th>
				<td>Jacob</td>
				<td>1902/04/01</td>
				<td>
					<button type="button" class="btn btn-secondary"
						onclick="deletemsg();">삭제</button>

					<button type="button" class="btn btn-secondary" onclick="reply();">답장</button>
				</td>
			</tr>
			<tr>
				<th scope="row">Larry</th>
				<td>the Bird</td>
				<td>2012/02/23</td>
				<td>
					<button type="button" class="btn btn-secondary"
						onclick="deletemsg();">삭제</button>

					<button type="button" class="btn btn-secondary" onclick="reply();">답장</button>
				</td>
			</tr>
			<tr>
				<th scope="row">Larry</th>
				<td>the Bird</td>
				<td>2039/12/03</td>
				<td>
					<button type="button" class="btn btn-secondary"
						onclick="deletemsg();">삭제</button>

					<button type="button" class="btn btn-secondary" onclick="reply();">답장</button>
				</td>
			</tr>
			<tr>
				<th scope="row">Larry</th>
				<td>안녕하세요</td>
				<td>1994/02/33</td>
				<td>
					<button type="button" class="btn btn-secondary"
						onclick="deletemsg();">삭제</button>

					<button type="button" class="btn btn-secondary" onclick="reply();">답장</button>
				</td>
			</tr>

		</tbody>

	</table>
	<br>
	<br>
	<table class="table2">
		<thead class="thead-light">
			<tr>
				<th scope="col">날짜</th>
				<th scope="col">메세지</th>
				<th scope="col">수신인</th>
				<th scope="col">발신인</th>
				<th scope="col"><button type="button"
						class="btn btn-outline-danger">삭제</button></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">작성자명</th>
				<td>Mark</td>
				<td>Otto</td>
				<td></td>
				<td><input type="checkbox" name="" id="" class="del_check"></td>
			</tr>
			<tr>
				<th scope="row">작성자명</th>
				<td>Jacob</td>
				<td>Thornton</td>
				<td></td>
				<td><input type="checkbox" name="" id="" class="del_check"></td>
			</tr>
			<tr>
				<th scope="row">작성자명</th>
				<td>Larry</td>
				<td>the Bird</td>
				<td></td>
				<td><input type="checkbox" name="" id="" class="del_check"></td>
			</tr>
			<tr>
				<th scope="row">작성자명</th>
				<td>Larry</td>
				<td>the Bird</td>
				<td></td>
				<td><input type="checkbox" name="" id="" class="del_check"></td>
			</tr>
			<tr>
				<th scope="row">작성자명</th>
				<td>Larry</td>
				<td>the Bird</td>
				<td></td>
				<td><input type="checkbox" name="" id="" class="del_check"></td>
			</tr>

		</tbody>

	</table>
</article>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
