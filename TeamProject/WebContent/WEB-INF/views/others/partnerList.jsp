<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <%@ include file="/WEB-INF/views/common/header.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/others/partnerList.css" />
<article>
	<section id="partner-section">
		<div id="partner-container">
		<h2>협력사 모아보기</h2>
			<div id="partner-list">
				<span>♣ 중고거래 카페</span>
				<ol>
					<li onclick="location.href='https://cafe.naver.com/joonggonara'">중고나라
					<img src="<%=request.getContextPath() %>/images/partner/중고나라.PNG" /></li>
					<li onclick="location.href='https://cafe.naver.com/musicstar2'">중고카페 그린유즈
					<img src="<%=request.getContextPath() %>/images/partner/중고카페 그린유즈.PNG" alt="" /></li>
					<li onclick="location.href='https://jungocafe.com'">중고카페
					<img src="<%=request.getContextPath() %>/images/partner/중고카페.PNG" alt="" /></li>
				</ol>
				<span>♠ 중고거래 마켓</span>
				<ol>
					<li onclick="location.href='http://www.gmarket.co.kr'">G마켓
					<img src="<%=request.getContextPath() %>/images/partner/g마켓.PNG" alt="" /></li>	
					<li onclick="location.href='https://www.coupang.com'">쿠팡
					<img src="<%=request.getContextPath() %>/images/partner/쿠팡.PNG" alt="" /></li>
					<li onclick="location.href='http://www.auction.co.kr'">옥션
					<img src="<%=request.getContextPath() %>/images/partner/옥션.PNG" alt="" /></li>
					<li onclick="location.href='http://www.interpark.com/malls/index.html'">인터파크
					<img src="<%=request.getContextPath() %>/images/partner/인터파크.PNG" alt="" /></li>
					<li onclick="location.href='https://www.withsellit.com'">셀잇
					<img src="<%=request.getContextPath() %>/images/partner/셀잇.PNG" alt="" /></li>
					<li onclick="location.href='https://www.hellomarket.com'">헬로마켓
					<img src="<%=request.getContextPath() %>/images/partner/헬로마켓.PNG" alt="" /></li>
					<li onclick="location.href='http://www.momscafe.net'">맘스카페오투오
					<img src="<%=request.getContextPath() %>/images/partner/맘스카페.PNG" alt="" /></li>
				</ol>
				<span>★ 자동차 중고사이트</span>
				<ol>			    
					<li onclick="location.href='http://www.encar.com/index.do'">SK엔카
					<img src="<%=request.getContextPath() %>/images/partner/sk엔카.PNG" alt="" /></li>
					<li onclick="location.href='https://certifiedcar.hyundaicapital.com/hcsfront/main'">현대캐피탈 인증중고차
					<img src="<%=request.getContextPath() %>/images/partner/현대캐피탈 인증중고차.PNG" alt="" /></li>
					<li onclick="location.href='http://www.bobaedream.co.kr'">보배드림
					<img src="<%=request.getContextPath() %>/images/partner/보배드림.PNG" alt="" /></li>
					<li onclick="location.href='http://www.fuucar.com'">국민 퍼스트카
					<img src="<%=request.getContextPath() %>/images/partner/국민 퍼스트카.PNG" alt="" /></li>
					<li onclick="location.href='http://www.sinhancar.com'">신한다이렉트카
					<img src="<%=request.getContextPath() %>/images/partner/신한다이렉트카.PNG" alt="" /></li>
				</ol>
				<span>◈ 중고도서 사이트</span>
				<ol>
					<li onclick="location.href='https://www.aladin.co.kr/home/welcome.aspx'">알라딘
					<img src="<%=request.getContextPath() %>/images/partner/알라딘.PNG" alt="" /></li>
					<li onclick="location.href='http://www.yes24.com/main/default.aspx'">YES24
					<img src="<%=request.getContextPath() %>/images/partner/예스24.PNG" alt="" /></li>
					<li onclick="location.href='http://used.kyobobook.co.kr/index.ink?orderClick=c19'">교보문고 중고장터
					<img src="<%=request.getContextPath() %>/images/partner/교보문고.PNG" alt="" /></li>
				</ol>
			</div>
		</div>
	</section>
</article>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>