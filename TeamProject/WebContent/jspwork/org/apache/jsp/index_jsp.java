/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-06-06 22:04:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import free.model.vo.Free;
import buy.model.vo.Buy;
import sell.model.vo.Sell;
import java.util.List;
import user.model.vo.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("buy.model.vo.Buy");
    _jspx_imports_classes.add("sell.model.vo.Sell");
    _jspx_imports_classes.add("user.model.vo.User");
    _jspx_imports_classes.add("free.model.vo.Free");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/index.css\" />\r\n");
 
List<Sell> sellList=(List<Sell>)request.getAttribute("sellList");
List<Buy> buyList=(List<Buy>)request.getAttribute("buyList");
List<Free> sudaList=(List<Free>)request.getAttribute("sudaList");
List<Free> mediaList=(List<Free>)request.getAttribute("mediaList");
List<Free> senseList=(List<Free>)request.getAttribute("senseList");
List<Free> nanumList=(List<Free>)request.getAttribute("nanumList");
String stop=(String)request.getAttribute("stop");


      out.write("\r\n");
      out.write("  \r\n");
      out.write("<article id=\"article\">\r\n");
      out.write("<section>\r\n");
      out.write("\t<div id=\"list-container\">\r\n");
      out.write("\t<div id=\"board1\">\r\n");
      out.write("\t\t<span class=\"title\">판매 / 구매 게시판</span>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id=\"sellList\">\r\n");
      out.write("\t\t<colgroup>\r\n");
      out.write("\t        <col width=\"20px\">\r\n");
      out.write("\t        <col width=\"70px\">  <!-- 너비를 지정해주어야한다 -->\r\n");
      out.write("\t        <col width=\"25px\">\r\n");
      out.write("   \t\t</colgroup>\r\n");
      out.write("\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr >\r\n");
      out.write("\t\t<th style=\"font-size: 20px;\"colspan=\"3\" id=\"firstTitle\">판매 게시판</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\"><nobr>번호</nobr></th>\r\n");
      out.write("\t\t<th><nobr>제목</nobr></th>\r\n");
      out.write("\t\t<th class=\"viewer\"><nobr>조회수</nobr></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t ");
if(sellList!=null){for(int i=0;i<sellList.size();i++){
      out.write("\r\n");
      out.write("\t\t<tr onclick=\"boardView('");
      out.print(sellList.get(i).getBoardNo());
      out.write("','/sell/sellView?boardNo=');\">\r\n");
      out.write("\t\t\t<td class=\"board_no\"><nobr>");
      out.print( sellList.get(i).getBoardNo());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td><nobr>");
      out.print( sellList.get(i).getBoardTitle());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td class=\"viewer\"><nobr>");
      out.print( sellList.get(i).getBoardReadCounter());
      out.write("</nobr></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
}} 
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id=\"buyList\">\r\n");
      out.write("\t\t<colgroup>\r\n");
      out.write("\t        <col width=\"20px\">\r\n");
      out.write("\t        <col width=\"70px\">  <!-- 너비를 지정해주어야한다 -->\r\n");
      out.write("\t        <col width=\"25px\">\r\n");
      out.write("   \t\t</colgroup>\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t<tr >\r\n");
      out.write("\t\t<th style=\"font-size: 20px;\"colspan=\"3\" id=\"firstTitle\"><nobr>구매 게시판</nobr></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\"><nobr>번호</nobr></th>\r\n");
      out.write("\t\t<th><nobr>제목</nobr></th>\r\n");
      out.write("\t\t<th class=\"viewer\"><nobr>조회수</nobr></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t ");
if(buyList!=null){for(int i=0;i<buyList.size();i++){
      out.write("\r\n");
      out.write("\t\t<tr onclick=\"boardView('");
      out.print(buyList.get(i).getBoardNo());
      out.write("','/buy/buyView?boardNo=');\">\r\n");
      out.write("\t\t\t<td class=\"board_no\"><nobr>");
      out.print( buyList.get(i).getBoardNo());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td><nobr>");
      out.print( buyList.get(i).getBoardTitle());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td class=\"viewer\"><nobr>");
      out.print( buyList.get(i).getBoardReadCounter());
      out.write("</nobr></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
}} 
      out.write(" \r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"board2\">\r\n");
      out.write("\t\t<span class=\"title\">자유게시판</span>\r\n");
      out.write("\t\t<table id=\"jayuList1\">\r\n");
      out.write("\t\t<colgroup>\r\n");
      out.write("\t        <col width=\"20px\">\r\n");
      out.write("\r\n");
      out.write("\t        <col width=\"70px\">  <!-- 너비를 지정해주어야한다 -->\r\n");
      out.write("\t        <col width=\"20px\">\r\n");
      out.write("   \t\t</colgroup>\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t<tr >\r\n");
      out.write("\t\t<th colspan=\"3\" style=\"font-size: 20px;\" id=\"firstTitle\"><nobr>나눔 게시판</nobr></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\"><nobr>번호</nobr></th>\r\n");
      out.write("\t\t<th><nobr>제목</nobr></th>\r\n");
      out.write("\t\t<th class=\"viewer\"><nobr>조회수</nobr></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t ");
