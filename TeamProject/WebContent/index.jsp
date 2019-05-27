<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Sell&Buy</title>
<script>


</script>
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Poor+Story&display=swap" rel="stylesheet">
<style>
span#sellBuy1{font-family: 'Gloria Hallelujah', cursive; font-size: 100px;margin:0 auto;}
span#sellBuy2{font-family: 'Poor Story', cursive; font-size: 80px;margin:0 auto; color: orange;}
div#head-container{max-height: 300px;text-align: center;}
aside#asideLeft{float: left;width: 170px;height: 100%;background:lightpink;}
aside#asideRight{float: right;width: 170px;height: 100%;background:lightsteelblue;}
body{max-width:1080px;}
input{width:100px;position: relative;}
img{width:20px;height:20px;position: relative;top: 5.5px;}


</style>

</head>
<body>

	<div id="head-container">
		<span id="sellBuy1">Sell&Buy</span>&nbsp;<br />
		<span id="sellBuy2">우리들의 쎌빠</span>
	</div>
	<hr />

	<aside id="asideLeft">
	<section>
	<div id="login-container">
		<img src="<%=request.getContextPath() %>/images/강사님.PNG" alt="" /><input type="text" name="userId" id="userId" />
		<input type="password" name="userPwd" id="userPwd" />
		
	</div>
	
	<p>테스트ㅇㅇㅇㅇㅇㅇ</p>
	<p>테스트ㅇㅇㅇ</p>
	<p>테스트ㅇㅇㅇ</p>
	<p>테스트</p>
	<p>테스트</p>
	<p>테스트</p>
	<p>테스트</p>
	<p>테스트</p>
	<p>테스트</p>
	<p>테스트</p>
	<p>테스트</p>
	<p>테스트</p>

	</section>
	</aside>
	
	<aside id="asideRight">
		<section>
			<div id="weather-day">
			오늘 날짜/ 날씨
			</div>
			<div id="ad1">
			광고1
			</div>
			<div id="ad2">
			광고2
			</div>
		</section>
	</aside>





</body>
</html>