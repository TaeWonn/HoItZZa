package user.controllor;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class UserEnrollEndServlet
 */
@WebServlet("/views/user/userJoin")
public class UserEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 핸들링
		String userId = request.getParameter("userId");
		String name = request.getParameter("userName");
		String gender = request.getParameter("gender");
		int point = 0;
		String ssn = request.getParameter("ssn");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String [] interests = request.getParameterValues("interest");
		String interest = "";	//request.getParameter("interest");
		// intrests가 널이면, NPE 발생
		if(interests != null)
			interest = String.join(",", interest);
		
		User u = new User(userId, name, gender, point, ssn, password, email, phone, interests, null);
		
		//2.업무로직
		int result = new UserService().insertUser(u);
		
		String msg = "";
		if(result > 0) {
			msg = "회원가입성공!";
		}
		else {
			msg = "회원가입실패!";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/");
		
		//3.view단처리
		String view = "/WEB-INF/views/common/msg.jsp";
		request.getRequestDispatcher(view)
			   .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