if(nanumList!=null){for(int i=0;i<nanumList.size();i++){
      out.write("\r\n");
      out.write("\t\t<tr onclick=\"boardView('");
      out.print(nanumList.get(i).getBoardNo());
      out.write("');\">\r\n");
      out.write("\t\t\t<td class=\"board_no\"><nobr>");
      out.print( nanumList.get(i).getBoardNo());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td><nobr>");
      out.print( nanumList.get(i).getBoardTitle());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td class=\"viewer\"><nobr>");
      out.print( nanumList.get(i).getBoardReadCounter());
      out.write("</nobr></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
}} 
      out.write(" \r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id=\"jayuList2\">\r\n");
      out.write("\t\t<colgroup>\r\n");
      out.write("\t        <col width=\"20px\">\r\n");
      out.write("\r\n");
      out.write("\t        <col width=\"70px\">  <!-- 너비를 지정해주어야한다 -->\r\n");
      out.write("\t        <col width=\"20px\">\r\n");
      out.write("   \t\t</colgroup>\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t<tr >\r\n");
      out.write("\t\t<th colspan=\"3\" style=\"font-size: 20px;\" id=\"firstTitle\"><nobr>잡담 게시판</nobr></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\"><nobr>번호</nobr></th>\r\n");
      out.write("\t\t<th><nobr>제목</nobr></th>\r\n");
      out.write("\t\t<th class=\"viewer\"><nobr>조회수</nobr></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t ");
if(sudaList!=null){for(int i=0;i<sudaList.size();i++){
      out.write("\r\n");
      out.write("\t\t<tr onclick=\"boardView('");
      out.print(sudaList.get(i).getBoardNo());
      out.write("',);\">\r\n");
      out.write("\t\t\t<td class=\"board_no\"><nobr>");
      out.print( sudaList.get(i).getBoardNo());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td><nobr>");
      out.print( sudaList.get(i).getBoardTitle());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td class=\"viewer\"><nobr>");
      out.print( sudaList.get(i).getBoardReadCounter());
      out.write("</nobr></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
}} 
      out.write(" \r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id=\"jayuList3\">\r\n");
      out.write("\t\t<colgroup>\r\n");
      out.write("\t        <col width=\"20px\">\r\n");
      out.write("\r\n");
      out.write("\t        <col width=\"70px\">  <!-- 너비를 지정해주어야한다 -->\r\n");
      out.write("\t        <col width=\"20px\">\r\n");
      out.write("   \t\t</colgroup>\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t<tr >\r\n");
      out.write("\t\t<th  colspan=\"3\" style=\"font-size: 20px;\" id=\"firstTitle\">유용한 생활지식 게시판</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\"><nobr>번호</nobr></th>\r\n");
      out.write("\t\t<th><nobr>제목</nobr></th>\r\n");
      out.write("\t\t<th class=\"viewer\"><nobr>조회수</nobr></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t ");
if(senseList!=null){for(int i=0;i<senseList.size();i++){
      out.write("\r\n");
      out.write("\t\t<tr onclick=\"boardView('");
      out.print(senseList.get(i).getBoardNo());
      out.write("');\">\r\n");
      out.write("\t\t\t<td class=\"board_no\"><nobr>");
      out.print( senseList.get(i).getBoardNo());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td><nobr>");
      out.print( senseList.get(i).getBoardTitle());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td class=\"viewer\"><nobr>");
      out.print( senseList.get(i).getBoardReadCounter());
      out.write("</nobr></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
}} 
      out.write(" \r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table id=\"jayuList4\">\r\n");
      out.write("\t\t<colgroup>\r\n");
      out.write("\t        <col width=\"20px\">\r\n");
      out.write("\r\n");
      out.write("\t        <col width=\"70px\">  <!-- 너비를 지정해주어야한다 -->\r\n");
      out.write("\t        <col width=\"20px\">\r\n");
      out.write("   \t\t</colgroup>\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th  colspan=\"3\" style=\"font-size: 20px;\" id=\"firstTitle\">연예/미디어 게시판</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<th class=\"board_no\">번호</th>\r\n");
      out.write("\t\t<th>제목 </th>\r\n");
      out.write("\t\t<th class=\"viewer\">조회수</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t \t");
if(mediaList!=null){for(int i=0;i<mediaList.size();i++){
      out.write("\r\n");
      out.write("\t\t<tr onclick=\"boardView('");
      out.print(mediaList.get(i).getBoardNo());
      out.write("');\">\r\n");
      out.write("\t\t\t<td class=\"board_no\"><nobr>");
      out.print( mediaList.get(i).getBoardNo());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td><nobr>");
      out.print( mediaList.get(i).getBoardTitle());
      out.write("</nobr></td>\r\n");
      out.write("\t\t\t<td class=\"viewer\"><nobr>");
      out.print( mediaList.get(i).getBoardReadCounter());
      out.write("</nobr></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
}} 
      out.write(" \r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write(" \r\n");
      out.write("\t</div>\r\n");
      out.write(" \r\n");
      out.write("</section>\r\n");
      out.write("</article>\r\n");
      out.write("<script>\r\n");
 if(stop==null){
      out.write("\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("    // 로딩되기 시작할때\r\n");
      out.write("location.href=\"");
      out.print(request.getContextPath());
      out.write("/views/index\";\r\n");
      out.write("});\r\n");
}
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("function boardView(boardNo,link){\r\n");
      out.write("\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("\"+link+boardNo;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
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
