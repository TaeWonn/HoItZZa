<%@page import="message.model.vo.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	String pageBar=(String)request.getAttribute("pageBar");
	String searchKeyword=(String)request.getAttribute("searchKeyword");
	String searchType=(String)request.getAttribute("searchType");
	List<Message> list=(List<Message>)request.getAttribute("msgList");
	String senRec=(String)request.getAttribute("senRec");
	

%>
<style>
div#search-userId{
display: <%=searchType == null || "userId_find".equals(searchType) ? "inline-block" : "none"%>
}
div#search-content{
<%if(searchType!=null){%>
	display:inline-block;
	<%}else{%>
	display:none;
	<%}%>
}



</style>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/message/message.css" />

<article>
	<h2 id="title2" >쪽지함</h2>
	<form action="<%=request.getContextPath()%>/views/message/myMessage2" method="post" id="sub" >
		<div id="senRec">
		<select name="senRec"  onchange="submit();">
				<option value="receive"
					<%="receive".equals(senRec) ? "selected" : ""%>>받은 쪽지함</option>
				<option value="send"
					<%="send".equals(senRec) ? "selected" : ""%>>보낸 쪽지함</option>
			</select>
		</div>
		<input type="hidden" name="userId" value="<%=userLoggedIn.getUserId() %>" />
	</form>
	
	<table class="table">
		<thead class="thead-light">
			<tr id="tHeader">
				<th scope="col" style="max-width:80px;"><%=senRec==null||senRec.equals("receive")?"발신인":"수신인" %></th>
				<th scope="col">내용</th>
				<th scope="col" style="max-width: 90px;">작성일자</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
		<%if(senRec==null||senRec.equals("receive")){for(int i=0;i<list.size();i++){ %>
			<tr>
				<th scope="row"><nobr><%=list.get(i).getSender() %></nobr></th>
				<td><nobr><%= list.get(i).getContent()%></nobr></td>
				<td><nobr><%=list.get(i).getNoteDate() %></nobr></td>
				<td>
					<button type="button" class="btn btn-secondary"  onclick="reply('<%=userLoggedIn.getUserId() %>','<%=list.get(i).getSender()%>');">답장</button>
					<button type="button" class="btn btn-secondary"  onclick="deletemsg('<%=list.get(i).getMessageNo()%>','<%=list.get(i).getRecipient()%>');">삭제</button>
				</td>
			</tr>
		<%}}else{for(int i=0;i<list.size();i++){%>
		<tr>
				<th scope="row"><nobr><%=list.get(i).getRecipient() %></nobr></th>
				<td><nobr><%= list.get(i).getContent() %></nobr></td>
				<td><nobr><%=list.get(i).getNoteDate() %></nobr></td>
				<td></td>
			</tr>
		<%}} %>
		</tbody>
	</table>
	<br>
	<div id="pageBar">
		<%=pageBar!=null?pageBar:"" %>
	</div>
	
	<div id="search-container">
		<select name="" id="searchType" >
			<option value="userId"
				<%="userId".equals(searchType) ? "selected" : "" %>>아이디로
				조회</option>
			<option value="content"
				<%="content".equals(searchType) ? "selected" : "" %>>내용으로
				조회</option>
		</select>

		<div id="search-userId">

			<input type="search" onchange="insertKeyword(this);" 
				 size="25" placeholder="검색할 아이디를 입력하세요" 
				value='<%="userId".equals(searchType)?searchKeyword:"" %>' /> 
				<input type="button" value="검색" onclick="submit2();"/>
		</div>
		<div id="search-content">

			<input type="search" onchange="insertKeyword(this);" 
				value='<%="content".equals(searchType)?searchKeyword:"" %>'
				size="25" placeholder="검색할 내용을 입력하세요" />
			<input type="button" value="검색" onclick="submit2();"/>

		</div>
		
		<div id="sub">
		<form action="<%=request.getContextPath()%>/views/message/messageFinder" id="submit2" method="post">
			<input type="hidden" name="searchType" />
			<input type="hidden" name="searchKeyword" />
			<input type="hidden" name="userId" value="<%=userLoggedIn.getUserId()%>"/>
			<input type="hidden" name="senRec" value="<%=senRec!=null?senRec:"receive" %>" />
		</form>
		</div>
		
	</div>
</article>

<script>





function deletemsg(msgNo,userId){
	//사용자가 recipient, 보낸사람이 sender
	var bool=confirm('정말 삭제하시겠습니까?');
	if(bool){
	location.href="<%=request.getContextPath()%>/views/message/messageDelete?msgNo="+msgNo+"&userId="+userId;		
	}
}
function reply(sender,recipient){
	//사용자가 sender, 받는사람이 recipient
	var url="<%=request.getContextPath()%>/views/message/messageReply?senderId="+sender+"&recipient="+recipient;
	var title="쪽지 보내기";
	var specs="width=460px, height=500px, left=500px, top=200px";
	var popup=open(url, title,specs);

}

$('#searchType').change(function() {
	var value = $('#searchType option:selected').val();
	$('#search-container div').css('display', 'none');
	$('#search-' + value).css('display', 'inline-block');
	
	$('input[name=searchType]').val(value);
});
function insertKeyword(obj){
	 $('input[name=searchKeyword]').val(obj.value);
}
function submit2(){
	$('input[name=searchType]').val($('#searchType').val());	
	$('#submit2').submit();  
}

function submit(){
	$('#sub').submit();
}

//주소창에 파라미터 값 숨기기
history.replaceState({}, null, location.pathname);

</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>