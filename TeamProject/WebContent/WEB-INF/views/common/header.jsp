<%@page import="user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	User userLoggedIn=(User)request.getAttribute("useLoggedIn");


%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.0.js"></script>
<title>SellBar - Flea Market For U</title>

<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Poor+Story&display=swap" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/header.css" />

</head>
<body>
	<div id="head-container">
		<span id="sellBuy1">Sell&Buy</span>&nbsp;<br />
		<span id="sellBuy2">우리들의 쎌빠</span>
	</div>
	<hr />

	<aside id="asideLeft">
	<section>
	<%if(userLoggedIn==null){ %>
	<div id="login-container">
		<br />
		<img src="<%=request.getContextPath() %>/images/userId.svg" class="inout"><input type="text" name="userId" id="userId" />
		<br />
		<img src="<%=request.getContextPath() %>/images/pwd.svg" class="inout"><input type="password" name="userPwd" id="userPwd" />
		<br />
		<button id="loginBtn">Login</button>
		<br />
		<ul id="link">
			<li><a href="<%=request.getContextPath() %>/views/user/userJoin">회원가입</a></li>
			<li><a href="<%=request.getContextPath() %>/views/user/findId_pwd">아이디/비밀번호 찾기</a></li>
		</ul>
	</div>
	<%}else{%>
		<div id="login-container">
	
		<span>admin님 안녕하세요!</span>
		<img src="images/profile.png" alt="" id="user_profile_photo" />
		<ul id="link">
			<li><span><a href="<%=request.getContextPath() %>/">내쪽지함</a></span>
				&nbsp;&nbsp;<span><a href="<%=request.getContextPath() %>/">내정보 보기</a></span>
			</li>
			<li><a href="<%=request.getContextPath() %>/">현재 포인트</a></li>
			<li><a href="<%=request.getContextPath() %>/">로그아웃</a></li>
		</ul>
		</div>
	<%} %>
	<div id="board-list-container">
		<p id="board_title">판매/구매</p>
		<ul class="boardList">
			<li><a href="">판매 게시판</a></li>
			<li><a href="">구매 게시판</a></li>
		</ul>
		<p id="board_title">자유게시판</p>
		<ul class="boardList">
			<li><a href="">잡담 게시판</a></li>
			<li><a href="">유용한 생활지식</a></li>
			<li><a href="">연예/미디어</a></li>
			<li><a href="">나눔 게시판</a></li>
		</ul>
		<p id="board_title">건의사항/신고</p>
		<ul class="boardList">
			<li><a href="">건의 게시판</a></li>
			<li><a href="">신고 게시판</a></li>
		</ul>
		
	
	</div>

	</section>
	</aside>
	
	<aside id="asideRight">
		<section>
			<div id="weather-day">
			
			</div>
			<div id="ad1" class="ad">
				<img src="<%=request.getContextPath() %>/images/강사님.PNG" alt="" />
				<span>지식을 원하는자</span>
				<br /><span>나에게 오라</span>
				
			</div>
			<div id="ad2"class="ad">
			<img src="<%=request.getContextPath() %>/images/강사님.PNG" alt="" />
			<span>공부를 원하는자</span>
			<br /><span>나에게 질문하라</span>
			</div>
		</section>
	</aside>


<script>

//날씨정보 api불러오기
$(function(){
	console.log('sdfs');
	var location="Seoul";
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();

	if(dd<10) {
	    dd='0'+dd
	} 
	if(mm<10) {
	    mm='0'+mm
	} 
	
	today =yyyy+"년"+mm+"월"+dd+"일";
	var apiUrl="http://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=d69250224a399641ef739b6e02e5cfaf";
	 $.ajax({
            url: apiUrl,
            dataType: "json",
            type: "GET",
            async: "false",
            success: function(resp) {

            var imgURL = "http://openweathermap.org/img/w/" + resp.weather[0].icon + ".png";

               var html='<span style="font-size:24px;">'+today+'</span><div id="weather"><img src="'+imgURL+'" alt="" /><span id="wSpan">'+resp.weather[0].description+'</span><br /><span>현재위치 : '+resp.name+'</span><br />';
                	html+='<span>현재온도 : '+Math.round((resp.main.temp- 273.15)*10.0)/10.0+'°C</span><br /><span>현재습도 : '+resp.main.humidity+'</span><br />';
                	html+='<span>풍속 : '+resp.wind.speed+'</span></div>';
            	 $("#weather-day").append(html);
            }
        });
	});




</script>


</body>
</html>