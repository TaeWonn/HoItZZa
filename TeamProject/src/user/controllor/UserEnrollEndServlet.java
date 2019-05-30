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
@WebServlet("/views/user/userJoinEnd")
public class UserEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 핸들링
		String userId = request.getParameter("userId");
		String password = request.getParameter("userPwd");
		String name = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String ssn = request.getParameter("ssn_1").trim() + request.getParameter("ssn_2").trim();
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_1").trim()
					 + request.getParameter("phone_2").trim()
					 + request.getParameter("phone_3").trim();
		String addr = request.getParameter("addr1").trim() + "," 
					+ request.getParameter("addr2").trim();
		String [] interests = {request.getParameter("interest1"),
							   request.getParameter("interest2"),
							   request.getParameter("interest3")};
		String interest = "";	
		
		// intrests가 널이면, NPE 발생
		if(interests != null)
			interest = String.join(",", interests);

		User u = new User();
		u.setUserId(userId);
		u.setPassword(password);
		u.setName(name);
		u.setGender(gender);
		u.setSsn(ssn);
		u.setEmail(email);
		u.setPhone(phone);
		u.setAddr(addr);
		u.setInterest(interests);
		
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
