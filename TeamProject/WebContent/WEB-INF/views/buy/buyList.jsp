<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../common/error.jsp"%>
    <%@ page import="buy.model.vo.Buy, java.util.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<Buy> list = (List<Buy>)request.getAttribute("buy");
	String pageBar = (String)request.getAttribute("pageBar");
	//header.jsp에 memberLoggedIn변수를 선언했으므로, 이 페이지에서는 선언할 필요 없음.
   
%>

  <link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardList.css" /> 

    
<article id="article">

		<br>
	<H3 style="text-align: center; margin-bottom: 10px;">구매게시판</H3>

<%if(userLoggedIn != null){ %> 
		<input type="button" value="글쓰기" 
			   id="btn-add"
			   onclick="location.href='<%=request.getContextPath()%>/buy/buyWrite'"/>
	 <% } %> 	 

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
        <% for(Buy b : list){ %>
         
          <tr>
            <td><%= b.getBoardNo() %></td>
            <td><%=b.getBoardWriter() %></td>
            <td><a href="<%=request.getContextPath()%>/buy/buyView?boardNo=<%= b.getBoardNo() %>" style="text-decoration:none; color: black;">
            <%=b.getBoardTitle() %> </a></td>
            <td><%=b.getBoardDate() %></td>
            <td><%=b.getBoardCodeNo() %></td> 
     </tr>
                <% } %>
        </tbody>
        
      </table>
	<div id="pageBar" >
		<%=pageBar %> 
	</div>
	
	
	<div class="input-group">
		<select id="search_category">
			<option value="board_Title" selected>제목</option>
			<option value="board_Writer">작성자</option>
			<option value="board_Content">내용</option>
			<option value="board_CodeName">카테고리</option>
		</select>
		<input class="form-control" placeholder="검색어를 입력하세요" id="search_key"/>
		<input type="button" value="검색" onclick="search_category();">
	</div>
</article>
</html>

<script>
//카테고리를 보내준다
	function search_category() {
	
		var boardContent = $("#search_key").val();
		if(boardContent.trim().length == 0){
			alert("검색어 입력하세요.");
			return false;
		}
	
		var search_category = $("#search_category option:selected").val();
		var search_key = $("#search_key").val();
		location.href = "<%=request.getContextPath()%>/buy/buyList?search_category="+search_category+"&search_key="+search_key;
	}

</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
