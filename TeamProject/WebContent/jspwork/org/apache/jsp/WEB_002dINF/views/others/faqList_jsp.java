/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-06-09 01:46:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.others;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.model.vo.User;

public final class faqList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1559983844579L));
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
      out.write("\r\n");
      out.write(" ");
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
      out.write("            <a href=\"https://audioclip.naver.com/channels/2212\"> <img src=\"https://ssl.pstatic.net/tveta/libs/1222/1222741/4700e66469135fe571c9_20190522110854287.jpg\" alt=\"\" /> \r\n");
      out.write("            </a>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div id=\"ad2\" class=\"ad\">\r\n");
      out.write("            <a href=\"http://mhorigin.noblegames.kr/simplejoin/\"> <img\r\n");
      out.write("               src=\"https://ssl.pstatic.net/tveta/libs/1242/1242071/2c71934b68f1550955f4_20190607145802832.jpg\" alt=\"\" />\r\n");
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
      out.write("<script src=\"http://dmaps.daum.net/map_js_init/postcode.v2.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/header.css\" />\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("div#faq-container{\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("div#faq-container h2{\r\n");
      out.write("    margin-right: 144px;\r\n");
      out.write("\tpadding: 30px;\r\n");
      out.write("\tmargin-bottom: 10px;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("table#faq-tbl{\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\twidth: 610px;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tborder-top: 2px solid rgb(196, 192, 192);\r\n");
      out.write("}\r\n");
      out.write("table#faq-tbl tr{\r\n");
      out.write("\tborder-bottom: 1px solid rgb(196, 192, 192);\r\n");
      out.write("}\r\n");
      out.write("table#faq-tbl tr:last-of-type{\r\n");
      out.write("\tborder-bottom: 2px solid rgb(196, 192, 192);\r\n");
      out.write("}\r\n");
      out.write("table#faq-tbl tr:first-of-type{\r\n");
      out.write("\t/* background: #e9ecef; */\r\n");
      out.write("\tbackground: #cae5ffcc;\r\n");
      out.write("\tborder-bottom: 1px solid rgb(196, 192, 192);\r\n");
      out.write("\tfont-size: 1.2em;\r\n");
      out.write("}\r\n");
      out.write("table#faq-tbl td:last-of-type {\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("}\r\n");
      out.write("tr#p-tag:hover td{\r\n");
      out.write("\tcolor: #0041ff;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("tr#p-tag:hover td p{\r\n");
      out.write("\tcursor: default;\r\n");
      out.write("}\r\n");
      out.write("tr#p-tag td P{\r\n");
      out.write("\tmin-height: 10px;\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<article>\r\n");
      out.write("\r\n");
      out.write("\t<section>\r\n");
      out.write("\t\t<div id=\"faq-container\">\r\n");
      out.write("\t\t\t<h2>쎌빠 FAQ</h2>\r\n");
      out.write("\t\t\t<table id=\"faq-tbl\" >\r\n");
      out.write("\t\t\t<colgroup>\r\n");
      out.write("\t\t\t\t<col width=\"35px\">\r\n");
      out.write("\t\t\t\t<col width=\"135px\">\r\n");
      out.write("\t\t\t\t<col width=\"80px\">\r\n");
      out.write("\t\t\t\t<col width=\"360px\">\r\n");
      out.write("\t\t\t</colgroup>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>순서</th>\r\n");
      out.write("\t\t\t\t\t<th>대분류</th>\r\n");
      out.write("\t\t\t\t\t<th>중분류</th>\r\n");
      out.write("\t\t\t\t\t<th>제목</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"p-tag\">\r\n");
      out.write("\t\t\t\t\t<td>1</td>\r\n");
      out.write("\t\t\t\t\t<td>서비스/피해/오류문의</td>\r\n");
      out.write("\t\t\t\t\t<td>계정문의</td>\r\n");
      out.write("\t\t\t\t\t<td>경고를 받아서 계정이 삭제되었습니다. 재가입 할수 있나요?\r\n");
      out.write("\t\t\t\t\t\t<p>&nbsp;&nbsp;┖ 경고 누적3회로 인해 발생한 계정삭제는 허위사실로 인한\r\n");
      out.write("\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;경고가 아닌이상 복구는 불가하며 재가입도 불가합니다.</p>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"p-tag\">\r\n");
      out.write("\t\t\t\t\t<td>2</td>\r\n");
      out.write("\t\t\t\t\t<td>서비스/피해/오류문의</td>\r\n");
      out.write("\t\t\t\t\t<td>피해문의<p></td>\r\n");
      out.write("\t\t\t\t\t<td>악의적인 허위 신고때문에 경고를 먹었습니다. 조사해서 허위 신고자를 처벌할 수 없을까요?\r\n");
      out.write("\t\t\t\t\t\t<p>&nbsp;&nbsp;┖ 신고처리된 부분을 조사해서 허위적인 신고라고 판명나\r\n");
      out.write("\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;면 허위 신고자에게 경고처리 하겠습니다.</p>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"p-tag\">\r\n");
      out.write("\t\t\t\t\t<td>3</td>\r\n");
      out.write("\t\t\t\t\t<td>결제/충전/환불</td>\r\n");
      out.write("\t\t\t\t\t<td>결제/환불</td>\r\n");
      out.write("\t\t\t\t\t<td>포인트 결제도중에 문제가 발생했습니다. 포인트가 날라갔는데 복구해주시면 안될까요?\r\n");
      out.write("\t\t\t\t\t\t<p>&nbsp;&nbsp;┖ 결제,거래\t내역을 확인하고 복구처리 해드리겠습니다.</p>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"p-tag\">\r\n");
      out.write("\t\t\t\t\t<td>4</td>\r\n");
      out.write("\t\t\t\t\t<td>서비스/피해/오류문의</td>\r\n");
      out.write("\t\t\t\t\t<td>피해문의</td>\r\n");
      out.write("\t\t\t\t\t<td>사기를 당했는데 사기친 사람에 계정을 차단 해주실 수 없을까요?\r\n");
      out.write("\t\t\t\t\t\t<p>&nbsp;&nbsp;┖ 기본적으로 신고하기를 해주시면 저희가 조사해서 경고 \r\n");
      out.write("\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;처리를 합니다. 사기를 당하신 경우에는 증거물을 보내주 \r\n");
      out.write("\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;시면 계정을 차단하도록 하겠습니다.</p>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"p-tag\">\r\n");
      out.write("\t\t\t\t\t<td>5</td>\r\n");
      out.write("\t\t\t\t\t<td>서비스/피해/오류문의</td>\r\n");
      out.write("\t\t\t\t\t<td>피해문의</td>\r\n");
      out.write("\t\t\t\t\t<td>사기당한 피해자인데 고소를 할려고 합니다. 사기친 사람이 게시글을 지워서 증거가 없는데 게시글을 보여주시면 안될까요?\r\n");
      out.write("\t\t\t\t\t\t<p>&nbsp;&nbsp;┖ 개인정보 보호법에 의해 경찰동석없이는 알려드릴수 없 \r\n");
      out.write("\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;습니다. 먼저 경찰에 신고를 하시고 사이트에 문의하시면  \r\n");
      out.write("\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;게시글 정보를 내어 드리겠습니다.</p>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"p-tag\">\r\n");
      out.write("\t\t\t\t\t<td>6</td>\r\n");
      out.write("\t\t\t\t\t<td>서비스/피해/오류문의</td>\r\n");
      out.write("\t\t\t\t\t<td>서비스문의</td>\r\n");
      out.write("\t\t\t\t\t<td>삭제한 게시글을 다시 복구해서 게시할수 있을까요?\r\n");
      out.write("\t\t\t\t\t\t<p>&nbsp;&nbsp;┖ 삭제한 게시글에경우 복구처리를하지 않습니다.</p>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr id=\"p-tag\">\r\n");
      out.write("\t\t\t\t\t<td>7</td>\r\n");
      out.write("\t\t\t\t\t<td>결제/충전/환불</td>\r\n");
      out.write("\t\t\t\t\t<td>충전</td>\r\n");
      out.write("\t\t\t\t\t<td>포인트 충전이 되지 않습니다. 계좌 계좌에서 돈은 빠져나갔는데 포인트 충전이 안됬어요.\r\n");
      out.write("\t\t\t\t\t\t<p>&nbsp;&nbsp;┖ 저희쪽 계좌를 확인하고 돈이 들어와있는게 확인되면 \r\n");
      out.write("\t\t\t\t\t\t<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;포인트를 충전해 드리겠습니다.</p>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("</article>\r\n");
      out.write("<script>\r\n");
      out.write("$(\"tr:first\").nextAll().click(function() {\r\n");
      out.write("\t$(this).children(\"td:last\").children(\"p\").slideToggle(100).css(\"color\",\"black\");\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write(" ");
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
