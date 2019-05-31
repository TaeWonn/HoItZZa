package user.controllor;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/views/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 핸들링
		String userId = request.getParameter("userId");
		String password = request.getParameter("userPwd");
		
		String saveId = request.getParameter("saveId");
		
		User u = new User();
		u.setUserId(userId);
		u.setPassword(password);
		
		// 2. business logic
		// 1(로그인 성공), 0(비밀번호 오류), -1(아이디 없음)
		int result = new UserService().loginCheck(u);
		
		Map<String, String> headerMap = new HashMap<>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
			headerMap.put(name, value);
		}
		
		System.out.println("headermap@loginServlet="+headerMap);
		
		String referer = headerNames.nextElement();
		String origin = request.getHeader("Origin");
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		
		System.out.println("referer="+referer);
		System.out.println("origin="+origin);
		System.out.println("url="+url);
		System.out.println("uri="+uri);
		
		String view = "";
		String msg = "";
//		String loc = referer.replace(origin+request.getContextPath(), "");
		String loc = "/";
		
		// login Success
		if(result == UserService.LOGIN_OK) {
			view = "/";
			
			//로그인에 성공한 회원정보 가져오기
			User userLoggedIn = new UserService().selectOne(userId);
			
			HttpSession session = request.getSession();
			session.setAttribute("userLoggedIn", userLoggedIn);
			
			System.out.println("Session Object ID: "+session.getId());
			System.out.println("Session Max Interval: " + session.getMaxInactiveInterval());
			
			session.setMaxInactiveInterval(5*60);
			
			// 로그인 성공시 아이디 저장 쿠키 처리
			System.out.println("saveId@UserLoginServlet: " + saveId);
			if(saveId != null) {
				Cookie c = new Cookie("saveId", userId);
				c.setMaxAge(7*24*60*60);	// 초단위로 유효기간 설정
				c.setPath("/"); 			// 현재 도메인 전역에서 사용하겠다.
				response.addCookie(c);
			}
			else {
				// 쿠키는 별도의 삭제 메소드 없이 maxAge값으로 삭제
				Cookie c = new Cookie("saveId", userId);
				c.setMaxAge(0); 	// 즉시 삭제, 음수값 사용시, 현재 세션이 유효한 동안 사용
				
				c.setPath("/");
				response.addCookie(c);
				
			}	// end of if(saveId != null)
			
			response.sendRedirect(request.getContextPath());
		} // end of if(LOGIN_OK)
		else {	// login failure
			view = "/WEB-INF/views/common/msg.jsp";
			
			// password dismatch
			if(result == UserService.WRONG_PASSWORD) {
				msg = "비밀번호가 틀렸습니다.";
			}
			// ID non-existence
			else {
				msg = "존재하지 않는 아이디입니다.";
			}
			
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			
			// 3. view
			request.getRequestDispatcher(view).forward(request, response);
		}	// end of else(Login Failure)
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
