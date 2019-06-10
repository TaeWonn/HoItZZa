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
@WebServlet(urlPatterns= {"/views/user/updatePwdEnd"},
				name="UserUpdatePasswordEndServlet")


public class UserUpdatePasswordEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 핸들링
		String userId = request.getParameter("findUserPwd_Id");
		String password = request.getParameter("re_userPwd");

		System.out.println("@userFindPwdServlet:userId="+userId+", password="+password);

		User u = new User();
		u.setUserId(userId);
		u.setPassword(password);

		// 2. 업무 로직
		int result = new UserService().updatePassword(u);

		// 3. view단 처리
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "";
		if(result>0) {
			msg = "비밀번호가 성공적으로 변경되었습니다.";
			loc = "/";
		}
		else {
			msg = "비밀번호 변경에 실패하였습니다.";
			loc = "/WEB-INF/views/user/updatePwd";
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
