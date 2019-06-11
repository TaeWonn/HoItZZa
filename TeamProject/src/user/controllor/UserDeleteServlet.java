package user.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.service.UserService;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/views/user/deleteUser")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 핸들링
		String userId = request.getParameter("userId");
		System.out.println(userId+"가 탈퇴시도 ");
		
		// 2. 업무 로직
		int result = new UserService().deleteUser(userId);
		System.out.println("유저 탈퇴처리 : "+result );
		
		// 3. view
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/";
		
		if(result>0) {
			msg = "성공적으로 회원 정보를 삭제했습니다.";
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.invalidate();
			}
			loc = "/";
		}
		else {
			msg = "회원정보 삭제에 실패했습니다.";
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
