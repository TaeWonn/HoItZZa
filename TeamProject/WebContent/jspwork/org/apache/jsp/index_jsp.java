/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-05-31 02:56:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.model.vo.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1559261843520L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1559261843627L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("user.model.vo.User");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	//세션 객체로부터 저장된 로그인 사용자 정보 가져오기
	User userLoggedIn = (User)session.getAttribute("userLoggedIn");
	String userIdd="user";
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
	//String[] interestArr=userLoggedIn.getInterest();
	String[] interestArr={"A","D","F"};

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<!DOCTYPE html >\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.4.0.js\"></script>\r\n");
      out.write("<title>SellBar - Flea Market For U</title>\r\n");
      out.write("\r\n");
      out.write("<!-- 부트스트랩 -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n");
      out.write("\tintegrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n");
      out.write("\tcrossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.js\"\r\n");
      out.write("\tintegrity=\"sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"\r\n");
      out.write("\tintegrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"\r\n");
      out.write("\tintegrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- 부트스트랩 End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://fonts.googleapis.com/css?family=Gloria+Hallelujah&display=swap\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://fonts.googleapis.com/css?family=Poor+Story&display=swap\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/header.css\" />\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://fonts.googleapis.com/css?family=Sunflower:300&display=swap\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("#head-container {\r\n");
      out.write("\tbackground-image: url(\"");
      out.print(request.getContextPath());
      out.write("/images/냥챗 아이콘.jpg\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul#link2{list-style: none;padding-left: 0px;margin-top: 0px;margin-bottom: 20px;}\r\n");
      out.write("ul#link{padding-left:6px;list-style: none;padding-left: 0px;margin-top: 0px;margin-bottom: 20px;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"head-container\">\r\n");
      out.write("\t\t<span id=\"sellBuy1\">Sell&Buy</span>&nbsp;<br /> <span id=\"sellBuy2\"><a\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("\">우리들의 쎌빠</a></span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<hr />\r\n");
      out.write("\r\n");
      out.write("\t<aside id=\"asideLeft\">\r\n");
      out.write("\t\t<section>\r\n");
      out.write("\t\t\t");
 if (userLoggedIn == null) { 
      out.write("\r\n");
      out.write("\t\t\t<div id=\"login-container\">\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/views/user/login\" method=\"post\" id=\"loginFrm\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/userId.svg\" class=\"inout\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"userId\" id=\"header_userId\" value='");
      out.print(saveIdflag?userLoggedIn.getUserId():"" );
      out.write("' /> \r\n");
      out.write("\t\t\t\t\t\t<br /> \r\n");
      out.write("\t\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/pwd.svg\" class=\"inout\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"userPwd\" id=\"header_userPwd\" />\r\n");
      out.write("\t\t\t\t\t\t <br /> \r\n");
      out.write("\t\t\t\t\t\t <input type=\"checkbox\" name=\"saveId\" id=\"saveId\"  ");
      out.print(saveIdflag?"checked":"" );
      out.write(" />\r\n");
      out.write("\t\t\t\t\t\t <label for=\"saveId\">아이디 저장</label> \r\n");
      out.write("\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" id=\"loginBtn\" class=\"btn btn-secondary\" onclick=\"checkLogin();\" >Login</button>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<ul id=\"link\">\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/views/user/userJoin\">회원가입</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/views/user/findId_pwd\">아이디/비밀번호 찾기</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");

				} else if(userLoggedIn.getUserId().equals("admin")){
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"login-container\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<span>");
      out.print(userLoggedIn.getUserId() );
      out.write("님 안녕하세요!</span> <img src=\"images/profile.png\" alt=\"\"\r\n");
      out.write("\t\t\t\t\tid=\"user_profile_photo\" />\r\n");
      out.write("\t\t\t\t<ul id=\"link\">\r\n");
      out.write("\t\t\t\t\t<li><span><a href=\"");
      out.print(request.getContextPath());
      out.write("/\">내쪽지함</a></span>\r\n");
      out.write("\t\t\t\t\t\t&nbsp;&nbsp;<span><a href=\"");
      out.print(request.getContextPath());
      out.write("/views/admin/adminInfo\">관리자 페이지</a></span></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/\">로그아웃</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
}else{
      out.write("\r\n");
      out.write("\t\t\t<div id=\"login-container\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<span>");
      out.print(userLoggedIn.getUserId() );
      out.write("님 안녕하세요!</span> <img src=\"images/profile.png\" alt=\"\"\r\n");
      out.write("\t\t\t\t\tid=\"user_profile_photo\" />\r\n");
      out.write("\t\t\t\t<ul id=\"link\">\r\n");
      out.write("\t\t\t\t\t<li><span><a href=\"");
      out.print(request.getContextPath());
      out.write("/\">내쪽지함</a></span>\r\n");
      out.write("\t\t\t\t\t\t&nbsp;&nbsp;<span><a href=\"");
      out.print(request.getContextPath());
      out.write("/views/user/userInfo\">내정보\r\n");
      out.write("\t\t\t\t\t\t\t\t보기</a></span></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/\">현재 포인트</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/\">로그아웃</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t<div id=\"board-list-container\">\r\n");
      out.write("\t\t\t\t<p id=\"board_title\">판매/구매</p>\r\n");
      out.write("\t\t\t\t<ul class=\"boardList\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">판매 게시판</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">구매 게시판</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<p id=\"board_title\">자유게시판</p>\r\n");
      out.write("\t\t\t\t<ul class=\"boardList\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">잡담 게시판</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">유용한 생활지식</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">연예/미디어</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">나눔 게시판</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<p id=\"board_title\">건의사항/신고</p>\r\n");
      out.write("\t\t\t\t<ul class=\"boardList\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">건의 게시판</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">신고 게시판</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<p id=\"board_title\">협력사</p>\r\n");
      out.write("\t\t\t\t<ul class=\"boardList\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">이게 중고다!</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">나는 중고다 </a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\">중고라나? </a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</aside>\r\n");
      out.write("\r\n");
      out.write("\t<aside id=\"asideRight\">\r\n");
      out.write("\t\t<section>\r\n");
      out.write("\t\t\t<div id=\"weather-day\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"ad1\" class=\"ad\">\r\n");
      out.write("\t\t\t\t<a href=\"\"> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/강사님.PNG\" alt=\"\" /> <span>지식을\r\n");
      out.write("\t\t\t\t\t\t원하는자</span> <br /> <span>나에게 오라</span>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"ad2\" class=\"ad\">\r\n");
      out.write("\t\t\t\t<a href=\"\"> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/images/강사님.PNG\" alt=\"\" /> <span>공부를\r\n");
      out.write("\t\t\t\t\t\t원하는자</span> <br /> <span>나에게 질문하라</span>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</aside>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//날씨정보 api불러오기\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\tvar location = \"Seoul\";\r\n");
      out.write("\t\t\tvar today = new Date();\r\n");
      out.write("\t\t\tvar dd = today.getDate();\r\n");
      out.write("\t\t\tvar mm = today.getMonth() + 1; //January is 0!\r\n");
      out.write("\t\t\tvar yyyy = today.getFullYear();\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (dd < 10) {\r\n");
      out.write("\t\t\t\tdd = '0' + dd\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (mm < 10) {\r\n");
      out.write("\t\t\t\tmm = '0' + mm\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\ttoday = yyyy + \"년\" + mm + \"월\" + dd + \"일\";\r\n");
      out.write("\t\t\tvar apiUrl = \"http://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=d69250224a399641ef739b6e02e5cfaf\";\r\n");
      out.write("\t\t\t$\r\n");
      out.write("\t\t\t\t\t.ajax({\r\n");
      out.write("\t\t\t\t\t\turl : apiUrl,\r\n");
      out.write("\t\t\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\t\t\ttype : \"GET\",\r\n");
      out.write("\t\t\t\t\t\tasync : \"false\",\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(resp) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tvar imgURL = \"http://openweathermap.org/img/w/\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ resp.weather[0].icon + \".png\";\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tvar html = '<div id=\"weather\"><span style=\"font-size:20px;\" id=\"today\">'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ today\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ '</span><img src=\"'+imgURL+'\" alt=\"\" /><span id=\"wSpan\">'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ resp.weather[0].description\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ '</span><br /><span>현재위치 : '\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ resp.name\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ '</span><br />';\r\n");
      out.write("\t\t\t\t\t\t\thtml += '<span>현재온도 : '\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ Math\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.round((resp.main.temp - 273.15) * 10.0)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t/ 10.0 + '°C</span><br /><span>현재습도 : '\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ resp.main.humidity + '</span><br />';\r\n");
      out.write("\t\t\t\t\t\t\thtml += '<span>풍속 : ' + resp.wind.speed\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ ' m/s</span></div><br />';\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#weather-day\").append(html);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//로그인 처리\r\n");
      out.write("\t\tfunction checkLogin() {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar id = $('#header_userId').val().trim();\r\n");
      out.write("\t\t\tvar pwd = $('#header_userPwd').val().trim();\r\n");
      out.write("\t\t\tif (id.length == 0) {\r\n");
      out.write("\t\t\t\talert('아이디를 입력해주세요.');\r\n");
      out.write("\t\t\t\t$('#header_userId').focus();\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tif (pwd.length == 0) {\r\n");
      out.write("\t\t\t\t\talert('비밀번호를 입력해주세요.');\r\n");
      out.write("\t\t\t\t\t$('#header_userPwd').focus();\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$('#loginFrm').submit();\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<section id=\"content\">");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/index.css\" />\n");
      out.write("  \r\n");
      out.write("<article id=\"article\">\r\n");
      out.write("<section>\r\n");
      out.write("\t<div id=\"list-container\">\r\n");
      out.write("\t<div id=\"board1\">\r\n");
      out.write("\t\t<span class=\"title\">판매 / 구매 게시판</span>\r\n");
      out.write("\t\t<table id=\"sellList\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t<tr colspan=\"3\">\r\n");
      out.write("\t\t<th></th>\r\n");
      out.write("\t\t<th style=\"font-size: 20px;\">나눔 게시판</th>\r\n");
      out.write("\t\t<th></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\">번호</th>\r\n");
      out.write("\t\t<th>제목</th>\r\n");
      out.write("\t\t<th class=\"viewer\">조회수</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t");
for(int i=1;i<=10;i++){
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"board_no\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( i);
      out.write("번째 글입니다</td>\r\n");
      out.write("\t\t\t<td class=\"viewer\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id=\"buyList\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t<tr colspan=\"3\">\r\n");
      out.write("\t\t<th></th>\r\n");
      out.write("\t\t<th style=\"font-size: 20px;\">나눔 게시판</th>\r\n");
      out.write("\t\t<th></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\">번호</th>\r\n");
      out.write("\t\t<th>제목</th>\r\n");
      out.write("\t\t<th class=\"viewer\">조회수</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t");
for(int i=1;i<=10;i++){
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"board_no\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( i);
      out.write("번째 글입니다</td>\r\n");
      out.write("\t\t\t<td class=\"viewer\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"board2\">\r\n");
      out.write("\t\t<span class=\"title\">자유게시판</span>\r\n");
      out.write("\t\t<table id=\"jayuList1\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t<tr >\r\n");
      out.write("\t\t<th colspan=\"3\" style=\"font-size: 20px;\">나눔 게시판</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\">번호</th>\r\n");
      out.write("\t\t<th>제목</th>\r\n");
      out.write("\t\t<th class=\"viewer\">조회수</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t");
for(int i=1;i<=3;i++){
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"board_no\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( i);
      out.write("번째 글입니다</td>\r\n");
      out.write("\t\t\t<td class=\"viewer\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id=\"jayuList2\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t<tr >\r\n");
      out.write("\t\t<th colspan=\"3\" style=\"font-size: 20px;\">잡담 게시판</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\">번호</th>\r\n");
      out.write("\t\t<th>제목</th>\r\n");
      out.write("\t\t<th class=\"viewer\">조회수</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t");
for(int i=1;i<=3;i++){
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"board_no\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( i);
      out.write("번째 글입니다</td>\r\n");
      out.write("\t\t\t<td class=\"viewer\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id=\"jayuList3\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t<tr >\r\n");
      out.write("\t\t<th  colspan=\"3\" style=\"font-size: 20px;\">유용한 생활지식 게시판</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\">번호</th>\r\n");
      out.write("\t\t<th>제목</th>\r\n");
      out.write("\t\t<th class=\"viewer\">조회수</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t");
for(int i=1;i<=3;i++){
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"board_no\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( i);
      out.write("번째 글입니다</td>\r\n");
      out.write("\t\t\t<td class=\"viewer\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id=\"jayuList4\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th  colspan=\"3\" style=\"font-size: 20px;\">연예/미디어 게시판</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\">번호</th>\r\n");
      out.write("\t\t<th>제목</th>\r\n");
      out.write("\t\t<th class=\"viewer\">조회수</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t");
for(int i=1;i<=3;i++){
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"board_no\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( i);
      out.write("번째 글입니다</td>\r\n");
      out.write("\t\t\t<td class=\"viewer\">");
      out.print( i);
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write(" \r\n");
      out.write("</section>\r\n");
      out.write("</article>\r\n");
      out.write("</body>\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/footer.css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("#footer{\r\n");
      out.write("background-image: url('");
      out.print(request.getContextPath());
      out.write("/images/leo.jpg');\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</section>\r\n");
      out.write("<footer>\r\n");
      out.write("\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("\r\n");
      out.write("\t<p id=\"text\">여긴 footer다</p>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("    \r\n");
      out.write("</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
