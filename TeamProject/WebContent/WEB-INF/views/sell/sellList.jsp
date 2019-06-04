<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="sell.model.vo.Sell, java.util.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<Sell> list = (List<Sell>)request.getAttribute("sell");
	String pageBar = (String)request.getAttribute("pageBar");
	//header.jsp에 memberLoggedIn변수를 선언했으므로, 이 페이지에서는 선언할 필요 없음.
    //Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/boardForm.css" />

  <link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
 <style>
body{
	margin: auto;
}
 
 #btn-add{
 float: right;}
#pageBar{
text-align: center;
}
#pageBar{
  border-radius: 5px;
}

#pageBar {
  border-radius: 5px;
}
 
    .table{
        width: 610px; 
        border: none;
        border-top: 2px solid rgb(196, 192, 192);
        border-bottom: 2px solid rgb(196, 192, 192);
        padding: 15px;
        margin: 20px auto;
        text-align: center;
        font-size: 15px;
    }
    .table #title{
      width: 200px;
    }
    
    .table td, .table tr th{
    border: none;
    border-bottom: 0.5px solid lightgray;
    }
    .thead-light{
    font-size : 14px;}
    </style>
</head>
<body>  
<body>
	<br>
	<H3 style="text-align: center;">판매게시판</H3>


    <table class="table">
        <thead class="thead-light">
          <tr>
            <th scope="col">글번호</th>
            <th scope="col">작성자</th>
            <th scope="col" id="title">제목</th>
            <th scope="col">작성일</th>
            <th scope="col">카테고리</th>
          </tr>
        </thead>
        <tbody>
        <% for(Sell b : list){ %>
         
          <tr>
            <td><%= b.getBoardNo() %></td>
            <td><%=b.getBoardWriter() %></td>
            <td><a href="<%=request.getContextPath()%>/sell/sellView?boardNo=<%= b.getBoardNo() %>" style="text-decoration:none; color: black;">
            <%=b.getBoardTitle() %> </a></td>
            <td><%=b.getBoardDate() %></td>
            <td><%=b.getBoardCodeNo() %></td>
     </tr>
                <% } %>
        </tbody>
        
      </table>
	<div id="pageBar">
		<%=pageBar %>
	</div>
	<%-- <%if(memberLoggedIn != null){ %> --%>
		<input type="button" value="글쓰기" 
			   id="btn-add"
			   onclick="location.href='<%=request.getContextPath()%>/sell/sellWrite'"/>
	<%-- <% } %> --%>
</body>
</html>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>
