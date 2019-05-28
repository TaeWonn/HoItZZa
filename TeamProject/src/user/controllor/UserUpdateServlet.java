package user.controllor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/user/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 핸들링(아이디, 비밀번호, 이름, 이메일, 전화번호, 관심카테고리)
		String userId = request.getParameter("userId");
		String password = null;
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String [] interest = request.getParameterValues("interest");
		
		User user = new User(userId, name, null, 0, null, password, email, phone, interest, null);
		
		// 2. Business Logic
		int result = new UserService().updateUser(user);
		
		// 3. view
		String view = "/WEB-INF/vies/common/msg.jsp";
		String msg = "";
		String loc = "/";
		
		if(result > 0) {
			msg = "성공적으로 회원 정보를 수정했습니다.";
			loc = "/user/userView?userId=" + userId;
			HttpSession session = request.getSession();
			session.setAttribute("userLoggedIn", new UserService().selectOne(userId));
		}
		else 
			msg = "회원정보 수정에 실패했습니다.";
			
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
