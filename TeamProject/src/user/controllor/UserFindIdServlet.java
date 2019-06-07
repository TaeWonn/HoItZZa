package user.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserFindIdServlet
 */
@WebServlet("/views/user/findId")
public class UserFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 서블릿
		String name = request.getParameter("findUserId_name");
		String phone = request.getParameter("findUserId_phone");
		
		// 2. 업무 로직
		User u = new User();
		u.setName(name);
		u.setPhone(phone);
		String userId = new UserService().findUserId(u);
		
		
		
		// 3. view단 처리
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "";
		if(userId == null || "".equals(userId)) {
			msg = "일치하는 회원 정보가 존재하지 않습니다.";
			loc = "/views/user/findId_pwd";
		}
		else {
			msg = "회원 정보와 일치하는 아이디를 찾았습니다.";
			loc = "/views/user/findId?userId=" + userId;
		}
		
		request.setAttribute("msg", msg);
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
