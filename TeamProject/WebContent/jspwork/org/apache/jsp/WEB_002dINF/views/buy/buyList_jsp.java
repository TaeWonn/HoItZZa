/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-06-07 22:23:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.buy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import buy.model.vo.Buy;
import java.util.*;
import user.model.vo.User;

public final class buyList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1559858628176L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1559797906883L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("buy.model.vo.Buy");
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

      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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
   
   

      out.write("\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("<!DOCTYPE html >\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.4.0.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<title>SellBar - Flea Market For U</title>\r\n");
      out.write("\r\n");
      out.write("<!-- 부트스트랩 -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("   href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n");
      out.write("   integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n");
      out.write("   crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.js\"\r\n");
      out.write("   integrity=\"sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=\"\r\n");
      out.write("   crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script\r\n");
      out.write("   src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"\r\n");
      out.write("   integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\"\r\n");
      out.write("   crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script\r\n");
      out.write("   src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"\r\n");
      out.write("   integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\"\r\n");
      out.write("   crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- 부트스트랩 End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link\r\n");
      out.write("   href=\"https://fonts.googleapis.com/css?family=Gloria+Hallelujah&display=swap\"\r\n");
      out.write("   rel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("   href=\"https://fonts.googleapis.com/css?family=Poor+Story&display=swap\"\r\n");
      out.write("   rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/header.css\" />\r\n");
      out.write("<link\r\n");
      out.write("   href=\"https://fonts.googleapis.com/css?family=Sunflower:300&display=swap\"\r\n");
      out.write("   rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("#head-container {\r\n");
      out.write("   background-image: url(\"");
      out.print(request.getContextPath());
      out.write("/images/header.jpg\");\r\n");
      out.write("} \r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("   <div id=\"head-container\" onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("'\">\r\n");
      out.write("   </div>\r\n");
      out.write("   <hr />\r\n");
      out.write("\r\n");
      out.write("   <aside id=\"asideLeft\">\r\n");
      out.write("      <section>\r\n");
      out.write("         ");
 if (userLoggedIn == null) { 
      out.write("\r\n");
      out.write("         <div id=\"login-container\">\r\n");
      out.write("            <br />\r\n");
      out.write("            <form action=\"");
      out.print(request.getContextPath());
      out.write("/views/user/login\" method=\"post\" id=\"loginFrm\">\r\n");
      out.write("               <img src=\"");
      out.print(request.getContextPath());
      out.write("/images/userId.svg\" class=\"inout\">\r\n");
      out.write("               <input type=\"text\" name=\"userId\" id=\"header_userId\" value='");
      out.print(saveIdflag?userId:"" );
      out.write("' /> \r\n");
      out.write("                  <br /> \r\n");
      out.write("                  <img src=\"");
      out.print(request.getContextPath());
      out.write("/images/pwd.svg\" class=\"inout\">\r\n");
      out.write("                  <input type=\"password\" name=\"userPwd\" id=\"header_userPwd\" onkeyup=\"enterUser();\"/>\r\n");
      out.write("                   <br /> \r\n");
      out.write("                   <input type=\"checkbox\" name=\"saveId\" id=\"saveId\"  ");
      out.print(saveIdflag?"checked":"" );
      out.write(" />\r\n");
      out.write("                   <label for=\"saveId\">아이디 저장</label> \r\n");
      out.write("                  <br />\r\n");
      out.write("                  <button type=\"button\" id=\"loginBtn\" class=\"btn btn-secondary\" onclick=\"checkLogin();\" >Login</button>\r\n");
      out.write("               \r\n");
      out.write("               <br />\r\n");
      out.write("            </form>\r\n");
      out.write("            <ul id=\"link\">\r\n");
      out.write("               <li>\r\n");
      out.write("               <a href=\"");
      out.print(request.getContextPath());
      out.write("/views/user/userJoin\">회원가입</a></li>\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/views/user/findId_pwd\">아이디/비밀번호 찾기</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("         </div>\r\n");
      out.write("         ");

            } else if(userLoggedIn.getUserId().equals("admin")){
      out.write("\r\n");
      out.write("            <div id=\"login-container\">\r\n");
      out.write("\r\n");
      out.write("            <span id=\"hi\">관리자님 안녕하세요!</span><img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/user.svg\" alt=\"\"\r\n");
      out.write("               id=\"user_profile_photo\" />\r\n");
      out.write("            <ul id=\"link\">\r\n");
      out.write("               <li><span><a href=\"");
      out.print(request.getContextPath());
      out.write("/views/message/myMessage?userId=");
      out.print(userLoggedIn.getUserId());
      out.write("\">내쪽지함</a></span></li>\r\n");
      out.write("               <li><span><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/adminInfo\">관리자 페이지</a></span></li>\r\n");
      out.write("               <li><span><a href=\"");
      out.print(request.getContextPath());
      out.write("/views/user/userLogout\">로그아웃</a></span></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("         </div>   \r\n");
      out.write("         \r\n");
      out.write("         ");
}else{
      out.write("\r\n");
      out.write("         <div id=\"login-container\">\r\n");
      out.write("            <div id=\"contnet\">\r\n");
      out.write("            <span id=\"hi\">");
      out.print(userLoggedIn.getName() );
      out.write("님 안녕하세요!</span> <img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/user.svg\" alt=\"\"\r\n");
      out.write("               id=\"user_profile_photo\" />\r\n");
      out.write("            <ul id=\"link\">\r\n");
      out.write("               <li><span><a href=\"");
      out.print(request.getContextPath());
      out.write("/views/message/myMessage?userId=");
      out.print(userLoggedIn.getUserId());
      out.write("\">내쪽지함</a></span>\r\n");
      out.write("                  &nbsp; &nbsp;<span><a href=\"");
      out.print(request.getContextPath());
      out.write("/views/user/userInfo?userId=");
      out.print(userLoggedIn.getUserId());
      out.write("\">내정보</a></span></li>\r\n");
      out.write("               <li><span id=\"userPoint\">포인트 :  ");
      out.print(userLoggedIn.getPoint() );
      out.write("P</span></li>\r\n");
      out.write("               <li>\r\n");
      out.write("               <span id=\"pullPoint\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/views/point/pointCharge?userId=");
      out.print(userLoggedIn.getUserId());
      out.write("\" >충전하기</a></span>&nbsp;&nbsp;\r\n");
      out.write("               <span id=\"changePoint\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/views/point/pointCharge?userId=");
      out.print(userLoggedIn.getUserId());
      out.write("\" >환전하기</a></span>\r\n");
      out.write("               </li>\r\n");
      out.write("               <li><span><a href=\"");
      out.print(request.getContextPath());
      out.write("/views/user/userLogout\">로그아웃</a></span></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         ");
}
      out.write("\r\n");
      out.write("         <div id=\"board-list-container\">\r\n");
      out.write("            <p id=\"board_title\">판매/구매</p>\r\n");
      out.write("            <ul class=\"boardList\">\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/sell/sellList\">판매 게시판</a></li>\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/buy/buyList\">구매 게시판</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <p id=\"board_title\">자유게시판</p>\r\n");
      out.write("            <ul class=\"boardList\">\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/free/freeList\">잡담 게시판</a></li>\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/free/senseList\">유용한 생활지식</a></li>\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/free/entertainList\">연예/미디어</a></li> \r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/free/divideList\">나눔 게시판</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <p id=\"board_title\">건의사항/신고</p>\r\n");
      out.write("            <ul class=\"boardList\">\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/opinion/opinionList\">건의 게시판</a></li>\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/opinion/declarationList\">신고 게시판</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <p id=\"board_title\">기타</p>\r\n");
      out.write("            <ul class=\"boardList\">\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/others/partnerList\">협력사 모아보기</a></li>\r\n");
      out.write("               <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/others/faqList\">QnA </a><br><br></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("      </section>\r\n");
      out.write("   </aside>\r\n");
      out.write("\r\n");
      out.write("   <aside id=\"asideRight\">\r\n");
      out.write("      <section>\r\n");
      out.write("         <div id=\"weather-day\">\r\n");
      out.write("         </div>\r\n");
      out.write("         <div id=\"ad1\" class=\"ad\">\r\n");
      out.write("            <a href=\"\"> <img\r\n");
      out.write("               src=\"");
      out.print(request.getContextPath());
      out.write("/images/강사님.PNG\" alt=\"\" /> <span>지식을 \r\n");
      out.write("                  원하는자</span> <br /> <span>나에게 오라</span>\r\n");
      out.write("            </a>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div id=\"ad2\" class=\"ad\">\r\n");
      out.write("            <a href=\"\"> <img\r\n");
      out.write("               src=\"");
      out.print(request.getContextPath());
      out.write("/images/강사님.PNG\" alt=\"\" /> <span>공부를\r\n");
      out.write("                  원하는자</span> <br /> <span>나에게 질문하라</span>\r\n");
      out.write("            </a>\r\n");
      out.write("         </div>\r\n");
      out.write("      </section>\r\n");
      out.write("   </aside>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//날씨정보 api불러오기\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\tvar location = \"Seoul\";\r\n");
      out.write("\t\t\tvar today = new Date();\r\n");
      out.write("\t\t\tvar dd = today.getDate();\r\n");
      out.write("\t\t\tvar mm = today.getMonth() + 1; //January is 0!\r\n");
      out.write("\t\t\tvar yyyy = today.getFullYear();\r\n");
      out.write("\t\t\tif (dd < 10) {\r\n");
      out.write("\t\t\t\tdd = '0' + dd\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (mm < 10) {\r\n");
      out.write("\t\t\t\tmm = '0' + mm\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\ttoday = yyyy + \"년\" + mm + \"월\" + dd + \"일\";\r\n");
      out.write("\t\t\tvar apiUrl = \"http://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=d69250224a399641ef739b6e02e5cfaf\";\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl : apiUrl,\r\n");
      out.write("\t\t\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\t\t\ttype : \"GET\",\r\n");
      out.write("\t\t\t\t\t\tasync : \"false\",\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(resp) {\r\n");
      out.write("\t\t\t\t\t\t\tvar imgURL = \"http://openweathermap.org/img/w/\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ resp.weather[0].icon + \".png\";\r\n");
      out.write("\t\t\t\t\t\t\tvar html = '<div id=\"weather\"><span style=\"font-size:20px;\" id=\"today\">'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ today\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ '</span><img src=\"'+imgURL+'\" alt=\"\" />';\r\n");
      out.write("\t\t\t\t\t\t\t\t/* 날씨 설명이 너무 길어질 때가 있어 생략함.\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif(!resp.weather[0].description.length>5){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\thtml+='<span id=\"wSpan\"><nobr>'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ resp.weather[0].description\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ '</nobr></span><br />';\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\thtml+='<span id=\"wSpan2\"><nobr>'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ resp.weather[0].description\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ '</nobr></span><br />';\r\n");
      out.write("\t\t\t\t\t\t\t\t\t} */\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\thtml+='<br /><span>현재위치 : '\r\n");
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
      out.write("\t\t//로그인 처리\r\n");
      out.write("\t\tfunction checkLogin() {\r\n");
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
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction enterUser(){\r\n");
      out.write("\t\t\tif(window.event.keyCode==13){\r\n");
      out.write("\t\t\t\tcheckLogin();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\n");
      out.write("\t</script>\r\n");
      out.write("\t<section id=\"content\">\n");
      out.write('\r');
      out.write('\n');

	List<Buy> list = (List<Buy>)request.getAttribute("buy");
	String pageBar = (String)request.getAttribute("pageBar");
	//header.jsp에 memberLoggedIn변수를 선언했으므로, 이 페이지에서는 선언할 필요 없음.
   

      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/boardForm.css\" />\r\n");
      out.write("\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
      out.write("    \r\n");
      out.write(" <style>\r\n");
      out.write(" .input-group{\r\n");
      out.write(" margin-top : 3%;\r\n");
      out.write(" margin-left: 30%;\r\n");
      out.write(" width: 400px;\r\n");
      out.write(" font-size: 12px;\r\n");
      out.write(" }\r\n");
      out.write(" .input-group *{\r\n");
      out.write("  width: 40px;\r\n");
      out.write(" height: 25px;\r\n");
      out.write(" }\r\n");
      out.write(" .input-group select{\r\n");
      out.write(" width: 70px;\r\n");
      out.write("  margin-top : -3px;\r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
      out.write(" body{\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("#btn-add{\r\n");
      out.write(" margin-right : 25px;\r\n");
      out.write(" width : 80px;\r\n");
      out.write(" float: right;}\r\n");
      out.write("\r\n");
      out.write("#pageBar{\r\n");
      out.write("text-align: center;\r\n");
      out.write("width: 300px;\r\n");
      out.write("  margin: auto;\r\n");
      out.write("  padding: 0px 9px;\r\n");
      out.write("  \r\n");
      out.write("    border-radius: 5px;\r\n");
      out.write("    \r\n");
      out.write("    background-color white;\r\n");
      out.write("    box-shadow: inset 0px 1px 0px rgba(255,255,255, .8), 0px 1px 3px rgba(0,0,0, .1);\r\n");
      out.write("    font-size: .875em;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    color: #717171;\r\n");
      out.write("    text-shadow: 0px 1px 0px rgba(255,255,255, 1);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#pageBar >*{\r\n");
      out.write("border-radius: 3px;\r\n");
      out.write(" padding: 4px 10px;\r\n");
      out.write("\tmargin: 5px;\r\n");
      out.write("  background-color: skyblue;\r\n");
      out.write("    color: white;\r\n");
      out.write("    font-size : 15px;\r\n");
      out.write("    border: solid 1px lightgray;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#pageBar >a{\r\n");
      out.write("border-radius: 3px;\r\n");
      out.write(" padding: 1.5px 7px;\r\n");
      out.write("\tmargin: 5px;\r\n");
      out.write("  background-color: #f5f5f5;\r\n");
      out.write("    color: #969696;\r\n");
      out.write("    border: solid 1px skyblue;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("    .table{\r\n");
      out.write("        width: 600px; \r\n");
      out.write("        border: none;\r\n");
      out.write("        border-top: 2px solid rgb(196, 192, 192);\r\n");
      out.write("        border-bottom: 2px solid rgb(196, 192, 192);\r\n");
      out.write("        padding: 15px;\r\n");
      out.write("        margin: 20px auto;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("    }\r\n");
      out.write("    .table #title{\r\n");
      out.write("      width: 200px;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .table td, .table tr th{\r\n");
      out.write("    border: none;\r\n");
      out.write("    border-bottom: 0.5px solid lightgray;\r\n");
      out.write("    }\r\n");
      out.write("    .thead-light{\r\n");
      out.write("    font-size : 14px;}\r\n");
      out.write("    </style>\r\n");
      out.write("    \r\n");
      out.write("<article id=\"article\">\r\n");
      out.write("\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t<H3 style=\"text-align: center;\">구매게시판</H3>\r\n");
      out.write("\r\n");
if(userLoggedIn != null){ 
      out.write(" \r\n");
      out.write("\t\t<input type=\"button\" value=\"글쓰기\" \r\n");
      out.write("\t\t\t   id=\"btn-add\"\r\n");
      out.write("\t\t\t   onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/buy/buyWrite'\"/>\r\n");
      out.write("\t ");
 } 
      out.write(" \t \r\n");
      out.write("\r\n");
      out.write("    <table class=\"table\">\r\n");
      out.write("        <thead class=\"thead-light\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <th scope=\"col\">글번호</th>\r\n");
      out.write("            <th scope=\"col\">작성자</th>\r\n");
      out.write("            <th scope=\"col\" id=\"title\">제목</th>\r\n");
      out.write("            <th scope=\"col\">작성일</th>\r\n");
      out.write("            <th scope=\"col\">카테고리</th>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("        ");
 for(Buy b : list){ 
      out.write("\r\n");
      out.write("         \r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>");
      out.print( b.getBoardNo() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(b.getBoardWriter() );
      out.write("</td>\r\n");
      out.write("            <td><a href=\"");
      out.print(request.getContextPath());
      out.write("/buy/buyView?boardNo=");
      out.print( b.getBoardNo() );
      out.write("\" style=\"text-decoration:none; color: black;\">\r\n");
      out.write("            ");
      out.print(b.getBoardTitle() );
      out.write(" </a></td>\r\n");
      out.write("            <td>");
      out.print(b.getBoardDate() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print(b.getBoardCodeNo() );
      out.write("</td> \r\n");
      out.write("     </tr>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("        \r\n");
      out.write("      </table>\r\n");
      out.write("\t<div id=\"pageBar\" >\r\n");
      out.write("\t\t");
      out.print(pageBar );
      out.write(" \r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"input-group\">\r\n");
      out.write("\t<select>\r\n");
      out.write("\t<option value=\"boardTitle\" selected>제목</option>\r\n");
      out.write("\t<option value=\"boardWriter\">작성자</option>\r\n");
      out.write("\t<option value=\"boardContant\">내용</option>\r\n");
      out.write("\t<option value=\"boardCodeName\">카테고리</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("  <input class=\"form-control\" placeholder=\"검색어를 입력하세요\" />\r\n");
      out.write("  <input type=\"submit\" value=\"검색\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</article>\r\n");
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
      out.write("/images/footer.jpg');\r\n");
      out.write("\r\n");
      out.write("} \r\n");
      out.write("</style>\r\n");
      out.write("</section>\r\n");
      out.write("<footer>\r\n");
      out.write("\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("    \r\n");
      out.write("</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
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
