package user.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.MembershipService;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserUpdatePasswordEndServlet
 */
@WebServlet("/user/updatePasswordEnd")
public class UserUpdatePasswordEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 핸들링
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String password_new = request.getParameter("password_new");
		
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		
		// 2. Service Logic
		int result = new UserService().loginCheck(user);
		
		// 3. If Correct, update password
		//	  else, call pop-up url
		String msg = "";
		String loc = "";
		String view = "/WEB-INF/views/common/msg.jsp";
		if(result == UserService.LOGIN_OK) {
			user.setPassword(password_new);
			result = new UserService().updatePassword(user);
			if(result>0) 
				msg = "패스워드 변경 성공";
		}
		else {
			msg = "패스워드를 잘못 입력하셨습니다.";
			loc = "/user/updatePassword?userId=" + userId;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("script", "self.close();");
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
