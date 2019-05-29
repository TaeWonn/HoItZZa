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
		// 1. 파라미터 핸들링(아이디, 이름, 이메일, 전화번호, 주소, 관심카테고리)
		String userId = request.getParameter("userId");
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_1").trim()
					 + request.getParameter("phone_2").trim()
					 + request.getParameter("phone_3").trim();
		String addr = request.getParameter("addr1").trim() + " " 
					+ request.getParameter("addr2").trim();
		String [] interest = request.getParameterValues("interest");
		
		User u = new User();
		u.setUserId(userId);
		u.setName(name);
		u.setEmail(email);
		u.setPhone(phone);
		u.setAddr(addr);
		u.setInterest(interest);
		
		// 2. Business Logic
		int result = new UserService().updateUser(u);
		
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
