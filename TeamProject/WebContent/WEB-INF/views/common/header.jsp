<%@page import="user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
   //세션 객체로부터 저장된 로그인 사용자 정보 가져오기
   User userLoggedIn = (User)session.getAttribute("userLoggedIn");
   
   //쿠키 처리
   Cookie[] cookies = request.getCookies();
   boolean saveIdflag = false;
   String userId = "";
   if (cookies != null) {
      for (Cookie c : cookies) {
         
         String key = c.getName();
         String value = c.getValue();
         if ("saveId".equals(key)) {
            saveIdflag = true;
            userId = value;
         }
      }
   }
   
   
%>
   
   
   
   
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath()%>/js/jquery-3.4.0.js"></script>

<title>SellBar - Flea Market For U</title>

<!-- 부트스트랩 -->
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
   integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
   crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.js"
   integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
   crossorigin="anonymous"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
   integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
   crossorigin="anonymous"></script>
<script
   src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
   integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
   crossorigin="anonymous"></script>
<!-- 부트스트랩 End -->


<link
   href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah&display=swap"
   rel="stylesheet">
<link
   href="https://fonts.googleapis.com/css?family=Poor+Story&display=swap"
   rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />
<link
   href="https://fonts.googleapis.com/css?family=Sunflower:300&display=swap"
   rel="stylesheet">

<style>
#head-container {
   background-image: url("<%=request.getContextPath()%>/images/header.jpg");
} 
</style>
</head>
<body>
<header>
   <div id="head-container" onclick="location.href='<%=request.getContextPath()%>'">
   </div>
   <hr />

   <aside id="asideLeft">
      <section>
         <% if (userLoggedIn == null) { %>
         <div id="login-container">
            <br />
            <form action="<%=request.getContextPath()%>/views/user/login" method="post" id="loginFrm">
               <img src="<%=request.getContextPath()%>/images/userId.svg" class="inout">
               <input type="text" name="userId" id="header_userId" value='<%=saveIdflag?userId:"" %>' /> 
                  <br /> 
                  <img src="<%=request.getContextPath()%>/images/pwd.svg" class="inout">
                  <input type="password" name="userPwd" id="header_userPwd" onkeyup="enterUser();"/>
                   <br /> 
                   <input type="checkbox" name="saveId" id="saveId"  <%=saveIdflag?"checked":"" %> />
                   <label for="saveId">아이디 저장</label> 
                  <br />
                  <button type="button" id="loginBtn" class="btn btn-secondary" onclick="checkLogin();" >Login</button>
               
               <br />
            </form>
            <ul id="link">
               <li>
               <a href="<%=request.getContextPath()%>/views/user/userJoin">회원가입</a></li>
               <li><a href="<%=request.getContextPath()%>/views/user/findId_pwd">아이디/비밀번호 찾기</a></li>
            </ul>
         </div>
         <%
            } else if(userLoggedIn.getUserId().equals("admin")){%>
            <div id="login-container">

            <span id="hi">관리자님 안녕하세요!</span><img src="<%=request.getContextPath() %>/images/user.svg" alt=""
               id="user_profile_photo" />
            <ul id="link">
               <li><span><a href="<%=request.getContextPath()%>/views/message/myMessage?userId=<%=userLoggedIn.getUserId()%>">내쪽지함</a></span></li>
               <li><span><a href="<%=request.getContextPath()%>/admin/adminInfo">관리자 페이지</a></span></li>
               <li><span><a href="<%=request.getContextPath()%>/views/user/userLogout">로그아웃</a></span></li>
            </ul>
         </div>   
         
         <%}else{%>
         <div id="login-container">
            <div id="contnet">
            <span id="hi"><%=userLoggedIn.getName() %>님 안녕하세요!</span> <img src="<%=request.getContextPath() %>/images/user.svg" alt=""
               id="user_profile_photo" />
            <ul id="link">
               <li><span><a href="<%=request.getContextPath()%>/views/message/myMessage?userId=<%=userLoggedIn.getUserId()%>">내쪽지함</a></span>
                  &nbsp; &nbsp;<span><a href="<%=request.getContextPath()%>/views/user/userInfo?userId=<%=userLoggedIn.getUserId()%>">내정보</a></span></li>
               <li><span id="userPoint">포인트 :  <%=userLoggedIn.getPoint() %>P</span></li>
               <li>
               <span id="pullPoint"><a href="<%=request.getContextPath()%>/views/point/pointCharge?userId=<%=userLoggedIn.getUserId()%>" >충전하기</a></span>&nbsp;&nbsp;
               <span id="changePoint"><a href="<%=request.getContextPath()%>/views/point/pointCharge?userId=<%=userLoggedIn.getUserId()%>" >환전하기</a></span>
               </li>
               <li><span><a href="<%=request.getContextPath()%>/views/user/userLogout">로그아웃</a></span></li>
            </ul>
            </div>
         </div>
         <%}%>
         <div id="board-list-container">
            <p id="board_title">판매/구매</p>
            <ul class="boardList">
               <li><a href="<%=request.getContextPath()%>/sell/sellList">판매 게시판</a></li>
               <li><a href="<%=request.getContextPath()%>/buy/buyList">구매 게시판</a></li>
            </ul>
            <p id="board_title">자유게시판</p>
            <ul class="boardList">
               <li><a href="<%=request.getContextPath()%>/free/freeList">잡담 게시판</a></li>
               <li><a href="<%=request.getContextPath()%>/free/senseList">유용한 생활지식</a></li>
               <li><a href="<%=request.getContextPath()%>/free/entertainList">연예/미디어</a></li> 
               <li><a href="<%=request.getContextPath()%>/free/divideList">나눔 게시판</a></li>
            </ul>
            <p id="board_title">건의사항/신고</p>
            <ul class="boardList">
               <li><a href="">건의 게시판</a></li>
               <li><a href="">신고 게시판</a></li>
            </ul>
            <p id="board_title">기타</p>
            <ul class="boardList">
               <li><a href="<%=request.getContextPath()%>/others/partnerList">협력사 모아보기</a></li>
               <li><a href="<%=request.getContextPath()%>/others/faqList">QnA </a><br><br></li>
            </ul>


         </div>

      </section>
   </aside>

   <aside id="asideRight">
      <section>
         <div id="weather-day">
         </div>
         <div id="ad1" class="ad">
            <a href=""> <img
               src="<%=request.getContextPath()%>/images/강사님.PNG" alt="" /> <span>지식을 
                  원하는자</span> <br /> <span>나에게 오라</span>
            </a>
         </div>
         <div id="ad2" class="ad">
            <a href=""> <img
               src="<%=request.getContextPath()%>/images/강사님.PNG" alt="" /> <span>공부를
                  원하는자</span> <br /> <span>나에게 질문하라</span>
            </a>
         </div>
      </section>
   </aside>
