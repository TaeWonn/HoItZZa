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
 * Servlet implementation class UserFindPwdServlet
 */
@WebServlet("/views/user/findPwd")
public class UserFindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 핸들링
		String userId = request.getParameter("userId");
		String name = request.getParameter("userName");
		String ssn = request.getParameter("ssn_1").trim()
				   + request.getParameter("ssn_2").trim();
		
		User u = new User();
		u.setUserId(userId);
		u.setName(name);
		u.setSsn(ssn);
		
		// 2. 업무 로직
		Boolean chkPwd = new UserService().findUserPwd(u);
		
		// 3. view단 처리
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "";
		
		if(!chkPwd) {
			msg = "일치하는 회원 정보가 존재하지 않습니다.";
			loc = "/views/user/findId_pwd";
		}
		else {
			msg = "비밀번호를 새로 설정해주세요.";
			loc = "/WEB-INF/views/user/findPwd?userId=" + userId;
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