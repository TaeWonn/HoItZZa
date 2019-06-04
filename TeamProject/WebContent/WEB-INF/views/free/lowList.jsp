<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="board.model.vo.Board, java.util.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<Board> list = (List<Board>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	//header.jsp에 memberLoggedIn변수를 선언했으므로, 이 페이지에서는 선언할 필요 없음.
	//Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css" />

  <link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
 <style>
    .table{
        width: 600px; 
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
    font-size : 17px;}
    
    h2{
    text-align: center;
    }
    </style>
</head>
<body>  
<body>
	<h2>유용한 생활지식</h2>

    <table class="table">
        <thead class="thead-light">
          <tr>
            <th scope="col">글번호</th>
            <th scope="col">작성자</th>
            <th scope="col" id="title">제목</th>
            <th scope="col">작성일</th>
            <th scope="col">조회수</th>
          </tr>
        </thead>
        <tbody>
        <% for(int i=0; i<7; i++){ %>
         
          <tr>
            <th scope="row">작성자명</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>2019-06-24</td>
            <td>5</td>
     </tr>
                <% } %>
        </tbody>
        
      </table>

<%-- <%if(memberLoggedIn != null){ %>
		<input type="button" value="글쓰기" 
			   id="btn-add"
			   onclick="location.href='<%=request.getContextPath()%>/board/boardForm'"/>
	<% } %> --%>
</body>
</html>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>