</header>


	<script>
		//날씨정보 api불러오기
		$(function() {
			var location = "Seoul";
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1; //January is 0!
			var yyyy = today.getFullYear();
			if (dd < 10) {
				dd = '0' + dd
			}
			if (mm < 10) {
				mm = '0' + mm
			}
			today = yyyy + "년" + mm + "월" + dd + "일";
			var apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=d69250224a399641ef739b6e02e5cfaf";
			$
					.ajax({
						url : apiUrl,
						dataType : "json",
						type : "GET",
						async : "false",
						success : function(resp) {
							var imgURL = "http://openweathermap.org/img/w/"
									+ resp.weather[0].icon + ".png";
							var html = '<div id="weather"><span style="font-size:20px;" id="today">'
									+ today
									+ '</span><img src="'+imgURL+'" alt="" /><span id="wSpan">'
									+ resp.weather[0].description
									+ '</span><br /><span>현재위치 : '
									+ resp.name
									+ '</span><br />';
							html += '<span>현재온도 : '
									+ Math
											.round((resp.main.temp - 273.15) * 10.0)
									/ 10.0 + '°C</span><br /><span>현재습도 : '
									+ resp.main.humidity + '</span><br />';
							html += '<span>풍속 : ' + resp.wind.speed
									+ ' m/s</span></div><br />';
							$("#weather-day").append(html);
						}
					});
		});
		//로그인 처리
		function checkLogin() {
			var id = $('#header_userId').val().trim();
			var pwd = $('#header_userPwd').val().trim();
			if (id.length == 0) {
				alert('아이디를 입력해주세요.');
				$('#header_userId').focus();
				return;
			} else {
				if (pwd.length == 0) {
					alert('비밀번호를 입력해주세요.');
					$('#header_userPwd').focus();
					return;
				}
			}
			
			$('#loginFrm').submit();
		}
		
		function enterUser(){
			if(window.event.keyCode==13){
				checkLogin();
			}
		}
		
	</script>
	<section id="content">
