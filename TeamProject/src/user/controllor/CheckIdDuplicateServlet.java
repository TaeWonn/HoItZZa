package user.controllor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;

/**
 * Servlet implementation class CheckIdDuplicateServlet
 */
@WebServlet("/user/checkIdDuplicate")
public class CheckIdDuplicateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터핸들링
		String userId = request.getParameter("userId");
		System.out.println("userId@CheckIdDuplicateServlet="+userId);
		
		//2.업무로직
		//select count(*) as cnt from member where mebmerid = ?
		//0(해당아이디 사용가능), 1(해당아이디 사용불가)
		//select * from member where memberid = ? (selectOne)
		//Member null(해당아이디 사용가능), not null(해당아이디 사용불가)
		boolean isUsable = new UserService().checkIdDuplicate(userId);
		
		//3.view단 처리
		request.setAttribute("isUsable", isUsable);
		request.getRequestDispatcher("/WEB-INF/views/user/checkIdDuplicate.jsp")
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
